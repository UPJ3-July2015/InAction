package net.lermex.inaction.signin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignInController {
	

	@RequestMapping(value = "/signin")
	public ModelAndView index() {
        final ModelAndView mav = new ModelAndView("signin/signin");
       
		return mav;
	}
}