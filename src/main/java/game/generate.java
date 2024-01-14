package game;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Scanner;

/**
 *
 * @author Jerry1065
 */
public class generate {
    
    public static int random(int min, int max){
        int num;
        
        num = ThreadLocalRandom.current().nextInt(min, max+1);
        
        return num;
        
}
    
    
    //make enemy stats
    public static void enemy(int room, int difficulty){
        game.ehp = generate.random(10+room*difficulty,15+room*difficulty);
        game.edef = generate.random(room*difficulty,room*difficulty);
        game.eatk = generate.random(room*difficulty,3+room*difficulty);
        game.edex = generate.random(room*difficulty,3+room*difficulty);
    }
    public static void StatsDisplay(String Name) {
        System.out.println("\n--------STATS--------");
        System.out.println("Name: " + Name);
        System.out.println("HP: " + game.chp+"/"+game.hp);
        System.out.println("Defense: " + game.def);
        System.out.println("Attack: " + game.atk);
        System.out.println("Dexterity: " + game.dex);
        System.out.println("Bananas: " + game.bananas);
    }

    public static void eStatsDisplay() {
        String[] consonant = new String[]{"B","C","D","F","G","H","J","K","L","M","N","P","Q","R","S","T","V","W","X","Y","Z"};
        String[] vowel = new String[]{"A","E","I","O","U"};
        System.out.println(consonant[generate.random(0, 20)]+vowel[generate.random(0,4)]+vowel[generate.random(0,4)]+consonant[generate.random(0, 20)]+" has appeared");
        System.out.println("HP: " + game.ehp);
        System.out.println("Defense: " + game.edef);
        System.out.println("Attack: " + game.eatk);
        System.out.println("Dexterity: " + game.edex);
    }
    
    public static void timeDelay(int seconds) {
        
        try {
            for (int i = 0; i < seconds ; i ++) {
                Thread.sleep(1000);
                System.out.print(".");
            }
        } catch (InterruptedException ie)
        {
            Thread.currentThread().interrupt();
        }
    }
    
    public static void highscore(String name, int roomNum) throws IOException {
        PrintWriter outputFile = new PrintWriter("spartaHackIV/src/Highscore");

        Scanner input = new Scanner(System.in);

        String Answer="";
        while(!Answer.equals("y")){
        System.out.print("Would You Like To Save Your Score(y/n): ");
        Answer = input.next().toLowerCase();
        input.nextLine();
        }

        if (Answer.equals("y")) {

            outputFile.println("Name: "+name+";"+roomNum);
        }
        outputFile.close();

    }
    
    
}
