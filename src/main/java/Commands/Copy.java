package Commands;

import LetJerryEat.BerryChan;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import java.util.Arrays;

    public class Copy extends ListenerAdapter {

        boolean copy = false;

        public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
            String[] args = event.getMessage().getContentRaw().split("\\s+");

            if(copy && !event.getAuthor().isBot() && !args[0].equals(BerryChan.prefix+"copy")){
                String capped = "";
                for(int i =0; i<args.length; i++){
                    capped += args[i]+" ";
                }



                event.getChannel().sendMessage(capped).queue();
            }

            if(args[0].equals(BerryChan.prefix+"copy") && !event.getAuthor().isBot()) {
                copy =! copy;
                if(copy){
                    EmbedBuilder copy = new EmbedBuilder();
                    copy.setTitle(":bulb: Copy is on :bulb:");
                    copy.setColor(0xF8B195);
                    event.getChannel().sendMessage(copy.build()).queue();
                    copy.clear();
                }
                else{
                    EmbedBuilder copy = new EmbedBuilder();
                    copy.setTitle(":no_entry: Copy is off :no_entry:");
                    copy.setColor(0xF8B195);
                    event.getChannel().sendMessage(copy.build()).queue();
                    copy.clear();
                }
            }





        }
}
