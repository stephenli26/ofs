package com.stephen.ofs.compent;

import cn.hutool.json.JSONUtil;
import com.stephen.ofs.constant.ErrorCode;
import com.stephen.ofs.entity.model.CommonResult;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

/**
 * @Description: 当访问接口没有权限时，自定义的返回结果
 * @Author: zlf
 * @Date: 2021/3/30
 */
@Component
public class RestfulAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request,
            HttpServletResponse response,
            AccessDeniedException e) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json");
        response.getWriter().println(JSONUtil.parse(new CommonResult(ErrorCode.NOT_ACCESSIBLE)));
        response.getWriter().flush();
    }
}
