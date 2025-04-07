package validate;

public class ValidateCourse {
    public static boolean isValidCourseId(String courseId, java.util.List<entity.Course> courses) {
        if (courseId == null || !courseId.matches("^C[A-Za-z0-9]{4}$")) {
            return false;
        }
        return courses.stream().noneMatch(c -> c.getCourseId().equals(courseId));
    }

    public static boolean isValidCourseName(String courseName, java.util.List<entity.Course> courses) {
        if (courseName == null || courseName.length() < 20 || courseName.length() > 100) {
            return false;
        }
        return courses.stream().noneMatch(c -> c.getCourseName().equals(courseName));
    }

    public static boolean isValidBoolean(String input) {
        return "true".equalsIgnoreCase(input) || "false".equalsIgnoreCase(input);
    }
}
