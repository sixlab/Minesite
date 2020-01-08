package cn.sixlab.minesite.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    MineLogoutHandler logoutHandler;

    @Autowired
    MineAuthHandler authHandler;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authHandler);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //允许被 iframe 嵌入
        http.headers().frameOptions().disable();

        //关闭csrf
        http.csrf().disable();

        // 无状态
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        // 登录
        http.formLogin().loginProcessingUrl("/login")
                .successHandler(authHandler)
                .failureHandler(authHandler);

        // 退出
        http.logout().logoutUrl("/logout")
                .addLogoutHandler(logoutHandler)
                .logoutSuccessHandler(logoutHandler);

        // 登录才可以访问 - 例外设置
        http.authorizeRequests()
                .antMatchers(
                        "/*",
                        "/**/guest/**"
                ).permitAll()
                .anyRequest().authenticated();

        http.exceptionHandling()
                .accessDeniedHandler(authHandler)
                .authenticationEntryPoint(authHandler);

        // 校验过滤器
        http.addFilter(new MineAuthFilter(authenticationManager()));
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/druid/**")
                .antMatchers("/static/**")
                .antMatchers("/callback/**")
                .antMatchers("/favicon.ico");
    }

}
