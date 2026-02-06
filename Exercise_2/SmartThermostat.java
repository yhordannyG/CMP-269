
public class SmartThermostat extends SmartDevice implements Adjustable {

    private int temperature; 

    public SmartThermostat(String deviceName) {
        super(deviceName);
        this.temperature = 70; 
    }
    @Override
    public void turnOn() {
        System.out.println("HVAC System Starting...");
        super.turnOn();  
    }
    @Override
    public void setLevel(int level) {
        if (!isOn) {
            System.out.println("Cannot adjust: Device is OFF.");
            return;
        }

        if (level < 60 || level > 80) {
            System.out.println("Temperature must be between 60 and 80 degrees.");
            return;
        }

        this.temperature = level;
        System.out.println(deviceName + " temperature set to " + temperature + "°F.");
    }
    @Override
    public void performSelfDiagnostic() {
        System.out.println(deviceName + ": Running HVAC system diagnostics...");
    }
}

