import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class task_6 extends JFrame {
    private DefaultListModel<String> listModel;
    private JList<String> taskList;
    private JTextField taskInput;
    private JButton addButton;
    private JButton deleteButton;
    
    public task_6() {
        // Set up the window
        setTitle("My To-Do List");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Create components
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        taskInput = new JTextField(20);
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        
        // Set up layout
        setLayout(new BorderLayout());
        
        // Input panel at top
        JPanel inputPanel = new JPanel();
        inputPanel.add(new JLabel("Task: "));
        inputPanel.add(taskInput);
        inputPanel.add(addButton);
        
        // Button panel at bottom
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(deleteButton);
        
        // Add components to window
        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(taskList), BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        // Add button functionality
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });
        
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteTask();
            }
        });
        
        // Add Enter key functionality
        taskInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addTask();
            }
        });
    }
    
    private void addTask() {
        String task = taskInput.getText().trim();
        if (!task.isEmpty()) {
            listModel.addElement(task);
            taskInput.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Please enter a task!");
        }
    }
    
    private void deleteTask() {
        int selectedIndex = taskList.getSelectedIndex();
        if (selectedIndex != -1) {
            listModel.remove(selectedIndex);
        } else {
            JOptionPane.showMessageDialog(this, "Please select a task to delete!");
        }
    }
    
    public static void main(String[] args) {
        // Create and show the GUI
        task_6 app = new task_6();
        app.setVisible(true);
    }
}