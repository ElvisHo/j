package cn.tedu.login.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * ����session��֤��������
 * @author Administrator
 *
 */
public class LoginInterceptor implements HandlerInterceptor{

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle()��ʼsession��֤");
		//��ȡsession����
		Object obj=request.getSession().getAttribute("user");
		if(obj==null){
			//û�е�¼Ҫ�ض��򵽵�¼ҳ��
			System.out.println("�ض��򵽵�¼ҳ��");
			response.sendRedirect("toLogin.do");
			return false;
		}
		System.out.println("�������");
		return true;//��¼���������
	}

	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		
	}
     
}
