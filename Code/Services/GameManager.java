package Services;

import java.util.Random;

import Animals.Animal;
import Enums.*;
import Enums.Character;

public class GameManager 
{
    private Random random = new Random();

    private Map map;
    private GameState currentGameState;

    private Animal snake;
    private Animal rabbit;

    public GameManager(Map map, Animal snake, Animal rabbit) 
    {
        this.map = map;
        this.snake = snake;
        this.rabbit = rabbit;
    }

    public void StartGame()
    {
        InitializeGameStartSettings();

        while (currentGameState.equals(GameState.RUNNING)) 
        {
            UpdateGameLogic();
        }
    }

    private void InitializeGameStartSettings()
    {
        //Change the game state to running 
        currentGameState = GameState.RUNNING;

        //Change the animal positions to the opposite sites of the map
        map.ChangeCharacterPosition(Character.RABBIT, new Coordinate(0, 0));
        map.ChangeCharacterPosition(Character.SNAKE, new Coordinate(map.GetSize(), map.GetSize()));
    }

    private void UpdateGameLogic()
    {
        //Predator changes position
        map.ChangeCharacterPosition(Character.SNAKE, map.GetRandomNeighbourCoordinate(map.GetSnakePos()));

        //Print out the position of the snake
        System.out.println(String.format("I am the Snake, I'm now standing on square %s", map.GetSnakePos().toString()));

        //Check to see if predator is in reach of the prey
        CheckDistance();

        map.ChangeCharacterPosition(Character.RABBIT, map.GetRandomNeighbourCoordinate(map.GetRabbitPos()));

        //Print out the position of the rabbit
        System.out.println(String.format("I am the rabbit, I'm now standing on square %s", map.GetRabbitPos().toString()));

        CheckDistance();   
    }


    private void CheckDistance()
    {
        if (map.GetSnakePos().GetDistanceTo(map.GetRabbitPos()) < 2) 
        {   
            BegForMercy();
        }   
    }

    private void BegForMercy()
    {
        //Rabbit begs for mercy
        rabbit.Talk();

        //Rolls a random number between 0-1. If the number is 1, the snake will eat the rabbit and the game is over!
        if (random.nextInt(2) == 1) 
        {
            snake.Talk();
            currentGameState = GameState.GAME_OVER;
        }
    }
}