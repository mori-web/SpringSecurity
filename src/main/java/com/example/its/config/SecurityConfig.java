package com.example.its.config;


import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//カスタムログインページが表示される設定を指定する
@EnableWebSecurity //@EnableWebSecurityは、このクラスはWEB関連のセキュリティいう指定
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  private final UserDetailsService userDetailsService;
  private final PasswordEncoder passwordEncoder;

  //自作ログインページを作成する
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    //for h2-console
    http
        .authorizeRequests().antMatchers("/h2-console/**").permitAll()
        .and()
        .csrf().ignoringAntMatchers("/h2-console/**")
        .and()
        .headers().frameOptions().disable();

    http
        .authorizeRequests()
        .mvcMatchers("/users/**").hasAnyAuthority("ADMIN") //ADMINユーザーしか/users以下のURLしかアクセスできない
        .mvcMatchers("/login/**").permitAll() //『/login/**』のこのURLのページは認証不要という指示
        .anyRequest().authenticated() //それ以外のページは認証が必要であるという指示
        .and()
        .formLogin()                 //ログイン認証はフォームログインで指定
        .loginPage("/login");       //ログインページのパスは『/login』であるという指定
  }

  //ログイン処理時にUserDetailServiceを組み込ませて呼び出す処理
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //authオブジェクトのuserDetailsServiceメソッドで自作のuserDetailsServiceを登録する
    auth.userDetailsService(userDetailsService)
        //passwordEncoderはパスワードをハッシュ化する指示
        .passwordEncoder(passwordEncoder);
  }
}
