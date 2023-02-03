import java.util.Random;
public class Dice {
    int numberOfDices = 1;
    public Dice(int numberOfDices){
        this.numberOfDices=numberOfDices;
    }
    public int rollDice(){
        Random r=new Random();
        int x=r.nextInt(6*numberOfDices+1);
        if(x==0){
            return 1;
        }
        return x;
    }
    
}
