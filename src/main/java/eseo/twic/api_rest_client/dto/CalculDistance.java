package eseo.twic.api_rest_client.dto;

public class CalculDistance {

    public double Calcul(String latitude1, String longitude1, String latitude2, String longitude2) {
        int rayonTerre = 6378137;
        double longitude1Radians = Degres2Radians(Double.parseDouble(longitude1));
        double latitude1Radians = Degres2Radians(Double.parseDouble(latitude1));
        double longitude2Radians = Degres2Radians(Double.parseDouble(longitude2));
        double latitude2Radians = Degres2Radians(Double.parseDouble(latitude2));
        double differenceLongitudes = (longitude2Radians - longitude1Radians) / 2;
        double differenceLatitudes = (latitude2Radians - latitude1Radians) / 2;

        double a = (Math.sin(differenceLatitudes) * Math.sin(differenceLatitudes)) + Math.cos(latitude1Radians) * Math.cos(latitude2Radians) * (Math.sin(differenceLongitudes) * Math.sin(differenceLongitudes));
        double distance = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return (rayonTerre * distance);
    }

    double Degres2Radians(double angle) {
        return angle * Math.PI / 180;
    }

}
