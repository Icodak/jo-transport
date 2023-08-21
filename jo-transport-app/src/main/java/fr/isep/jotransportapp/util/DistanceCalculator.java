package fr.isep.jotransportapp.util;

public class DistanceCalculator {
    public static final double EARTH_RADIUS = 6371.0;

    public static double calculateDistance(double latitude1, double longitude1, double latitude2, double longitude2) {
        double lat1Rad = Math.toRadians(latitude1);
        double lon1Rad = Math.toRadians(longitude1);
        double lat2Rad = Math.toRadians(latitude2);
        double lon2Rad = Math.toRadians(longitude2);

        double dLat = lat2Rad - lat1Rad;
        double dLon = lon2Rad - lon1Rad;
        double a = Math.pow(Math.sin(dLat / 2), 2) + Math.cos(lat1Rad) * Math.cos(lat2Rad) * Math.pow(Math.sin(dLon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c;
    }
}
