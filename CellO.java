public class CellO extends Square {

    public CellO(int x, int y) {
        super(x, y);
    }

    public CellO() {
        super();
    }

    public CellO(CellO cellO) {
        super(cellO);
    }

    @Override
    public String toString() {
        // ANSI escape code for bold (1) blue (34) and reset (0)
        return Type.O;
    }
}
