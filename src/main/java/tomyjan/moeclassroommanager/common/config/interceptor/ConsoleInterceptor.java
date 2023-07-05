package tomyjan.moeclassroommanager.common.config.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 后台登录拦截
 */
@Component
public class ConsoleInterceptor implements HandlerInterceptor {
    private static final String SESSION_ADMIN = "sessionAdmin";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        Object attribute = request.getSession().getAttribute(SESSION_ADMIN);
        String contextPath = request.getContextPath();
        if (null == attribute) {
            response.sendRedirect(contextPath + "/console/login");
            return false;
        }
        return true;
    }
}
