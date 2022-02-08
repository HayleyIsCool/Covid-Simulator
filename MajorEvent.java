import java.util.*;
class MajorEvent {
  public void startEvent(Characters player){
    Scanner s = new Scanner(System.in);
    int r = random.randint(0,5);
    if(r == 0){
      System.out.println("You pass someone who is not wearing their mask indoors. Do you...");
      System.out.println("Ignore and walk past(1)");
      System.out.println("Yell at them(2)");
      System.out.println("Give them a high five and ask to hang out(3)");
      int answer = s.nextInt();
      if(answer == 1){
        player.health += 0;
        player.happy += 0;
        player.covid += 5;
      }
      else if(answer == 2){
        player.health += 2;
        player.happy += -3;
        player.covid += -5;
      }
      else{
        player.health += -3;
        player.happy += 3;
        player.covid += 5;
      }
    }
    s.close();
  }
}