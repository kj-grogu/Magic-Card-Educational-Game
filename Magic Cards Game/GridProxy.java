import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GridProxy extends Actor
{
    GridDecorator gridDeco;
    
    GridProxy(GridDecorator gd)
    {
        gridDeco = gd;
    }
    
    public boolean isExpanded()
    {
        return gridDeco.isExpanded();
    
    }
    
    public void expandGrid()
    {
        System.out.println("in expand grid of Proxy");
        gridDeco.expandGrid();
    }
    
    void setExpanded(boolean flag) 
    {
        gridDeco.setExpanded(flag);
    }
    
    public int getSize() {
        return gridDeco.getSize();
    }

    public Card[][] getCardGrid()
    {
        return gridDeco.getCardGrid();
    }
    
}
