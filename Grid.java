public class Grid {
    private final static int HEIGHT = 3;
    private final static int WIDTH = 3;
    
    private final Square[][] grid;
    
    public Grid() {
        grid = new Square[HEIGHT][WIDTH];
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                grid[i][j] = new Empty(i, j);
            }
        }
    }

    public Grid(Grid other) {
        this.grid = new Square[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.grid[i][j] = other.getSquare(i, j);
            }
        }
    }    

    public Square getSquare(int x, int y) {
        return grid[x][y];
    }

    public void setSquare(Square square) {
        grid[square.getX()][square.getY()] = square;
    }

    public Grid getGrid() {
        return this;
    }

    public void setGrid(Grid grid) {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                this.grid[i][j] = grid.getSquare(i, j);
            }
        }
    }

    public boolean isFull() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (grid[i][j].checkOverlap() == true) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {
        
        for (int i = 0; i < HEIGHT; i++) {
            if (i == 0){System.out.println("    1    2    3");}
            System.out.print("  ");
            for(int k = 0; k < HEIGHT; k++){ System.out.print("+---+"); }
            System.out.println();
            char[] letters = {'A', 'B', 'C'};
            System.out.print(letters[i] + " ");
            for (int j = 0; j < WIDTH; j++) { System.out.print("| " + grid[i][j].toString() + " |");}
            System.out.println();
            if (i == 2){
                System.out.print("  ");
                for(int k = 0; k < HEIGHT; k++){ System.out.print("+---+"); }}
        }
        System.out.println();
        return "";
    }
}
