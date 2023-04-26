package com.example.its.domain.issue.auth;


import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

//Userは、UserDetailsの実装する記述を最低限にしてくれるもの
public class CustomUserDetails extends User {

  public CustomUserDetails(String username, String password,
      Collection<? extends GrantedAuthority> authorities) {
    super(username, password, authorities);
  }
}
