/**
 * Write a description of class IRankingitem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IRankingitem  
{
    void addItem(IRankingitem c);
    void removeItem(IRankingitem c);
    void display(int x, int y);
    IRankingitem getItem(int i);
}
