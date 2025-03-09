
public class AI extends Player {
    public final Game game;

    public AI(String name, Game game) {
        super(name);
        this.game = game;
    }

    @Override
    public String play() {
        return minimaxMove();
    }
    
    private String minimaxMove() {
        int bestScore = Integer.MIN_VALUE;
        String bestMove = "";
        Grid grid = game.getGrid();
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid.getSquare(i, j).checkOverlap()) { // If square is empty
                    grid.setSquare(new CellX(i, j));
                    int score = minimax(grid, 0, false);
                    grid.setSquare(new Empty(i, j)); // Undo move
                    
                    if (score > bestScore) {
                        bestScore = score;
                        bestMove = "" + (char) (i + 'A') + (char) (j + '1');
                    }
                }
            }
        }
        return bestMove;
    }
    
    private int minimax(Grid grid, int depth, boolean isMaximizing) {
        if (game.checkWinConditionX()) return 10 - depth;
        if (game.checkWinConditionO()) return depth - 10;
        if (grid.isFull()) return 0;
        
        int bestScore = isMaximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid.getSquare(i, j).checkOverlap()) {
                    grid.setSquare(isMaximizing ? new CellX(i, j) : new CellO(i, j));
                    int score = minimax(grid, depth + 1, !isMaximizing);
                    grid.setSquare(new Empty(i, j)); // Undo move
                    
                    bestScore = isMaximizing ? Math.max(score, bestScore) : Math.min(score, bestScore);
                }
            }
        }
        return bestScore;
    }
}
