package com.springboot.sample.config;

import org.apache.shiro.authz.UnauthorizedException;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class MyExceptionResolver{
	
    @ExceptionHandler(UnauthorizedException.class)
    public ModelAndView handleShiroException(HttpServletRequest req, HttpServletResponse resp, Exception e) throws IOException {
    	if (e instanceof UnauthorizedException) {
            ModelAndView mv = new ModelAndView("/403");
            return mv;
        }
    	
        return null;
    }
	
    @ResponseBody
    @ExceptionHandler(AuthorizationException.class)
    public String AuthorizationException(Exception ex) {
        return "权限认证失败！！";
    }

}
