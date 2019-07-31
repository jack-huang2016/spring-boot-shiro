package com.springboot.sample.realm;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.springboot.sample.entity.Permission;
import com.springboot.sample.entity.Role;
import com.springboot.sample.entity.User;
import com.springboot.sample.mapper.PermissionMapper;
import com.springboot.sample.mapper.RoleMapper;
import com.springboot.sample.mapper.UserMapper;

public class MyRealm extends AuthorizingRealm {
	
	private final static Logger logger = LoggerFactory.getLogger(MyRealm.class);
	
	@Autowired
	private UserMapper userDao;
	
	@Autowired
	private RoleMapper roleDao;

	@Autowired
	private PermissionMapper permissionDao;

	/**
	 * 授权
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		logger.debug("##################为用户授权##################");
		//方式一：直接通过SecurityUtils类来获取用户名
		//String userName=(String) SecurityUtils.getSubject().getPrincipal();
		//方式二：通过PrincipalCollection类来获取用户，从而获取用户名
		User user = (User) principals.getPrimaryPrincipal();
		if(user != null){
			SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
			Set<String> roles=new HashSet<String>();
			List<Role> rolesByUserName = roleDao.getRolesByUserName(user.getUserName());
			for(Role role:rolesByUserName) {
				roles.add(role.getRoleName());
			}
			List<Permission> permissionsByUserName = permissionDao.getPermissionsByUserName(user.getUserName());
			for(Permission permission:permissionsByUserName) {
				info.addStringPermission(permission.getPermissionName());
			}
			info.setRoles(roles);
			return info;
		}
		
		return null;
	}

	/**
	 * 认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		logger.debug("##################用户认证执行##################");
		//方式一：直接通过token.getPrincipal()获取用户名
		//String userName = token.getPrincipal().toString();
		//方式二：直接强转成UsernamePasswordToken类来获取用户名
		UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
		//获取前端输入的用户名
        String userName  = usernamePasswordToken.getUsername();
        //根据用户名查询数据库中对应的记录
		User user = userDao.getUserByUserName(userName);
		if(user==null){
            logger.error("用户 { "+userName+" } 不存在 ");
            throw new UnknownAccountException("账户不存在");
        }
		if(user.getStatus() == 0){
            logger.error("用户 { " + userName + " } 被禁用 ");
            throw new DisabledAccountException("账号已经禁止登录");
        }
		if(user.getIsLocked() == 0){
            logger.error("用户 { " + userName + " } 被锁定 ");
            throw new LockedAccountException("账号已经被锁定");
        }
		//当前realm对象的name
        String realmName = getName();
        //盐值
        ByteSource credentialsSalt = ByteSource.Util.bytes(user.getUserName());
        //封装用户信息，构建AuthenticationInfo对象并返回
        AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user, user.getPassword(),
                credentialsSalt, realmName);
        
        return authcInfo;
	}

}
