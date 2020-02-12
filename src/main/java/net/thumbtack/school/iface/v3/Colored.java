package net.thumbtack.school.iface.v3;

import net.thumbtack.school.colors.v3.Color;
import net.thumbtack.school.colors.v3.ColorException;

import static net.thumbtack.school.colors.v3.Color.colorFromString;

public interface Colored {

    void setColor(Color color) throws ColorException;

    default void setColor(String colorString) throws ColorException {
        setColor(colorFromString(colorString));
    }

    Color getColor();

}