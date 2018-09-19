package Animals;

public abstract class Animal 
{
    protected String name;
    protected String message;

    public String GetName() { return name; }
    public String GetMessage() { return message; }

    public Animal(String name, String message) 
    {
        this.name = name;
        this.message = message;
    }

    public abstract void Talk();
}