package meng.shiro.Hellowdemo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

/**
 * Hello world!
 *
 */
public class App 
{
    
    public static void main( String[] args )
    {
    	Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:my.ini");
    	SecurityManager securityManager = factory.getInstance();
    	//subject、
    	SecurityUtils.setSecurityManager(securityManager);
    	Subject subject = SecurityUtils.getSubject();
    	
//    	获取session
    	Session session=subject.getSession();
    	session.setAttribute("hellow", "world");
    	String value = (String)session.getAttribute("hellow");
    	System.out.println(value);
    	
    	
    	// 测试当前的用户是否已经被认证. 即是否已经登录.
    	if(subject.isAuthenticated()){
    		System.out.println("已经登录");
    	}else{
    		System.out.println("没登录");
    		//执行登录
    		UsernamePasswordToken token =new UsernamePasswordToken("root","meng");
    		token.setRememberMe(true);
    		//登录操作
    		subject.login(token);
    		System.out.println("是否登录?"+subject.isAuthenticated());
    	}
    	
    	//测试角色
    	
    	if(subject.hasRole("admin")){
    		System.out.println("yes");
    	}
    	
    	//测试行为
    	if(subject.isPermitted("admin")){
    		System.out.println("yes");
    	}
    	
    	
    }
}
