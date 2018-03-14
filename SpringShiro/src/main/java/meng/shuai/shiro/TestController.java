package meng.shuai.shiro;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
@RequestMapping("/index")
	public String index(){
		return "index";
	}
@RequestMapping("login")
public String login(String name ,String password){
	UsernamePasswordToken token=new UsernamePasswordToken(name,password);
	Subject subject=SecurityUtils.getSubject();
	try {
		subject.login(token);
	} catch (AuthenticationException e) {
System.out.println("µÇÂ¼Ê§°Ü");		e.printStackTrace();
	}
	return "list";
	
	
}
}
