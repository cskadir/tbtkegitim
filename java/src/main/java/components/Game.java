package components;

import locations.Location;
import locations.battle.BattleLoc;
import locations.battle.Cave;
import locations.battle.Forest;
import locations.battle.River;
import locations.normal.SafeHause;
import locations.normal.Toolstore;

import java.util.Scanner;

public class Game {
    private Scanner sc = new Scanner(System.in);

    private Player player;
    private Location location;

    private Location[] locationList = {new SafeHause(null),
            new Toolstore(null),
            new Cave(null),
            new Forest(null),
            new River(null)};

    public void start() {

        System.out.println("Welcome to the Adventure components.Game!!");
        System.out.println("Please enter a game: ");
        String playerName =sc.nextLine();

        Player player = new Player(playerName);
        System.out.println("Welcome " + playerName);

        System.out.println("Please select a character");
        player.selectChar();


        Location location;
        while (true) {

            location=null;
            player.printInfo();
            int i = 1;
            System.out.println("###############################################################################");
            System.out.println("Locations:");
            System.out.println("0. ->> Exit");
            for (Location loc : locationList) {
                System.out.println(i + ".  " + loc.getName());
                i++;
            }
            System.out.println("###############################################################################");
            System.out.print("Select the location you want to go to: ");

            int selectedLocation = sc.nextInt();
            if (selectedLocation > 0 && selectedLocation <= locationList.length) {
                location = locationList[selectedLocation - 1];
                locationList[selectedLocation - 1].setPlayer(player);
            }
            if (location == null) {
                System.out.println("You gave up quickly ");
                break;
            }

            if (!location.onLocation()) {
                System.out.println("Game Over!");
                break;
            }
        }


    }
}
