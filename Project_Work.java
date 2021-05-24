import java.util.*;
import static java.lang.System.exit;


public class Project_Work {

    static String name1;
    static String name2;

    public static void main(String args[]) throws MyException {
        Project_Work pw = new Project_Work();
        Scanner s = new Scanner(System.in);
        Board b=new Board();
        b.board();
        System.out.println("\nEnter the name of Player 1:");
        pw.name1 = s.nextLine();
        System.out.println("\nEnter the name of Player 2:");
        pw.name2 = s.nextLine();
        Player p1 = new Player();
        Player p2 = new Player();
        int c = 0;
        while (p1.pos != 100 && p2.pos != 100) {
            c++;
            p1.player(c);
            if (p1.pos == 100) {
                System.out.println("Congratulations! " + pw.name1 + ", You won!");
                break;
            }
            c++;
            p2.player(c);
            if (p2.pos == 100) {
                System.out.println("Congratulations! " + pw.name2 + ", You won!");
                break;
            }
        }
    }

}





class Board {

    void board() {
        System.out.println("Welcome to Snakes and Ladder");
        int a = 100;
        int b = 81;
        for (int i = 0; i < 10; i++) {
            int c1 = a;
            int c2 = b;
            System.out.print("\n");
            if (i % 2 == 0) {
                for (int j = 0; j < 10; j++) {
                    System.out.print(c1 + "\t");
                    c1--;
                }
                a = a - 20;
            } else {
                for (int j = 0; j < 10; j++) {
                    System.out.print(c2 + "\t");
                    c2++;
                }
                b = b - 20;
            }
        }
    }

}





class Player extends Project_Work{

    int pos=0;

    void player(int c) throws MyException {
        Dice p = new Dice();
        Scanner sc = new Scanner(System.in);
        char op;
        if (c % 2 == 1){
            System.out.println("\n"+name1+": If you wish to continue press Y else press N");
    }
        else{
            System.out.println("\n"+name2+": If you wish to continue press Y else press N");
        }
            op = sc.next().charAt(0);
            if (op == 'Y' || op == 'y') {

                int d=p.dicee();
                pos = pos + d;
                try {
                    if (pos > 100) {
                        throw new MyException();
                    }
                }
                catch(MyException e)
                {
                    pos=pos-d;
                }
                s_and_l sl=new s_and_l();
                pos = sl.sandl(pos);
                if(c%2==1)
                    System.out.println(name1+" position:" + pos);
                else
                System.out.println(name2+" position:" + pos);
            } else {
                char ch;
                System.out.println("You are on home page");
                System.out.println("Press R to restart and Q to quit");
                ch=sc.next().charAt(0);
                HomePage hp=new HomePage();
                hp.homepage(ch);
            }
    }

}





class Dice{

    public int dicee(){
        int n1,n2,n3=0;
        Random r = new Random();
        n1= r.nextInt(6) + 1;
        System.out.println("You rolled"+n1);
        if(n1==6){
            System.out.println("Roll again!");
            n2=r.nextInt(6)+1;
            System.out.println("You rolled "+n2);
            n1=n1+n2;
            if(n2==6){
                System.out.println("Roll again!");
                n3=r.nextInt(6)+1;
                System.out.println("You rolled "+n3);
                n1=n1+n3;
                if(n3==6){
                    n1=0;
                }
            }
        }
        return n1;
    }

}





class s_and_l {

    public int sandl(int pos) {

        int l1[] = {4, 13, 33, 42, 50, 62, 74};
        int l2[] = {25, 46, 49, 63, 69, 81, 92};
        int s1[] = {27, 40, 43, 54, 66, 76, 89, 99};
        int s2[] = {5, 3, 18, 31, 45, 58, 53, 41};

        for (int i = 0; i <l1.length ; i++) {
            if(pos==l1[i]) {
                System.out.println("Hey,it's a ladder!");
                pos = l2[i];
            }
        }
        for (int i = 0; i <s1.length ; i++) {
            if(pos==s1[i]) {
                System.out.println("Oops,it's a snake!");
                pos = s2[i];
            }
        }
        return pos;
    }

}





class HomePage {

    Project_Work pw=new Project_Work();

    void homepage(char ch) throws MyException{
        Scanner sc=new Scanner(System.in);
        if(ch=='R'||ch=='r'){
            String[] args={};
            pw.main(args);
        }
        else {
                System.out.println("You quit the game!");
                exit(0);
            }
    }

}





class MyException extends Exception{

    MyException(){
        System.out.println("Position exceeded 100");
    }

}













