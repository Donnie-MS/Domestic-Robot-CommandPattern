package ar.edu.unahur.obj2.command;

public class LightOff implements ITask{
    private Room room;

    public LightOff(Room aRoom) {
        this.room = aRoom;
    }

    @Override
    public void execute(Robot robot) {
        Integer durationInSeconds = this.getTaskDurationInSeconds(robot);
        Double batteryConsumption = this.getBatteryConsumption();

        robot.turnOnTheLights(room, Boolean.FALSE);
        robot.consume(batteryConsumption);
        robot.logTask("LIGHT-OFF", durationInSeconds);
    }

    @Override
    public Double getBatteryConsumption() {
        Double batteryConsumption = 1.00;
        if (this.room.theLightIsOn()) {
            batteryConsumption = 5.00;
        }
        return batteryConsumption;
    }

    @Override
    public Integer getTaskDurationInSeconds(Robot aRobot) {
        Integer durationInSeconds = 25;
        if (this.room.theLightIsOn()) {
            durationInSeconds = 90;
        }
        return durationInSeconds;
    }

}
