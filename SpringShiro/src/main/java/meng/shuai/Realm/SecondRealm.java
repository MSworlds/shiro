package meng.shuai.Realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthenticatingRealm;

public class SecondRealm extends AuthenticatingRealm {

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationtoken)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		UsernamePasswordToken currenToken=(UsernamePasswordToken)authenticationtoken;
		String username = currenToken.getUsername();
	if(username.equals("admin")){
		System.out.println(" SecondRealm认证");
	}else{
			throw new UnknownAccountException("SecondRealm认证失败");
	}
	Object principal ="admin";
	Object credentials="a94d5cd0079cfc8db030e1107de1addd1903a01b";
	String realmName=getName();
	System.out.println(realmName);
	SimpleAuthenticationInfo simpleAuthenticationInfo =new SimpleAuthenticationInfo(principal, credentials, realmName);
	return simpleAuthenticationInfo;
}
	public static void main(String[] args) {
		String algorithmName="SHA1";
				String source="123456";
		String salt=null;
		int hashIterations=1024;
		SimpleHash simpleHash = new SimpleHash(algorithmName, source, salt, hashIterations);
		System.out.println(simpleHash);	

}}
