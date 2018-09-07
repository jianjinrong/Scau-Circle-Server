package com.pinnuli.interceptor;

import com.pinnuli.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @description: 描述
 * @author: pinnuli
 * @date: 2018-09-05
 */

public class JWTInterceptor implements HandlerInterceptor {
    private static Logger log = LoggerFactory.getLogger(JWTInterceptor.class);

    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
            throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) {
        // TODO Auto-generated method stub
        JwtUtil util = new JwtUtil();
        String jwt = request.getHeader("Authorization");

        try {
            if (jwt == null) {
                System.out.println("用户未登录，验证失败");
            } else {
                Claims c;
                c = util.parseJWT(jwt);
                System.out.println("用户id" + c.get("user_id") + "已是登录状态");
                return true;
            }

            System.out.println("token解析错误，验证失败");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("未登录，请重新登录后操作");;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            log.debug("");
            e.printStackTrace();
        }
        return false;
    }

}
