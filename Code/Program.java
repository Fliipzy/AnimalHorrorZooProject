import Animals.*;
import Services.*;

public class Program 
{
    public static void main(String[] args) 
    {
        Animal rabbit = new Rabbit("nice rabbit", "Please don't eat me!");
        Animal snake = new Snake("evil snake", "Omomomom, I'm going to eat you!!");

        Map map = new Map(9);
        GameManager gm = new GameManager(map, snake, rabbit);

        gm.StartGame();
    }
}