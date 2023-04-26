package com.example.its.web.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;


//アノテーションの自作作成
//重複判定でひっかかったら、エラーを表示させる

@Target({ElementType.METHOD, ElementType.FIELD}) //@Targetは、アノテーションが付与できる場所を示すもの(今回はフィールド)
@Retention(RetentionPolicy.RUNTIME) //@Retentionは、実行時までアノテーションを残すという意味
@Constraint(validatedBy = UniqueUsernameValidator.class) //@Constraintは、バリデーションを行うクラスを指定する
public @interface UniqueUsername {
  String message() default "入力したユーザー名はすでに登録されています。別のユーザー名を入力してください"; //バリデーションエラーが発生した場合のメッセージ
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
