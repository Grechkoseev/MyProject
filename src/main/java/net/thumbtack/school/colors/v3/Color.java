package net.thumbtack.school.colors.v3;

public enum Color {

    RED, GREEN, BLUE;

    public static Color colorFromString(String colorString) throws ColorException {
        try {
            Color color = Color.valueOf(colorString);
            return color;
        }
        catch (NullPointerException ex) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        catch (IllegalArgumentException ex) {
            throw new ColorException(ColorErrorCode.WRONG_COLOR_STRING);
        }
    }

    public static void checkColor(Color color) throws ColorException {
        if (color == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        if (color != Color.valueOf("RED") && color != Color.valueOf("GREEN") && color != Color.valueOf("BLUE")) {
            throw new ColorException(ColorErrorCode.WRONG_COLOR_STRING);
        }
    }
}
