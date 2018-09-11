package com.pinnuli.interceptor;

import com.alibaba.fastjson.JSON;
import com.pinnuli.commons.ErrorCodeEnum;
import com.pinnuli.commons.Result;
import com.pinnuli.utils.JwtUtil;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

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
        String jwt = request.getHeader("Authorization");
        String userName = request.getHeader("currentUserName");
        try {
            if (jwt == null) {
                log.info("用户未登录，验证失败");
                return buildResponseResult(response, ErrorCodeEnum.ILLEGAL_OPERATION);
            } else {
                //解析token
                Claims c;
                c = JwtUtil.parseJWT(jwt);
                //验证用户名是否正确
                if(c.get("userName").equals(userName)) {
                    log.info("用户id" + c.get("uid") + "已是登录状态");
                    return true;
                }
            }

        } catch (ExpiredJwtException expiredJwtException) {
            //token过期
            log.info("token已过期");
            try {
                return buildResponseResult(response, ErrorCodeEnum.TOKEN_EXPIRED);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            log.info("token解析错误，验证失败");
            try {
                return buildResponseResult(response, ErrorCodeEnum.TOKEN_VALID);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        return false;
    }

    private boolean  buildResponseResult(HttpServletResponse response, ErrorCodeEnum errorCodeEnum) throws IOException {
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print(JSON.toJSONString(Result.createByErrorCodeEnum(errorCodeEnum)));
        out.flush();
        out.close();
        return false;
    }

}
