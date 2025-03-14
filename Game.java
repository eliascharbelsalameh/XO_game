import java.util.Scanner;

public final class Game {
    static final Scanner SCANNER = new Scanner(System.in);
    private final Grid grid;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private boolean isOver;
    private Player winner;

    public Grid getGrid() {
        return grid.getGrid();
    }

    public Game() {
        this.grid = new Grid();
        this.isOver = false;
        this.winner = null;
        startGame();
        this.currentPlayer = playerX;
    }

    public Game(Game game) {
        this.grid = new Grid(game.getGrid());
        this.isOver = game.isOver;
        this.winner = game.winner;
        this.playerX = game.playerX;
        this.playerO = game.playerO;
        this.currentPlayer = game.currentPlayer;
    }

    public void startGame() {
        String nameX;
        do {
            System.out.println("(PlayerX) Enter your name:");
            nameX = SCANNER.nextLine().trim();
        } while (nameX.isEmpty());

        String typeXStr;
        do {
            System.out.println("(" + nameX + ") Enter 0 for human or 1 for computer:");
            typeXStr = SCANNER.nextLine().trim();
        } while (typeXStr.isEmpty() || (typeXStr.charAt(0) != '0' && typeXStr.charAt(0) != '1'));
        char typeX = typeXStr.charAt(0);
        while (typeX != '0' && typeX != '1') {
            System.out.println("(" + nameX + ") Enter 0 for human or 1 for computer:");
            typeX = SCANNER.nextLine().charAt(0);
        }
        playerX = (typeX == '0') ? new Human(nameX) : new AI(nameX, this);
        playerX.setPlayerType('X');
        String nameO;
        do {
            System.out.println("(PlayerO) Enter your name:");
            nameO = SCANNER.nextLine().trim();
        } while (nameO.isEmpty());
        while (nameO.equals(nameX)) {
            System.out.println("(PlayerO) Name in use, enter a different name");
            nameO = SCANNER.nextLine();
        }
        if (typeX == '1') {
            this.playerO = new Human(nameO);
            playerO.setPlayerType('O');
        } else {
            String typeOStr;
            do {
                System.out.println("(" + nameO + ") Enter 0 for human or 1 for computer:");
                typeOStr = SCANNER.nextLine().trim();
            } while (typeOStr.isEmpty() || (typeOStr.charAt(0) != '0' && typeOStr.charAt(0) != '1'));
            char typeO = typeOStr.charAt(0);
            playerO = (typeO == '0') ? new Human(nameO) : new AI(nameO, this);
            playerO.setPlayerType('O');
        }
    }

    public boolean checkWinConditionX() {
        for (int i = 0; i < 3; i++) {
            if (grid.getSquare(i, 0).toString().equals(Type.X) && grid.getSquare(i, 1).toString().equals(Type.X)
                    && grid.getSquare(i, 2).toString().equals(Type.X)) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (grid.getSquare(0, i).toString().equals(Type.X) && grid.getSquare(1, i).toString().equals(Type.X)
                    && grid.getSquare(2, i).toString().equals(Type.X)) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (grid.getSquare(0, 0).toString().equals(Type.X) && grid.getSquare(1, 1).toString().equals(Type.X)
                    && grid.getSquare(2, 2).toString().equals(Type.X)) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (grid.getSquare(0, 2).toString().equals(Type.X) && grid.getSquare(1, 1).toString().equals(Type.X)
                    && grid.getSquare(2, 0).toString().equals(Type.X)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkWinConditionO() {
        for (int i = 0; i < 3; i++) {
            if (grid.getSquare(i, 0).toString().equals(Type.O) && grid.getSquare(i, 1).toString().equals(Type.O)
                    && grid.getSquare(i, 2).toString().equals(Type.O)) {
                return true;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (grid.getSquare(0, i).toString().equals(Type.O) && grid.getSquare(1, i).toString().equals(Type.O)
                    && grid.getSquare(2, i).toString().equals(Type.O)) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (grid.getSquare(0, 0).toString().equals(Type.O) && grid.getSquare(1, 1).toString().equals(Type.O)
                    && grid.getSquare(2, 2).toString().equals(Type.O)) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (grid.getSquare(0, 2).toString().equals(Type.O) && grid.getSquare(1, 1).toString().equals(Type.O)
                    && grid.getSquare(2, 0).toString().equals(Type.O)) {
                return true;
            }
        }
        return false;
    }

    public void handleTurn() {
        this.currentPlayer = (this.currentPlayer == playerX) ? playerO : playerX;
    }

    public void handleInput(Player player) {
        boolean validMove = false;
        while (!validMove) {
            System.out.println("(" + currentPlayer.getName() + ") it's your turn.");
            String input = currentPlayer.play();
            int tmpX = 0;
            int tmpY = 0;
            switch (input) {
                case Coordinate.UPPER_LEFT:
                    tmpX = 0;
                    tmpY = 0;
                    break;
                case Coordinate.UPPER_CENTER:
                    tmpX = 0;
                    tmpY = 1;
                    break;
                case Coordinate.UPPER_RIGHT:
                    tmpX = 0;
                    tmpY = 2;
                    break;
                case Coordinate.MIDDLE_LEFT:
                    tmpX = 1;
                    tmpY = 0;
                    break;
                case Coordinate.MIDDLE_CENTER:
                    tmpX = 1;
                    tmpY = 1;
                    break;
                case Coordinate.MIDDLE_RIGHT:
                    tmpX = 1;
                    tmpY = 2;
                    break;
                case Coordinate.LOWER_LEFT:
                    tmpX = 2;
                    tmpY = 0;
                    break;
                case Coordinate.LOWER_CENTER:
                    tmpX = 2;
                    tmpY = 1;
                    break;
                case Coordinate.LOWER_RIGHT:
                    tmpX = 2;
                    tmpY = 2;
                    break;
            }
            if (grid.getSquare(tmpX, tmpY).checkOverlap()) {
                if (currentPlayer.getPlayerType() == 'X') {
                    grid.setSquare(new CellX(tmpX, tmpY));
                } else {
                    grid.setSquare(new CellO(tmpX, tmpY));
                }
                validMove = true;
            } else {
                System.out.println("(" + currentPlayer.getName() + ") This square is already taken. Try again.");
                grid.toString();
            }
        }
    }

    public void play() {
        currentPlayer = playerX;
        while (!isOver) {
            grid.toString();
            handleInput(currentPlayer);
            if (checkWinConditionX()) {
                isOver = true;
                winner = playerX;
            } else if (checkWinConditionO()) {
                isOver = true;
                winner = playerO;
            } else if (grid.isFull()) {
                isOver = true;
            }
            handleTurn();
        }
        grid.toString();
        if (winner != null) {
            System.out.println("(" + winner.getName() + ") Congratulations! You won!");
        } else {
            System.out.println("It's a tie!");
        }
    }
}