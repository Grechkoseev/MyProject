package net.thumbtack.school.boxes.v3;

import net.thumbtack.school.figures.v3.Figure;

public class NamedBox<T extends Figure> extends Box<T>{

    private String nameOfBox;

    public NamedBox(T box, String nameOfBox) {
        super(box);
        this.nameOfBox = nameOfBox;
    }

    public String getName() {
        return nameOfBox;
    }

    public void setName(String nameOfBox) {
        this.nameOfBox = nameOfBox;
    }
}
