package game;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Scanner;

/**
 *
 * @author Jerry1065
 */
public class room {
    
    //fight
    public static void fight(int room, int difficulty){
        Scanner input = new Scanner(System.in);
        String action="z"; 
        boolean turn=false;
        int money;
        money = generate.random(5, 10);
        generate.enemy(room, difficulty);
        generate.timeDelay(3);
        System.out.println("\n--------NEW ENEMY--------");
        generate.eStatsDisplay();
        generate.timeDelay(3);
        while(game.chp>0&&game.ehp>0){
            
            if(game.dex>game.edex){
                turn=true;
            }
        if(turn){
            while(!action.equalsIgnoreCase("a")&&!action.equalsIgnoreCase("h")&&!action.equalsIgnoreCase("q")){
        System.out.println("\n--------CHOICE--------\nAttack (a)\nHeal(h)\nQuit(q)");
        action = input.nextLine();
        
            }
        //you attac
        if(action.equalsIgnoreCase("a")){
            
        System.out.println("\n-----------------------------------\nYou did "+(game.atk-game.edef)+" damage!");
        game.ehp-=game.atk-game.edef;
        if(game.ehp<0){
            game.ehp=0;
        }
        System.out.println("Enemy hp left: "+game.ehp+"\n-----------------------------------");
        turn=false;
        }
        if(action.equalsIgnoreCase("q")){
            game.chp=0;
        }
        //you hel
        if(action.equalsIgnoreCase("h")){
        System.out.println("\n-----------------------------------\nYou healed "+game.dex+"!");
        game.chp+=game.dex;
        if(game.chp>game.hp){
            game.chp=game.hp;
        }
        System.out.println("You now have "+game.chp+"/"+game.hp+"hp left\n---------------------------------------");
        turn=false;
        }
        }
        if(!turn&&game.ehp>0){
        //enemy attac
        generate.timeDelay(3);
        if(game.eatk>game.def){
        System.out.println("\n-------------------------------------------\nThe enemy dealt "+(game.eatk-game.def)+" damage!");
        game.chp-=(game.eatk - game.def);
        }
        if(game.eatk<game.def){
            System.out.println("\n------------------------------------\nThe enemy dealt 0 damage!");
        }
        if(game.chp<0){
            game.chp=0;
        }
        System.out.println("You now have "+game.chp+"/"+game.hp+"hp left\n----------------------------------------");
        turn=true;
        
        }
        action="z";
        }
        if(game.chp>0){
        System.out.println("You Defeated an enemy! You got "+money+" Bananas");
        game.bananas+=money;
        }
    }
    
    
    public static void display(int hp, int def, int atk, int dex) {
        
        System.out.println("HP: " + hp + " Enter 'hp' to get +"+hp+" maxhp for 20B");
        System.out.println("Defense: " + def + " Enter 'def' to get +"+def+" defense for 20B");
        System.out.println("Attack: " + atk + " Enter 'atk' to get +"+atk+" attack for 20B");
        System.out.println("Dexterity: " + dex + " Enter 'dex' to get +"+dex+" Dexterity for 20B");
        System.out.println("Enter 'none' to save your money\n");

    }

    public static void shop(String name, int roomNum, int difficulty) {
        int hp, def, atk, dex;
        hp = generate.random(1,5)+roomNum*difficulty;
        def = generate.random(1,5)+roomNum*difficulty;
        atk = generate.random(1,5)+roomNum*difficulty;
        dex = generate.random(1,5)+roomNum*difficulty;
        
        Scanner input = new Scanner(System.in);
        String upgrade = "";

        
            generate.StatsDisplay(name);
            while (game.bananas>20&&!upgrade.equals("none")) {
            System.out.println("\n--------SHOP--------");
            display(hp, def, atk, dex);
            System.out.print("What would you like to upgrade: ");
            upgrade = input.next();
            input.nextLine().toLowerCase();
            generate.timeDelay(3);
            switch (upgrade) {
                case "hp":
                    game.hp += hp;
                    game.bananas -= 20;
                    System.out.println("Upgrade Successful!");
                    break;
                case "def":
                    game.def += def;
                    game.bananas -= 20;
                    System.out.println("Upgrade Successful!");
                    break;
                case "atk":
                    game.atk += atk;
                    game.bananas -= 20;
                    System.out.println("Upgrade Successful!");
                    break;
                case "dex":
                    game.dex += dex;
                    game.bananas -= 20;
                    System.out.println("Upgrade Successful!");
                    break;
                default:
                    System.out.println("No Upgrade added");
            }

        }
    }
    
    
    //rest
    public static void firePlace() {
        generate.timeDelay(3);
        System.out.println("-------------------------------------------\nYou have found a fireplace!");
        System.out.println("You have healed "+(game.hp-game.chp)+"hp");
        game.chp=game.hp;
        System.out.println("You are now at "+game.chp+"/"+game.hp+"hp");
        
    }
    public static void treasure(){
        String ans="";
        int num;
        Scanner input = new Scanner(System.in);
        
        System.out.println("-------------------------------------------\nYou have found a Mysterious Chest!");
        while(!ans.equals("y")||!ans.equals("n")){
        System.out.println("Will you open?(y/n)");
        ans=input.nextLine().toLowerCase();
        }
        generate.timeDelay(3);
        num=generate.random(0, 10);
        if(num%2==0){
            System.out.println("\n-------------------------------------\nBANANA GEM!!! You gained 25 bananas!");
            game.bananas+=25;
    }
        else{
            System.out.println("\n-------------------------------------\nBOMB!!! You lost 5 hp!");
            if(game.chp>5){
            game.chp-=5;
            }
            else{
                game.chp=0;
            }
        }
        
    }
    public static void end(String name, int roomNum){
        generate.timeDelay(3);
        System.out.println("You died!");
        System.out.println("Here are your stats: ");
        generate.timeDelay(3);
        generate.StatsDisplay(name);
        System.out.println("Enemies cleared: "+roomNum);
    }
    
    
}
