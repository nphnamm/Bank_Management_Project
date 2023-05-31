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
import model.Bank_Account;
import model.Client;
import model.Login_Account;

public class TransferMoneyForm {
    public TransferMoneyForm() {
    }

    void openTransferMoneyForm(final JFrame frame, final Client client, final Bank_Account account) {
        final JPanel f = new JPanel();
        f.setBackground(Color.white);
        JLabel l_hcreate = new JLabel("Transfer Money");
        l_hcreate.setFont(l_hcreate.getFont().deriveFont(30.0F));
        l_hcreate.setBounds(300, 60, 300, 40);
        f.add(l_hcreate);
        JLabel l_rAccNum = new JLabel("Reciever Account Number: ");
        l_rAccNum.setBounds(200, 140, 200, 40);
        f.add(l_rAccNum);
        JLabel l_amount = new JLabel("Amount: ");
        l_amount.setBounds(200, 190, 100, 40);
        f.add(l_amount);
        final JTextField tf_rAccNum = new JTextField();
        tf_rAccNum.setBounds(400, 150, 180, 25);
        f.add(tf_rAccNum);
        final JTextField tf_amount = new JTextField();
        tf_amount.setBounds(400, 200, 180, 25);
        f.add(tf_amount);
        JButton btn_Transfer = new JButton("Transfer");
        btn_Transfer.setBackground(new Color(0, 204, 153));
        btn_Transfer.setForeground(Color.white);
        btn_Transfer.setBounds(300, 270, 180, 40);
        btn_Transfer.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\check.png"));
        f.add(btn_Transfer);
        JButton btn_mm = new JButton("Main Menu");
        btn_mm.setBackground(new Color(0, 204, 153));
        btn_mm.setForeground(Color.white);
        btn_mm.setBounds(50, 400, 100, 30);
        btn_mm.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\home.png"));
        f.add(btn_mm);
        btn_Transfer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (tf_rAccNum.getText().compareTo(account.getAccountNum()) == 0) {
                    JOptionPane.showMessageDialog(f, "You cannot enter your own account number");
                } else {
                    int r = client.transferMoney(tf_rAccNum.getText(), Integer.parseInt(tf_amount.getText()));
                    if (r == 1) {
                        JOptionPane.showMessageDialog(f, "Reciever account not found, is blocked or closed");
                    } else if (r == 2) {
                        JOptionPane.showMessageDialog(f, "You have low balance");
                    } else if (r == 3) {
                        JOptionPane.showMessageDialog(f, "Transaction successful");
                        account.updateBalance();
                        frame.remove(f);
                        frame.repaint();
                        frame.validate();
                        ClientMenuForm clientMenuForm = new ClientMenuForm();
                        clientMenuForm.openClientMenu(frame, client, account);
                    }
                }

            }
        });
        btn_mm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.remove(f);
                frame.repaint();
                frame.validate();
                ClientMenuForm clientMenuForm = new ClientMenuForm();
                clientMenuForm.openClientMenu(frame, client, account);
            }
        });
        JButton btn_sign_out = new JButton("Sign Out");
        btn_sign_out.setBackground(new Color(0, 204, 153));
        btn_sign_out.setForeground(Color.white);
        btn_sign_out.setBounds(630, 30, 130, 30);
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
