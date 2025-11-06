package ar.edu.unahur.obj2.command;

public class LightOn implements ITask{
    private Room room;
    public LightOn(Room aRoom) {
        this.room = aRoom;
    }
    @Override
    public void execute(Robot robot) {
        Integer durationInSeconds = this.getTaskDurationInSeconds(robot);
        Double batteryConsumption = this.getBatteryConsumption();
        robot.turnOnTheLights(room, Boolean.TRUE);
        robot.consume(batteryConsumption);
        robot.logTask("LIGHT-ON", durationInSeconds);
        robot.turnOnTheLights(this.room, Boolean.TRUE);
    }

    @Override
    public Double getBatteryConsumption() {
        Double batteryConsumption = 5.0;
        if (this.room.theLightIsOn()) {
            batteryConsumption = 1.0;
        }
        return batteryConsumption;
    }

    @Override
    public Integer getTaskDurationInSeconds(Robot aRobot) {
        Integer durationInSeconds = 90;
        if (this.room.theLightIsOn()) {
            durationInSeconds = 25;
        }
        return durationInSeconds;
    }

}