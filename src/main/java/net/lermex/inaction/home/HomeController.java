package net.lermex.inaction.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

	@RequestMapping(value = "/")
	public ModelAndView index() {
        final ModelAndView mav = new ModelAndView("home/homeNotSignedIn");
		List<Integer> activityMinutes = Arrays.asList(0,2,5,3,4,5,6);
        mav.addObject("customers", "test");
        mav.addObject("activityMinutes", activityMinutes);
		return mav;
	}

}
