package tr.com.ogedik.skypedia.mapper;

/**
 * @author orkungedik
 */

import tr.com.ogedik.skypedia.model.SkypediaModel;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * This is an abstract mapper class.
 * @implSpec All mappers in the projects needs to extend this class to be able to prevent
 * code duplication and decrease code complexity
 *
 * @author orkungedik
 */
public abstract class SkypediaMapper<A extends SkypediaModel, B> {

    public abstract A convert(B arg);

    public abstract B convert(A arg);

    public Collection<A> convert(Collection<B> args) {
        if (args == null) {
            return null;
        }
        return args.stream().map(arg -> convert(arg)).collect(Collectors.toList());
    }
}
