public class CellX extends Square {

    public CellX(int x, int y) {
        super(x, y);
    }
    
    @Override
    public String toString() {
        // ANSI escape codes for bold yellow: "\033[1;33m" and reset with "\033[0m"
        return Type.X;
    }
}
