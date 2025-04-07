package validate;

import java.time.LocalDateTime;

public class ValidateSchedule {
    public static boolean isValidScheduleTime(LocalDateTime startTime, LocalDateTime endTime) {
        return startTime != null && endTime != null && endTime.isAfter(startTime);
    }
}
