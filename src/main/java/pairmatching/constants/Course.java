package pairmatching.constants;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String courseName;

    Course(String courseName) {
        this.courseName = courseName;
    }

    public static String courseNameToString() {
        return BACKEND.courseName + " | " + FRONTEND.courseName;
    }

    public static Course getCourse(String courseName) {
        return Arrays.stream(Course.values())
                .filter(course -> course.courseName.equals(courseName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.COURSE_TYPE_ERROR_MESSAGE));
    }

}