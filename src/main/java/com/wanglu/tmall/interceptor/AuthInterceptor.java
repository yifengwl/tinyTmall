package com.wanglu.tmall.interceptor;


import com.wanglu.tmall.model.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by wanglu on 17/2/6.
 */

public class AuthInterceptor extends HandlerInterceptorAdapter {

    /**
     * Handler执行完成之后调用这个方法
     */
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception exc)
            throws Exception {

    }

    /**
     * Handler执行之后，ModelAndView返回之前调用这个方法
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {
    }

    /**
     * Handler执行之前调用这个方法
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        String url = request.getRequestURI();
        if(url.indexOf("/user/")>=0){
            return true;
        }
        //获取Session
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        if(username != null){
            return true;
        }
        //不符合条件的，跳转到登录界面
        User u = new User();
        request.setAttribute("user",u);
        response.sendRedirect("/user/login?next=".concat(request.getRequestURI()));

//        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        return false;
    }

    @Target(ElementType.METHOD)
    @Retention(RetentionPolicy.RUNTIME)
    public static @interface AccessRequired {
        public String name();
        public String success() default "";
        public String failed() default "";
    }

}
