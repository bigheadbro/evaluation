package com.psylife.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.WebUtils;

import com.psylife.common.Account;
import com.psylife.entity.UserEntity;
import com.psylife.service.CommonService;
import com.psylife.util.JsonUtil;
import com.psylife.util.StringUtil;
import com.psylife.util.Util;

public class UserLoginInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	@Qualifier("commonService")
	private CommonService commonService;
	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {	
		Account account = (Account) WebUtils.getSessionAttribute(request, "account");
		String uri = request.getRequestURI();
		if(account == null)
		{
			String cardno = request.getParameter("cardno");
			account = Util.getStudentInfo(cardno);
			if(StringUtil.isEmpty(account.getCardno()) || StringUtil.isEqual(account.getCardno(), "null"))
			{
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("http://180.153.108.93/")));
			}
			else
			{
				UserEntity user = commonService.getUserByCN(account.getCardno());
				if(user != null)
				{
					account.setUserId(user.getId());
				}
				request.getSession().setAttribute("account", account);
			}
		}
		else
		{
			String cardno = request.getParameter("cardno");
			if(StringUtil.isNotEmpty(cardno) && StringUtil.isNotEqual(cardno, account.getCardno()))
			{
				account = Util.getStudentInfo(cardno);
				if(StringUtil.isEmpty(account.getCardno()) || StringUtil.isEqual(account.getCardno(), "null"))
				{
					throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("http://180.153.108.93/")));
				}
				else
				{
					UserEntity user = commonService.getUserByCN(account.getCardno());
					if(user != null)
					{
						account.setUserId(user.getId());
					}
					request.getSession().setAttribute("account", account);
				}
			}
		}
		//用户未填写表格
		if(account.getUserId() == 0)
		{
			if(StringUtil.isContains(uri, "index"))
			{
				return true;
			}
			if(StringUtil.isContains(uri, "profile"))
			{
				return true;
			}
			throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/index")));
		}
		int state = commonService.getUser(account.getUserId()).getState();
		switch(state)
		{
			case 100:
				if(StringUtil.isContains(uri, "index"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/index")));
			case 0:
				if(StringUtil.isContains(uri, "introducer") || StringUtil.isContains(uri, "q1"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/introducer")));
			case 1:
				if(StringUtil.isContains(uri, "q2"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/q2")));
			case 2:
				if(StringUtil.isContains(uri, "q3"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/q3")));
			case 3:
				if(StringUtil.isContains(uri, "q4"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/q4")));
			case 4:
				if(StringUtil.isContains(uri, "q5"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/q5")));
			case 5:
				if(StringUtil.isContains(uri, "q6"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/q6")));
			case 6:
				if(StringUtil.isContains(uri, "q7"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/q7")));
			case 7:
				if(StringUtil.isContains(uri, "q8"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/q8")));
			case 8:
				if(StringUtil.isContains(uri, "q9"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/q9")));
			case 9:
				if(StringUtil.isContains(uri, "q10"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/q10")));
			case 10:
				if(StringUtil.isContains(uri, "q11"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/q11")));
			case 11:
				if(StringUtil.isContains(uri, "q12"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/q12")));
			case 12:
				if(StringUtil.isContains(uri, "q13"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/q13")));
			case 13:
				if(StringUtil.isContains(uri, "q46"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/q46")));
			case 141:
				if(StringUtil.isContains(uri, "q14a"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/q14a")));
			case 142:
				if(StringUtil.isContains(uri, "q14b"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/q14b")));
			case 143:
				if(StringUtil.isContains(uri, "q14c"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/q14c")));
			case 1411:
				if(StringUtil.isContains(uri, "q14a1"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/q14a1")));
			case 1412:
				if(StringUtil.isContains(uri, "q14a2"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/q14a2")));
			case 14121:
				if(StringUtil.isContains(uri, "q14a21"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/q14a21")));
			case 1431:
				if(StringUtil.isContains(uri, "q14c1"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/q14c1")));
			case 1432:
				if(StringUtil.isContains(uri, "q14c2"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/q14c2")));
			case 14321:
				if(StringUtil.isContains(uri, "q14c21"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/q14c21")));
			case 14:
				if(StringUtil.isContains(uri, "q15"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/q15")));
			case 15:
				if(StringUtil.isContains(uri, "q16"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/q16")));
			case 16:
				if(StringUtil.isContains(uri, "q162"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/q162")));
			case 162:
				if(StringUtil.isContains(uri, "end"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/end")));
			case 46:
				if(StringUtil.isContains(uri, "51"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/q51")));
			case 51:
				if(StringUtil.isContains(uri, "q52"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/q52")));
			case 52:
				if(StringUtil.isContains(uri, "q53"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/q53")));
			case 53:
				if(StringUtil.isContains(uri, "q54"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/q54")));
			case 54:
				if(StringUtil.isContains(uri, "q55"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/q55")));
			case 55:
				if(StringUtil.isContains(uri, "q56"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/q56")));
			case 56:
				if(StringUtil.isContains(uri, "q14"))
				{
					return true;
				}
				throw new ModelAndViewDefiningException(new ModelAndView(new RedirectView("/evaluation/q14")));
		}
		return true;
	}
}
