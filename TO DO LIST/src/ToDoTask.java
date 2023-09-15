import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ToDoTask {
    static class Task {
        String description;
        LocalDateTime deadline;

        Task(String description, LocalDateTime deadline) {
            this.description = description;
            this.deadline = deadline;
        }
    }

    static List<Task> currentList = new ArrayList<>();
    static JFrame frame;
    static DefaultListModel<String> listModel;
    static JList<String> taskList;

    public static void main(String[] args) {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("ToDo List");
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        panel.add(new JScrollPane(taskList), BorderLayout.CENTER);

        JButton addButton = new JButton("Add Task");
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addItem();
            }
        });

        JButton removeButton = new JButton("Remove Task");
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeItem();
            }
        });

        panel.add(addButton, BorderLayout.WEST);
        panel.add(removeButton, BorderLayout.EAST);

        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public static void addItem() {
        JFrame addTaskFrame = new JFrame("Add Task");
        addTaskFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        addTaskFrame.setSize(300, 150);
        addTaskFrame.setLayout(new GridLayout(3, 1));

        JTextField descriptionField = new JTextField();
        JTextField deadlineField = new JTextField();

        JButton addButton = new JButton("Add");

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String description = descriptionField.getText();
                String deadlineStr = deadlineField.getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

                try {
                    LocalDateTime deadline = LocalDateTime.parse(deadlineStr, formatter);
                    Task task = new Task(description, deadline);
                    currentList.add(task);
                    listModel.addElement("Description: " + task.description + "   Deadline: " + task.deadline.format(formatter));
                    addTaskFrame.dispose();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(addTaskFrame, "Invalid date/time format. Please use yyyy-MM-dd HH:mm.");
                }
            }
        });

        addTaskFrame.add(new JLabel("Task Description:"));
        addTaskFrame.add(descriptionField);
        addTaskFrame.add(new JLabel("Task Deadline (yyyy-MM-dd HH:mm):"));
        addTaskFrame.add(deadlineField);
        addTaskFrame.add(addButton);

        addTaskFrame.setVisible(true);
    }

    public static void removeItem() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            currentList.remove(selectedIndex);
            listModel.remove(selectedIndex);
        }
    }
}
