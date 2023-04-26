package com.example.its.domain.issue.auth;

import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

//このインターフェイスがMybatisの、
// マッパーであるということがわかるように『@Mapper』をつける
@Mapper
public interface UserRepository {

  @Select("select * from users where username = #{username}") //#{username}は引数で入ってくる
  Optional<User> findByUsername(String username);

  @Select("select * from users")
  List<User> findAll();

  @Insert("insert into users (username, password, authority) values (#{username}, #{password}, #{authority})")
  void insert(String username, String password, String authority);

}
