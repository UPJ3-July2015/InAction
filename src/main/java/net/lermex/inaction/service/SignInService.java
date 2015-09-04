package net.lermex.inaction.service;

import java.security.GeneralSecurityException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.lermex.inaction.dao.UserDao;
import net.lermex.inaction.entity.User;
import net.lermex.inaction.util.CSHA1Util;
import net.lermex.inaction.util.StrUtils;

@Controller
public class SignInService {
	
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value = "authenticate")
	public ModelAndView checkPassword(HttpServletRequest request, HttpServletResponse presponse ){
		
		ModelAndView mav = null;
		String login = request.getParameter("username");
		String password = request.getParameter("password");
		if(checkPassWord(login, password)){
			System.out.println("=======================================================================================");
			System.out.println(login + password);
			mav = new ModelAndView("home/homeNotSignedIn");
		}else{
			
			mav = new ModelAndView("signin/signin");
			mav.addObject("error", "incorrect pass or login");
		}
		
		return mav;
		
	}
	
	private boolean checkPassWord(String username, String password ){
		User u;
		if (StrUtils.isNullOrEmptyTrim(username) 
				|| StrUtils.isNullOrEmptyTrim(password) 
				|| ((u = userDao.getUserByNameWithNoResultTreatment(username)) == null) ) {
			return false;
		}		
		try {
			String theHash = CSHA1Util.getSHA1String(password);
			return theHash.equals(u.getPasswordhash());
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

}
