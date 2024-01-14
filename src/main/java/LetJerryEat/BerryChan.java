package LetJerryEat;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;

public class BerryChan extends ListenerAdapter {

    public static String prefix = "!";

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException e) {
            return false;
        } catch(NullPointerException e) {
            return false;
        }
        // only got here if we didn't return false
        return true;
    }

    public static void main(String[] args) throws LoginException {
        JDABuilder builder = JDABuilder.createDefault("My Token Here");
        builder.addEventListeners(new BerryChan());
        builder.setActivity(Activity.playing("With Paul's Heart"));
        builder.addEventListeners(new Commands.Counting());
        builder.addEventListeners(new Commands.DatingSim());
        builder.addEventListeners(new Commands.WhoJoe());
        builder.addEventListeners(new Commands.Caps());
        builder.addEventListeners(new Commands.Copy());
        builder.addEventListeners(new Commands.Event());
        builder.build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        if(event.getAuthor().isBot()){
            return;
        }
        if(event.getMessage().getContentRaw().equals(BerryChan.prefix+"help")){
            EmbedBuilder help = new EmbedBuilder();
            help.setTitle(":bulb: XxBerryChanxX Help! :bulb:");
            help.addField("*!d help*", "Dating Berry Chan!", false);
            help.addField("*!count*","Counts numbers! You can also type numbers for Berry Chan to help count!", false);
            help.addField("*!caps*","Capitalizes all the words you type! (retypes)",false);
            help.addField("*!copy*","Copies all the words you type!",false);
            help.addField("*joe*","Who's Joe? :flushed:", false);
            help.addField("*!event*", "Find out about recent global news", false);
            help.setColor(0xF8B195);
            event.getChannel().sendMessage(help.build()).queue();
            help.clear();
        }
        System.out.printf("[%s][%s] %s: %s\n", event.getGuild().getName(),
                        event.getTextChannel().getName(), event.getMember().getEffectiveName(),
                        event.getMessage().getContentDisplay());

    }
}
