import java.util.Scanner;

public class JosephusTest {

    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
        Josephus game = new Josephus();
      
        System.out.print("Enter the values of M: ");
        int m = scan.nextInt();
        game.setCountNum(m);
        
        System.out.print("Enter the value of N: ");
        int n = scan.nextInt();
        scan.close();
        game.setNumOfPeople(n);
        game.addPeople();
        game.display();
        game.josephus();
        
        System.out.print("WINNER: ");
        game.showWinner();
    }

}