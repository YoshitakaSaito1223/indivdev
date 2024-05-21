package com.example.myapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

	@Bean // このメソッドの返り値をSpringのBeanとして登録します
	public PasswordEncoder passwordEncoder() { // パスワードエンコーダー（パスワードのハッシュ化）を提供するメソッド
		return new BCryptPasswordEncoder(); // パスワードをBCrypt方式でハッシュ化するエンコーダーを返します
	}

	@Bean // このメソッドの返り値をSpringのBeanとして登録します
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception { // セキュリティフィルタチェーンを定義するメソッド
		http
				.authorizeRequests(authorizeRequests -> // 認証リクエストを設定します
				authorizeRequests
						.requestMatchers("/login", "/registration", "/registration_check", "/registration_completed",
								"/")
						.permitAll() // "/login"と"/register"へのリクエストは認証なしで許可します
						.anyRequest().authenticated() // それ以外の全てのリクエストは認証が必要です
				)
				.formLogin(formLogin -> // フォームベースのログインを設定します
				formLogin
						.loginPage("/login") // ログインページのURLを設定します
						.defaultSuccessUrl("/index", true)
						.permitAll() // ログインページは認証なしで許可します
				)
				.logout(logout -> // ログアウトを設定します
				logout
						.logoutRequestMatcher(new AntPathRequestMatcher("/logout")) // ログアウトのリクエストURLを設定します
						.logoutSuccessUrl("/") // ログアウト成功後のリダイレクト先を指定
						.invalidateHttpSession(true) // HTTPセッションを無効化する
						.deleteCookies("JSESSIONID") // クッキーを削除する
				)
				.csrf((csrf) -> csrf.disable());

		return http.build(); // 上記の設定を反映してHttpSecurityオブジェクトをビルドします
	}
}
