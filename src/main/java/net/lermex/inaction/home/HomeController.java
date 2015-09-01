package net.lermex.inaction.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import net.lermex.inaction.dao.SportActivityDao;
import net.lermex.inaction.dao.UserActivityDao;
import net.lermex.inaction.dao.UserActivityShowDao;
import net.lermex.inaction.dao.UserDao;
import net.lermex.inaction.dao.UserStatusDao;
import net.lermex.inaction.entity.SportActivity;
import net.lermex.inaction.entity.User;
import net.lermex.inaction.entity.UserActivity;
import net.lermex.inaction.entity.UserActivityShow;
import net.lermex.inaction.entity.UserStatus;

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
	
	@Autowired
	UserStatusDao userStatusDao;
	
	@Autowired
	UserActivityDao userActivityDao;
	
	@Autowired
	UserActivityShowDao userActivityShowDao;

	@RequestMapping(value = "/")
	public ModelAndView index() {
		List<Integer> listOfIntegers = Arrays.asList(4, 5, 6, 12, 3, 4, 5);
		final ModelAndView mav = new ModelAndView("home/homeNotSignedIn");
		List<Integer> activityMinutes = Arrays.asList(0, 2, 5, 3, 4, 5, 6);
		mav.addObject("customers", "test");
		mav.addObject("activityMinutes", activityMinutes);

		try {
			//create user
			User u = new User();
			u.setName("Pedro" + (Calendar.getInstance()).get(Calendar.MILLISECOND));
			u.setPassword("YESYOUARE");
			boolean createW = userDao.createUserW(u);
			System.out.println(createW);
			//post msg
			UserStatus us = new UserStatus(u);
			us.setUserText("HI THERE "+(Calendar.getInstance()).get(Calendar.MILLISECOND));
			userStatusDao.createUserStatus(us);
			//create sport_activity
			SportActivity a = new SportActivity();
			a.setName("MixFight" +(Calendar.getInstance()).get(Calendar.MILLISECOND));
			sportActivityDao.createActivity(a);
			//create user activity
			UserActivity ua = new UserActivity(u, a);
			ua.setDt(new java.util.Date());
			ua.setMinutes(15);
			userActivityDao.createUserActivity(ua);			
		} catch (Exception ex) {
			//System.out.println(ex);
			ex.printStackTrace();
		}
		
		//show it
		List<UserActivityShow> listUserActivityShow = userActivityShowDao.getUserActivityShowList();
		mav.addObject("listUserActivityShow", listUserActivityShow);		
		
		return mav;
	}

}
