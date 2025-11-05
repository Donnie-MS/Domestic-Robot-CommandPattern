package ar.edu.unahur.obj2.command;

import java.util.ArrayList;
import java.util.List;

public class House {
    private List<Room> rooms;

    public House(List<Room> rooms) {
        this.rooms = new ArrayList<>(rooms);
    }
    public void addRoom(Room aRoom) {
        rooms.add(aRoom);
    }
    public void removeRoom(Room aRoom) {
        rooms.remove(aRoom);
    }
}
