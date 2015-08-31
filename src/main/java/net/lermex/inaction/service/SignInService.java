package net.lermex.inaction.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignInService {
	
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
		
		return true;
	}

}
