package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import LetJerryEat.BerryChan;

import java.util.concurrent.TimeUnit;

public class Counting extends ListenerAdapter {

    boolean count = false;

    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] args = event.getMessage().getContentRaw().split("\\s+");

        if(args.length==1 && BerryChan.isInteger(args[0]) && !event.getAuthor().isBot() && count){
                int plusOne = Integer.parseInt(event.getMessage().getContentRaw())+1;
                event.getChannel().sendTyping().queue();
                event.getChannel().sendMessage(Integer.toString(plusOne)).queue();
                return;
            }
        else if(args[0].equals(BerryChan.prefix+"count") && !event.getAuthor().isBot()){

            try{
                int max = Integer.parseInt(args[1]);
                if(max>100){
                    EmbedBuilder high = new EmbedBuilder();
                    high.setTitle(":no_entry: Too high of a number");
                    high.setDescription("UwU my computer can't handle numbers that are bigger than 100 <3");
                    high.setColor(0xA8E6CE);
                    event.getChannel().sendMessage(high.build()).queue();
                    high.clear();
                }
                else{
                    for(int i = 1; i<=max; i++){
                        event.getChannel().sendMessage(Integer.toString(i)).queue();
                        try {
                            TimeUnit.SECONDS.sleep(1);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } catch(ArrayIndexOutOfBoundsException e){
                count = !count;
                if(count){
                    EmbedBuilder cap = new EmbedBuilder();
                    cap.setTitle(":bulb: Counting is on :bulb:");
                    cap.setColor(0xF8B195);
                    event.getChannel().sendMessage(cap.build()).queue();
                    cap.clear();
                }
                else{
                    EmbedBuilder cap = new EmbedBuilder();
                    cap.setTitle(":no_entry: Counting is off :no_entry:");
                    cap.setColor(0xF8B195);
                    event.getChannel().sendMessage(cap.build()).queue();
                    cap.clear();
                }
            }
            catch(NumberFormatException e){
                EmbedBuilder high = new EmbedBuilder();
                high.setTitle(":no_entry: Please use an integer for !count");
                high.setDescription("Try: *!count 5*");
                high.setColor(0xA8E6CE);
                event.getChannel().sendMessage(high.build()).queue();
                high.clear();
            }

        }


        }

    }


