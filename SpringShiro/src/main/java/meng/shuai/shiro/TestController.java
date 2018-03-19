package meng.shuai.shiro;


import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	@RequestMapping("/index")
	public String index(){
		return "redirect:/list.jsp";
	}
	@RequestMapping("login")
	public String login(String name ,String password  ,HttpSession session){
		UsernamePasswordToken token=new UsernamePasswordToken(name,password);
		Subject subject=SecurityUtils.getSubject();
		try {
			subject.login(token);
		} catch (AuthenticationException e) {
			System.out.println("µÇÂ¼Ê§°Ü");		e.printStackTrace();
		}
		session.setAttribute("meng", "shuai");
		Session session2 = subject.getSession();
		System.out.println(session);
		System.out.println(session2);
		Object attribute = session.getAttribute("meng");
		System.out.println(attribute);
		return "redirect:/list.jsp";


	}
}
