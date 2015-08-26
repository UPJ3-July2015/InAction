package net.lermex.inaction.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

	@RequestMapping(value = "/")
	public ModelAndView index() {
		List<Integer> listOfIntegers = Arrays.asList(4, 5, 6, 12, 3, 4, 5);
        final ModelAndView mav = new ModelAndView("home/homeNotSignedIn");
		mav.addObject("listOfIntegers", listOfIntegers);

		return mav;
	}

}
