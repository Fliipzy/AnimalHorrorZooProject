package Animals;

public class Snake extends Animal 
{
    public Snake(String name, String message) 
    {
        super(name, message);
    } 
    
    public void Talk()
    {
        System.out.println(super.message);
    }   
}