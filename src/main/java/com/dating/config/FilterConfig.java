package com.dating.config;

import com.dating.mapper.UserMapper;
import com.dating.pojo.User;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;

@Component
public class FilterConfig implements Filter {

    @Resource
    private UserMapper userMapper;

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) resp;
//        String customer = request.getParameter("username");
//        String passWord = request.getParameter("password");
//        User user = userMapper.findByUserName(customer);
//        if (user != null){
//            if (!passWord.equals(user.getPassword())) {
//                request.getRequestDispatcher("/").forward(request, response);
//            }
//        }
        chain.doFilter(req, resp);
    }

}

