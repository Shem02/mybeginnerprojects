import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class ToDoList {
   static ArrayList <String> currentList = new ArrayList<String>();

    public static void main (String[] args) {
      int MenuItem;
        MenuItem = -1;
        while (MenuItem != 0) {
                  MenuItem =Menu();
                  switch (MenuItem) {
                      case 1 -> showList();
                      case 2 -> addItem();
                      case 3 -> removeItem();
                      default -> System.out.println("ENTER A VALID NUMBER");
                  }

              }
    }

    public static int Menu() {
        System.out.println();
        System.out.println("-------------------------");
        System.out.println("Main Menu");
        System.out.println("-------------------------");
        System.out.println("0. Exit the program");
        System.out.println("1. Display a new item from the list");
        System.out.println("2. Add an item from the list");
        System.out.println("3. Remove an item from the list");
        System.out.println("4. Enter task description");
        System.out.println();
        System.out.println("Enter your choice: ");
        Scanner scanner= new Scanner(System.in);
        return scanner.nextInt();
    }

    public  static void showList() {
        System.out.println();
        System.out.println("-----------------------");
        System.out.println("To Do List");
        System.out.println("---------------------");
        int num = 0;
        for (String item : currentList) {
            System.out.println(num++ + " " + item);
        }
        System.out.println("----------------------");
    }



    public  static void addItem() {
        System.out.println("Add an item");
        System.out.println("-----------------------");
        System.out.println("Enter an item");
        Scanner scanner = new Scanner(System.in);
        String item = scanner.nextLine();
        currentList.add(item);
        showList();
    }
    public static void removeItem() {
        System.out.println("Remove Item");
        System.out.println("----------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.print("What do you want to remove?");
        int index = scanner.nextInt();
        if((index-1)<0 || index>currentList.size()) {
            System.out.println("Wrong index number! Please enter in range of 1 to "+currentList.size());
        }else {
            currentList.remove(index-1);
        }
        System.out.println("----------------------");
        showList();


    }

}

