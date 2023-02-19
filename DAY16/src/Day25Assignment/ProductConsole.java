package Day25Assignment;

import java.util.Scanner;

public class ProductConsole {
    private Scanner sc;
    public ProductConsole(){
        this.sc = new Scanner(System.in);
    }
    private int menu(){
        System.out.println("Product management demo version by Ceceg");
        System.out.println("-----------------------------------------");
        System.out.println("1. Add      2. Update    3. Delete     4. Exit");
        int choice = readInt(1, 3);
        return choice;
        }
        private int readInt(int min, int max) {
            int choice;
            while (true) {
                try {
                    choice = Integer.parseInt(sc.next());
                    if (choice >= 1 && choice <= 3) {
                        break;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
        } return choice;
    }
}

