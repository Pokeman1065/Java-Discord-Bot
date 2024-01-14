package Commands;

import LetJerryEat.BerryChan;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class WhoJoe extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split("\\s+");
    if(args[0].toLowerCase().equals("joe") && !event.getAuthor().isBot()) {
        event.getChannel().sendTyping().queue();
        event.getChannel().sendMessage("MAMA").queue();
    }
    }
}
