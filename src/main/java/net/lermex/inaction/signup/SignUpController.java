package net.lermex.inaction.signup;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SignUpController {
	
	@RequestMapping(value = "/signup")
	public ModelAndView index() {
        final ModelAndView mav = new ModelAndView("signup/signup");
       
		return mav;
	}

}
