package hello;

import org.springframework.boot.SpringApplication; 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import hello.filters.pre.SimpleFilter;

@EnableZuulProxy
@SpringBootApplication
public class GatewayApplication {

  public static void main(String[] args) {
    SpringApplication.run(GatewayApplication.class, args);
  }

  /*The GatewayApplication class is annotated with @SpringBootApplication,
   *  which is equivalent to (among others) the @Configuration annotation that tells
   *   Spring to look in a given class for @Bean definitions. 
   *   Add one for our SimpleFilter here:*/
  @Bean
  public SimpleFilter simpleFilter() {
    return new SimpleFilter();
  }

}
