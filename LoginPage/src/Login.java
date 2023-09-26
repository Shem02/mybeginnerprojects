import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame{
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JButton LOGINButton;
    private JPanel Main;
    private Label success;

    public static void main (String[] args) {
        JFrame frame = new JFrame("Login");
        frame.setContentPane(new Login().Main);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Login () {
        LOGINButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                String username = txtUsername.getText();
                String password = txtPassword.getText();
                System.out.println(username + "  " + password);

                if (username.equals("Shem") && password.equals("12345")) {
                JOptionPane.showMessageDialog(Login.this, "Login Successful");
                 }
                else {
                    JOptionPane.showMessageDialog(Login.this, "Login  not Successful");
                }

            }

        });

    }
}


