package pl.sdacademy.kinga.calculator;

public class RoadLength {
    public final static short IN_MILES = 0;
    public final static short IN_KM = 1;
    private double lengthInKm;
    private double lengthInMiles;

    public RoadLength(double length, short unit) {
        if (unit==this.IN_KM) {
            this.lengthInKm=length;
            this.lengthInMiles=km2miles(length);
        }
        else {
            this.lengthInMiles =length;
            this.lengthInKm=miles2km(length);
        }
    }

    private double km2miles(double lenghtInKm)
    {
        return lenghtInKm*0.6214;
    }

    private double miles2km(double lenghtInMiles)
    {
        return lenghtInMiles*1.61;
    }

    @Override
    public String toString() {
        String output = String.format("%.02f",lengthInKm) + " KM \u2248 " + String.format("%.02f",lengthInMiles)+ " MIL";
        return output;
    }

    public double getLengthInKm() {
        return lengthInKm;
    }

    public double getLengthInMiles() {
        return lengthInMiles;
    }
}
