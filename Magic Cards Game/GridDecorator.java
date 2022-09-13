import greenfoot.*;  
import java.util.List;

public class GridDecorator extends AbstractGridDecorator
{
    Card [][] decoratedCardGrid;
    GridDecorator(IGrid g)
    {
        super(g);
    }
    
     public Card[][] getCardGrid() 
    {
        System.out.println("getting decorated grid ");
        return decoratedCardGrid;
    } 
    
    public void expandGrid() {
        if(!expanded) { //This Method adds a row and a column to the grid.
            System.out.println("inside Decorator expanded "+expanded );
            World world  = getWorld();
            System.out.println("to acess world obj... "+world.toString());
            List<Actor> actors = world.getObjects(Actor.class);
            
            int size = getSize();
            Greenfoot.delay(100);
            Card[][] cardGrid = this.grid.getCardGrid();
            System.out.println("for about to start");            
            for(Actor actor : actors) {
                if(actor instanceof GridDecorator) {
                    
                 System.out.println("EXPANDINGGGGGGGGGGG");
                    // Adding Extra col at every row  
                for(int row = 0; row < size - 1; row++) {
                        Card card = new Card();
                        cardGrid[row][size-1] = card;
                        cardGrid[row][size-1].updateExtraCard();
                        world.addObject(cardGrid[row][size - 1], 250 + (size - 1) * 60, 180 +   row * 60);
                        //world.addObject(cardGrid[y][size - 1], 165 + y * 60, 110 + (size - 1) * 60);
                        Greenfoot.delay(20);
                    }
                
                 for(int col = 0; col < size; col++) {
                        Card card = new Card();
                        cardGrid[size-1][col]= card;
                        cardGrid[size-1][col].updateExtraCard();
                        world.addObject(cardGrid[size - 1][col],  250  + col * 60, 180 + (size - 1)  * 60);
//                        world.addObject(cardGrid[col][size - 1], 165 + col * 60, 110 + (size - 1) * 60);
                        Greenfoot.delay(20);
                   }
               }
            }
            System.out.println(" assigning decorated herer ");
            decoratedCardGrid = cardGrid;
            System.out.println(" ROW"+decoratedCardGrid.length);
            System.out.println(" COL"+decoratedCardGrid[0].length);
        }  
    }
}