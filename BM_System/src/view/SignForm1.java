//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Login_Account;

public class SignForm1 extends JFrame {
    public RemakeScreenForm gui = new RemakeScreenForm();
    ManagerMenuForm managerMenuForm = new ManagerMenuForm();

    public SignForm1() {
    }

    void open_Signup_form_1(final JFrame frame, final Login_Account user) {
        System.out.println("Control Shifted to Signup form_1 page");
        final JPanel f = new JPanel();
        f.setBackground(Color.white);
        this.gui.remakeScreen(frame, f);
        JLabel lSignUp = new JLabel("Sign Up");
        lSignUp.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\sign-up-1.png"));
        lSignUp.setFont(lSignUp.getFont().deriveFont(30.0F));
        lSignUp.setBounds(320, 40, 300, 40);
        f.add(lSignUp);
        JLabel l_AccountNo = new JLabel("Enter Account#:");
        l_AccountNo.setBounds(200, 110, 100, 90);
        f.add(l_AccountNo);
        JLabel l_CNIC = new JLabel("Enter the CNIC:");
        l_CNIC.setBounds(200, 180, 100, 90);
        f.add(l_CNIC);
        final JTextField tf_AccountNo = new JTextField();
        tf_AccountNo.setBounds(350, 140, 200, 25);
        f.add(tf_AccountNo);
        final JTextField tf_CNIC = new JTextField();
        tf_CNIC.setBounds(350, 210, 200, 25);
        f.add(tf_CNIC);
        JButton btn_Verify_Account = new JButton("Verify Account");
        btn_Verify_Account.setBackground(new Color(0, 204, 153));
        btn_Verify_Account.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\verify.png"));
        btn_Verify_Account.setForeground(Color.white);
        btn_Verify_Account.setBounds(290, 280, 150, 40);
        f.add(btn_Verify_Account);
        JButton btn_BACK = new JButton("BACK");
        btn_BACK.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\back.png"));
        btn_BACK.setBackground(new Color(0, 204, 153));
        btn_BACK.setForeground(Color.white);
        btn_BACK.setBounds(50, 400, 100, 40);
        f.add(btn_BACK);
        btn_BACK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.remove(f);
                frame.repaint();
                frame.validate();
                SignForm sf = new SignForm();
                sf.openSignInForm(frame, user);
            }
        });
        btn_Verify_Account.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int verify_status = user.verify_account(tf_AccountNo.getText(), tf_CNIC.getText());
                System.out.println("Verify Status Value: " + verify_status);
                SignForm sf;
                if (verify_status == -1) {
                    JOptionPane.showMessageDialog(f, "There is no account present with this detail");
                    frame.remove(f);
                    frame.repaint();
                    frame.validate();
                    sf = new SignForm();
                    sf.openSignInForm(frame, user);
                } else if (verify_status == -2) {
                    JOptionPane.showMessageDialog(f, "A login account is already made for this account");
                    System.out.println("The login account cannot be created as there is already a login account associated with this account");
                    frame.remove(f);
                    frame.repaint();
                    frame.validate();
                    sf = new SignForm();
                    sf.openSignInForm(frame, user);
                } else if (verify_status == -3) {
                    SignForm2 sf2 = new SignForm2();
                    sf2.open_Signup_form_2(frame, user, tf_AccountNo.getText());
                } else {
                    JOptionPane.showMessageDialog(f, "No account found with this CNIC");
                    System.out.println("The CNIC did not match with any client");
                    frame.remove(f);
                    frame.repaint();
                    frame.validate();
                    sf = new SignForm();
                    sf.openSignInForm(frame, user);
                }

            }
        });
    }
}
