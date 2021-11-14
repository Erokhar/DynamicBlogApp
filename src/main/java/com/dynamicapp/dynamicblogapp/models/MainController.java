package com.dynamicapp.dynamicblogapp.models;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@ComponentScan("com.dynamicapp.dynamicblogapp.repositories")
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


    @RequestMapping("/login")
    public ModelAndView login(ModelAndView modelAndView, HttpServletRequest request){

        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping("/features")
    public ModelAndView features(ModelAndView modelAndView, HttpServletRequest request){

        modelAndView.setViewName("features");
        return modelAndView;
    }

    @RequestMapping("/about")
    public ModelAndView about(ModelAndView modelAndView, HttpServletRequest request){

        modelAndView.setViewName("about-us");
        return modelAndView;
    }


}
