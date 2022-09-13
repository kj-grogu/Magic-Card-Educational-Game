import greenfoot.*;  
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * class Senario will set up the curtains and show an animation when
 * "Start" button is clicked.
 * 
 * @author (Chen Shi) 
 * @version 1.0
 */

public class PlayWorld extends World
{
    //get worlds
    private Main menuworld = Main.getInstance();
    private TheoryWorld theoryworld = TheoryWorld.getInstance();
    private WaitingScoreWorld waitingScoreWorld = WaitingScoreWorld.getInstance();
    private BackCurtain backCurtain;
    private FrontCurtain frontCurtain;
    private Grid grid;
    private Magician magician; 
    private TimerActor timer = new TimerActor();
    private PlayerWorldButton p_btn = new PlayerWorldButton(timer);
    private GameProxy gameProxy;
    private GridDecorator deocratedGrid;
    private int counts=0;
    public PlayWorld()
    {
        super(800, 600, 1);
       // grid  = new Grid(5, this);
       // GridDecorator deocratedGrid = new GridDecorator(grid);
        //addObject(deocratedGrid, 300, 100);
        System.out.print(Player.object.toString());
        
      
        

        backCurtain = new BackCurtain(grid);
        addObject(backCurtain, 400, 300); 

        //GridProxy gridProxy = new GridProxy(deocratedGrid);
       // magician = new Magician(gridProxy/*, nextButton*/, backCurtain);
       // addObject(magician, 300, 550);
        
        //deocratedGrid.expandGrid();
        
        //addObject(magician, 550, 550);
        /*magician.fillErrorDetection();
        
        /*grid.flipRandomly();
        magician.trick();*/
        
        setPaintOrder(Message.class,ActionButton.class, FrontCurtain.class, BackCurtain.class, Grid.class);
 
        frontCurtain = new FrontCurtain();
        addObject(frontCurtain, 400, 300);  
        
        backCurtain = new BackCurtain(grid);
        addObject(backCurtain, 400, 300); 
        
      // addObject(new WorldSwitchButton("Menu", menuworld), 50, 500);
        gameProxy = new GameProxy();
    }
    
        public void setGrid(JSONObject serverGrid){
        grid = new Grid(5,this);
        try{
           
            for(int i=0;i<5;i++){
                for(int j=0;j<5;j++){
            
                    String key = "r"+i+"c"+j;
                    if(serverGrid.get(key).toString().equals("1")){
                        grid.cardGrid[i][j] = new Card(i,j);
                        grid.cardGrid[i][j].flipCard();
                        addObject(grid.cardGrid[i][j],250 /*165*/ + j * 60, 180 /*110*/ + i * 60);
                    }
                    else{
                        grid.cardGrid[i][j] = new Card(i,j);
                        addObject(grid.cardGrid[i][j], 250 /*165*/ + j * 60, 180 /*110*/ + i * 60);
                    }
                }
            }

        }
        
        catch(Exception e){
            
        }
        deocratedGrid = new GridDecorator(grid);
        addObject(deocratedGrid, 300, 100);
        magician = new Magician(deocratedGrid, backCurtain);
        addObject(magician, 300, 550);
    }
    
    public void act() 
    {
        counts ++;
        if(p_btn.getStage() =="game start"){
             if(counts < 5){
                Greenfoot.delay(100);
                System.out.print(new Integer(5-counts).toString());
                addObject(new TempMessage("Your only have a few seconds to remember these cards -- "+new Integer(5-counts).toString()),400,120);
            }
            // Greenfoot.delay(10);
            // Message msg = new Message("Your only have a few seconds to remember these cards");
            // addObject(msg,400, 120);
            // Greenfoot.delay(500);
            // removeObject(msg);
            if(counts > 5){
            addObject(p_btn, 600, 500);
            p_btn.setStage("grid expend");
            magician.operateGrid();
            addObject(timer,100,100);
           // getWorld().setPaintOrder(TimerActor.class,Card.class,ActionButton.class, FrontCurtain.class, BackCurtain.class);
            System.out.println(p_btn.getStage());
            
        }
            
        }
        if(p_btn.getStage() == "guess stage")
        {
            // setPaintOrder(Card.class,NextButton.class, FrontCurtain.class, BackCurtain.class);
            if(grid.isFlipped()&& Greenfoot.getMouseInfo()!= null &&Greenfoot.getMouseInfo().getActor() !=null && Greenfoot.getMouseInfo().getActor().getClass().equals(Card.class)){
                //System.out.println(Greenfoot.getMouseInfo().getActor().getClass().toString());
                if(Greenfoot.mouseClicked(Greenfoot.getMouseInfo().getActor())){
                   grid.selectCard((Card)Greenfoot.getMouseInfo().getActor());
                }
            }
           
        }
        if(p_btn.getStage() == "complete guess"){
            Player.object.setResult(grid.getGuessResult());
            System.out.print("result:");
            System.out.println(Player.object.getResult());
            grid.showFlippedCard();
            if(Player.object.getResult()){
                addObject(new Message("You got correct answer."),400, 120);
            }else{
                addObject(new Message("You got wrong answer."),400, 120);
            }
            gameProxy.submitScore(Player.object.getName(),new Integer(Player.object.getScore()).toString(), new Boolean(Player.object.getResult()).toString());
           Greenfoot.delay(200);
            Greenfoot.setWorld(this.waitingScoreWorld);
        }
    
    }
    
    public PlayerWorldButton getButton()
    {
        return p_btn;
    }
    
    public BackCurtain getBackCurtain()
    {
        return backCurtain;
    }
    
    public FrontCurtain getFrontCurtain()
    {
        return frontCurtain;
    }
    
    public Grid getGrid()
    {
        return grid;
    }
    
    public Magician getMagician()
    {
        return magician;
    }

}


