

public class Human extends Player {
    public Human(String name) {
        super(name);
    }

    @Override
    public String play() {
        String input = "";
        
        System.out.println("(" + getName() + ") is playing ...");
        do {
            System.out.println("(" + getName() + ") use the following format to enter your move: A1, C2, B3");
            input = Game.SCANNER.nextLine().toUpperCase();
        } while (input.length() != 2 || input.charAt(0) < 'A' || input.charAt(0) > 'C' ||
                 input.charAt(1) < '1' || input.charAt(1) > '3');
        
        return input;
    }
    

}
