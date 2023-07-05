package tomyjan.moeclassroommanager.common.config.interceptor;

import tomyjan.moeclassroommanager.common.annotation.Operation;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import tomyjan.moeclassroommanager.common.context.Constant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 判断是否需要登录
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object    attribute = request.getSession().getAttribute(Constant.SESSION_USER);
        Operation operation = null;
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            if (method.hasMethodAnnotation(Operation.class)) {
                operation = method.getMethodAnnotation(Operation.class);
            } else {
                if (method.getBeanType().isAnnotationPresent(Operation.class)) {
                    operation = method.getBeanType().getAnnotation(Operation.class);
                }
            }
        }
        if (operation != null && operation.needLogin() && null == attribute) {
            response.sendRedirect("/login");
            return false;
        }
        return true;
    }
}
