package com.frog.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletResponse;

/**
 * ClassName: ErrorFilter
 * Description: error过滤器，在请求生命周期的pre，route，post三个阶段抛出的异常都会进入error阶段处理</br>
 * 除了在myfilter中使用try-catch处理，定义该过滤器作为双重保险。
 * Date: 2018/8/21 19:46
 *
 * @author guoxinlu
 */
public class ErrorFilter extends ZuulFilter {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public String filterType() {
        return "error";
    }

    @Override
    public int filterOrder() {
        return 10;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        Throwable throwable = requestContext.getThrowable();

        logger.info("[my error filter] throwable: {}", throwable.getCause().getMessage());

        requestContext.set("error.status_code", HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        requestContext.set("error.message", throwable.getMessage());
        requestContext.set("error.exception", throwable);

        return null;
    }
}
