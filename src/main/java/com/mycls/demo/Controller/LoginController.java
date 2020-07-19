package com.mycls.demo.Controller;

import com.mycls.demo.entities.User;
import com.mycls.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@ResponseBody
@Controller
public class LoginController {


    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView login(User user, HttpServletRequest request, Map<String,Object> map, HttpSession session) {
        ModelAndView mav = new ModelAndView();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        user.setUsername(username);
        user.setPassword(password);
        User loginUser = this.userService.login(user);
        System.out.println(username + password);
        if (loginUser != null) {
            //成功
            mav.clear();
            mav.setViewName("redirect:/main.html");
            session.setAttribute("loginUser",loginUser);
            return mav;
        } else {
            //失败
            session.setAttribute("msg", "账号或密码错误!请重新输入");
        }
        mav.setViewName("login");
        //map.put("msg","用户名和密码错误");
        return mav;
    }
    @RequestMapping(value = "/register",method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView register(User user, HttpServletRequest request, Map<String,Object> map, HttpSession session){
        ModelAndView mav = new ModelAndView();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        user.setUsername(username);
        user.setPassword(password);
        int registerUser = this.userService.register(user);
        if(registerUser >0 ){
            //成功
            mav.clear();
            mav.setViewName("redirect:/main.html");
            session.setAttribute("registerUser",registerUser);
            return mav;
        }else{
            //失败
            session.setAttribute("msg","账号已存在!请重新输入");
        }
        mav.setViewName("register");
        return mav;
    }

}

