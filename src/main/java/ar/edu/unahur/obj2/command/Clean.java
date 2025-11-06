package ar.edu.unahur.obj2.command;

public class Clean implements ITask{
    private Room room;

    public Clean(Room aRoom) {
        this.room = aRoom;
    }
    @Override
    public void execute(Robot robot) {
        Double batteryConsumption = this.getBatteryConsumption();
        Integer durationInSeconds = this.getTaskDurationInSeconds(robot);
        
        room.setClean(Boolean.TRUE);
        robot.consume(batteryConsumption);
        robot.logTask("CLEAN", durationInSeconds);
    }

    @Override
    public Double getBatteryConsumption() {
        return this.room.getSquareMeters() * 5.00;
    }

    @Override
    public Integer getTaskDurationInSeconds(Robot aRobot) {
        return Integer.valueOf((int) Math.round(room.getSquareMeters() * 180));
    }
}
