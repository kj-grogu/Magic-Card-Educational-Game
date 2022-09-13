public class Player  
{
    // instance variables - replace the example below with your own
    private String name;
    private int score;
    private boolean result;
    public static Player object = null;
    
    public Player(String name)
    {
        this.name = name;
        System.out.print(name);
        object = this;
        new GameProxy().addPlayer(this.name);
       System.out.println(Player.object.toString());
    }
    public void setScore(int score){
        this.score = score;
    }
    public String getName(){
        return this.name;
    }
    public int getScore(){
        return this.score;
    }
    public Player getPlayer(){
        return object;
    }
    public void setResult(boolean result){
        this.result = result;
    }
    public boolean getResult(){
        return this.result;
    }
}
