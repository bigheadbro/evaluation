package com.psylife.controller;

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
import com.psylife.util.Util;
import com.psylife.common.Account;
import com.psylife.common.Result;
import com.psylife.entity.DimensionEntity;
import com.psylife.entity.QuestionEntity;
import com.psylife.entity.UserEntity;
import com.psylife.form.QuestionForm;
import com.psylife.form.UserForm;

@Controller
@RequestMapping("/")
@SessionAttributes({"account"})
public class CommonController extends BaseController{
	private Logger logger = LoggerFactory.getLogger(CommonController.class);
	@Autowired
	@Qualifier("commonService")
	private CommonService commonService;
	
	@RequestMapping(value="/")
	public ModelAndView main(final HttpServletRequest request,final HttpServletResponse response)
	{
		ModelAndView mv = new ModelAndView("/evaluation/index");

		Account account = new Account();
		//获取爱才网信息
		account.setCardno("1234");
		account.setGender(1);
		account.setUserName("guichaoqun");
		account.setSchool("tongji");
		
		request.getSession().setAttribute("account", account);
		return mv;
	}
	
	@RequestMapping(value="/profile")
	public ModelAndView profile(final HttpServletRequest request,final HttpServletResponse response, 
			@ModelAttribute("account")Account account, @ModelAttribute("form")UserForm form, BindingResult result)
	{
		if(result.hasErrors())
		{
			return new ModelAndView("/evaluation/profile");
		}
		ModelAndView mv = new ModelAndView("/evaluation/profile");
		if(isDoSubmit(request))
		{
			UserEntity user = form.getUser();
			user.setCardno(account.getCardno());
			user.setGender(account.getGender());
			user.setName(account.getUserName());
			user.setSchool(account.getSchool());
			commonService.insertUser(user);
			account.setUserId(user.getId());
			return new ModelAndView(new RedirectView("/evaluation/q1"));
		}
		else
		{
			return mv;
		}
	}
	
	@RequestMapping(value="/q1")
	public ModelAndView q1(final HttpServletRequest request,final HttpServletResponse response, @ModelAttribute("account")Account account, @ModelAttribute("form")QuestionForm form)
	{
		ModelAndView mv = new ModelAndView("/evaluation/q1");
		form.setQuestionid(1);
		if(isDoSubmit(request))
		{
			DimensionEntity dim = commonService.getDim(1, form.getChoice());
			QuestionEntity ques = Util.calcSingleScore(dim, account.getUserId(), form.getChoice(), form.getTime());
			commonService.insertQuestion(ques);
			return new ModelAndView(new RedirectView("/evaluation/q2"));
		}
		else
		{
			return mv;
		}
	}
	
	@RequestMapping(value="/q2")
	public ModelAndView q2(final HttpServletRequest request,final HttpServletResponse response, @ModelAttribute("account")Account account, @ModelAttribute("form")QuestionForm form)
	{
		ModelAndView mv = new ModelAndView("/evaluation/q2");
		form.setQuestionid(2);
		if(isDoSubmit(request))
		{
			DimensionEntity dim = commonService.getDim(2, form.getChoice());
			QuestionEntity ques = Util.calcSingleScore(dim, account.getUserId(), form.getChoice(), form.getTime());
			commonService.insertQuestion(ques);
			return new ModelAndView(new RedirectView("/evaluation/q3"));
		}
		else
		{
			return mv;
		}
	}
	
	@RequestMapping(value="/q3")
	public ModelAndView q3(final HttpServletRequest request,final HttpServletResponse response, @ModelAttribute("account")Account account, @ModelAttribute("form")QuestionForm form)
	{
		ModelAndView mv = new ModelAndView("/evaluation/q3");
		form.setQuestionid(3);
		if(isDoSubmit(request))
		{
			DimensionEntity dim = commonService.getDim(3, form.getChoice());
			QuestionEntity ques = Util.calcSingleScore(dim, account.getUserId(), form.getChoice(), form.getTime());
			commonService.insertQuestion(ques);
			return new ModelAndView(new RedirectView("/evaluation/q4"));
		}
		else
		{
			return mv;
		}
	}
	
	@RequestMapping(value="/q4")
	public ModelAndView q4(final HttpServletRequest request,final HttpServletResponse response, @ModelAttribute("account")Account account, @ModelAttribute("form")QuestionForm form)
	{
		ModelAndView mv = new ModelAndView("/evaluation/q4");
		form.setQuestionid(4);
		if(isDoSubmit(request))
		{
			DimensionEntity dim = commonService.getDim(4, form.getChoice());
			QuestionEntity ques = Util.calcSingleScore(dim, account.getUserId(), form.getChoice(), form.getTime());
			commonService.insertQuestion(ques);
			return new ModelAndView(new RedirectView("/evaluation/q5"));
		}
		else
		{
			return mv;
		}
	}
	
	@RequestMapping(value="/q5")
	public ModelAndView q5(final HttpServletRequest request,final HttpServletResponse response, @ModelAttribute("account")Account account, @ModelAttribute("form")QuestionForm form)
	{
		ModelAndView mv = new ModelAndView("/evaluation/q5");
		form.setQuestionid(5);
		if(isDoSubmit(request))
		{
			DimensionEntity dim = commonService.getDim(5, form.getChoice());
			QuestionEntity ques = Util.calcSingleScore(dim, account.getUserId(), form.getChoice(), form.getTime());
			commonService.insertQuestion(ques);
			return new ModelAndView(new RedirectView("/evaluation/q6"));
		}
		else
		{
			return mv;
		}
	}
	
	@RequestMapping(value="/q6")
	public ModelAndView q6(final HttpServletRequest request,final HttpServletResponse response, @ModelAttribute("account")Account account, @ModelAttribute("form")QuestionForm form)
	{
		ModelAndView mv = new ModelAndView("/evaluation/q6");
		form.setQuestionid(6);
		if(isDoSubmit(request))
		{
			DimensionEntity dim = commonService.getDim(6, form.getChoice());
			QuestionEntity ques = Util.calcSingleScore(dim, account.getUserId(), form.getChoice(), form.getTime());
			commonService.insertQuestion(ques);
			return new ModelAndView(new RedirectView("/evaluation/q7"));
		}
		else
		{
			return mv;
		}
	}
	
	@RequestMapping(value="/q7")
	public ModelAndView q7(final HttpServletRequest request,final HttpServletResponse response, @ModelAttribute("account")Account account, @ModelAttribute("form")QuestionForm form)
	{
		ModelAndView mv = new ModelAndView("/evaluation/q7");
		form.setQuestionid(7);
		if(isDoSubmit(request))
		{
			DimensionEntity dim = commonService.getDim(7, form.getChoice());
			QuestionEntity ques = Util.calcSingleScore(dim, account.getUserId(), form.getChoice(), form.getTime());
			commonService.insertQuestion(ques);
			return new ModelAndView(new RedirectView("/evaluation/q8"));
		}
		else
		{
			return mv;
		}
	}

	@RequestMapping(value="/q8")
	public ModelAndView q8(final HttpServletRequest request,final HttpServletResponse response, @ModelAttribute("form")QuestionForm form)
	{
		ModelAndView mv = new ModelAndView("/evaluation/q8");
		form.setQuestionid(8);
		if(isDoSubmit(request))
		{
			ModelAndView q14 = new ModelAndView("/evaluation/q14");
			return q14;
		}
		else
		{
			return mv;
		}
	}
	
	@RequestMapping(value="/q14")
	public ModelAndView q14(final HttpServletRequest request,final HttpServletResponse response, @ModelAttribute("form")QuestionForm form)
	{
		ModelAndView mv = new ModelAndView("/evaluation/q14");
		form.setQuestionid(14);
		if(isDoSubmit(request))
		{
			ModelAndView q15 = new ModelAndView("/evaluation/q15");
			return q15;
		}
		else
		{
			return mv;
		}
	}
	
	@RequestMapping(value="/q15")
	public ModelAndView q15(final HttpServletRequest request,final HttpServletResponse response, @ModelAttribute("form")QuestionForm form)
	{
		ModelAndView mv = new ModelAndView("/evaluation/q15");
		form.setQuestionid(15);
		if(isDoSubmit(request))
		{
			ModelAndView q16 = new ModelAndView("/evaluation/q16");
			return q16;
		}
		else
		{

			return mv;
		}
	}
	
	@RequestMapping(value="/q16")
	public ModelAndView q16(final HttpServletRequest request,final HttpServletResponse response, @ModelAttribute("form")QuestionForm form)
	{
		ModelAndView mv = new ModelAndView("/evaluation/q16");
		form.setQuestionid(16);
		if(isDoSubmit(request))
		{
			ModelAndView end = new ModelAndView("/evaluation/end");
			return end;
		}
		else
		{
			return mv;
		}
	}
}
