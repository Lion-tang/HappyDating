package com.dating.config;

import com.dating.pojo.User;
import com.dating.realm.LoginRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Hashtable;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager securityManager){
        ShiroFilterFactoryBean factoryBean = new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(securityManager);
        Map<String,String> map = new Hashtable<>();
        map.put("/main", "authc");
        map.put("/admin", "perms[manage]");
        factoryBean.setFilterChainDefinitionMap(map);
        factoryBean.setLoginUrl("/index");
        factoryBean.setUnauthorizedUrl("/unauthc");
        return factoryBean;
    }


    @Bean
    public DefaultWebSecurityManager securityManager(@Qualifier("loginRealm") LoginRealm loginRealm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(loginRealm);
        return manager;
    }

    @Bean
    public LoginRealm loginRealm(){
        return new LoginRealm();
    }
}
