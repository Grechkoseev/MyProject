package net.thumbtack.school.colors.v3;

public class ColorException extends Exception {

    private ColorErrorCode colorErrorCode;

    ColorException(ColorErrorCode colorErrorCode) {
        super(colorErrorCode.getErrorString());
    }

    public ColorErrorCode getErrorCode() {
        return colorErrorCode;
    }
}
