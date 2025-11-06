package ar.edu.unahur.obj2.command;

public class Room {
    private Boolean theLightIsOn;
    private Double squareMeters;
    private Boolean itIsClean;
    
    public Room (Boolean theLightIsOn, Double squareMeters, Boolean itIsClean) {
        this.theLightIsOn = theLightIsOn;
        this.squareMeters = squareMeters;
        this.itIsClean = itIsClean;
    }
    public Boolean theLightIsOn() {
        return this.theLightIsOn;
    }
    public Boolean itIsBoolean() {
        return this.itIsClean;
    }
    public void setClean(Boolean clean) {
        this.itIsClean = clean;
    }
    public void setLight(Boolean on) {
        this.theLightIsOn = on;
    }
    public Double getSquareMeters() {
        return this.squareMeters;
    }
}
