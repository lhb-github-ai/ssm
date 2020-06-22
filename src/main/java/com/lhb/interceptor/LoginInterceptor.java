package com.lhb.interceptor;



import com.lhb.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //获取请求的URL

            HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        System.out.println(user+"111");
            if (user != null) {

                return true;
            } else {
//                request.setAttribute("message", "请先登录！");
//                response.sendRedirect("  http://localhost:8080/");
                System.out.println(111);
                return true;
            }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {

    }
}
