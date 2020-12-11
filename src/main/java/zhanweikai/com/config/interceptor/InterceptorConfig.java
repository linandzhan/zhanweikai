package zhanweikai.com.config.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
@Configuration
public class InterceptorConfig extends WebMvcConfigurerAdapter {

    @Bean
    AuthenticationInterceptor authenticationInterceptor(){
        return new AuthenticationInterceptor();
    }

    public void addInterceptors(InterceptorRegistry registry) {

        // 权限校验拦截器配置
        registry.addInterceptor(authenticationInterceptor()).addPathPatterns("/**");



        // 父类的配置
        super.addInterceptors(registry);
    }
}
