package validate;

public class ValidateTeacher {
    public static boolean isValidSubject(String subject) {
        return subject != null && !subject.trim().isEmpty();
    }
}
