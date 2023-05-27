package com.armorfeed.api.vehicles.security;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import com.armorfeed.api.vehicles.providers.feignclients.UsersServiceFeignClient;
import com.armorfeed.api.vehicles.providers.feignclients.dtos.AuthTokenResponse;

import lombok.extern.slf4j.Slf4j;

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

    private enum AuthTokenMessage { 
        OK("Sucessfull authentication");
        private String message;
        private AuthTokenMessage(String message) {
            this.message = message;
        }
        public String getMessage() {
            return this.message;
        }
    }

    private boolean isValidToken(HttpServletRequest request) {
        String authorizationHeader = request.getHeader("Authorization");
        log.info("AuthorizationHeader: {}",authorizationHeader);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            String token = authorizationHeader.substring(7);
            log.info("Token is {}", token);
            AuthTokenResponse authTokenResponse = usersServiceFeignClient.validateToken(token);
            log.info("Token is valid is {} and message is {}", authTokenResponse.isValidToken(), authTokenResponse.getMessage());
            return authTokenResponse.isValidToken() || authTokenResponse.getMessage().equals(AuthTokenMessage.OK.getMessage());
        }
        return false;
    }
    
}
