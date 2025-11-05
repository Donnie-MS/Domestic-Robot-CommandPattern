package ar.edu.unahur.obj2.command;

public class Room {
    private Boolean theLightIsOn;
    private Double squareMeters;
    
    public Room (Boolean theLightIsOn, Double squareMeters) {
        this.theLightIsOn = theLightIsOn;
        this.squareMeters = squareMeters;
    }
    public Boolean theLightIsOn() {
        return this.theLightIsOn;
    }
    public void setLight(Boolean on) {
        this.theLightIsOn = on;
    }
    public Double getSquareMeters() {
        return this.squareMeters;
    }
}
