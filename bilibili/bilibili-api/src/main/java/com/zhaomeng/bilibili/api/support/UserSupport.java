package com.zhaomeng.bilibili.api.support;

import com.zhaomeng.bilibili.domain.exception.ConditionException;
import com.zhaomeng.bilibili.service.util.TokenUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequestAttributeEvent;

/**
 * @author: zhaomeng
 * @Date: 2022/11/27 18:09
 */

@Component
public class UserSupport {

    public Long getCurrentUserId() {
        // !抓取前段传来的请求
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

        // !拿到请求中的token
        String token = requestAttributes.getRequest().getHeader("token");

        // !验证token，并拿到token中的userId
        Long userId = TokenUtil.verifyToken(token);

        if (userId < 0) {
            throw new ConditionException("非法用户");
        }

        return userId;
    }
}
