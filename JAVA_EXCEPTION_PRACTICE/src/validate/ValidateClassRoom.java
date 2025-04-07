package validate;

import entity.ClassRoom;

import java.util.List;

public class ValidateClassRoom {
    public static boolean isValidClassRoomName(String classRoomName, List<ClassRoom> classRooms) {
        if (classRoomName == null || classRoomName.length() < 15 || classRoomName.length() > 50) {
            return false;
        }
        return classRooms.stream().noneMatch(c -> c.getClassRoomName().equals(classRoomName));
    }
}
