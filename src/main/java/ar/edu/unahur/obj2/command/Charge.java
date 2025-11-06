package ar.edu.unahur.obj2.command;

public class Charge implements ITask{
    private Double minutes;

    public Charge(Double minutes) {
        this.minutes = minutes;
    }

    @Override
    public void execute(Robot aRobot) {
        Integer durationSeconds = this.getTaskDurationInSeconds(aRobot);
        aRobot.charge(minutes);
        aRobot.logTask("CHARGE", durationSeconds);
    }

    @Override
    public Double getBatteryConsumption() {
        return 0.0;
    }

    @Override
    public Integer getTaskDurationInSeconds(Robot aRobot) {
        Double missing = Robot.getMaximumCharge() - aRobot.getBatteryChargeLevel();
        Double minutesNeeded = missing / Robot.getChargePerMinute();
        Double effectiveMinutes = Math.min(minutes, minutesNeeded);
        return Integer.valueOf((int) Math.round(effectiveMinutes * 60));
    }
}
