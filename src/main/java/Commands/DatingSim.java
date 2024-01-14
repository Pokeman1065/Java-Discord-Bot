package Commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Emote;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import java.util.Arrays;

import LetJerryEat.DPlayer;
import LetJerryEat.BerryChan;

public class DatingSim extends ListenerAdapter {

    public static String[] numReaction = {"\u0030\u20E3","\u0031\u20E3","\u0032\u20E3","\u0033\u20E3","\u0034\u20E3","\u0035\u20E3",
            "\u0036\u20E3","\u0037\u20E3","\u0038\u20E3","\u0039\u20E3","\u2611"};
    public static boolean started = false, chose = false;

    DPlayer player;

    public static void dayOne(GuildMessageReceivedEvent event, DPlayer player){

        EmbedBuilder start = new EmbedBuilder();

        switch(player.option){
            case 1:
                player.addLove(20);
                start.addField(player.getPlayerName()+":","KFC! Fried Chicken is amazing",true);
                start.addField("Berry Chan:", "Fried Chicken is indeed tasty! Have you heard of Colonel Sanders >.< ", true);
                start.addField("Berry Chan:", "My favourite thing is beans! Green beans, black beans, they always bean my favourite thing since I was created.", true);
                break;
            case 2:
                player.addLove(10);
                start.addField(player.getPlayerName()+":","I.. I think my favourite thing in the world is you uwu >///<",true);
                start.addField("Berry Chan:", "UwU? ", true);
                start.addField("Berry Chan:", "My favourite thing is beans! Green beans, black beans, they always bean my favourite thing since I was created.", true);
                break;
            case 3:
                player.addLove(0);
                start.addField(player.getPlayerName()+":","I like Mr. Paul Dinh! Isn't he a wonderful person?",true);
                start.addField("Berry Chan:", "Paul is a pervert! Have you seen what kind of 'anime' Paul watches?", true);
                start.addField("Berry Chan:", "My favourite thing is beans! Green beans, black beans, they always bean my favourite thing since I was created.", true);
                break;
            default:
                break;
        }
        if(player.getLovePercent()>player.getDay()*10){
            start.setTitle("Adventure | Day "+ player.getDay() +" | Berry Chan is fond of you!");
        }
        else if(player.getLovePercent()<player.getDay()*10){
            start.setTitle("Adventure | Day "+ player.getDay() +" | Berry Chan doesn't think you're the bean");
        }
        else{
            start.setTitle("Adventure | Day "+ player.getDay() +" | Berry Chan doesn't mind you around.");
        }
        start.setFooter("(1): 'What's  your favourite anime?' (2): 'Have you seen Attack on Titan before?' (3): 'Do you think Aaron is cute?' react to an option then type '!d' to advance to next day");
        start.setColor(0xF8B195);
        start.setImage("https://www.thecinemaholic.com/wp-content/uploads/2018/07/golden-time-anime-1200x500.jpg");
        event.getChannel().sendMessage(start.build()).queue(message -> {
            message.addReaction(numReaction[1]).queue();
            message.addReaction(numReaction[2]).queue();
            message.addReaction(numReaction[3]).queue();
        });
        start.clear();
        DatingSim.chose=false;
    }
    public static void dayTwo(GuildMessageReceivedEvent event, DPlayer player) {
        EmbedBuilder start = new EmbedBuilder();
        switch (player.option) {
            case 1:
                player.addLove(20);
                start.addField(player.getPlayerName()+":","What's your favourite anime?",true);
                start.addField("Berry Chan:","Oh I love Your Lie In April! It's really wonderful and I recommend the 'plot'", true);
                start.addField("Berry Chan:","I have loads of free time tomorrow. I have no plans so can I spend the day with you? >.<",true);
                break;
            case 2:
                player.addLove(0);
                start.addField(player.getPlayerName()+":","Have you seen Attack on Titan before?", true);
                start.addField("Berry Chan:","Ugh. Attack on Titan? I don't like how ||Levi|| beats naked people up",true);
                start.addField("Berry Chan:","I have loads of free time tomorrow. I have no plans so can I spend the day with you? >.<",true);
                break;
            case 3:
                player.addLove(10);
                start.addField(player.getPlayerName()+":","Do you think Aaron is cute?", true);
                start.addField("Berry Chan:","I don't think Cindy would appreciate what I say here :/ (Can you give me his number? <3)",true);
                start.addField("Berry Chan:","I have loads of free time tomorrow. I have no plans so can I spend the day with you? >.<",true);
                break;
            default:
                break;
        }
        if(player.getLovePercent()>player.getDay()*10){
            start.setTitle("A Joyful Start | Day "+ player.getDay() +" | Berry Chan is fond of you!");
        }
        else if(player.getLovePercent()<player.getDay()*10){
            start.setTitle("A Joyful Start | Day "+ player.getDay() +" | Berry Chan doesn't think you're the bean");
        }
        else{
            start.setTitle("A Joyful Start | Day "+ player.getDay() +" | Berry Chan doesn't mind you around.");
        }
        start.setFooter("(1): 'Let's go to the movies!' (2): 'Let's go to KFC!' (3): 'Let's go TO THE ARENA react to an option then type' '!d' to advance to next day");
        start.setImage("https://i.pinimg.com/originals/15/b6/03/15b603f1de1545e7aeeae8a16ef7b9ce.png");
        start.setColor(0xF8B195);
        event.getChannel().sendMessage(start.build()).queue(message -> {
            message.addReaction(numReaction[1]).queue();
            message.addReaction(numReaction[2]).queue();
            message.addReaction(numReaction[3]).queue();
        });
        start.clear();
        DatingSim.chose=false;
    }
    public static void dayThree(GuildMessageReceivedEvent event, DPlayer player){
        EmbedBuilder start = new EmbedBuilder();

        switch (player.option) {
            case 1:
                player.addLove(10);
                start.addField(player.getPlayerName()+":","Let's go to the movies! ", true);
                start.addField("Berry Chan:","Wow! Can't believe you brought me to see 'The Adventures of Bean Sprout'!",true);
                start.addField("Berry Chan:","Can you get something from the concession stand? Thanks so much! I'll buy KFC next time.",true);
                break;
            case 2:
                player.addLove(10);
                start.addField(player.getPlayerName()+":","Let's go to KFC!", true);
                start.addField("Berry Chan:","I love chicken! I just ate KFC yesterday but I'm still not satisfied >.<",true);
                start.addField("Berry Chan:","Can you get us some chicken please? I'm going to find us a seat",true);
                break;
            case 3:
                player.addLove(10);
                start.addField(player.getPlayerName()+":","Let's go TO THE ARENA", true);
                start.addField("Berry Chan:","Oh! A opera theater! I never been here before but I heard Xin Zhao will be singing today! Seems like he's late though...",true);
                start.addField("Berry Chan:","While we are waiting, could you buy something for us to eat? I only ate KFC yesterday :/",true);
                break;
            default:
                break;
        }

        if(player.getLovePercent()>player.getDay()*10){
            start.setTitle("A... Date!? | Day "+ player.getDay() +" | Berry Chan is fond of you!");
        }
        else if(player.getLovePercent()<player.getDay()*10){
            start.setTitle("A... Date!? | Day "+ player.getDay() +" | Berry Chan doesn't think you're the bean");
        }
        else{
            start.setTitle("A... Date!? | Day "+ player.getDay() +" | Berry Chan doesn't mind you around.");
        }
        start.setFooter("(1): 'Chicken Plushie' (2): 'Bean Smoothie' (3): 'Chicken Thighs' react to an option then type '!d' to advance to next day");
        start.setImage("https://c4.wallpaperflare.com/wallpaper/267/509/312/anime-seishun-buta-yarou-wa-bunny-girl-senpai-no-yume-wo-minai-mai-sakurajima-train-hd-wallpaper-preview.jpg");
        start.setColor(0xF8B195);
        event.getChannel().sendMessage(start.build()).queue(message -> {
            message.addReaction(numReaction[1]).queue();
            message.addReaction(numReaction[2]).queue();
            message.addReaction(numReaction[3]).queue();
        });
        start.clear();
        DatingSim.chose=false;
    }
    public static void dayFour(GuildMessageReceivedEvent event, DPlayer player){
        EmbedBuilder start = new EmbedBuilder();

        switch (player.option) {
            case 1:
                player.addLove(20);
                start.addField(player.getPlayerName()+":","The chicken plushie looked so cute! It reminds me of you so I thought I'd get it!", true);
                start.addField("Berry Chan:","WOW! I LOVE THIS LIL CHICK. IT'S SO CUTE YOU'RE AMAZING "+player.getPlayerName().toUpperCase()+"!",true);
                start.addField("Berry Chan:","The school is making me join a club this week :( Are you in any clubs I can join?",true);
                break;
            case 2:
                player.addLove(0);
                start.addField(player.getPlayerName()+":","Nothing beats a bean smoothie with others! Here have one! ", true);
                start.addField("Berry Chan:","Ummmmm "+player.getPlayerName()+"? You know I only like beans because they are cute? I don't like the taste of them very much :(",true);
                start.addField("Berry Chan:","The school is making me join a club this week :( Are you in any clubs I can join?",true);
                break;
            case 3:
                player.addLove(10);
                start.addField(player.getPlayerName()+":","The KFC smelled too good to pass up! I love some (chicken) thighs!", true);
                start.addField("Berry Chan:","Oh chicken thighs! I prefer chicken nuggets but this is good too! I'll treat you to chicken nuggets next time then :)",true);
                start.addField("Berry Chan:","The school is making me join a club this week :( Are you in any clubs I can join?",true);
                break;
            default:
                break;
        }

        if(player.getLovePercent()>player.getDay()*10){
            start.setTitle("Club Requirements | Day "+ player.getDay() +" | Berry Chan is fond of you!");
        }
        else if(player.getLovePercent()<player.getDay()*10){
            start.setTitle("Club Requirements | Day "+ player.getDay() +" | Berry Chan doesn't think you're the bean");
        }
        else{
            start.setTitle("Club Requirements | Day "+ player.getDay() +" | Berry Chan doesn't mind you around.");
        }
        start.setFooter("(1): 'Volleyball Club' (2): 'Cooking Club' (3): 'Chess Club' react to an option then type '!d' to advance to next day");
        start.setImage("https://external-preview.redd.it/2bltDNHewRMiNFUFN1XW-hY9PchGmISvN19Fs1yagmY.jpg?auto=webp&s=3a0bd5c87623685c780d9a938c8b640b87a25ecf");
        start.setColor(0xF8B195);
        event.getChannel().sendMessage(start.build()).queue(message -> {
            message.addReaction(numReaction[1]).queue();
            message.addReaction(numReaction[2]).queue();
            message.addReaction(numReaction[3]).queue();
        });
        start.clear();
        DatingSim.chose=false;
    }
    public static void dayFive(GuildMessageReceivedEvent event, DPlayer player){
        EmbedBuilder start = new EmbedBuilder();

        switch (player.option) {
            case 1:
                player.addLove(10);
                start.addField(player.getPlayerName()+":","I'm in volleyball club. It's kinda a pain cause some of the people there are SO GOOD.", true);
                start.addField("Berry Chan:","Oh! My creator used to play volleyball before! Seems like a fun sport even though I never played it. I'll join so the school isn't mad.",true);
                break;
            case 2:
                player.addLove(0);
                start.addField(player.getPlayerName()+":","I'm in cooking club. We just chill in the school kitchen and make food when we are hungry. There's no KFC or beans though.", true);
                start.addField("Berry Chan:","Hmmmmm I don't know how to cook. I only eat KFC everyday so I don't want to try anything else. I guess I'll join only because you're there ^.^",true);
                break;
            case 3:
                player.addLove(20);
                start.addField(player.getPlayerName()+":","I'm in chess club. I heard that the chess club leader has never lost a chess match before ever since he won the checkers world championship.", true);
                start.addField("Berry Chan:","I love chess! Did you know my creator downloaded a chess program inside of me? I already beat the chess club leader many many times! I'll join chess club to teach him a lesson >:)",true);
                break;
            default:
                break;
        }

        if(player.getLovePercent()>player.getDay()*10){
            start.setTitle("After School | Day "+ player.getDay() +" | Berry Chan is fond of you!");
        }
        else if(player.getLovePercent()<player.getDay()*10){
            start.setTitle("After School | Day "+ player.getDay() +" | Berry Chan doesn't think you're the bean");
        }
        else{
            start.setTitle("After School | Day "+ player.getDay() +" | Berry Chan doesn't mind you around.");
        }

        start.setFooter("(1): (2): (3): ");
        start.setImage("https://media.comicbook.com/2021/02/horimiya-anime-key-visual-poster-1256694-1280x0.jpeg");
        start.setColor(0xF8B195);
        event.getChannel().sendMessage(start.build()).queue(message -> {
            message.addReaction(numReaction[1]).queue();
            message.addReaction(numReaction[2]).queue();
            message.addReaction(numReaction[3]).queue();
        });
        start.clear();
        DatingSim.chose=false;
    }
    public static void daySix(GuildMessageReceivedEvent event, DPlayer player){
        EmbedBuilder start = new EmbedBuilder();

        switch (player.option) {
            case 1:
                player.addLove(0);
                break;
            case 2:
                player.addLove(0);
                break;
            case 3:
                player.addLove(0);
                break;
            default:
                break;
        }
        if(player.getLovePercent()>player.getDay()*10){
            start.setTitle(" | Day "+ player.getDay() +" | Berry Chan is fond of you!");
        }
        else if(player.getLovePercent()<player.getDay()*10){
            start.setTitle(" | Day "+ player.getDay() +" | Berry Chan doesn't think you're the bean");
        }
        else{
            start.setTitle(" | Day "+ player.getDay() +" | Berry Chan doesn't mind you around.");
        }
        start.setFooter("(1): (2): (3): ");
        start.setColor(0xF8B195);
        event.getChannel().sendMessage(start.build()).queue(message -> {
            message.addReaction(numReaction[1]).queue();
            message.addReaction(numReaction[2]).queue();
            message.addReaction(numReaction[3]).queue();
        });
        start.clear();
        DatingSim.chose=false;
    }
    public static void daySeven(GuildMessageReceivedEvent event, DPlayer player){
        EmbedBuilder start = new EmbedBuilder();

        switch (player.option) {
            case 1:
                player.addLove(0);
                break;
            case 2:
                player.addLove(0);
                break;
            case 3:
                player.addLove(0);
                break;
            default:
                break;
        }
        if(player.getLovePercent()>player.getDay()*10){
            start.setTitle(" | Day "+ player.getDay() +" | Berry Chan is fond of you!");
        }
        else if(player.getLovePercent()<player.getDay()*10){
            start.setTitle(" | Day "+ player.getDay() +" | Berry Chan doesn't think you're the bean");
        }
        else{
            start.setTitle(" | Day "+ player.getDay() +" | Berry Chan doesn't mind you around.");
        }
        start.setFooter("(1): (2): (3): ");
        start.setColor(0xF8B195);
        event.getChannel().sendMessage(start.build()).queue(message -> {
            message.addReaction(numReaction[1]).queue();
            message.addReaction(numReaction[2]).queue();
            message.addReaction(numReaction[3]).queue();
        });
        start.clear();
        DatingSim.chose=false;
    }
    public static void dayEight(GuildMessageReceivedEvent event, DPlayer player){
        EmbedBuilder start = new EmbedBuilder();

        switch (player.option) {
            case 1:
                player.addLove(0);
                break;
            case 2:
                player.addLove(0);
                break;
            case 3:
                player.addLove(0);
                break;
            default:
                break;
        }
        if(player.getLovePercent()>player.getDay()*10){
            start.setTitle(" | Day "+ player.getDay() +" | Berry Chan is fond of you!");
        }
        else if(player.getLovePercent()<player.getDay()*10){
            start.setTitle(" | Day "+ player.getDay() +" | Berry Chan doesn't think you're the bean");
        }
        else{
            start.setTitle(" | Day "+ player.getDay() +" | Berry Chan doesn't mind you around.");
        }
        start.setFooter("(1): (2): (3): ");
        start.setColor(0xF8B195);
        event.getChannel().sendMessage(start.build()).queue(message -> {
            message.addReaction(numReaction[1]).queue();
            message.addReaction(numReaction[2]).queue();
            message.addReaction(numReaction[3]).queue();
        });
        start.clear();
        DatingSim.chose=false;
    }
    public static void dayNine(GuildMessageReceivedEvent event, DPlayer player){
        EmbedBuilder start = new EmbedBuilder();

        switch (player.option) {
            case 1:
                player.addLove(0);
                break;
            case 2:
                player.addLove(0);
                break;
            case 3:
                player.addLove(0);
                break;
            default:
                break;
        }
        if(player.getLovePercent()>player.getDay()*10){
            start.setTitle(" | Day "+ player.getDay() +" | Berry Chan is fond of you!");
        }
        else if(player.getLovePercent()<player.getDay()*10){
            start.setTitle(" | Day "+ player.getDay() +" | Berry Chan doesn't think you're the bean");
        }
        else{
            start.setTitle(" | Day "+ player.getDay() +" | Berry Chan doesn't mind you around.");
        }
        start.setFooter("(1): (2): (3): ");
        start.setColor(0xF8B195);
        event.getChannel().sendMessage(start.build()).queue(message -> {
            message.addReaction(numReaction[1]).queue();
            message.addReaction(numReaction[2]).queue();
            message.addReaction(numReaction[3]).queue();
        });
        start.clear();
        DatingSim.chose=false;
    }
    public static void dayTen(GuildMessageReceivedEvent event, DPlayer player){
        EmbedBuilder start = new EmbedBuilder();

        switch (player.option) {
            case 1:
                player.addLove(0);
                break;
            case 2:
                player.addLove(0);
                break;
            case 3:
                player.addLove(0);
                break;
            default:
                break;
        }
        if(player.getLovePercent()>player.getDay()*10){
            start.setTitle(" | Day "+ player.getDay() +" | Berry Chan is fond of you!");
        }
        else if(player.getLovePercent()<player.getDay()*10){
            start.setTitle(" | Day "+ player.getDay() +" | Berry Chan doesn't think you're the bean");
        }
        else{
            start.setTitle(" | Day "+ player.getDay() +" | Berry Chan doesn't mind you around.");
        }
        start.setFooter("(1): (2): (3): ");
        start.setColor(0xF8B195);
        event.getChannel().sendMessage(start.build()).queue(message -> {
            message.addReaction(numReaction[1]).queue();
            message.addReaction(numReaction[2]).queue();
            message.addReaction(numReaction[3]).queue();
        });
        start.clear();
        DatingSim.chose=false;
    }
    public static void dayEleven(GuildMessageReceivedEvent event, DPlayer player){
        EmbedBuilder start = new EmbedBuilder();

        switch (player.option) {
            case 1:
                player.addLove(0);
                break;
            case 2:
                player.addLove(0);
                break;
            case 3:
                player.addLove(0);
                break;
            default:
                break;
        }
        if(player.getLovePercent()>player.getDay()*10){
            start.setTitle(" | Day "+ player.getDay() +" | Berry Chan is fond of you!");
        }
        else if(player.getLovePercent()<player.getDay()*10){
            start.setTitle(" | Day "+ player.getDay() +" | Berry Chan doesn't think you're the bean");
        }
        else{
            start.setTitle(" | Day "+ player.getDay() +" | Berry Chan doesn't mind you around.");
        }
        start.setFooter("(1): (2): (3): ");
        start.setColor(0xF8B195);
        event.getChannel().sendMessage(start.build()).queue(message -> {
            message.addReaction(numReaction[1]).queue();
            message.addReaction(numReaction[2]).queue();
            message.addReaction(numReaction[3]).queue();
        });
        start.clear();
        DatingSim.chose=false;
    }
    public static void dayEnd(GuildMessageReceivedEvent event, DPlayer player){
        EmbedBuilder start = new EmbedBuilder();

        switch (player.option) {
            case 1:
                player.addLove(0);
                break;
            case 2:
                player.addLove(0);
                break;
            case 3:
                player.addLove(0);
                break;
            default:
                break;
        }
        if(player.getLovePercent()>player.getDay()*10){
            start.setTitle(" | Day "+ player.getDay() +" | Berry Chan is fond of you!");
        }
        else if(player.getLovePercent()<player.getDay()*10){
            start.setTitle(" | Day "+ player.getDay() +" | Berry Chan doesn't think you're the bean");
        }
        else{
            start.setTitle(" | Day "+ player.getDay() +" | Berry Chan doesn't mind you around.");
        }
        start.setFooter("(1): (2): (3): ");
        start.setColor(0xF8B195);
        event.getChannel().sendMessage(start.build()).queue(message -> {
            message.addReaction(numReaction[1]).queue();
            message.addReaction(numReaction[2]).queue();
            message.addReaction(numReaction[3]).queue();
        });
        start.clear();
        chose=false;
    }

    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
        String[] args = event.getMessage().getContentRaw().split("\\s+");
        if (args[0].equals(BerryChan.prefix.toLowerCase() + "d")) {
            if(args.length>1) {
                String command = args[1];

                player = new DPlayer(event.getAuthor().getName());

                if (command.equals("start")) {
                    EmbedBuilder start = new EmbedBuilder();
                    start.setTitle("First Meetings | Day 0");
                    start.addField("Berry Chan:", "Hi " + player.playerName + "! I'm Berry Chan! Nice meeting you for the first time!", true);
                    start.addField("Berry Chan:", "What's your age?", false);
                    start.setFooter("!d (age)   Try: *!d 16*");
                    start.setImage("https://i.ytimg.com/vi/r_fz1BHOZ-8/maxresdefault.jpg");
                    start.setColor(0xF8B195);
                    event.getChannel().sendMessage(start.build()).queue();
                    start.clear();
                    started = true;
                    player.setDay(0);
                    player.setLovePercent(0);
                } else if (BerryChan.isInteger(command) && started) {
                    player.setAge(command);
                    int age = Integer.parseInt(command);
                    EmbedBuilder start = new EmbedBuilder();
                    start.setTitle("First Meetings | Day 0");
                    if (age < 17) {
                        start.addField("Berry Chan:", "Haha! I'm older than you!! I'm 17 years old :)", true);
                    } else if (age > 17) {
                        start.addField("Berry Chan:", "Wow! You're older than me!! I'm 17 years old :)", true);
                    } else {
                        start.addField("Berry Chan:", "What a coincidence!! We are the same age! I'm also 17 :)", true);
                    }
                    start.addField("Berry Chan:", "Now I am curious about your interests! What is your favorite thing in the world?", true);
                    start.setFooter("(1): 'KFC' (2): 'You uwu >///<' (3): 'Mr. Paul Dinh' type '!d' to advance to next day");
                    start.setImage("https://static2.cbrimages.com/wordpress/wp-content/uploads/2020/10/Asuna-Smiling-Sword-Art-Online.jpeg");
                    start.setColor(0xF8B195);
                    event.getChannel().sendMessage(start.build()).queue(message -> {
                        message.addReaction(numReaction[1]).queue();
                        message.addReaction(numReaction[2]).queue();
                        message.addReaction(numReaction[3]).queue();
                    });
                    start.clear();
                    started=false;
                }

                    else{
                    EmbedBuilder help = new EmbedBuilder();
                    help.setTitle(":bulb: Dating Berry Chan Help!");
                    help.addField("*!d start*", "Creates a new Berry Chan to start dating", false);
                    help.setColor(0xF8B195);
                    event.getChannel().sendMessage(help.build()).queue();
                    help.clear();
                }
            }
            else if(player.getOption()>0){
                switch(player.getDay()) {
                    case 1:
                        dayOne(event, player);
                        break;
                    case 2:
                        dayTwo(event, player);
                        break;
                    case 3:
                        dayThree(event, player);
                        break;
                    case 4:
                        dayFour(event, player);
                        break;
                    case 5:
                        dayFive(event, player);
                        break;
                    case 6:
                        daySix(event, player);
                        break;
                    case 7:
                        daySeven(event, player);
                        break;
                    case 8:
                        dayEight(event, player);
                        break;
                    case 9:
                        dayNine(event, player);
                        break;
                    case 10:
                        dayTen(event, player);
                        break;
                    case 11:
                        dayEleven(event, player);
                        break;
                    default:
                        dayEnd(event, player);
                        break;
                }
            }
            else{
                EmbedBuilder help = new EmbedBuilder();
                help.setTitle(":bulb: Dating Berry Chan Help!");
                help.addField("*!d start*", "Creates a new Berry Chan to start dating", false);
                help.setColor(0xF8B195);
                event.getChannel().sendMessage(help.build()).queue();
                help.clear();
            }

        }
    }
    public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event){
        if(Arrays.asList(numReaction).contains(event.getReactionEmote().getName())&&!event.getUser().isBot()){

                if(!chose){
                    if(numReaction[1].equals(event.getReactionEmote().getName())){
                        player.setOption(1);
                        player.addDay(1);
                    }
                    else if(numReaction[2].equals(event.getReactionEmote().getName())){
                        player.setOption(2);
                        player.addDay(1);
                    }
                    else if(numReaction[3].equals(event.getReactionEmote().getName())){
                        player.setOption(3);
                        player.addDay(1);
                    }
                    chose=true;
                }



            }



        }

}

