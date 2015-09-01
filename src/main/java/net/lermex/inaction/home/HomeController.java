package net.lermex.inaction.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import net.lermex.inaction.dao.SportActivityDao;
import net.lermex.inaction.dao.UserDao;
import net.lermex.inaction.entity.SportActivity;
import net.lermex.inaction.entity.User;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	SportActivityDao sportActivityDao;

	@RequestMapping(value = "/")
	public ModelAndView index() {
		List<Integer> listOfIntegers = Arrays.asList(4, 5, 6, 12, 3, 4, 5);
        final ModelAndView mav = new ModelAndView("home/homeNotSignedIn");
		List<Integer> activityMinutes = Arrays.asList(0,2,5,3,4,5,6);
        mav.addObject("customers", "test");
        mav.addObject("activityMinutes", activityMinutes);
        
        
        try {
         User u = new User();
         u.setName("Pedro");
         u.setPassword("YESYOUARE");
         boolean createW = userDao.createUserW(u);
         System.out.println(createW);
        } catch (Exception ex) {
        	//???Что делать с этим исключением?
        	System.out.println(ex);
        }
        
        /* 4 test
        SportActivity a = new SportActivity();
        a.setName("MixFight" + (Calendar.getInstance()).get(Calendar.MILLISECOND));        
        sportActivityDao.createActivity(a);
        */
		return mav;
	}

}
