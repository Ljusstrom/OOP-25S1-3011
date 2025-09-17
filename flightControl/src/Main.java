import logic.FlightControl;
import ui.TextUI;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FlightControl flightControl = new FlightControl();
        TextUI        textUI        = new TextUI(flightControl, new Scanner(System.in));

        textUI.start();
    }
}