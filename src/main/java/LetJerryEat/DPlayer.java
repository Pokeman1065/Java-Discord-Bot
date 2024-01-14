package LetJerryEat;

public class DPlayer {
    public String playerName;
    public String age;
    public String interest;
    public int lovePercent;
    public int day;
    public int option;


    public DPlayer(String name){
        playerName=name;
        lovePercent=0;
        day=0;
        option = 0;
    }

    public void setAge(String age) {this.age = age;}

    public void setInterest(String interest) {this.interest = interest;}

    public void setOption(int option){this.option=option;}

    public void setDay(int days){day=days;}

    public void setLovePercent(int lovePercent){this.lovePercent=lovePercent;}

    public String getPlayerName(){return playerName;}

    public int getDay(){return day;}

    public int getOption(){return option;}

    public int getLovePercent(){return lovePercent;}

    public void addDay(int days){day+=days;}

    public void addLove(int percent){ lovePercent+=percent;}


}
