package hello.filters.pre;

import javax.servlet.http.HttpServletRequest;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.ZuulFilter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SimpleFilter extends ZuulFilter {

  private static Logger log = LoggerFactory.getLogger(SimpleFilter.class);

  @Override
  public String filterType() {
    return "pre";
    //post , routing, or error
    
  }
//  gives the order in which this filter will be executed, relative to other filters.
  @Override
  public int filterOrder() {
    return 1;
  }
/*  contains the logic that determines when to execute this 
  filter (this particular filter will always be executed).*/
  @Override
  public boolean shouldFilter() {
    return true;
  }

//  contains the functionality of the filter
  @Override
  public Object run() {
    RequestContext ctx = RequestContext.getCurrentContext();
    HttpServletRequest request = ctx.getRequest();

    log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

    return null;
  }

}
