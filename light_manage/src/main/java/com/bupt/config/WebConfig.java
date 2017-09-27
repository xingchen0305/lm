package com.bupt.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by hexiuyu on 2017/1/19.
 */
@Configuration
public class WebConfig extends RepositoryRestConfigurerAdapter {


    /**
     *  todo
     * to permit csrf , but it will move to api gateway in the future
     */
    @Component
    @Order(Ordered.HIGHEST_PRECEDENCE)
    class CorsFilter implements Filter {

        public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
            HttpServletResponse response = (HttpServletResponse) res;
            HttpServletRequest request = (HttpServletRequest) req;
            response.setHeader("Access-Control-Allow-Origin", "*");
            response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
            response.setHeader("Access-Control-Allow-Headers", "X-XSRF-TOKEN, Origin, X-Requested-With, Content-Type, Accept, Authorization");
            response.setHeader("Access-Control-Max-Age", "3600");
            if (!"OPTIONS".equals(request.getMethod())) {
                chain.doFilter(req, res);
            } else {
            }
        }

        public void init(FilterConfig filterConfig) {}

        public void destroy() {}

    }


}
