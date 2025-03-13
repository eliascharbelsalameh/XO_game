public class Empty extends Square {

    public Empty(int x, int y) {
        super(x, y);
    }

    public Empty() {
        super();
    }

    public Empty(Empty empty) {
        super(empty);
    }

    @Override
    public String toString() {
        return " ";
    }

}
