//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package view;

import java.awt.Color;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Accountant;
import model.Bank_Account;
import model.Client;
import model.Login_Account;

public class WithDrawCashForm {
    public WithDrawCashForm() {
    }

    void openWithdrawCash(final JFrame frame, final Accountant accountant, Client client, final Bank_Account account) {
        final JPanel f = new JPanel();
        f.setBackground(Color.white);
        JLabel lWithdraw = new JLabel("Withdraw Cash");
        lWithdraw.setFont(lWithdraw.getFont().deriveFont(30.0F));
        lWithdraw.setBounds(150, 50, 250, 40);
        f.add(lWithdraw);
        JLabel lName = new JLabel("Client Name: " + client.getFName() + " " + client.getLName());
        lName.setBounds(150, 100, 150, 40);
        f.add(lName);
        JLabel lCnic = new JLabel("CNIC: " + client.getCNIC());
        lCnic.setBounds(150, 130, 150, 40);
        f.add(lCnic);
        JLabel lAccNum = new JLabel("Account Number: " + account.getAccountNum());
        lAccNum.setBounds(150, 160, 150, 40);
        f.add(lAccNum);
        JLabel lType = new JLabel("Account Type" + account.getType());
        lType.setBounds(150, 190, 150, 40);
        f.add(lType);
        JLabel lAmount = new JLabel("Enter amount:");
        lAmount.setBounds(150, 240, 150, 40);
        f.add(lAmount);
        final JTextField tfAmount = new JTextField();
        tfAmount.setBounds(150, 280, 180, 25);
        f.add(tfAmount);
        JButton btnWithdraw = new JButton("Withdraw");
        btnWithdraw.setBackground(new Color(0, 204, 153));
        btnWithdraw.setForeground(Color.white);
        btnWithdraw.setBounds(150, 320, 120, 30);
        btnWithdraw.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\withdraw.png"));
        f.add(btnWithdraw);
        btnWithdraw.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tfAmount.getText().compareTo("") != 0) {
                    if (Integer.valueOf(tfAmount.getText()) > 0) {
                        int r = account.removeAmount(Integer.valueOf(tfAmount.getText()));
                        if (r == 2) {
                            JOptionPane.showMessageDialog(f, "Not enough balance in account");
                        } else {
                            if (r == 1) {
                                JOptionPane.showMessageDialog(f, "Amount withdrawal successful");
                            } else {
                                JOptionPane.showMessageDialog(f, "Amount withdrawal failed");
                            }

                            frame.remove(f);
                            frame.repaint();
                            frame.validate();
                            AccountMenuForm accountMenuForm = new AccountMenuForm();
                            accountMenuForm.openAccountantMenu(frame, accountant);
                        }
                    } else {
                        JOptionPane.showMessageDialog(f, "Invalid Amount");
                    }
                } else {
                    JOptionPane.showMessageDialog(f, "Invalid Amount");
                }

            }
        });
        JButton btn_mm = new JButton("Main Menu");
        btn_mm.setBackground(new Color(0, 204, 153));
        btn_mm.setForeground(Color.white);
        btn_mm.setBounds(50, 400, 120, 30);
        btn_mm.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\home.png"));
        f.add(btn_mm);
        btn_mm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.remove(f);
                frame.repaint();
                frame.validate();
                AccountMenuForm accountMenuForm = new AccountMenuForm();
                accountMenuForm.openAccountantMenu(frame, accountant);
            }
        });
        JButton btn_sign_out = new JButton("Sign Out");
        btn_sign_out.setBackground(new Color(0, 204, 153));
        btn_sign_out.setForeground(Color.white);
        btn_sign_out.setBounds(650, 30, 130, 30);
        btn_sign_out.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\logout.png"));
        f.add(btn_sign_out);
        btn_sign_out.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.remove(f);
                frame.repaint();
                frame.validate();
                Login_Account user = new Login_Account();
                SignForm sf = new SignForm();
                sf.openSignInForm(frame, user);
            }
        });
        f.setLayout((LayoutManager)null);
        frame.setContentPane(f);
        frame.setVisible(true);
    }
}
