package cn.tedu.login.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.login.entity.User;
import cn.tedu.login.sevice.AppException;
import cn.tedu.login.sevice.LoginService;

@Controller
public class LoginController {
	@Resource(name="loginService")
	private LoginService service;
   @RequestMapping("/toLogin.do")
   public String toLogin(){
	   System.out.println("toLogin()");
	   return "login";
   }
   @RequestMapping("/checkcode.do")
   public void checkcode(HttpServletRequest request, HttpServletResponse response) throws IOException{

		
		//创建内存映像对象（画布）
		BufferedImage image=new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
		//获得画笔
		Graphics g=image.getGraphics();
		//给笔设置颜色
		g.setColor(new Color(255,255,255));
		//用笔给画布设置背景颜色
		g.fillRect(0, 0, 80, 30);
		//重新给笔设置一个新的颜色
      Random r=new Random(); 		
	    g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
	    //设置字体
	    g.setFont(new Font(null, Font.ITALIC,24));
	    //绘图（number）
	    String number=getCode(4);
	    //将number绑订到session对象上
	    HttpSession session=request.getSession();
	    session.setAttribute("number", number);
	    
	    g.drawString(number, 5, 25);
	    //加一些干扰线
	    for(int i=0;i<8;i++){
	    	g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
	    	g.drawLine(r.nextInt(80), r.nextInt(30), r.nextInt(80), r.nextInt(30));
	    }
		/*
		 * 将图片压缩然然后输出给浏览器
		 */
	    //设置MIME类型（告诉浏览器，服务器返回的是图片）
	    response.setContentType("image/jpeg");
	    //输出图片应该使用字节输出流
		OutputStream os=response.getOutputStream();
		//压缩图片并输出
		javax.imageio.ImageIO.write(image, "jpeg", os);
		os.close();
	}
	private String getCode(int i) {
		char[] letter={'1','2','3','4','5','6','7','8','9','0','A','B','C','D','E','F','G','H','I', 'J',
				'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
				'W', 'X', 'Y', 'Z'};
		String number="";
		for(int j=0;j<i;j++){
			int index=(int)(Math.random()*letter.length);
			number+=letter[index];
		}
		
		return number;
	}
   
   @RequestMapping("/login.do")
   public String login(HttpServletRequest request,HttpSession session){
	   System.out.println("login()")   ;
	   /*
	    * 先比较验证码是否正确，如果不正确，提示用户，否则在比较用户名和密码
	    */
	   String number1=request.getParameter("number");
	   String number2=(String)session.getAttribute("number");
	   if(!number1.equals(number2)){
		   request.setAttribute("number_error", "验证码错误");
		   return "login";
	   }
	   String uname=request.getParameter("username");
	   String pwd=request.getParameter("pwd");
	   System.out.println("usename:"+uname+",password:"+pwd);
	   //调用业务层的服务进行登录的验证
	
	   User user=service.checkLogin(uname, pwd);
	   //绑订数据用于session验证
	   session.setAttribute("user", user);
	   return "redirect:toIndex.do";//登录成功 重定向到首页
   }

   @ExceptionHandler
   public String handle(Exception e,HttpServletRequest request){
	   System.out.println("handle()");
	   if(e instanceof AppException){
			 request.setAttribute("login_failed", e.getMessage());
			  return  "login"; 
		  }
	return "error";
	   
   }
   
   @RequestMapping("/toIndex.do")
   public String toIndex(){
	   System.out.println("toIndex()");
	   return"index";
   }
    
}
