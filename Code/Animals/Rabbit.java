package Animals;

public class Rabbit extends Animal 
{
    public Rabbit(String name, String message) 
    {
        super(name, message);
    }

    public void Talk()
    {
        System.out.println(super.message);
    }
}