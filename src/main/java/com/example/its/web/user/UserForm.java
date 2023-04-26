package com.example.its.web.user;

import com.example.its.web.validation.UniqueUsername;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ここはユーザー作成フォームから送信されて、
 * バリデーションチェックが行われるところ
 */

@Data
@AllArgsConstructor
public class UserForm {

  @NotBlank
  @UniqueUsername
  private String username;
  @NotBlank
  @Size(min=12, max=128) //パスワードの長さがセキュリティの標準に制限する
  private String password;

  @NotBlank
  private String authority;

}
