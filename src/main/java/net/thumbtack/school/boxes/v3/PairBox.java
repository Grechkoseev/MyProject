package net.thumbtack.school.boxes.v3;

import net.thumbtack.school.figures.v3.Figure;
import net.thumbtack.school.iface.v3.HasArea;

public class PairBox<T extends Figure, V extends Figure> implements HasArea {

    private T boxT;
    private V boxV;

    public PairBox(T boxT, V boxV) {
        super();
        this.boxT = boxT;
        this.boxV = boxV;
    }

    public T getBoxT() {
        return boxT;
    }

    public void setBoxT(T BoxT) {
        this.boxT = BoxT;
    }

    public V getBoxV() {
        return boxV;
    }

    public void setObjV(V boxV) {
        this.boxV = boxV;
    }

    @Override
    public double getArea() {
        return boxT.getArea() + boxV.getArea();
    }

    public boolean isAreaEqual(PairBox<? extends Figure, ? extends Figure> box) {
        return box.boxT.getArea() + box.boxV.getArea() == getArea();
    }

    public static boolean isAreaEqual(PairBox<? extends Figure, ? extends Figure> box1, PairBox<? extends Figure, ? extends Figure> box2) {
        return box1.getArea() == box2.getArea();
    }
}
