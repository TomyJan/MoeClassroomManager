package tomyjan.moeclassroommanager.common.annotation;

import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Operation {

    /**
     * 操作
     */
    String value();

    /**
     * 是否需要登录
     *
     * @return
     */
    boolean needLogin() default false;
}
