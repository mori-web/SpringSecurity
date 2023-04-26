package com.example.its.domain.issue.auth;

import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    //ログインするユーザー情報を検索する
    return userRepository.findByUsername(username)
        //検索してユーザーが合った場合には、CustomUserDetailsに変換する
        .map(
            user -> new CustomUserDetails(
                user.getUsername(),
                user.getPassword(),
                toGrantedAuthorityList(user.getAuthority())
            )
        )
        //もしユーザーの情報がなかった場合は、、
        .orElseThrow(
            () -> new UsernameNotFoundException(
                "Given username is not found. (username='" + username + "')"
            )
        );
  }

  private List<GrantedAuthority> toGrantedAuthorityList(User.Authority authority) {
    return Collections.singletonList(new SimpleGrantedAuthority(authority.name()));
  }
}
