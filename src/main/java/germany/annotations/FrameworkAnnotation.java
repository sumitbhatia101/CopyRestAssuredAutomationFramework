package germany.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;

//CREATING CUSTOM ANNOTATIONS:
@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({METHOD})
public @interface FrameworkAnnotation {
    String[] authors() default "Amuthan";
    String[] categories() default "Regression";
}
