public abstract class Player {
    private String name;
    private char player_type;
    
    public Player(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public char getPlayerType() {
        return player_type;
    }

    public void setPlayerType(char player_type) {
        this.player_type = player_type;
    }

    public abstract String play();

}
