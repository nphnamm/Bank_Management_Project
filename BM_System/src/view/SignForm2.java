//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Login_Account;

public class SignForm2 {
    public RemakeScreenForm gui = new RemakeScreenForm();

    public SignForm2() {
    }

    void open_Signup_form_2(final JFrame frame, final Login_Account user, final String acc_num) {
        System.out.println("Control Shifted to Signup form_2 page");
        final JPanel f = new JPanel();
        f.setBackground(Color.white);
        this.gui.remakeScreen(frame, f);
        JLabel lSignUp = new JLabel("Sign Up");
        lSignUp.setFont(lSignUp.getFont().deriveFont(30.0F));
        lSignUp.setBounds(320, 40, 300, 40);
        f.add(lSignUp);
        JLabel l_username = new JLabel("Enter Username:");
        l_username.setBounds(200, 100, 100, 90);
        f.add(l_username);
        JLabel l_pin = new JLabel("Enter Pin Code(4 character):");
        l_pin.setBounds(200, 160, 100, 90);
        f.add(l_pin);
        JLabel l_password = new JLabel("Enter Password:");
        l_password.setBounds(200, 220, 100, 90);
        f.add(l_password);
        JLabel l_password_2 = new JLabel("Confirm the password:");
        l_password_2.setBounds(200, 280, 150, 90);
        f.add(l_password_2);
        final JTextField tf_username = new JTextField();
        tf_username.setBounds(350, 130, 200, 25);
        f.add(tf_username);
        final JTextField tf_pin = new JTextField();
        tf_pin.setBounds(350, 190, 200, 25);
        f.add(tf_pin);
        final JTextField tf_password = new JTextField();
        tf_password.setBounds(350, 250, 200, 25);
        f.add(tf_password);
        final JTextField tf_password_2 = new JTextField();
        tf_password_2.setBounds(350, 310, 200, 25);
        f.add(tf_password_2);
        JButton btn_create_login_Account = new JButton("Create Login Account");
        btn_create_login_Account.setBackground(new Color(0, 204, 153));
        btn_create_login_Account.setForeground(Color.white);
        btn_create_login_Account.setBounds(300, 320, 200, 40);
        f.add(btn_create_login_Account);
        JButton btn_BACK = new JButton("BACK");
        btn_BACK.setBackground(new Color(0, 204, 153));
        btn_BACK.setForeground(Color.white);
        btn_BACK.setBounds(50, 400, 100, 40);
        f.add(btn_BACK);
        btn_BACK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.remove(f);
                frame.repaint();
                frame.validate();
                SignForm1 sf1 = new SignForm1();
                sf1.open_Signup_form_1(frame, user);
            }
        });
        btn_create_login_Account.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int signup_status = user.signup(tf_username.getText(), tf_password.getText(), tf_password_2.getText(), acc_num, tf_pin.getText());
                if (signup_status == -1) {
                    System.out.println("The 2 passwords did not match");
                    JOptionPane.showMessageDialog(f, "The entered passwords do not match");
                    frame.remove(f);
                    frame.repaint();
                    frame.validate();
                    SignForm2.this.open_Signup_form_2(frame, user, acc_num);
                } else {
                    SignForm sf;
                    if (signup_status == -2) {
                        System.out.println("Something went wrong in creating login account because the returned login id is -1");
                        JOptionPane.showMessageDialog(f, "Unfortunately the login account could not be made");
                        frame.remove(f);
                        frame.repaint();
                        frame.validate();
                        sf = new SignForm();
                        sf.openSignInForm(frame, user);
                    } else {
                        JOptionPane.showMessageDialog(f, "Your Login Account has been successfully created. Please Login to continue");
                        frame.remove(f);
                        frame.repaint();
                        frame.validate();
                        sf = new SignForm();
                        sf.openSignInForm(frame, user);
                    }
                }

            }
        });
    }
}
