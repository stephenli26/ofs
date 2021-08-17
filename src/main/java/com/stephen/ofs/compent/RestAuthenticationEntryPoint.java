package com.stephen.ofs.compent;

import cn.hutool.json.JSONUtil;
import com.stephen.ofs.constant.ErrorCode;
import com.stephen.ofs.entity.model.CommonResult;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * @Description: 当未登录或者token失效访问接口时，自定义的返回结果
 * @Author: zlf
 * @Date: 2021/3/30
 */
@Component
public class RestAuthenticationEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSONUtil.parse(new CommonResult(ErrorCode.UNAUTHORIZED)));
        response.getWriter().flush();
    }
}
