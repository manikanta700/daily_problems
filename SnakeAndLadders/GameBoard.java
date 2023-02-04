import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;

public class GameBoard extends Jumpper{
    Queue<Player> players;
    List<String> winList=new ArrayList<>();
    Dice dice;
     GameBoard(Queue<Player> players,Dice dice){
         this.players=players;
         this.dice=dice;
    }
    public List<String> startGame(){
        while(players.size()>1){
        Player playBoy=players.poll();
        int val=dice.rollDice();
        System.out.println(playBoy.getName()+" got "+val);
        int newPosition=playBoy.getPosition()+val;
        newPosition=jump(newPosition);
        if(newPosition==100){
            System.out.println(playBoy.getName()+" won the game \n ****\n ****");
            winList.add(playBoy.getName());
            }
       else if(newPosition>100){
            newPosition=newPosition-val;
            players.offer(playBoy);
            }
       else{
            playBoy.setPosition(newPosition);
            System.out.println(playBoy.getName()+" current position is : "+newPosition);
            players.offer(playBoy);
            }

    }
    
    return winList;
}
}
