package com.khalil.ssm.blog.controller.admin;



import com.khalil.ssm.blog.entity.User;
import com.khalil.ssm.blog.service.ArticleService;
import com.khalil.ssm.blog.service.CommentService;
import com.khalil.ssm.blog.service.UserService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.khalil.ssm.blog.util.MyUtil.getIpAddr;


@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private ArticleService articleService;

    @Autowired
    private CommentService commentService;

    /**
     * 后台首页
     */
    @RequestMapping("/admin")
    public String index(Model model) {

        return "Admin/index";
    }

    /**
     * 登录页面
     */
    @RequestMapping("/login")
    public String loginPage(){
        return "Admin/login";
    }

    /**
     * 登录验证
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/login/verify")
    public String loginVerify(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> map = new HashMap<>();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberme = request.getParameter("rememberme");
        User user = userService.getUserByNameOrEmail(username);
        if(user == null) {
            map.put("code", 0);
            map.put("msg", "用户名无效");
        } else if(!user.getUserPass().equals(password)) {
            map.put("code", 0);
            map.put("msg", "密码错误");
        } else {
            map.put("code", 1);
            map.put("msg", "登录成功");
            request.getSession().setAttribute("user", user);
            if(rememberme != null) {
                Cookie nameCookie = new Cookie("username", username);
                nameCookie.setMaxAge(60 * 60 * 24 * 3);
                Cookie passCookie = new Cookie("password", password);
                passCookie.setMaxAge(60 * 60 * 24 * 3);
                response.addCookie(nameCookie);
                response.addCookie(passCookie);
            }
           user.setUserLastLoginTime(new Date());
            user.setUserLastLoginIp(getIpAddr(request));
            userService.updateUser(user);
        }
        String result = new JSONObject(map).toString();
        return result;
    }

    /**
     * 退出登录
     */
    @RequestMapping(value = "/admin/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        session.invalidate();
        return "redirect:/login";
    }
}
