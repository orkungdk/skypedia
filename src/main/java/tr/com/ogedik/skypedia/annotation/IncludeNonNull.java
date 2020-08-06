package tr.com.ogedik.skypedia.annotation;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.lang.annotation.*;

/**
 * This annotation is used to hide null fields in the response body. This is an inherited annotation.
 * Therefore, in case of a class extends another class that annotation with this annotation will be also effected.
 * @see Inherited
 * @see JsonInclude
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@JsonInclude(JsonInclude.Include.NON_NULL)
public @interface IncludeNonNull {
}
