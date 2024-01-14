package Commands;

import LetJerryEat.BerryChan;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.Arrays;

public class Caps extends ListenerAdapter {

    boolean caps = false;

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if(caps && !event.getAuthor().isBot() && !args[0].equals(BerryChan.prefix+"caps")){
            String capped = "";
            for(int i =0; i<args.length; i++){
                if(args[i].charAt(0) <= 122 && args[i].charAt(0) >= 97){
                    char[] cap = args[i].toCharArray();
                    cap[0] = (char)(cap[0]-32);
                    args[i] = String.valueOf(cap);
                }
                capped += args[i]+" ";
            }

            event.getChannel().sendMessage(capped).queue();
        }

        if(args[0].equals(BerryChan.prefix+"caps") && !event.getAuthor().isBot()) {
            caps =! caps;
            if(caps){
                EmbedBuilder cap = new EmbedBuilder();
                cap.setTitle(":bulb: Caps is on :bulb:");
                cap.setColor(0xF8B195);
                event.getChannel().sendMessage(cap.build()).queue();
                cap.clear();
            }
            else{
                EmbedBuilder cap = new EmbedBuilder();
                cap.setTitle(":no_entry: Caps is off :no_entry:");
                cap.setColor(0xF8B195);
                event.getChannel().sendMessage(cap.build()).queue();
                cap.clear();
            }
        }





    }

}
