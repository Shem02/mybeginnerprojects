import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ToDo{
    static class Task {
        String description;
        LocalDateTime deadline;

        Task(String description, LocalDateTime deadline) {
            this.description = description;
            this.deadline = deadline;
        }
    }

    static List<Task> currentList = new ArrayList<>();

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(150,150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Test Frame");
        frame.setVisible(true);

        int MenuItem;
        MenuItem = -1;
        while (MenuItem != 0) {
            MenuItem = Menu();
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
        System.out.println("1. Display the To-Do List");
        System.out.println("2. Add a task to the list");
        System.out.println("3. Remove a task from the list");
        System.out.println();
        System.out.println("Enter your choice: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void showList() {
        System.out.println();
        System.out.println("-----------------------");
        System.out.println("To Do List");
        System.out.println("---------------------");
        int num = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        for (Task task : currentList) {
            System.out.println(num++ + " Description: " + task.description);
            System.out.println("   Deadline: " + task.deadline.format(formatter));
        }
        System.out.println("----------------------");
    }

    public static void addItem() {
        System.out.println("Add a task");
        System.out.println("-----------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter task description: ");
        String description = scanner.nextLine();
        System.out.print("Enter task deadline (yyyy-MM-dd HH:mm): ");
        String deadlineStr = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        try {
            LocalDateTime deadline = LocalDateTime.parse(deadlineStr, formatter);
            Task task = new Task(description, deadline);
            currentList.add(task);
            System.out.println("Task added successfully.");
        } catch (Exception e) {
            System.err.println("Invalid date/time format. Please use yyyy-MM-dd HH:mm.");
        }
    }

    public static void removeItem() {
        System.out.println("Remove a task");
        System.out.println("----------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the task number to remove: ");
        int index = scanner.nextInt();

        if (index < 0 || index >= currentList.size()) {
            System.out.println("Invalid task number. Please enter a valid number.");
        } else {
            Task removedTask = currentList.remove(index);
            System.out.println("Removed task: " + removedTask.description);
        }
    }
}
