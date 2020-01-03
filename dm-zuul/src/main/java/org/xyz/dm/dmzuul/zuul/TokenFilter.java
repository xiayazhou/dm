package org.xyz.dm.dmzuul.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class TokenFilter extends ZuulFilter  {

    @Value("${tokenEnable}")
    private Boolean tokenEnable;

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();
        String token = request.getParameter("token");
        //     http://localhost:9006/item/p/index/queryAllType
        String uri = request.getRequestURI();
//        System.out.println(uri.split("/")[3]);
        System.out.println(uri);
        if(uri.split("/")[2].equals("p")){
            return "success";
        }
        if(token!=null && !token.trim().equals("")){
            return "success";
        }
        context.setSendZuulResponse(false);
        context.setResponseStatusCode(403);
        context.setResponseBody("{\"msg\":\"403, access without permission , pls login first.\"}");
        return "error";
    }
}
