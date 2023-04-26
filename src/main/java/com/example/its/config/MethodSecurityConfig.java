package com.example.its.config;

import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@EnableGlobalMethodSecurity(prePostEnabled = true) //これで、@PreAuthorizeが有効になる
public class MethodSecurityConfig {

}
