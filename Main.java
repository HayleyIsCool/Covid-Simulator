import java.util.*;
//package io;
import java.io.*;
import java.lang.*;
//currently on 132nd generation of macoc bloodline
class Main {

  public static FileWriter info1;
  public static FileReader info;
  public static FileWriter lead1;
  public static FileReader lead;
  public static HashMap<String, String> saveInfo = new HashMap<String, String>();
  public static HashMap<String, String> saveLead = new HashMap<String, String>();
  public static int[] saveLeadList;
  public static String[] saveLeadList2;
  public static String word = "";
  public static String word1 = "";
  public static String highScore = "";
  public static int x = 0;
  public static int y = 0;
  public static int size;
  public static String pass;
  public static String user;

  public static boolean start = false;

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    Characters player = new Characters("Harry", "Potty", 12, 8, 3, 100, 0, false);
    while(start == false){
      System.out.print("Sign Up(1), Log In(2), LeaderBoard(3): ");
      String player3 = s.nextLine();
      try {
        info = new FileReader("info.txt");
        lead = new FileReader("leaderBoard.txt");
        word = "";
        highScore = "";
        int i;    
        while((i = info.read()) != -1) {
          if((char) i == ' '){
            x = 1;
          }
          else if((char) i == '\n'){
            x = 0;
            saveInfo.put(word,word1);
            word = "";
            word1 = "";
          }
          else if(x == 0){
            word += (char) i;    
          }
          else{
            word1 += (char) i;
          }
        }  
        saveInfo.put(word,word1);
        info.close();
        word = "";
        x = 0;
        while((i = lead.read()) != -1) {
          if((char) i == ' '){
            x = 1;
          }
          else if((char) i == '\n'){
            x = 0;
            saveLead.put(word,highScore);
            word = "";
            highScore = "";
          }
          else if(x == 0){
            word += (char) i;    
          }
          else{
            highScore += (char) i;
          }
        }
        saveLead.put(word,highScore);
        lead.close();
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }
      saveLeadList = new int[saveLead.size()];
      saveLeadList2 = new String[saveLeadList.length];
      int v = 0;
      for (String i : saveLead.values()) {
        saveLeadList[v] = java.lang.Integer.parseInt(i.trim());
        v += 1;
      }
      Arrays.sort(saveLeadList);
      for(String user : saveLead.keySet()){
        int num = java.lang.Integer.parseInt(saveLead.get(user).trim());
        if(num == saveLeadList[saveLeadList.length-1]){
          saveLeadList2[saveLeadList2.length-1] = user;
        }
        else if(num == saveLeadList[saveLeadList.length-2]){
          saveLeadList2[saveLeadList2.length-2] = user;
        }
        else if(num == saveLeadList[saveLeadList.length-3]){
          saveLeadList2[saveLeadList2.length-3] = user;
        }
        else if(num == saveLeadList[saveLeadList.length-4]){
          saveLeadList2[saveLeadList2.length-4] = user;
        }
        else if(num == saveLeadList[saveLeadList.length-5]){
          saveLeadList2[saveLeadList2.length-5] = user;
        }
      }
      if(player3.equals("1")){
        System.out.print("Username: ");
        user = s.nextLine();
        System.out.print("Password: ");
        pass = s.nextLine();
        saveInfo.put(user,pass);
        saveLead.put(user,"0");
        try {
          info1 = new FileWriter("info.txt");
          size = saveInfo.size();
          y = 0;
          for (String i : saveInfo.keySet()) {
            y+=1;
            info1.write(i);
            info1.write(' ');
            info1.write(saveInfo.get(i));
            if(y!=size){
              info1.write('\n');
            }
          }
          info1.close();
          lead1 = new FileWriter("leaderBoard.txt");
          size = saveLead.size();
          y = 0;
          for (String i : saveLead.keySet()) {
            y+=1;
            lead1.write(i);
            lead1.write(' ');
            lead1.write(saveLead.get(i));
            if(y!=size){
              lead1.write('\n');
            }
          }
          lead1.close();
        } catch (IOException e) {
          System.out.println("An error occurred.");
          e.printStackTrace();
        }  
      }
      if (player3.equals("2")){
        System.out.print("Username: ");
        user = s.nextLine();
        System.out.print("Password: ");
        pass = s.nextLine();
        for (String i : saveInfo.keySet()) {
          if (user.equals(i) && pass.equals(saveInfo.get(i))){
            start=true;
          }
        }
      }
      if(player3.equals("3")){
        System.out.println("-------LeaderBoard-------");
        System.out.println("#1: " + saveLeadList2[saveLeadList.length-1] + " - " + String.valueOf(saveLeadList[saveLeadList.length-1]));
        System.out.println("#2: " + saveLeadList2[saveLeadList.length-2] + " - " + String.valueOf(saveLeadList[saveLeadList.length-2]));
        System.out.println("#3: " + saveLeadList2[saveLeadList.length-3] + " - " + String.valueOf(saveLeadList[saveLeadList.length-3]));
        System.out.println("#4: " + saveLeadList2[saveLeadList.length-4] + " - " + String.valueOf(saveLeadList[saveLeadList.length-4]));
        System.out.println("#5: " + saveLeadList2[saveLeadList.length-5] + " - " + String.valueOf(saveLeadList[saveLeadList.length-5]));
        System.out.println("-------LeaderBoard-------");
      }
    }
    System.out.print("Choose a character - Harry Potty(1), Homeowner Simpsons(2), Drem(3), Hollow Night(4), Costum(5): ");
    String player1 = s.nextLine();
    if (player1.equals("1")){
      player = new Characters("Harry", "Potty", 12, 8, 3, 150, 0, false);
    }
    else if (player1.equals("2")){
      player = new Characters("Homeowner", "Simpsons", 69, 4, 8, 100, 0, false);
    }
    else if (player1.equals("3")){
      player = new Characters("Drem", "WasTaken", 23, 6, 2, 200, 0, false);
    }
    else if (player1.equals("4")){
      player = new Characters("Hollow", "Night", 0, 9, 1, 150, 0, false);
    }
    else{
      System.out.print("Choose a First Name: ");
      String name1 = s.nextLine();
      System.out.print("Choose a Last Name: ");
      String name2 = s.nextLine();
      player = new Characters(name1, name2, random.randint(3,80), random.randint(1,10), random.randint(1,10), random.randint(5,300), 0, false);
    }
    Event.play = player;
    Event[] events = {new Event("You need to leave the house. Wear a mask for $5?", -5, 3, -2,-5, 0), new Event("Your friends are going out for lunch. Join them?", 5, -2, 3, 0, 0), new Event("Vaccines available at your local CVC!", 0, 3, -1, 0, 1),new Event("Jobs available at an indoor resturant for $100", 5, -3, 2, 100, 0), new Event("Zoom night with friends! Pay $50 to repair your computer?", 0, 0, 3, -50, 0), new Event("Oh no! Your best friend has Covid 19! Visit her in the hospital?", 5, -3, 3, 0, 0), new Event("Coronavirus cases reported in your family! Quarentine for 14 days?", -5, 3, -3, 0, 0), new Event("New movie just came out! Tickets available!", 5, -3, 3, -5, 0), new Event("You just got fired! Sell your house?", 0, 0, -3, 100, 0), new Event("Join the gym for $50", 5, 3, 3, -50, 0)};
    int r = random.randint(0, events.length-1);
    int r1 = random.randint(0, events.length-1);
    while(r1 == r){
      r1 = random.randint(0, events.length-1);
    }
    int r2 = random.randint(0, events.length-1);
    while(r2 == r || r2 == r1){
      r2 = random.randint(0, events.length-1);
    }
    System.out.println("");
    System.out.println("** Covid 19 disease reported in the US! Stores all over the country are closeing down. To help slow the spread, everyone exept for front-line workers are being asked to quarentine. We know that self isolating can be very difficult mentally, so make sure to take part in as many physical and social activities as you can while staying safe. You'll know you need to be doing more of these events if your happyness meter starts going down. Similarly, if you do not follow health guidlines, your health bar might go down as well. Watch out not to spend too much money on items or you might go bankrupt. If any of these sections equals 0, it's game over! That's all for today. We hope you can stay safe and happy during this bizzare, worldwide pandamic.");
    System.out.println("- The Buddy Bundle **");
    System.out.println("");
    while(player.alive == true){
      player.varient = player.getCovid();
      if(player.varient == true){
        if(player.age < 50){
          player.health -= 5;
        }
        else{
          player.health -= 6;
        }
      }
      player.homePage();
      if(player.varient == true){
        if(player.health<=0){
            System.out.println("You died of Covid. Game Over!");
            System.out.println("You survived for " + player.turn + " turns.");
            player.alive = false;
            if(player.turn >= java.lang.Integer.parseInt(highScore.trim())){
              highScore = String.valueOf(player.turn);
            }
            break;
        }
      }
      if(player.money <= 0){
        System.out.println("You lost all your money and went Bankrupt. Game Over!");
        System.out.println("You survived for " + player.turn + " turns.");
        player.alive = false;
        if(player.turn >= java.lang.Integer.parseInt(highScore.trim())){
          highScore = String.valueOf(player.turn);
        }
        break;
      }
      if(player.happy <= 0){
        System.out.println("You were too sad and commited suicide. Game Over!");
        System.out.println("You survived for " + player.turn + " turns.");
        player.alive = false;
        if(player.turn >= java.lang.Integer.parseInt(highScore.trim())){
          highScore = String.valueOf(player.turn);
        }
        break;
      }
      if(player.health <= 0){
        System.out.println("You were too unhealthy and died. Game Over!");
        System.out.println("You survived for " + player.turn + " turns.");
        player.alive = false;
        break;
      }
      System.out.println(events[r].eve + "(1)");
      System.out.println(events[r1].eve + "(2)");
      System.out.println(events[r2].eve + "(3)");
      String answer = s.nextLine();
      if(answer.equals("1")){
        events[r].reset();
        r = random.randint(0, events.length-1);
        while(r1 == r || r2 == r){
          r = random.randint(0, events.length-1);
        }
      }
      else if(answer.equals("2")){
        events[r1].reset();
        r1 = random.randint(0, events.length-1);
        while(r == r1 || r2 == r1){
          r1 = random.randint(0, events.length-1);
        }
      }
      else if(answer.equals("3")){
        events[r2].reset();
        r2 = random.randint(0, events.length-1);
        while(r == r2 || r1 == r2){
          r2 = random.randint(0, events.length-1);
        }
      }
    }
    if(player.turn > java.lang.Integer.parseInt(saveLead.get(user.trim()))){
      saveLead.remove(user);
      saveLead.put(user,String.valueOf(player.turn));
      System.out.println("New High Score!");
      try {
        lead1 = new FileWriter("leaderBoard.txt");
        size = saveLead.size();
        y = 0;
        for (String i : saveLead.keySet()) {
          y+=1;
          lead1.write(i);
          lead1.write(' ');
          lead1.write(saveLead.get(i));
          if(y!=size){
            lead1.write('\n');
          }
        }
        lead1.close();
      } catch (IOException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
      }  
    }
    s.close();
  }
}