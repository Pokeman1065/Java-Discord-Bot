package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Emote;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;

import LetJerryEat.BerryChan;

import java.util.Arrays;

public class Event extends ListenerAdapter{

    int wk = 1;

    public static void wkOne(GuildMessageReceivedEvent event) {

        EmbedBuilder news = new EmbedBuilder();

        news.setTitle("Why you should wear *orange* on Canada Day", "https://totimes.ca/why-many-canadians-are-wearing-orange-on-canada-day/");
        news.setImage("https://totimes.ca/wp-content/uploads/2021/07/Every-child-matters-859x639.png");
        news.setFooter("Many Canadians are wearing orange to raise awareness on the recent findings of unmarked graves in residential schools");

        event.getChannel().sendMessage(news.build()).queue(message -> {
            message.addReaction("\u2B05\uFE0F").queue();
            message.addReaction("\u27A1\uFE0F").queue();
        });
        news.clear();
    }
    public static void wkTwo(GuildMessageReceivedEvent event) {

        EmbedBuilder news = new EmbedBuilder();

        news.setTitle("Help India breathe - Huge covid wave hits India", "https://covid.giveindia.org/oxygen/");
        news.setImage("https://www.reuters.com/resizer/QH3-zaQ-ae3MR-6s9fOtwM11MFM=/1920x1920/smart/filters:quality(80)/cloudfront-us-east-2.images.arcpublishing.com/reuters/XHE7R6RMX5PAXCL43SPIKE4FFE.jpg");
        news.setFooter("Click on the link to inform yourself of this world issue and donate if you can. " +
                "India is in need of equipment as many people are forced to share beds.");

        event.getChannel().sendMessage(news.build()).queue(message -> {
            message.addReaction("\u2B05\uFE0F").queue();
            message.addReaction("\u27A1\uFE0F").queue();
        });
        news.clear();
    }


    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if (!event.getAuthor().isBot() && args[0].equals(BerryChan.prefix + "event")) {

                switch(wk) {
                    case 1:
                        wkOne(event);
                        break;
                    case 2:
                        wkTwo(event);
                        break;
            /*        case 3:
                        wkThree(event);
                        break;
                    case 4:
                        wkFour(event);
                        break;
                    case 5:
                        wkFive(event);
                        break;
                    case 6:
                        wkSix(event);
                        break;
                    case 7:
                        wkSeven(event);
                        break;
                    case 8:
                        wkEight(event);
                        break;
                    case 9:
                        wkNine(event);
                        break;
                    case 10:
                        wkTen(event);
                        break;
                    case 11:
                        wkEleven(event);
                        break;*/
                    default:
                        //wkEnd(event);
                        break;
                }



        }


    }

    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event){
        if(!event.getUser().isBot()){

                if("\u2B05\uFE0F".equals(event.getReactionEmote().getName())){
                    if(wk > 1){
                        wk -= 1;
                    }
                }
                else if("\u27A1\uFE0F".equals(event.getReactionEmote().getName())){
                    wk += 1;
                }
            }
        }


}
