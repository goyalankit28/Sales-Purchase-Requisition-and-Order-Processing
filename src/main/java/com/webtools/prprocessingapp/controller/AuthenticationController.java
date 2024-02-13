/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.webtools.prprocessingapp.controller;

import com.webtools.prprocessingapp.dao.UsersDAO;
import com.webtools.prprocessingapp.exception.UsersException;
import com.webtools.prprocessingapp.pojo.User;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author ankitgoyal
 */
@Controller
public class AuthenticationController {

    @RequestMapping(value = "/register.htm", method = RequestMethod.GET)
    public ModelAndView displayRegistration(ModelAndView mv) {
        mv.addObject("user", new User());
        mv.setViewName("register");
        return mv;

    }

    @RequestMapping(value = "/register.htm", method = RequestMethod.POST)
//    @RequestParam("h1") String h1
    public ModelAndView registerUser(ModelAndView mv, @ModelAttribute("user") User users, BindingResult result, UsersDAO userDao, HttpServletRequest request, HttpServletResponse response) throws UsersException, IOException {

//        if (result.hasErrors()) {
//            mv.addObject("user", users);
//            mv.setViewName("register");
//            return mv;
//        }
//		User existingUser;
//        System.out.println("--------------******************************----------------" + users.getUsername());
//		existingUser = userDao.findByUserName(users.getUsername());
//		if (existingUser != null) {
//			mv.addObject("error", "This email is already registered!!");
//			mv.setViewName("register");
//		} else {
        //users.setIsAllowedAccess("N");
        String role = request.getParameter("userRole");
        users = userDao.register(users, role);

        /*
			 * SimpleMailMessage mailMessage = new SimpleMailMessage();
			 * mailMessage.setTo(users.getUsername());
			 * mailMessage.setSubject("Registration Complete !");
			 * mailMessage.setFrom("jagmangrewal9@gmail.com");
			 * mailMessage.setText("You have been registered to the Job Portal ");
			 * 
			 * emailService.sendEmail(mailMessage);
         */
//			SendEmail(users);
        System.out.println("************Done with Controller***************");

//        mv.addObject("emailId", users.getUsername());
//        mv.setViewName("login");
        response.sendRedirect(request.getContextPath()+"/login.htm");
//		}
        System.out.println("This was pringted.....");
        return mv;
    }
    
    @RequestMapping(value = "/login.htm", method = RequestMethod.GET)
	public ModelAndView displayLogin(ModelAndView mv) {
		mv.addObject("user", new User());
		mv.setViewName("login");
		return mv;
	}

	@RequestMapping(value = "/login.htm", method = RequestMethod.POST)
	public ModelAndView getUser(@ModelAttribute("user") User user, ModelAndView mv, HttpServletRequest request,
			UsersDAO userDao, BindingResult result) {
	System.out.println("Inside Post method!!!!!");
            HttpSession session = (HttpSession) request.getSession();
		String email = request.getParameter("username");
		String password = request.getParameter("password");
		User existingUser;
		try {

			existingUser = userDao.getUser(email, password);
			if (existingUser != null) {
				//if(existingUser.getIsAllowedAccess().equalsIgnoreCase("Y"))
				 {
				if (existingUser.getUserRole().getRole().equalsIgnoreCase("Supplier")) {
					mv.addObject("user", existingUser);
					mv.setViewName("supplier-success");
					mv.addObject("role", "Supplier");
					session.setAttribute("userSession", existingUser);

				} else if (existingUser.getUserRole().getRole().equalsIgnoreCase("Customer")) {
					mv.addObject("user", existingUser);
					mv.setViewName("index");
					mv.addObject("role", "employer");
					session.setAttribute("userSession", existingUser);

				}
				}
				/*
				 * else { mv.addObject("error","Kindly validate your email address");
				 * mv.setViewName("login");
				 * 
				 * 
				 * 
				 * }
//				 */}
                        else {
				mv.addObject("error", "Incorrect credentials !! Kindly Login with correct credentials");
				mv.setViewName("login");

			}
		} catch (UsersException e) {

			e.printStackTrace();
			mv.addObject("message", "Sorry for the inconvience. There is some issue !!");
			mv.setViewName("index");

		}
		return mv;

	}

        @RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request, ModelAndView mv) {
		HttpSession session = request.getSession(false);
		if (session != null) {
			User u = (User) session.getAttribute("userSession");
			if (u == null) {
				mv.addObject("message", "Kindly Login Again!!!");
				mv.setViewName("/login");
			} else {
				request.getSession(false).invalidate();
				mv.setViewName("/login");
			}

		}
		return mv;

	}

}
