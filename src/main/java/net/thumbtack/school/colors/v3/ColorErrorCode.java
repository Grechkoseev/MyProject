package net.thumbtack.school.colors.v3;

public enum ColorErrorCode {

    WRONG_COLOR_STRING("Wrong color %s"),
    NULL_COLOR("Color doesn't exist");

    private String errorString;

    ColorErrorCode(String errorString) {
        this.errorString = errorString;
    }

    public String getErrorString() {
        return errorString;
    }
}
