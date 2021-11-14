package com.dynamicapp.dynamicblogapp.controllers;

import com.dynamicapp.dynamicblogapp.models.UserModel;
import com.dynamicapp.dynamicblogapp.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@ComponentScan("com.dynamicapp.dynamicblogapp.repositories")
public class UsersController {

    @Autowired
    UsersRepository usersRepository;

    @PostMapping("/saveRegistration")
    public String saveRegistration(HttpServletRequest request){
        String username = request.getParameter("username");
        String userpassword = request.getParameter("userpassword");
        String useremail = request.getParameter("useremail");

        if(username!=null && !username.equals("") && userpassword!=null && !userpassword.equals("") && useremail!=null && !useremail.equals("") ){
            UserModel user = new UserModel();
            user.setUseremail(useremail);
            user.setUsername(username);
            user.setUserpassword(userpassword);

            usersRepository.save(user);
        }

        return "redirect:/";
    }

    @GetMapping("/loginUser")
    public String loginUser(HttpServletRequest request){
        String username = request.getParameter("username");
        String userpassword = request.getParameter("userpassword");

        if(username != null && !username.equals("") && userpassword!=null && !userpassword.equals("")){
            List<UserModel> userlist = usersRepository.findByUsername(username);
            if(userlist!=null && !userlist.isEmpty()){
                UserModel user = userlist.get(0);
                if(user.getUsername().equals(username) && user.getUserpassword().equals(userpassword)){
                    request.getSession().setAttribute("userLogged",true);
                    request.getSession().setAttribute("username",username);
                }
            }

        }

        return "redirect:/";
    }
}
