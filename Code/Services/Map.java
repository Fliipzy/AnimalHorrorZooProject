package Services;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Enums.Character;

public class Map 
{
     private Random random = new Random();

     private int size;
     public int GetSize() {return size;}

     private Coordinate rabbitPos;
     private Coordinate snakePos;

     public Coordinate GetRabbitPos() { return rabbitPos; }
     public Coordinate GetSnakePos() { return snakePos; }
    
     public Map(int size) 
     {
        this.size = size;
     }

     public void ChangeCharacterPosition(Character animal, Coordinate newPos)
     {
         switch (animal) {
             case RABBIT:
                    rabbitPos = newPos;
                 break;
         
             case SNAKE:
                    snakePos = newPos;
                 break;
         }
     }

     public Coordinate GetRandomNeighbourCoordinate(Coordinate currentPos)
     {
        Coordinate newPos = new Coordinate(0, 0);

        int currX = currentPos.GetX();
        int currY = currentPos.GetY();

		ArrayList<Integer> availableMoves = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5,6,7));

        while (true) 
        {
            int index = random.nextInt(availableMoves.size());
            int choice = availableMoves.get(index);

            switch (choice)
            {
                //Right
                case 0:
                    if (isValidMove(new Coordinate(currX+1, currY))) {
                        return new Coordinate(currX+1, currY);
                    } 
                break;

                //Left
                case 1:
                    if (isValidMove(new Coordinate(currX-1, currY))) {
                        return new Coordinate(currX-1, currY);    
                    } 
                break;
                //Up
                case 2:
                    if (isValidMove(new Coordinate(currX, currY+1))) {
                        return new Coordinate(currX, currY+1);    
                    } 
                break;

                //Down
                case 3:
                    if (isValidMove(new Coordinate(currX, currY-1))) {
                        return new Coordinate(currX, currY-1);      
                    } 
                break;

                //UpperRight
                case 4:
                    if (isValidMove(new Coordinate(currX+1, currY+1))) {
                        return new Coordinate(currX+1, currY+1);      
                    } 
                break;

                //UpperLeft
                case 5:
                    if (isValidMove(new Coordinate(currX-1, currY+1))) {
                        return new Coordinate(currX-1, currY+1);     
                    } 
                break;

                //LowerRight
                case 6:
                    if (isValidMove(new Coordinate(currX+1, currY-1))) {
                        return new Coordinate(currX+1, currY-1);      
                    } 
                break;

                //LowerLeft
                case 7:
                    if (isValidMove(new Coordinate(currX-1, currY-1))) {
                        return new Coordinate(currX-1, currY-1);       
                    } 
                break;

            }

            availableMoves.remove(index);
        }
     }

     private boolean isValidMove(Coordinate pos)
     {
        int x = pos.GetX();
        int y = pos.GetY();

        if (x >= 0 && x <= size && y >= 0 && y <= size) 
        {
            return true;
        }
        return false;
     }
}