package com.dynamicapp.dynamicblogapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

    @RequestMapping("/")
    public ModelAndView getHomePage(ModelAndView modelAndView, HttpServletRequest request){

        modelAndView.setViewName("index");
        return modelAndView;
    }

    @RequestMapping("/register")
    public ModelAndView register(ModelAndView modelAndView, HttpServletRequest request){

        modelAndView.setViewName("registration");
        return modelAndView;
    }

    @PostMapping("/saveRegistration")
    public String saveRegistration(HttpServletRequest request){

        return "redirect:/";
    }

    @RequestMapping("/login")
    public ModelAndView login(ModelAndView modelAndView, HttpServletRequest request){

        modelAndView.setViewName("login");
        return modelAndView;
    }


}
