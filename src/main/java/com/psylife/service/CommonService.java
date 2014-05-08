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

}