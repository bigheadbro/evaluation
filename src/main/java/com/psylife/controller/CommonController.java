package com.psylife.controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.servlet.view.RedirectView;


import com.psylife.service.CommonService;
import com.psylife.common.Account;
import com.psylife.common.Constant;
import com.psylife.common.Result;

import com.psylife.form.LoginForm;
import com.psylife.util.JsonUtil;
import com.psylife.util.StringUtil;
import com.psylife.util.Util;
import com.psylife.entity.UserEntity;
@Controller
@RequestMapping("/")
@SessionAttributes({"account"})
public class CommonController extends BaseController{
	private Logger logger = LoggerFactory.getLogger(CommonController.class);
	@Autowired
	@Qualifier("commonService")
	private CommonService commonService;
	
	@RequestMapping(value="/downloadfile")
	public void download(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{  
        response.setCharacterEncoding("utf-8");  
        response.setContentType("multipart/form-data");  
        String fileName = request.getParameter("file");
        response.setHeader("Content-Disposition", "attachment;fileName="+java.net.URLEncoder.encode(fileName, "UTF-8"));  
        String path = request.getSession().getServletContext().getRealPath("/resource")+"/"+ fileName;
        try {  
            File file=new File(path);  
            response.setContentLength((int)(long)file.length());
            InputStream inputStream=new FileInputStream(file);  
            OutputStream os=response.getOutputStream();  
            byte[] b=new byte[1024];  
            int length;  
            while((length=inputStream.read(b))>0){  
                os.write(b,0,length);  
            }  
            inputStream.close();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  
	
	@RequestMapping(value="/downloadsample")
	public void downloadFile(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{  
        response.setCharacterEncoding("utf-8");  
        response.setContentType("multipart/form-data");  
        String fileName = request.getParameter("file");
        response.setHeader("Content-Disposition", "attachment;fileName="+java.net.URLEncoder.encode(fileName.split("/")[3], "UTF-8"));  
        String path = request.getSession().getServletContext().getRealPath("/sample")+ fileName.substring(9);
        try {  
            File file=new File(path);  
            response.setContentLength((int)(long)file.length());
            InputStream inputStream=new FileInputStream(file);  
            OutputStream os=response.getOutputStream();  
            byte[] b=new byte[1024];  
            int length;  
            while((length=inputStream.read(b))>0){  
                os.write(b,0,length);  
            }  
            inputStream.close();  
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }  

	/**
	 * 其他未识别的URL都统一到
	 * @return
	 */
	@RequestMapping(value="*")
	public ModelAndView otherEnter(final HttpServletResponse response,@ModelAttribute("form")LoginForm form)
	{
		ModelAndView mv = new ModelAndView("/common/index");
		
		Result result = new Result();
		
		return mv;
	}

	@RequestMapping(value="/reg")
	public ModelAndView reg(final HttpServletResponse response)
	{
		ModelAndView mv = new ModelAndView("/common/reg");
		
		return mv;
	}
	
	@RequestMapping(value="/forgetpwd")
	public ModelAndView forgetpwd(final HttpServletRequest request, final HttpServletResponse response, @ModelAttribute("form")LoginForm form, BindingResult result)
	{
		ModelAndView mv = new ModelAndView("/common/forgetpwd");
		if(isDoSubmit(request))
		{
			String rec[] ={form.getMail()};
			String pwd = UUID.randomUUID().toString().substring(0,6);
			String date = StringUtil.getCurrentDate();
			String content = "亲爱的"+form.getMail()+":\n\n欢迎使用刀师傅的找回密码功能，您的新密码是"+pwd+"，请使用该密码登录刀师傅后，在账户设置中修改此密码\n\n请勿回复此邮件\n\n此致\n\n刀师傅敬上\n"+date;
			commonService.changpwd(form.getMail(), pwd, result);
			if(!result.hasErrors())
			{
				//Util.sendEmail("noreply@daoshifu.com","cisco123",rec,"找回密码", content, null, "", "UTF-8");
			}
			else
			{
				return mv;
			}
			return new ModelAndView(new RedirectView("/log"));
		}
		return mv;
	}
	
	@RequestMapping(value="/log")
	public ModelAndView log(final HttpServletRequest request,
			final HttpServletResponse response, @ModelAttribute("form")LoginForm form, BindingResult result) throws IOException 
	{
		ModelAndView mv = new ModelAndView("/evaluation/log");
		if(isDoSubmit(request))
		{
			Result re = commonService.checkLogin(form, result);
			
			if(!result.hasErrors())
			{
				Account account = new Account();
				UserEntity user = (UserEntity)re.get("user");
				account.setUserId(user.getId());
				account.setLogin(true); // 登录成功标识
				account.setUserName(user.getUsername()); // 用户登录名
				account.setUserId(user.getId()); // 用户ID

				request.getSession().setAttribute("account", account);
				// 登陆成功， 跳转到登陆页面
				return new ModelAndView(new RedirectView("/evaluation/main"));
			}
		}
		return mv;
	}
	
	@RequestMapping(value="/index")
	public ModelAndView index(final HttpServletRequest request,final HttpServletResponse response)
	{
		ModelAndView mv = new ModelAndView("/evaluation/index");
		
		Result result = new Result();
		
		return mv;
	}

	
}
