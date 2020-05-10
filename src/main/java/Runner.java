import Equipment.Club;
import Group.Room;
import People.*;

import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Runner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Quest quest = new Quest();


        // Adds players
        System.out.println("Welcome to Fantasy Adventure!");
        System.out.println("How many players would you like to play?");

        String numOfPlayers = scanner.next();
        int players = parseInt(numOfPlayers);
        for (int i = 0; i < players; i++) {
            String namePrompt = String.format("Player %s, enter your name: ", (i + 1));
            System.out.println(namePrompt);
            String playerName = scanner.next();

            Player player = null;
            while (player == null) {

                String classPrompt = String.format("Player %s, choose your class: 1.Barbarian, 2.Cleric, 3.Dwarf, 4.Knight, 5.Necromancer, 6.Warlock, 7.Wizard", playerName);
                System.out.println(classPrompt);
                String playerClass = scanner.next();

                if (playerClass.toLowerCase().equals("barbarian") || playerClass.toLowerCase().equals("1")) {
                    player = quest.createBarbarian( playerName );
                } else if (playerClass.toLowerCase().equals("dwarf") || playerClass.toLowerCase().equals("2")) {
                    player = quest.createDwarf( playerName );
                } else if (playerClass.toLowerCase().equals("knight") || playerClass.toLowerCase().equals("3")) {
                    player = quest.createKnight( playerName );
                } else if (playerClass.toLowerCase().equals("cleric") || playerClass.toLowerCase().equals("4")) {
                    player = quest.createCleric(playerName);
                } else if (playerClass.toLowerCase().equals("wizard") || playerClass.toLowerCase().equals("7")) {
                    player = quest.createWizard(playerName);
                } else if (playerClass.toLowerCase().equals("warlock") || playerClass.toLowerCase().equals("6")) {
                    player = quest.createWarlock(playerName);
                } else if (playerClass.toLowerCase().equals("necromancer") || playerClass.toLowerCase().equals("5")) {
                    player = quest.createNecromancer(playerName);
                } else {
                    System.out.println("Input was not recognised please try again");
                }
            }
            quest.addPlayer(player);
        }

//        add rooms and enemies
        System.out.println("How many rooms would you like to play?");
        String numOfRoom = scanner.next();
        int roomNumber = parseInt(numOfRoom);

        quest.prepareQuest(roomNumber);

        quest.startQuest();

        quest.conclusion(roomNumber);

    }
}
