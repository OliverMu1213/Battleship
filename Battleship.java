import java.util.*;

public class Battleship {
    public static String [][] sea1 = new String[10][10];
    public static String [][] sea2 = new String[10][10];
    public static int first1, first2, second1, second2, third1, third2, fourth1, fourth2, fifth1, fifth2;
    public static boolean check = false;

    public static void main(String[] args){

        initialize();
        initialize2();
        random();

        System.out.println("**** Welcome to Battle Ships game ****");
        System.out.println();
        System.out.println("Right now the sea is empty");
        for(int i = 0; i<5; i++){
            board();
            ask();
        }
        checkboard();

    }
    public static void initialize(){
        for(int i = 0; i<sea1.length;i++){
            for(int a = 0; a <sea1[i].length; a++){
                sea1[i][a] = " ";
            }
        }
    }
    public static void initialize2(){
        for(int i = 0; i<sea2.length;i++){
            for(int a = 0; a <sea2[i].length; a++){
                sea2[i][a] = " ";
            }
        }
    }
    public static void board(){
        System.out.println();
        System.out.println("Your board:");
        System.out.println("   0123456789   ");
        for(int i = 0; i < 10; i++){
            for(int a = 0; a < 16; a++){
                if(a !=0 && a!= 1 && a!= 2 && a!=13 && a!=14 && a!=15){
                    System.out.print(sea1[i][a-3]);
                }else if(a == 0 ){
                    System.out.print(i);
                }else if(a == 1){
                    System.out.print(" ");
                }else if (a == 2){
                    System.out.print("|");
                }else if(a == 13){
                    System.out.print("|");
                }else if(a == 14){
                    System.out.print(" ");
                }else if(a == 15){
                    System.out.print(i);
                }

            }
            System.out.println();
        }
        System.out.println("   0123456789   ");
    }

    public static void board2(){
        System.out.println();
        System.out.println("Enemy's board:");
        System.out.println("   0123456789   ");
        for(int i = 0; i < 10; i++){
            for(int a = 0; a < 16; a++){
                if(a !=0 && a!= 1 && a!= 2 && a!=13 && a!=14 && a!=15){
                    System.out.print(sea2[i][a-3]);
                }else if(a == 0 ){
                    System.out.print(i);
                }else if(a == 1){
                    System.out.print(" ");
                }else if (a == 2){
                    System.out.print("|");
                }else if(a == 13){
                    System.out.print("|");
                }else if(a == 14){
                    System.out.print(" ");
                }else if(a == 15){
                    System.out.print(i);
                }

            }
            System.out.println();
        }
        System.out.println("   0123456789   ");
    }

    public static void ask(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter X coordinate for your ship: ");
        int x = input.nextInt();
        while(x >9 || x < 0){
            System.out.println("Please only enter number between 0 to 9");
            x = input.nextInt();
        }
        System.out.println("Enter Y coordinate for your ship: ");
        int y = input.nextInt();
        while(y > 9 || x <0){
            System.out.println("Please only enter number between 0 to 9");
            y = input.nextInt();
        }
        while(sea1[x][y]=="@"){
            System.out.println("the location is already occupied, please choose a different location");
            System.out.println("Enter X coordinate for your ship: ");
            x = input.nextInt();
            while(x >9 || x < 0){
                System.out.println("Please only enter number between 0 to 9");
                x = input.nextInt();
            }
            System.out.println("Enter Y coordinate for your ship: ");
            y = input.nextInt();
            while(y > 9 || y <0){
                System.out.println("Please only enter number between 0 to 9");
                y = input.nextInt();
            }
        }

        sea1[x][y]="@";
    }

    public static void random(){
        Random ran = new Random();
        first1 = ran.nextInt(10);
        first2 = ran.nextInt(10);

        second1 = ran.nextInt(10);
        second2 = ran.nextInt(10);
        while(second1 == first1 && first2 == second2){
            second1 = ran.nextInt(10);
            second2 = ran.nextInt(10);
        }
        third1 = ran.nextInt(10);
        third2 = ran.nextInt(10);
        while(third1 == second1 && third2 == second2 && third1 == first1 && third2 == first2){
            third1 = ran.nextInt(10);
            third2 = ran.nextInt(10);
        }
        fourth1 = ran.nextInt(10);
        fourth2 = ran.nextInt(10);
        while(fourth1 == third1 && fourth2 == third2 || fourth1 == second1 && fourth2 == second2 || fourth1 == first1 && fourth2 == first2){
            fourth1 = ran.nextInt(10);
            fourth2 = ran.nextInt(10);
        }

        fifth1 = ran.nextInt(10);
        fifth2 = ran.nextInt(10);
        while(fifth1 == fourth1 && fifth2 == fourth2 || fifth1 == third1 && fifth2 == third2 || fifth1 == second1 && fifth2 == second2|| fifth1 == first1 && fifth2 == first2){
            fifth1 = ran.nextInt(10);
            fifth2 = ran.nextInt(10);
        }


    }

    public static void checkboard(){
        int count1 = 0;
        int count2 = 0;
        Scanner check1 = new Scanner(System.in);
        Random ra = new Random();
        while(!check){
            board();
            System.out.println("Please enter the X coordinate to locate the enemy ships");
            int x = check1.nextInt();
            while(x > 9 || x <0){
                System.out.println("Please only enter number between 0 to 9 ");
                x = check1.nextInt();
            }
            System.out.println("Please enter the Y coordinate to locate the enemy ships");
            int y = check1.nextInt();
            while(y > 9 || y <0){
                System.out.println("Please only enter number between 0 to 9 ");
                y = check1.nextInt();
            }
            while(sea2[x][y]=="*" || sea2[x][y]=="o"){
                System.out.println("the location is already occupied, please choose a different location");
                System.out.println("Please enter the X coordinate to locate the enemy ships");
                x = check1.nextInt();
                while(x >9 || x < 0){
                    System.out.println("Please only enter number between 0 to 9");
                    x = check1.nextInt();
                }
                System.out.println("Please enter the Y coordinate to locate the enemy ships");
                y = check1.nextInt();
                while(y > 9 || y <0){
                    System.out.println("Please only enter number between 0 to 9");
                    y = check1.nextInt();
                }
            }

            if(x == first1 && y == first2 || x == second1 && y == second2 || x == third1 && y == third2 || x == fourth1 && y == fourth2 || x == fifth1 && y == fifth2){
                count1++;
                sea2[x][y] = "*";
            }else{
                sea2[x][y] = "o";
            }
            if(count1 == 5) {
                System.out.println("Good job, you win the game");
                check = true;
            }

            board2();
            int x2 = ra.nextInt(10);
            int y2 = ra.nextInt(10);
            while(sea1[x2][y2] == "o" || sea1[x2][y2] == "*"){
                x2 = ra.nextInt(10);
                y2 = ra.nextInt(10);
            }
            if(sea1[x2][y2] == "@"){
                sea1[x2][y2] = "*";
                count2++;
            }else{
                sea1[x2][y2] = "o";
            }

        }
        if(count2 == 5){
            System.out.println("Sorry, the computer win the game");
            check = true;
        }
    }

}
