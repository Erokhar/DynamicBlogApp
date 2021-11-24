package com.dynamicapp.dynamicblogapp.controllers;

import com.dynamicapp.dynamicblogapp.models.UserModel;
import com.dynamicapp.dynamicblogapp.repositories.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@ComponentScan("com.dynamicapp.dynamicblogapp.repositories")
public class UsersController {

    @Autowired
    UsersRepository usersRepository;

    Logger logger = LoggerFactory.getLogger(UsersController.class);

    @PostMapping("/saveRegistration")
    public String saveRegistration(HttpServletRequest request) {
        String username = request.getParameter("username");
        String userpassword = request.getParameter("userpassword");
        String useremail = request.getParameter("useremail");

        if (username != null && !username.equals("") && userpassword != null && !userpassword.equals("") && useremail != null && !useremail.equals("")) {

            List<UserModel> listExisitingUsers = usersRepository.findByUsername(username);
            if (listExisitingUsers != null && !listExisitingUsers.isEmpty()) {
                return "redirect:/saveRegistrationUsernameExist";
            }
            listExisitingUsers = usersRepository.findByUseremail(useremail);
            if (listExisitingUsers != null && !listExisitingUsers.isEmpty()) {
                return "redirect:/saveRegistrationUseremailExist";
            }
            UserModel user = new UserModel();
            user.setUseremail(useremail);
            user.setUsername(username);
            user.setUserpassword(userpassword);

            usersRepository.save(user);
        }

        return "redirect:/";
    }

    @PostMapping("/loginUser")
    public String loginUser(HttpServletRequest request) {
        String username = request.getParameter("username");
        String userpassword = request.getParameter("userpassword");

        if (username != null && !username.equals("") && userpassword != null && !userpassword.equals("")) {
            List<UserModel> userlist = usersRepository.findByUsername(username);
            if (userlist != null && !userlist.isEmpty()) {
                UserModel user = userlist.get(0);
                if (user.getUsername().equals(username) && user.getUserpassword().equals(userpassword)) {
                    request.getSession().setAttribute("userLogged", true);
                    request.getSession().setAttribute("userid", user.getUserid());
                }
            } else {

                return "redirect:/loginErr";
            }

        }

        return "redirect:/";
    }

    @RequestMapping("/loginErr")
    public ModelAndView loginErr(ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.addObject("loginErr", true);
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping("/saveRegistrationUsernameExist")
    public ModelAndView registrationUsernameErr(ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.addObject("useremailExist", false);
        modelAndView.addObject("usernameExist", true);
        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @RequestMapping("/saveRegistrationUseremailExist")
    public ModelAndView registrationUseremailErr(ModelAndView modelAndView, HttpServletRequest request) {
        modelAndView.addObject("usernameExist", false);
        modelAndView.addObject("useremailExist", true);
        modelAndView.setViewName("registration");
        return modelAndView;
    }
}
