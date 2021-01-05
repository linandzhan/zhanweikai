package zhanweikai.com.config.interceptor;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.*;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Resource
    private Environment environment;
    private String attachmentHome;

    @PostConstruct
    public void init() {
        this.attachmentHome = (String) this.environment.getProperty("attachment.home", String.class, "attachment/");
        if (this.attachmentHome != null && !this.attachmentHome.endsWith("/")) {
            this.attachmentHome = this.attachmentHome + "/";
        }
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/**");        //拦截所有请求，通过判断是否有@LoginRequired 注解 决定是否需要登录
    }

    @Bean
    public HandlerInterceptor authenticationInterceptor() {
        return new AuthenticationInterceptor();
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //http://localhost:8888/image   /test.jpg
        registry.addResourceHandler("/image/**").addResourceLocations("file:"+attachmentHome);
    }

}
