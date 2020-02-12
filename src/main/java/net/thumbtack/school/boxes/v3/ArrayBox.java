package net.thumbtack.school.boxes.v3;

import net.thumbtack.school.figures.v3.Figure;

public class ArrayBox<T extends Figure> {

    private T[] array;

    public ArrayBox(T[] array) {
        super();
        this.array = array;
    }

    public T[] getContent() {
        return array;
    }

    public void setContent(T[] array) {
        this.array = array;
    }

    public T getElement(int i) {
        return array[i];
    }

    public void setElement(int i, T element) {
        array[i] = element;
    }

    public boolean isSameSize(ArrayBox<? extends Figure> arrayBox) {
        return arrayBox.array.length == array.length;
    }
}
