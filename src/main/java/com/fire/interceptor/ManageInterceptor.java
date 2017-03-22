package com.fire.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Aspect
@Component
public class ManageInterceptor implements HandlerInterceptor{

public void postHandle (HttpServletRequest request, HttpServletResponse response, Object handle, ModelAndView modelAndView)
	 throws Exception{
		 // TODO Auto-generated method stub  
	}
	public void afterCompletion(HttpServletRequest request,   HttpServletResponse response, Object handler, Exception ex)
	    throws Exception {  
	        // TODO Auto-generated method stub  
	          
	    }  

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) 
			throws Exception{
			
			//登录拦截
			 if(request.getSession().getAttribute("limit")==null)
			 {
				 request.getRequestDispatcher( "/manage/login_new.jsp").forward(request, response);
				 return false;
			 }
			 return true;
		}

	
}
