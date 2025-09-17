import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Radar radar = new Radar(17.5f, "r2156", "Thales", "AirMaster", 1.3e6f);
        Part  part  = new Part("av3698", "Garmin", "G3000", 51200f);

        System.out.println(part);
        part = radar;
        System.out.println(part);
    }
}