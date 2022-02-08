class Characters {
  public String firstName = "";
  public String lastName = "";
  public int age;
  public int health;
  public int turn = 0;
  public int happy;
  public int money;
  public boolean varient;
  public int vaccine;
  public int covid = 30;
  public boolean alive = true;
  public Characters(String f, String e, int a,int h1,int h2, int m, int vac, boolean var){
    firstName = f;
    lastName = e;
    vaccine = vac;
    varient = var;
    health = h1;
    happy = h2;
    money = m;
    age = a;
  }
  public boolean getCovid(){
    int ran = random.randint(1,100);
    if(ran<=covid){
      return true;
    }
    else{
      return false;
    }
  }
  public void homePage(){
    System.out.println("");
    turn += 1;
    System.out.println("Turn: " + String.valueOf(turn));
    if(covid > 100){
      covid = 100;
    }
    if(covid < 0){
      covid = 0;
    }
    if(vaccine > 3){
      vaccine = 3;
    }
    if(health>10){
      health = 10;
    }
    if(happy>10){
      happy = 10;
    }
    //fix
    System.out.println("-------------------------");
    System.out.println(firstName + " " + lastName);
    if(varient==true){
      System.out.println(Colors.ANSI_RED + "Sick with Covid 19" + Colors.ANSI_RESET);
    }
    else{
      System.out.println("Not Sick");
    }
    System.out.println("Age: " + String.valueOf(age));
    if(money<50){
      System.out.println(Colors.ANSI_GREEN + "Money: $" + String.valueOf(money) + Colors.ANSI_RESET);
    }
    else{
      System.out.println("Money: $" + String.valueOf(money));
    }
    if(health<5){
      System.out.println(Colors.ANSI_PURPLE + "Health: " + String.valueOf(health) + "/10" + Colors.ANSI_RESET);
    }
    else{
      System.out.println("Health: " + String.valueOf(health) + "/10");
    }
    if(happy<5){
       System.out.println(Colors.ANSI_BLUE + "Happyness: " + String.valueOf(happy) + "/10" + Colors.ANSI_RESET);
    }
    else{
       System.out.println("Happyness: " + String.valueOf(happy) + "/10");
    }
    System.out.println("Chance of Covid: " + String.valueOf(covid) + "%");
    System.out.println("-------------------------");
  }
}