import greenfoot.*;

public class AbstractGridDecorator  extends Actor implements IGrid
{
    IGrid grid;
    protected boolean expanded;    
    
    AbstractGridDecorator(IGrid g)
    {
        this.grid = g;
    }
    
    public int getSize() 
    {
        return grid.getSize();
    } 
    
    public Card[][] getCardGrid() 
    {
        return grid.getCardGrid();
    } 
    
    public void setExpanded(boolean flag) 
    {
        this.grid.setExpanded(flag);
    }
    
    public boolean isExpanded()
    {
        return this.grid.isExpanded();
    }
}
