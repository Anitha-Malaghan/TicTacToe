package Models;

import java.util.Scanner;

public class Player {
    private  char symbol;
    private String name;
    private PlayerType type;
    public Player(char symbol, String name, PlayerType playerType){
        this.symbol = symbol;
        this.name = name;
        this.type = playerType;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PlayerType getType() {
        return type;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }

    //how will decide the move. based on the available move
    public Move decideMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the row to make move : ");
        int row = scanner.nextInt();

        System.out.println("Enter the col to make a move : ");
        int col = scanner.nextInt();

        return new Move(this,new Cell(row, col));

    }
}
