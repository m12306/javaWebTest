package cn.edu.ncu.forums.config;

import cn.edu.ncu.forums.JwtFilter.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Description:JSON Web Token 配置
 * @author Carlos Leo
 * @author 1119637652@qq.com
 * Time : 2018/12/20 21:26
 * @version : 1.0
 */
@Configuration
public class JwtConfig {
    @Bean
    public FilterRegistrationBean<JwtFilter> jwtFilter() {
        final FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new JwtFilter());
//        registrationBean.addUrlPatterns("/user/*");
        registrationBean.addUrlPatterns("/article/*");
        registrationBean.addUrlPatterns("/comment/*");
        registrationBean.addUrlPatterns("/reversion/*");
        return registrationBean;
    }
}
