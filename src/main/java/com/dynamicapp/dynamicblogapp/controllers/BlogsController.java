package com.dynamicapp.dynamicblogapp.controllers;

import com.dynamicapp.dynamicblogapp.models.BlogModel;
import com.dynamicapp.dynamicblogapp.models.UserModel;
import com.dynamicapp.dynamicblogapp.repositories.BlogsRepository;
import com.dynamicapp.dynamicblogapp.repositories.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@ComponentScan("com.dynamicapp.dynamicblogapp.repositories")
public class BlogsController {

    @Autowired
    BlogsRepository blogsRepository;

    @Autowired
    UsersRepository usersRepository;

    Logger logger = LoggerFactory.getLogger(BlogsController.class);

    @PostMapping("/saveBlogPost")
    public ModelAndView saveBlogPost(ModelAndView modelAndView, HttpServletRequest request) {
        String blogTitle = request.getParameter("blogTitle");
        String blogContent = request.getParameter("blogContent");

        if (blogTitle == null || blogTitle.equals("")) {
            modelAndView.addObject("missingTitle", true);
            if(blogContent!=null && !blogContent.equals("")){
                modelAndView.addObject("missingContent", false);
                modelAndView.addObject("contentAvailable", true);
                modelAndView.addObject("blogContent",blogContent);
            }
            modelAndView.setViewName("blog-edit");
            return modelAndView;
        }

        if (blogContent == null || blogContent.equals("")) {
            modelAndView.addObject("missingContent", true);
            if(blogTitle!=null && !blogTitle.equals("")){
                modelAndView.addObject("missingTitle", false);
                modelAndView.addObject("titleAvailable", true);
                modelAndView.addObject("blogTitle",blogTitle);
            }
            modelAndView.setViewName("blog-edit");
            return modelAndView;
        }

        if (blogTitle != null && !blogTitle.equals("") && blogContent != null && !blogContent.equals("")) {
            BlogModel blog = new BlogModel();
            blog.setBlogcontent(blogContent);
            blog.setBlogtitle(blogTitle);
            if (request.getSession().getAttribute("userid") != null) {
                blog.setBlogauthor(Integer.parseInt(request.getSession().getAttribute("userid").toString()));
            } else {
                blog.setBlogauthor(0);
            }
            blog.setBlogpublishdate(new Date());

            blogsRepository.save(blog);
            modelAndView.addObject("missingContent", false);
            modelAndView.addObject("missingTitle", false);
            modelAndView.addObject("blog", blog);
            List<UserModel> userList = usersRepository.findByUserid(blog.getBlogauthor());
            UserModel user = userList.get(0);
            modelAndView.addObject("user", user);
            modelAndView.setViewName("blog-post");
        }


        return modelAndView;
    }
}
