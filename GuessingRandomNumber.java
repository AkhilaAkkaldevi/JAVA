
import java.util.Random;
import java.util.Scanner;

public class GuessingRandomNumber{
    public static void main(String[] args) {
        final int max_no_of_attempts=10;
        int attempts=0;
        boolean play=true;
        int random_no;
        int guessed_NO;
        int total_score=0;
        System.out.println("*******Welocme to the Guessing Random Number Game*******");
        Random random=new Random();
        random_no=random.nextInt(100)+1;
        System.out.println("I have selected a number between 1 to 100 can you guess it?");
        Scanner sc=new Scanner(System.in);
        while(play){
            
            guessed_NO=sc.nextInt();
          
            if(guessed_NO==random_no){
                System.out.println("Congratulation You guessed Correctly..");
                total_score=max_no_of_attempts-attempts;
                System.out.println("Your Score is: "+total_score);
                play=false;
            }
            if(guessed_NO<random_no){
                System.out.println("Its Too Low....");
                attempts++;
            }
            if(guessed_NO>random_no){
                System.out.println("Its too High....");
                attempts++;
            }
            if(attempts==max_no_of_attempts){
                System.out.println("You missed all the chances...");
               play=false;
            }

           
        }


    }
}