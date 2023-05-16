package com.se.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.se.service.imlp.UserDetailServicesImpl;
import com.se.util.JwtRequestFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthenticationEntryPoint authenticationEntryPoint;

	@Autowired
	private UserDetailServicesImpl userDetailServicesImpl;

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailServicesImpl).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
				.antMatchers("/authen/register", "/authen/login", "/authen/hello", "/authen/signout", "/api/checkuser","/api/user/checkLock",
						"/api/users/{username}", "/api/users-paging", "/api/users-lock", "/api/lockuser","/api/user/checkUser",
						"/api/user/publicmoney", "/api/unlockuser", "/api/user/create","/api/user/update","/api/user/updateInfor", "/api/userscount",
						"/api/deductmoneypost", "/api/caterorys", "/api/caterorys/{id}", "/api/newsTypes","/api/newsTypes",
						"/api/newsTypesLock", "/api/newsTypes/count", "/api/newsType-paging",
						"/api/newsTypesSell/listSell", "/api/newsTypesRent/listRent", "/api/realestates",
						"/api/realestates-paging", "/api/realestates-paging-user","/api/outstanding","/api/realestate/delete","/api/realestates/{id}", "/api/realestates/count",
						"/api/listrealestateSell", "/api/listrealestateRent", "/api/realestates-user/{id_user}",
						"/api/realestates-newstype/{id_newstype}", "/api/bills", "/api/bills-paging", "/api/getRevenue","/api/getRevenueFromTo","/api/getRevenueMonthChart",
						"/api/reports-paging", "/api/stickreport", "/api/findReportByID", "/api/realestatesaves",
						"/api/realestatesaves/getlimit3", "/api/realestatesaves/forUser", "/api/realestatesaves/{id}",
						"/api/reports")

				.permitAll().anyRequest().authenticated().and().exceptionHandling()
				.authenticationEntryPoint(authenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler()).and()
//        .exceptionHandling().authenticationEntryPoint(new CustomHttp403ForbiddenEntryPoint());

		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	}
}
