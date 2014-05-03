package com.psylife.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;


import com.psylife.common.Account;
import com.psylife.common.Result;
import com.psylife.dao.BuyerDAO;
import com.psylife.form.LoginForm;

import com.psylife.util.ChineseSpelling;
import com.psylife.util.StringUtil;

import com.psylife.entity.UserEntity;


/**
 * @author guichaoqun
 *
 */
@Service("commonService")
public class CommonService {
	@Autowired
	@Qualifier("buyerDAO")
	private BuyerDAO buyerDAO;

	
	public Result checkLogin(LoginForm form, Errors errors)
	{
		Result result = new Result();
		if(StringUtil.isEmpty(form.getMail()))
		{
			errors.rejectValue("mail", "MAIL_IS_NOT_NULL"); // 邮箱不能为空
			return result;
		}
		UserEntity buyer = buyerDAO.queryBuyerEntityByMail(form.getMail());
		if(buyer == null)
		{
			errors.rejectValue("mail", "MAIL_IS_NOT_EXISTS"); // 邮箱不存在
			return result;
		}
		
		if(StringUtil.isNotEqual(buyer.getPassword(), StringUtil.encrypt(form.getPassword())))
		{
			errors.rejectValue("password", "PASSWORD_ERROR"); // 密码错误
			return result;
		}
		
		result.add("user", buyer);
		result.add("userType", 1);
		return result;
	}
	
	public Result changpwd(String mail, String pwd, Errors errors)
	{
		Result result = new Result();
		UserEntity buyer = buyerDAO.queryBuyerEntityByMail(mail);

		buyer.setPassword(StringUtil.encrypt(pwd));
		buyerDAO.updateBuyerPwdById(buyer);
		
		return result;
	}
}