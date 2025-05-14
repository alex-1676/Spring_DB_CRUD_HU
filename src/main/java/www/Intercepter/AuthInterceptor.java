package www.Intercepter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class AuthInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       log.info("AuthInterceptor={}", "=====================exist interceptor=====================");
        return super.preHandle(request, response, handler);
    }
}
