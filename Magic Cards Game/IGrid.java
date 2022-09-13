import greenfoot.*; 
public interface IGrid 
{    
    int getSize();
    Card[][] getCardGrid();
    boolean isExpanded();
    void setExpanded(boolean b);
}
