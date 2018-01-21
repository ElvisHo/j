package cn.tedu.login.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 用于session验证的拦截器
 * @author Administrator
 *
 */
public class LoginInterceptor implements HandlerInterceptor{

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle()开始session验证");
		//获取session对象
		Object obj=request.getSession().getAttribute("user");
		if(obj==null){
			//没有登录要重定向到登录页面
			System.out.println("重定向到登录页面");
			response.sendRedirect("toLogin.do");
			return false;
		}
		System.out.println("允许访问");
		return true;//登录过允许访问
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		
	}
     
}
