package com.xhpolaris.meowcloud.adaptation.security;

import com.xhpolaris.meowcloud.common.Result;
import com.xhpolaris.meowcloud.common.enums.UserExceptionEn;
import com.xhpolaris.meowcloud.common.exception.BaseException;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

// 对用户信息进行处理
@Component
public class AuthorizationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

        // 获取token
        String token = httpRequest.getHeader("Authorization");



        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);  // 移除 token 前缀

            boolean isValid = validateToke(token);

            if (!isValid) {
                // JWT 校验失败，返回异常
                httpResponse.setContentType("application/json;charset=UTF-8");
                httpResponse.getWriter().write(Result.immediateFail(new BaseException(UserExceptionEn.ERROR_TOKEN)));
                return; // 停止处理请求
            }
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        // JWT 为空，返回异常
        httpResponse.setContentType("application/json;charset=UTF-8");
        httpResponse.getWriter().write(Result.immediateFail(new BaseException(UserExceptionEn.ERROR_TOKEN)));
        // 停止处理请求
    }

    private boolean validateToke(String token) {
        // TODO 调用用户服务校验用户信息，并存储进上下文
        if (token.equals("shadow"))
            return true;
        return false;
    }
}
