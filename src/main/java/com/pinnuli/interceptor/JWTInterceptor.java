package com.pinnuli.interceptor;

import com.alibaba.fastjson.JSON;
import com.pinnuli.commons.ErrorCodeEnum;
import com.pinnuli.commons.Result;
import com.pinnuli.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

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
        String userName = request.getHeader("currentUserName");
        try {
            if (jwt == null) {
                log.info("用户未登录，验证失败");
                return buildResponseResult(response, ErrorCodeEnum.ILLEGAL_OPERATION);
            } else {
                Claims c;
                c = util.parseJWT(jwt);
                if(c.get("currentUserName").equals(userName)) {
                    log.info("用户id" + c.get("currentUserId") + "已是登录状态");
                    return true;
                }
            }
            log.info("token解析错误，验证失败");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("未登录，请重新登录后操作");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            log.debug("");
            e.printStackTrace();
        }
        return false;
    }

    private boolean buildResponseResult(HttpServletResponse response, ErrorCodeEnum errorCodeEnum) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print(JSON.toJSONString(Result.createByErrorCodeMessage(errorCodeEnum.getCode(), errorCodeEnum.getMessage())));
        out.flush();
        out.close();
        return false;
    }

}
