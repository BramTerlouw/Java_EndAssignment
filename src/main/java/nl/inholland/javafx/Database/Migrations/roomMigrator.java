package nl.inholland.javafx.Database.Migrations;
import nl.inholland.javafx.Model.Theater.Room;

import java.util.ArrayList;
import java.util.List;

public class roomMigrator{

    public List<Room> createRooms(){
        List<Room> rooms = new ArrayList<>();

        // make rooms
        Room room1 = new Room("Room 1", 200);
        Room room2 = new Room("Room 2", 100);

        // add rooms and return
        rooms.add(room1);
        rooms.add(room2);
        return rooms;
    }
}
