package game;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import LetJerryEat.BerryChan;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.*;
/**
 *
 * @author Jerry1065
 */
public class game extends ListenerAdapter {
    public static int hp, chp, def, atk, dex, bananas, ehp, edef, eatk, edex;

    
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        // TODO code application logic here
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equals(BerryChan.prefix+"b")) {

            String name;
            int difficulty, roomNum = 1;
            boolean alive = true;
            difficulty = intro.start();
            name = intro.name();

            //Character Stats
            hp = generate.random(40, 50);
            chp = hp;
            def = generate.random(0, 3);
            atk = generate.random(5, 10);
            dex = generate.random(5, 10);
            bananas = 25;


            generate.StatsDisplay(name);

            room.fight(roomNum, difficulty);

            for (; chp > 0; roomNum++) {

                if (roomNum % 5 == 0) {
                    room.firePlace();


                } else if (roomNum % 3 == 0) {
                    room.shop(name, roomNum, difficulty);

                } else if (roomNum % 3 != 0) {

                    room.fight(roomNum, difficulty);

                }
            }

            room.end(name, roomNum);
            //generate.highscore(name, roomNum);

        }
    }
    
}
