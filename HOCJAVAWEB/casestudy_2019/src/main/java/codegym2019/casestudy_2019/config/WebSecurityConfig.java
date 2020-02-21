package codegym2019.casestudy_2019.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder managerBuilder) throws Exception {
        managerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());

    }


    @Override
    public void configure(HttpSecurity http) throws Exception{
        http.
                authorizeRequests()
                //cấu hình cho các đường dẫn ko cần xác thực
                .antMatchers("/","/login","/register").permitAll()
                 //cấu hình cho các đường dẫn đăng nhập bằng role là Member,Admin
                 .antMatchers("/review","/booking").hasAnyRole("MEMBER","ADMIN")
                 //cấu hình cho đường dẫn admin,chỉ có Role admin mới vào đc
                 .antMatchers("/admin").hasRole("ADMIN")
                 .and()
                 //from login
                  .formLogin()
                  //đường dẫn trả về trang login
                  .loginPage("/login")
                  .usernameParameter("email")
                  .passwordParameter("password")
                  //neu login thanh cong se tra ve trang chu
                   .defaultSuccessUrl("/")
                  //neu login that bai
                   .failureUrl("/login?error")
                   //neu login thanh cong nhung khong vao dung role
                    .and()
                    .exceptionHandling()
                    .accessDeniedPage("403");

    }
}
