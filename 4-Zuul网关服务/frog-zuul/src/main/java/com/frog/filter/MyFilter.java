package com.frog.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: MyFilter
 * Description: 自定义拦截器
 * Date: 2018/8/21 10:01
 *
 * @author guoxinlu
 */
public class MyFilter extends ZuulFilter{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 过滤器的类型，决定过滤器在请求的那个生命周期中执行，pre表示请求被路由之前执行
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器的执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 判断该过滤器是否需要执行，true所有请求都有效
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器的具体逻辑
     * @return
     */
    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        logger.info("[myfilter] send {} request to {}", request.getMethod(), request.getRequestURL().toString());

        String token = request.getParameter("token");
        if (token == null) {
            try {
                logger.warn("token is empty");
                // 设置不进行路由
                requestContext.setSendZuulResponse(false);
                // 设置返回状态码为401
                requestContext.setResponseStatusCode(401);
                // 设置返回body
                requestContext.setResponseBody("您没有权限访问该模块");
                //requestContext.addZuulResponseHeader("Content-Encoding","UTF-8");
                requestContext.addZuulResponseHeader("Content-Type", "text/html;charset=UTF-8");
                //requestContext.addZuulResponseHeader("Content-Language","zh-CN");
                return null;
            } catch (Exception e) {
                // !!!异常处理
                requestContext.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                requestContext.set("error.message", e.getMessage());
                requestContext.set("error.exception", e);
            }
        }

        logger.info("token is {}", token);
        return null;
    }
}
