package tr.com.ogedik.skypedia.constant;

import lombok.experimental.UtilityClass;

/**
 * This utility class stores the endpoint paths in the controllers.
 *
 * @author orkungedik
 */
@UtilityClass
public class PathConstants {

    public static final String AIRLINE = "airline";
    public static final String AIRPORT = "airport";
    public static final String LOCATION = "location";
    public static final String ROUTE = "route";
    public static final String FLIGHT = "flight";
    public static final String TICKET = "ticket";
    public static final String BULK = "bulk";
    public static final String BOOKING = "booking";

    public static final String AUTH_HEADER = "X-Auth-User";
    public static final String ANONYMOUS = "Anonymous";
}
