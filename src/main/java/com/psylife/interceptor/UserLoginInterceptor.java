package com.psylife.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.util.WebUtils;

import com.psylife.common.Account;
import com.psylife.util.JsonUtil;

public class UserLoginInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {	
		Account account = (Account) WebUtils.getSessionAttribute(request, "account");
		ModelAndView modelAndView = new ModelAndView(new RedirectView("/evaluation"));
		if (account == null ) 
		{
			throw new ModelAndViewDefiningException(modelAndView);
		}
		else
		{
			int state = account.getState();
			return true;
		}
	}
}
