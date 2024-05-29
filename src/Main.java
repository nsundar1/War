/*
* Name: neel sundar
* period 1
* AP comp
* game: War (player vs computer: runs simulation)
*/



import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;




public class Main {
    public static void main(String[] args) {
        boolean run = true;
        Scanner console = new Scanner(System.in);
        String choice;
        while(run){
            System.out.println("Would you like to play (n to quit)");
            choice = console.nextLine();
            if(choice.equals("n")){run = false;}

            ArrayList<Card> deck = new ArrayList<>();
            for (int s = 0; s < 4; s++) {
                for (int v = 0; v < 12; v++) {
                    deck.add(new Card(v, s));
                }
            }
            ArrayList<Card> player = new ArrayList<>();
            ArrayList<Card> computer = new ArrayList<>();
            int deck_size = deck.size();
            Random r = new Random();
            int g;
            for (int i = 0; i < deck_size; i++) {
                g = r.nextInt(deck.size());
                if (i % 2 != 0) {
                    computer.add(deck.get(g));
                }
                if (i % 2 == 0) {
                    player.add(deck.get(g));
                }
                deck.remove(g);

            }
            //initialized deck and player
            int round = 1;
            int shown;
            int result = 0;
            boolean ru;
            Card fill;
            while(!player.isEmpty() && !computer.isEmpty()){
                System.out.println("\n\nRound: " + round);
                ru = true;
                shown = 1;
                while(ru){
                    result = CompareCards(computer, player, shown);
                    printComputerHand(computer, shown);
                    System.out.println();
                    System.out.println();
                    printPlayerHand(player, shown);
                    if(result == 0){
                        System.out.println("\nWAR WAR WAR WAR WAR WAR");
                        shown ++;
                    }else{
                        ru = false;
                    }
                }

                if(result > 0) //computer won this round
                {
                    System.out.println("\nComputer won");
                    for(int i = 0; i < shown; i++){
                        computer.add(player.get(i));
                        player.remove(i);
                        fill = computer.get(i);
                        computer.remove(i);
                        computer.add(fill);

                    }
                }
                if(result < 0) //player won this round
                {
                    System.out.println("\nPlayer won");
                    for(int i = 0; i < shown; i++){
                        player.add(computer.get(i));
                        computer.remove(i);
                        fill = player.get(i);
                        player.remove(i);
                        player.add(fill);
                    }
                }
                round++;

            }


        }


    }
    public static int CompareCards(ArrayList<Card> computer, ArrayList<Card> player, int shown){
        return computer.get(shown - 1).v - player.get(shown -1).v;

    }
    public static void printComputerHand(ArrayList<Card> computer, int shown) {
        String[] Value = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "X", "J", "Q", "K", "A"};
        String[] Suit = new String[]{"S", "C", "H", "D"};

        for (int i = 0; i < computer.size(); i++) {
            if (i < shown) {
                System.out.print("/-----\\");
            } else {
                System.out.print("[]");
            }
        }
        System.out.println();
        if (shown > 0) {
            for (int i = 0; i < shown; i++) {
                System.out.print("|" + Value[computer.get(i).v] + "    |");
            }
            System.out.println();
            for (int i = 0; i < shown; i++) {
                System.out.print("|" + Suit[computer.get(i).s] + "    |");
            }
            System.out.println();
            for (int i = 0; i < shown; i++) {
                System.out.print("|     |");
            }
            System.out.println();
            for (int i = 0; i < shown; i++) {
                System.out.print("\\-----/");
            }
        }
    }

    public static void printPlayerHand(ArrayList<Card> player, int shown) {
        String[] Value = new String[]{"2", "3", "4", "5", "6", "7", "8", "9", "X", "J", "Q", "K", "A"};
        String[] Suit = new String[]{"S", "C", "H", "D"};

        for (int i = 0; i < player.size(); i++) {
            if (i < shown) {
                System.out.print("/-----\\");
            } else {
                System.out.print("[]");
            }
        }
        System.out.println();
        if (shown > 0) {
            for (int i = 0; i < shown; i++) {
                System.out.print("|" + Value[player.get(i).v] + "    |");
            }
            System.out.println();
            for (int i = 0; i < shown; i++) {
                System.out.print("|" + Suit[player.get(i).s] + "    |");
            }
            System.out.println();
            for (int i = 0; i < shown; i++) {
                System.out.print("|     |");
            }
            System.out.println();
            for (int i = 0; i < shown; i++) {
                System.out.print("\\-----/");
            }
        }
    }



}