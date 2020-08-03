package tr.com.ogedik.skypedia.util;

import lombok.experimental.UtilityClass;

import java.util.Optional;
import java.util.function.Supplier;

/**
 * @author orkungedik
 */
@UtilityClass
public class ObjectUtils {

    public static <T> Optional<T> getNestedObjects(Supplier<T> resolver) {
        try {
            T result = resolver.get();
            return Optional.ofNullable(result);
        } catch (NullPointerException e) {
            return Optional.empty();
        }
    }
}
