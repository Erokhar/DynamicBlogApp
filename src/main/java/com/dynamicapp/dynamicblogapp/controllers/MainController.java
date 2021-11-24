package com.dynamicapp.dynamicblogapp.controllers;

import com.dynamicapp.dynamicblogapp.repositories.BlogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
@ComponentScan("com.dynamicapp.dynamicblogapp.repositories")
public class MainController {

    @Autowired
    BlogsRepository blogsRepository;

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

    @RequestMapping("/blog-posts")
    public ModelAndView blogPosts(ModelAndView modelAndView,HttpServletRequest request){

        modelAndView.setViewName("blog-post-list");
        return modelAndView;
    }

    @RequestMapping("/newBlogPost")
    public ModelAndView newBlogPost(ModelAndView modelAndView,HttpServletRequest request){

        modelAndView.setViewName("blog-edit");
        return modelAndView;
    }


}
