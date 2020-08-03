package tr.com.ogedik.skypedia.util;

import lombok.experimental.UtilityClass;

/**
 * @author orkungedik
 */
@UtilityClass
public class MathUtils {

    private static final double AVARAGE_AIRPLANE_SPEED = 300;

    /**
     * Calculates the distance between two point

     * @return double value of the calculated distance
     */
    public static double calculateDistance(double lat1, double lon1, double lat2, double lon2, String unit) {
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        } else {
            double theta = lon1 - lon2;
            double dist = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) +
                    Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            if (unit.equals("K")) {
                dist = dist * 1.609344;
            } else if (unit.equals("N")) {
                dist = dist * 0.8684;
            }
            return (dist);
        }
    }

    /**
     * Calculates the tentative time for the given distance. Airplane speed will be estimated as 300 km/h.
     *
     * @param distance kilometer
     * @return minutes
     */
    public static int calculateTime(double distance) {
        /*
         * Speed = Distance / Time
         * For this case speed is km/h and distance id km. So Time will represent h.
         * Therefore, its need to be multiplied with 60 to be receive a min result.
         */
        double time = distance / AVARAGE_AIRPLANE_SPEED;

        return (int) (time * 60);
    }
}
