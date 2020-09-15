package com.dating.realm;

import com.dating.pojo.User;
import com.dating.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

<<<<<<< Updated upstream:src/main/java/com/dating/realm/LoginRealm.java
public class LoginRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;
=======
import javax.annotation.Resource;
import java.util.Map;


public class LoginRealm extends AuthorizingRealm {
    @Resource
    private UserService userService;

>>>>>>> Stashed changes:src/main/java/com/dating/Realm/LoginRealm.java
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        User user = userService.findByUserName(token.getUsername());
<<<<<<< Updated upstream:src/main/java/com/dating/realm/LoginRealm.java
        if(user != null){
            return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
=======
        if (user != null) {
            return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
>>>>>>> Stashed changes:src/main/java/com/dating/Realm/LoginRealm.java
        }
        return null;
    }
}
