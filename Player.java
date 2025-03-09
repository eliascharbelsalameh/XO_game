import java.util.ArrayList;

public abstract class Player {
    private final String name;
    private boolean turn;
    private ArrayList<Square> squares;
    private char player_type;

    public Player(String name) {
        this.name = name;
        this.turn = false;
    }

    public String getName() {
        return name;
    }

    public boolean getTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public void addSquare(Square square) {
        squares.add(square);
    }

    public ArrayList<Square> getSquares() {
        return squares;
    }

    public char getPlayerType() {
        return player_type;
    }

    public void setPlayerType(char player_type) {
        this.player_type = player_type;
    }

    public abstract String play();

}
