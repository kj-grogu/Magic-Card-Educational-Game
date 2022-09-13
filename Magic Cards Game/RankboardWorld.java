import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.TreeMap;
import java.util.Map;

/**
 * Write a description of class RankboardWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RankboardWorld extends World
{
    private static RankboardWorld rbworld = null;
    private String rankBoardServerUrl;
   // private TreeMap<Integer, String> rankBoard;
    private IRankingitem board = new RankingItemRoot();
    /**
     * Constructor for objects of class RankboardWorld.
     * 
     */
    public RankboardWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1); 
        setBackground(new GreenfootImage("background5.jpg"));
        rbworld = this;
        addObject(new WorldSwitchButton("Menu", Main.getInstance()).withSize(130,55), 200, 500);
        addObject(new WorldSwitchButton("Theory",TheoryWorld.getInstance()).withSize(130,55),400,500);
//        addObject(new WorldSwitchButton("Play", new PlayWorld()).withSize(130,55),600,500);
        //showText("This will be Rankboard", 200, 100);
        rankBoardServerUrl = "http://some_valid_aws_url.com";
        //rankBoard = new TreeMap<Integer, String>();
        fetchRankerBoard();
        displayRankBoard();
        Player.object = null;
    }
    
    public static RankboardWorld getInstance(){
        if( rbworld == null)
            new RankboardWorld();
        return rbworld;
    }
    
    public void fetchRankerBoard()
    {
        
           // board.addItem(new RankingItemLeaf(1,"Carlos","1000"));
            String result = new GameProxy().getScores();
            System.out.println(result);
            //"rs - 11423 - You Lost...  |  rs3 - 23305 - Winner!!"
            String[] userRecords = result.split(";");
            if(userRecords.length > 0){
                for(String userRecord: userRecords){
                    System.out.println(userRecord);
                    String[] items = userRecord.split("-");
                    if(items.length > 1){
                         System.out.println(items.length);
                         board.addItem(new RankingItemLeaf(items[0],items[1],items[2]));
                    }
                }
            }
            

    }
    
    public void displayRankBoard()
    {
        // //showText("This will be Rankboard", 200, 100);
        // int i=0;
        
        // showText("Player - Score", 200, 70);
        // for (Map.Entry<Integer, String> rank: rankBoard.entrySet()) 
        // {    
            // String name = rank.getValue();
            // Integer score = rank.getKey();
            // showText(name+" - "+score, 200, 100 + i*20);
            // i++;
        // }
        board.display(450, 300);
    }
}
