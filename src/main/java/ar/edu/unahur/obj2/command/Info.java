package ar.edu.unahur.obj2.command;

public class Info implements ITask{

    @Override
    public void execute(Robot robot) {
        Integer durationInSeconds = this.getTaskDurationInSeconds(robot);
        robot.showAverageTaskTime();
        robot.logTask("INFO", durationInSeconds);
    }

    @Override
    public Double getBatteryConsumption() {
        return 0.0;
    }

    @Override
    public Integer getTaskDurationInSeconds(Robot aRobot) {
        return 0;
    } 
}
