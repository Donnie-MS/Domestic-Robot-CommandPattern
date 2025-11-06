package ar.edu.unahur.obj2.command;

public interface ITask {
    void execute(Robot robot);
    Double getBatteryConsumption();
    Integer getTaskDurationInSeconds(Robot aRobot);
}
