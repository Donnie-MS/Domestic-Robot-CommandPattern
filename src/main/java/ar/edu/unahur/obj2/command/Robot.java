package ar.edu.unahur.obj2.command;

import java.util.ArrayList;
import java.util.List;

public class Robot {
    private Double batteryChargeLevel;
    private static final Double MAXIMUM_CHARGE = 100.0;
    private static final Double MINUTES_FOR_FULL_CHARGE = 125.0;
    private static final Double CHARGE_PER_MINUTE = MAXIMUM_CHARGE / MINUTES_FOR_FULL_CHARGE;

    private final List<TaskLog> history = new ArrayList<>();

    public Robot(Double initialCharge) {
        if (initialCharge < 0 || initialCharge > MAXIMUM_CHARGE) {
            throw new IllegalArgumentException("Initial charge should be between 0 and 100");
        }
        this.batteryChargeLevel = initialCharge;
    }
    //BATERIA
    public void charge(Double minutes) {
        if (minutes < 0) {
            throw new IllegalArgumentException("Charge time cannot be negative");
        }
        Double missing = MAXIMUM_CHARGE - this.batteryChargeLevel;
        Double minutesNeeded = missing / CHARGE_PER_MINUTE;
        Double effectiveMinutes = Math.min(minutesNeeded, minutes);

        this.batteryChargeLevel = Math.min(MAXIMUM_CHARGE, batteryChargeLevel + effectiveMinutes * CHARGE_PER_MINUTE);
    }
    public void consume(Double percent) {
        if (percent < 0) {
            throw new IllegalArgumentException("Percent cannot be negative.");
        }
        if (percent > this.batteryChargeLevel) {
            throw new IllegalArgumentException("Percent is greater than current battery level.");
        }
        this.batteryChargeLevel = this.batteryChargeLevel - percent;
    }

    public Double getBatteryChargeLevel() {
        return Math.round(this.batteryChargeLevel * 100.0) / 100.0;
    } 
    //LUZ
    public void turnOnTheLights(Room room, Boolean on) {
        room.setLight(on);
    }

    //historial 
    public void logTask(String taskCode, Integer durationSeconds) {
        history.add(new TaskLog(taskCode, durationSeconds));
    }

    public void showAverageTaskTime() {
        //Double average = history.stream()
    }

    public static Double getMaximumCharge() { return MAXIMUM_CHARGE; }
    public static Double getMinutesForFullCharge() { return MINUTES_FOR_FULL_CHARGE; }
    public static Double getChargePerMinute() { return CHARGE_PER_MINUTE; }

    public record TaskLog(String taskCode, int durationSeconds) {}
}
