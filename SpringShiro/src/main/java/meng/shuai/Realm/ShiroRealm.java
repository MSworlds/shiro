package meng.shuai.Realm;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class ShiroRealm extends AuthorizingRealm{
	//认证
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken currenToken=(UsernamePasswordToken)token;
		String username = currenToken.getUsername();
		if(username.equals("admin")||username.equals("user")){
			System.out.println(" 认证");
		}else{
				throw new UnknownAccountException("认证失败");
		}
		Object principal =username;
		Object credentials="fc1709d0a95a6be30bc5926fdb7f22f4";
		String realmName=getName();
		System.out.println(realmName);
		SimpleAuthenticationInfo simpleAuthenticationInfo =new SimpleAuthenticationInfo(principal, credentials, realmName);
		return simpleAuthenticationInfo;
	}
	
public static void main(String[] args) {
	String algorithmName="md5";
			String source="123456";
	String salt=null;
	int hashIterations=1024;
	SimpleHash simpleHash = new SimpleHash(algorithmName, source, salt, hashIterations);
	System.out.println(simpleHash);
}

@Override
protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalcollection) {
     System.out.println("授权");
	Object primaryPrincipal = principalcollection.getPrimaryPrincipal();
	System.out.println("授权中"+primaryPrincipal);
	Set role =new HashSet();
	role.add("user");
	if(primaryPrincipal.equals("admin")){
		role.add("admin");
	}
	SimpleAuthorizationInfo nn=new SimpleAuthorizationInfo(role);
	return nn;
}

}
