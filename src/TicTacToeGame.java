import Models.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToeGame {
    public static void main(String[] args) {
        System.out.println("Hello world!:Game is starting..");
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is the dimension of the game: ");
        int dimension = scanner.nextInt();

        System.out.println("Number of players: ");
        int noOfPlayers = scanner.nextInt();

        //To store list of players
        List<Player> players = new LinkedList<>();

        System.out.println("Will there be any bot? y/n");
        String isBot = scanner.next();
        if(isBot.equals("y")){ //y or n
            //number of human players
            noOfPlayers = noOfPlayers-1;

            //Enter bot details
            System.out.println("Enter the name of the Bot: ");
            String name = scanner.next();

            System.out.println("Enter the symbol of the Bot: ");
            String botSymbol = scanner.next();

            System.out.println("Enter Bot Difficulty level: 1-EASY 2-MEDIUM 3-HARD");
            int difficultyLevel = scanner.nextInt();
            //todo for value to enum
            players.add(new Bot(botSymbol.charAt(0), name, BotDifficultyLevel.EASY));

        }
        for(int i=0; i<noOfPlayers; i++){
            System.out.println("What is the name of the player: " + (i+1));
            String name = scanner.next();

            System.out.println("What is the symbol for the player: "+ i+1);
            String symbol = scanner.next();

            Player player = new Player(symbol.charAt(0), name, PlayerType.HUMAN);
            players.add(player);

        }
        Game game = Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .build();

        while(game.getGameStatus() == GameStatus.IN_PROGRESS){
            //players will be playing
            break;
        }
        if(game.getGameStatus() == GameStatus.ENDED){
           System.out.println("Winning Player: "+ game.getWinner().getName());
        }else {
            System.out.println("Game has drawn");
        }
    }
}