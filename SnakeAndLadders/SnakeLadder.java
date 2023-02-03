import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
public class SnakeLadder{
    GameBoard gb;

    public SnakeLadder(Queue players,int numberOfDices){
        Dice dice =new Dice(numberOfDices);
        this.gb=new GameBoard(players, dice);
    }
    public List<String> startGame(){

        return gb.startGame();

    }
    
}
