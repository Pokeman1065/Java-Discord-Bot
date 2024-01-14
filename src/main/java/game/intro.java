package game;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.*;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
/**
 *
 * @author Jerry1065
 */
public class intro {
    
    public static int start(){
        
        Scanner input = new Scanner(System.in);
        int difficulty=0;
        EmbedBuilder intro = new EmbedBuilder();
        intro.setTitle("Welcome to the OLD BANANA");
        intro.addField("Choose your difficulty:","easy(1) medium(2) hard(3)", false);

        
        
        return difficulty;
        
    }
    public static String name(){
    Scanner input = new Scanner(System.in);
    String answer;
    System.out.print("\nWhat Is Your Name?: ");
    answer = input.next();
    input.nextLine();
    return(answer);
}
    
    
    
    
}
