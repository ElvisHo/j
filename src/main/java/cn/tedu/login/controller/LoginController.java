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

		
		//�����ڴ�ӳ����󣨻�����
		BufferedImage image=new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
		//��û���
		Graphics g=image.getGraphics();
		//����������ɫ
		g.setColor(new Color(255,255,255));
		//�ñʸ��������ñ�����ɫ
		g.fillRect(0, 0, 80, 30);
		//���¸�������һ���µ���ɫ
      Random r=new Random(); 		
	    g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
	    //��������
	    g.setFont(new Font(null, Font.ITALIC,24));
	    //��ͼ��number��
	    String number=getCode(4);
	    //��number�󶩵�session������
	    HttpSession session=request.getSession();
	    session.setAttribute("number", number);
	    
	    g.drawString(number, 5, 25);
	    //��һЩ������
	    for(int i=0;i<8;i++){
	    	g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
	    	g.drawLine(r.nextInt(80), r.nextInt(30), r.nextInt(80), r.nextInt(30));
	    }
		/*
		 * ��ͼƬѹ��ȻȻ������������
		 */
	    //����MIME���ͣ���������������������ص���ͼƬ��
	    response.setContentType("image/jpeg");
	    //���ͼƬӦ��ʹ���ֽ������
		OutputStream os=response.getOutputStream();
		//ѹ��ͼƬ�����
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
	    * �ȱȽ���֤���Ƿ���ȷ���������ȷ����ʾ�û��������ڱȽ��û���������
	    */
	   String number1=request.getParameter("number");
	   String number2=(String)session.getAttribute("number");
	   if(!number1.equals(number2)){
		   request.setAttribute("number_error", "��֤�����");
		   return "login";
	   }
	   String uname=request.getParameter("username");
	   String pwd=request.getParameter("pwd");
	   System.out.println("usename:"+uname+",password:"+pwd);
	   //����ҵ���ķ�����е�¼����֤
	
	   User user=service.checkLogin(uname, pwd);
	   //����������session��֤
	   session.setAttribute("user", user);
	   return "redirect:toIndex.do";//��¼�ɹ� �ض�����ҳ
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
