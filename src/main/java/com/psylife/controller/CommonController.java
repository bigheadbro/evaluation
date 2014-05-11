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
import com.psylife.form.QuestionForm;

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
		
		Result result = new Result();
		Account account = new Account();
		//获取爱才网信息
		account.setGender(1);
		request.getSession().setAttribute("account", account);
		return mv;
	}
	
	@RequestMapping(value="/profile")
	public ModelAndView profile(final HttpServletRequest request,final HttpServletResponse response)
	{
		ModelAndView mv = new ModelAndView("/evaluation/profile");
		
		Result result1 = new Result();
		
		return mv;
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
			Result result = new Result();
			
			return mv;
		}
	}
	
	@RequestMapping(value="/q2")
	public ModelAndView q2(final HttpServletRequest request,final HttpServletResponse response, @ModelAttribute("form")QuestionForm form)
	{
		ModelAndView mv = new ModelAndView("/evaluation/q2");
		form.setQuestionid(2);
		if(isDoSubmit(request))
		{
			return new ModelAndView(new RedirectView("/evaluation/q8"));
		}
		else
		{
			Result result = new Result();
			
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
			Result result = new Result();
			
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
			Result result = new Result();
			
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
			Result result = new Result();
			
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
			Result result = new Result();
			
			return mv;
		}
	}
}
