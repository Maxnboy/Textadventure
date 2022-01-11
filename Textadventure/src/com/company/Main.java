package com.company;
import com.company.NPC.NPC;
import com.company.NPC.Voiceline;

import java.util.Objects;
import java.util.Scanner;
import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) throws Exception {

        Location Edinburgh = new Location("Edinburgh", "Attention! They drink a lot of Whiskey here");
        Location Dumfries = new Location("Dumfries", "This place is famous for their crisps", true);
        Location Birmingham = new Location("Birmingham", "A lot of canals for you to explore", true);
        Location Chipping_Norton = new Location("Chipping Norton", "They have great fish and chips", true);
        Location London = new Location("London", "Be aware! You're awfully close to the queen", true);
        Location Southampton = new Location("Southampton", "The Titanic departed from here, no wonder it sank", true);


        Room EdinburghCastle = new Room("Castle", "A big, cold castle in the middle of Edinburgh!", Edinburgh, false);
        Room TrainstationEdinburgh = new Room("Trainstation", "Do you have a ticket?", Edinburgh, true);
        Room field = new Room("field", "A big grassland", Edinburgh, false);

        Room TrainstationDumfries = new Room("Trainstation", "Do you have a ticket?", Dumfries, true,true);

        Room TrainstationBirmingham = new Room("Trainstation", "Do you have a ticket?", Birmingham, true,true);

        Room TrainstationChipping_Norton = new Room("Trainstation", "Do you have a ticket?", Chipping_Norton, true,true);

        Room TrainstationLondon = new Room("Trainstation", "Do you have a ticket?", London, true,true);

        Room TrainstationSouthampton = new Room("Trainstation", "Do you have a ticket?", Southampton, true,true);

        Edinburgh.addNearbyLocation("down", Dumfries);
        Dumfries.addNearbyLocation("down", Birmingham);
        Birmingham.addNearbyLocation("down", Chipping_Norton);
        Chipping_Norton.addNearbyLocation("down", London);
        London.addNearbyLocation("down", Southampton);
        Dumfries.addNearbyLocation("up",Edinburgh);

        Room hidden = new Room("hidden", "for items or keys and shall not be seen by looking around", new Location("not existing", ""), false);

        Key knife = new Key("knoife", "bri'ish knife", false, hidden);


        NPC kidThief = new NPC("Kid", "A small suspicious looking kid", field, knife, new Voiceline("Gimme all ya money mate or I'll shank ya","2","3"));
        Event mug = new Event(field, kidThief, "\nA kid approaches you rapidly with a knife", new String[]{"Empty your pockets","Attack!"});
        NPC butler = new NPC("Butler", "Butler", EdinburghCastle, null, new Voiceline("Voiceline1","Voiceline2","Voiceline3"));

        TrainstationEdinburgh.setNeededKey(knife);

        menu(new String[]{"-~+*ESCAPE BRITAIN*+~-","play","exit"});

        switch (eingabe(2)) {

            case 1:
                break;
            case 2:
                return;
            default:
                System.err.println("error");
                break;
        }

        Player player = new Player(field);

        while(true) {

            menu(new String[] {"Select an action","view inventory","look around","move"});

            switch (eingabe(3)) {

                case 1:

                    System.out.print("\t Inventory: ");
                    for (Entitity entitity : player.getInventory()) {

                        System.out.print(" "+entitity.getName()+",");

                    }
                    System.out.print("\n\n");

                    break;

                case 2:


                    System.out.println("\tYou are in the " + player.getCurrentRoom().getName() + " right now.");
                    System.out.print("\tYou can see: ");
                    for (Entitity item : player.getCurrentRoom().getRoomInventory()) {
                        
                        System.out.print(" "+item.getName()+",");

                    }
                    System.out.print("\n\n");

                    break;

                case 3:

                    if (player.getCurrentRoom() == mug.getRoom()) {

                        System.out.println(player.getCurrentRoom().getEvent().getEvent());

                        menu2(player.getCurrentRoom().getEvent().getNpc().talk(),player.getCurrentRoom().getEvent().getOptions());


                        if(player.getCurrentRoom().getEvent().getRoom() == field) {
                            mug(eingabe(2), player, knife);
                        }

                    }

                    move(player);
                    break;


                default:
                    System.err.println("error");
                    break;

            }

        }
    }

    private static void menu(String[] lines) {

        System.out.println("\t" + lines[0] +"\n");
        for (int i = 1; i < lines.length; i++) {
            System.out.println("\t\t ["+i+"] " + lines[i]);
        }
        System.out.println();
    }

    private static void menu2(String title, String[] options) {

        System.out.println("\t" + title +"\n");
        for (int i = 0; i < options.length; i++) {
            System.out.println("\t\t ["+ (i+1) +"] " + options[i]);
        }
        System.out.println();
    }

    private static int eingabe(int optionen) throws Exception {

        int wahl;
        Scanner s;
        while (true) {

            try {
                s = new Scanner(System.in);

                wahl = s.nextInt();
                for (int i = 1; i <= optionen; i++) {

                    if (wahl == i) {
                        return wahl;
                    }

                }

            } catch (Exception ignored) {

            }

        }

    }

    public static void mug(int choice, Player player, Key knife) {
        switch (choice) {
            case 1:
                System.err.println("Game Over");
                exit(0);
            case 2:
                System.out.println("You sucessfully attacked the kid and stole his knife!");
                player.addItem(knife);
        }
    }

    public static void move(Player player) throws Exception{

        String[] a = new String[player.getCurrentRoom().getLocation().getLocationrooms().size()-1];
        String[] a2 = new String[player.getCurrentRoom().getLocation().getLocationrooms().size()-1];

        int changed = 0;
        int temp = 0;

        for (int i = 0; i < player.getCurrentRoom().getLocation().getLocationrooms().size(); i++) {

            if (player.getCurrentRoom() != player.getCurrentRoom().getLocation().getLocationrooms().get(i)) {

                a[i-changed] = player.getCurrentRoom().getLocation().getLocationrooms().get(i).toString() + "\n";
                a2[i-changed] = player.getCurrentRoom().getLocation().getLocationrooms().get(i).name;

            }else {
                changed++;
                temp = i;
            }

        }

        menu2("where would you like to move?",a);

        int ret = eingabe(player.getCurrentRoom().getLocation().getLocationrooms().size()-changed);

        for (int i = 0; i < player.getCurrentRoom().getLocation().getLocationrooms().size()-changed; i++) {

            if (temp == i) {

                i++;

            }

            if (i == ret-1) {

                for (Room room: player.getCurrentRoom().getLocation().getLocationrooms()) {

                    if (Objects.equals(a2[i], room.name)) {

                        player.move(room);

                    }

                }

            }

        }


    }
}

