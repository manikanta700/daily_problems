import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
public class driverCode{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.println("****GAME__START****");
        System.out.println("Enter Number of players : ");
        int n=in.nextInt();
        Queue<Player> players=new LinkedList<>();
        for(int i=0;i<n;i++){
            System.out.println("Player-"+(i+1)+" name : ");
            String name=in.next();
            Player p=new Player(name);
            players.add(p);
        }
        System.out.println("Enter Number of Dices you want to play : ");
        int numberOfDices = in.nextInt();


       SnakeLadder SandL = new SnakeLadder(players,numberOfDices);
       List<String> winList  = SandL.startGame();

       for(int i=0;i<winList.size();i++){
          System.out.println((i+1)+" place is "+winList.get(i));
        }
        
    }
    
}
