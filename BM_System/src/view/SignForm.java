//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package view;

import controller.DB_Handler;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import model.Accountant;
import model.Bank_Account;
import model.Client;
import model.Login_Account;
import model.Manager;

public class SignForm extends JFrame {
    public RemakeScreenForm gui = new RemakeScreenForm();

    public SignForm() {
    }

    public void openSignInForm(final JFrame frame, final Login_Account user) {
        final JPanel f = new JPanel();
        f.setBackground(Color.white);
        JLabel imgLabel = new JLabel(new ImageIcon(System.getProperty("user.dir") + "\\src\\image\\main-image.jpg"));
        imgLabel.setBounds(20, 24, 450, 400);
        f.add(imgLabel);
        JLabel imgSignUp = new JLabel("");
        imgSignUp.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\user.png"));
        imgSignUp.setBounds(500, 30, 200, 80);
        f.add(imgSignUp);
        JLabel l_hSignIn = new JLabel("Sign In");
        l_hSignIn.setFont(l_hSignIn.getFont().deriveFont(28.0F));
        l_hSignIn.setBounds(580, 50, 100, 40);
        f.add(l_hSignIn);
        JLabel l_UserName = new JLabel("User Name");
        l_UserName.setBounds(500, 120, 100, 40);
        f.add(l_UserName);
        JLabel l_Password = new JLabel("Password");
        l_Password.setBounds(500, 200, 100, 40);
        f.add(l_Password);
        JLabel l_Signup = new JLabel("Dont have an account?");
        l_Signup.setBounds(500, 380, 150, 40);
        f.add(l_Signup);
        final JTextField tf_UserName = new JTextField();
        tf_UserName.setBounds(500, 170, 180, 25);
        f.add(tf_UserName);
        final JPasswordField tf_Password = new JPasswordField();
        tf_Password.setBounds(500, 250, 180, 25);
        f.add(tf_Password);
        JButton btn_SignIn = new JButton("Sign In");
        btn_SignIn.setFont(btn_SignIn.getFont().deriveFont(18.0F));
        btn_SignIn.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\log-in.png"));
        btn_SignIn.setBackground(new Color(0, 204, 153));
        btn_SignIn.setForeground(Color.white);
        btn_SignIn.setBounds(550, 300, 130, 40);
        f.add(btn_SignIn);
        JButton btn_SignUp = new JButton("Sign Up");
        btn_SignUp.setFont(btn_SignUp.getFont().deriveFont(18.0F));
        btn_SignUp.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\sign-up.png"));
        btn_SignUp.setBackground(new Color(0, 204, 153));
        btn_SignUp.setForeground(Color.white);
        btn_SignUp.setBounds(650, 380, 126, 40);
        f.add(btn_SignUp);
        btn_SignUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SignForm1 sg1 = new SignForm1();
                sg1.open_Signup_form_1(frame, user);
            }
        });
        btn_SignIn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                DB_Handler db = new DB_Handler();
                Login_Account user = db.signIn(tf_UserName.getText(), tf_Password.getText());
                if (user.getLoginId().compareTo("") == 0) {
                    JOptionPane.showMessageDialog(f, "Wrong username or password");
                } else {
                    System.out.println("Login type=" + user.getType());
                    if (user.getType().compareTo("Client") == 0) {
                        Client client = db.getClient(user.getLoginId());
                        Bank_Account account = db.getAccount(user.getLoginId());
                        if (Integer.valueOf(account.getStatus()) == 0) {
                            JOptionPane.showMessageDialog(f, "No active account found with these credentials");
                        } else if (Integer.valueOf(account.getStatus()) == 1) {
                            frame.remove(f);
                            frame.repaint();
                            frame.validate();
                            ClientMenuForm clientform = new ClientMenuForm();
                            clientform.openClientMenu(frame, client, account);
                        } else if (Integer.valueOf(account.getStatus()) == 2) {
                            JOptionPane.showMessageDialog(f, "This account is blocked so you cannot sign in");
                        } else {
                            JOptionPane.showMessageDialog(f, "Sign In failed");
                        }
                    } else if (user.getType().compareTo("Manager") == 0) {
                        Manager manager = new Manager(user.getName());
                        frame.remove(f);
                        frame.repaint();
                        frame.validate();
                        ManagerMenuForm manage = new ManagerMenuForm();
                        manage.openManagerMenu(frame, manager);
                    } else if (user.getType().compareTo("Accountant") == 0) {
                        Accountant accountant = new Accountant(user.getName());
                        frame.remove(f);
                        frame.repaint();
                        frame.validate();
                        AccountMenuForm accoutant = new AccountMenuForm();
                        accoutant.openAccountantMenu(frame, accountant);
                    }
                }

            }
        });
        this.gui.remakeScreen(frame, f);
    }
}
