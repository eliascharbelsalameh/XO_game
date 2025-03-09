public abstract class Square {
    private int x;
    private int y;
    
    public Square(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void setSquare(Square square) {
        this.x = square.getX();
        this.y = square.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    @Override
    public abstract String toString();

    public boolean checkOverlap() {
        return this.getClass().getSimpleName().equals("Empty");
    }

}
