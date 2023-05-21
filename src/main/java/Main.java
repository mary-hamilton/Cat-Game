import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    private static Game game = new Game();

    public static void main(String[] args) {
        Game.loadRooms();
        System.out.println("Welcome to the world's most boring cat-based text adventure game.");
        Game.look();
        String input;
        String output;
        do {
            System.out.print("> ");
            input = sc.nextLine();
            output = game.runCommand(input);
            System.out.println(output);
        } while (!"quit".equals(input));
    }

}
