package com.example.its.domain.issue.auth;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;

  //ユーザー一覧を取得する処理
  @PreAuthorize("hasAuthority('ADMIN')") //これはADMINユーザーのみに実行できる処理という指示
  public List<User> findAll(){
    return userRepository.findAll();
  }

  @PreAuthorize("hasAuthority('ADMIN')") //これはADMINユーザーのみに実行できる処理という指示
  public void create(String username, String password, String authority) {
    //下のencodedPasswordはパスワードが『登録』されるときに、エンコードする処理
    var encodedPassword = passwordEncoder.encode(password);
    userRepository.insert(username,encodedPassword,authority);
  }

}
