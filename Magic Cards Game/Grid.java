import greenfoot.*;  
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class Grid extends Actor implements IGrid
{
    protected int size;
    public Card[][] cardGrid;
    protected boolean expanded;    
    protected World world;
    protected boolean flipped;
    private Card flippedCard;
    private Card guessCard;
    public Grid(int sz, World world)
    {
        this.size = sz + 1;
        this.cardGrid = new Card[this.size][this.size];
        expanded = false;
        flipped = false;
        this.world = world;
        
        System.out.println("   size "+size);
        for(int row = 0;row < size - 1; row++) {
            for(int col= 0; col< size - 1; col++) {
               // this.cardGrid[row][col] = new Card(row,col);
               // world.addObject(this.cardGrid[row][col], 250 /*165*/ + col * 60, 180 /*110*/ + row * 60);
            }
        }
    }

    public boolean isExpanded() {
        return  this.expanded;
    }

    public void setExpanded(boolean flag) {
        this.expanded  = flag;
    }

    public int getSize() {
        return this.size;
    }

    public void flipRandomly() {
        if(!flipped){
            double d = Math.random() * 10;
            int row = ((int)(Math.random() * 10)) % (size - 2 );
            int column = ((int)(Math.random()*10)) % (size - 2 );
           
            System.out.println("(size-1)  " + (size-1));
            System.out.println("Flipping  " + row + "  " + column);
            cardGrid[row][column].flipCard();
            flippedCard = cardGrid[row][column];
            System.out.println("is flipped " + cardGrid[row][column].isFlipped());
            flipped = true;
        }
    }
    public boolean isFlipped(){
        return flipped;
    }
    public Card[][] getCardGrid() 
    {
        System.out.println("getting orignial cgrid"); 
        return cardGrid;
    }    
    public void selectCard(Card card){
        if(guessCard !=null){
            guessCard.unselectCard();
        }
        guessCard = card;
        guessCard.selectCard();
    }
    public boolean getGuessResult(){
        return guessCard.equals(flippedCard);
    }
    public void showFlippedCard(){
        if(flippedCard!=null){
            flippedCard.circleit();
        }
    }
}