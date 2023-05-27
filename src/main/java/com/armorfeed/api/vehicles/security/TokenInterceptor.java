package com.armorfeed.api.vehicles.security;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.armorfeed.api.vehicles.providers.feignclients.UsersServiceFeignClient;
import com.armorfeed.api.vehicles.providers.feignclients.dtos.AuthTokenResponse;

@Slf4j
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private UsersServiceFeignClient usersServiceFeignClient;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        if (!isValidToken(request)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        } 
        return true;
    }

    private boolean isValidToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        log.info("AuthorizationHeader: {}",authorizationHeader);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);
            AuthTokenResponse authTokenResponse = usersServiceFeignClient.validateToken(token);
            return authTokenResponse.isValidToken();
        }
        return false;
    }
    
}
