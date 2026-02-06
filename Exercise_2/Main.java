
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<SmartDevice> homeHub = new ArrayList<>();

        SmartDevice livingRoomLight = new SmartLight("Living Room Light");
        SmartDevice kitchenLight = new SmartLight("Kitchen Light");
        SmartDevice hallwayThermostat = new SmartThermostat("Hallway Thermostat");

        homeHub.add(livingRoomLight);
        homeHub.add(kitchenLight);
        homeHub.add(hallwayThermostat);

        livingRoomLight.turnOn();
        hallwayThermostat.turnOn();

        ((Adjustable) kitchenLight).setLevel(75);

        System.out.println("Active devices: " + SmartDevice.activeDevicesCount);

        for (SmartDevice device : homeHub) {
            device.performSelfDiagnostic();
        }
    }
}

