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

public class SearchForm {
    public SearchForm() {
    }

    void searchForm(final JFrame frame, final Accountant accountant, final int case_) {
        final JPanel f = new JPanel();
        f.setBackground(Color.white);
        JLabel lheading = new JLabel("Deposit Cash");
        lheading.setFont(lheading.getFont().deriveFont(30.0F));
        lheading.setBounds(150, 50, 250, 40);
        f.add(lheading);
        if (case_ == 2) {
            lheading.setText("Withdraw Cash");
        } else if (case_ == 3) {
            lheading.setText("E-Statement");
        }

        JLabel lAccNum = new JLabel("Enter account number:");
        lAccNum.setBounds(150, 100, 150, 40);
        f.add(lAccNum);
        final JTextField tfAccNum = new JTextField();
        tfAccNum.setBounds(150, 140, 180, 25);
        f.add(tfAccNum);
        JLabel lCnic = new JLabel("Enter CNIC number:");
        lCnic.setBounds(150, 180, 150, 40);
        f.add(lCnic);
        final JTextField tfCnic = new JTextField();
        tfCnic.setBounds(150, 220, 180, 25);
        f.add(tfCnic);
        JButton btnSearch = new JButton("Search");
        btnSearch.setBackground(new Color(0, 204, 153));
        btnSearch.setForeground(Color.white);
        btnSearch.setBounds(150, 270, 110, 40);
        btnSearch.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\search.png"));
        f.add(btnSearch);
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Bank_Account account = accountant.searchAccount1(tfAccNum.getText(), tfCnic.getText());
                Client client = accountant.searchClient1(tfAccNum.getText(), tfCnic.getText());
                if (account.getAccountNum().compareTo("") != 0 && client.getCNIC().compareTo("") != 0) {
                    if (Integer.valueOf(account.getStatus()) == 0) {
                        JOptionPane.showMessageDialog(f, "Account is closed");
                    } else if (Integer.valueOf(account.getStatus()) == 2) {
                        JOptionPane.showMessageDialog(f, "Account is blocked");
                    } else {
                        frame.remove(f);
                        frame.repaint();
                        frame.validate();
                        if (case_ == 1) {
                            DepositCashForm depositCashForm = new DepositCashForm();
                            depositCashForm.openDepositCash(frame, accountant, client, account);
                        } else if (case_ == 2) {
                            WithDrawCashForm withDrawCashForm = new WithDrawCashForm();
                            withDrawCashForm.openWithdrawCash(frame, accountant, client, account);
                        } else if (case_ == 3) {
                            EstatementForm estatementForm = new EstatementForm();
                            estatementForm.openEstatement(frame, accountant, client, account);
                        }
                    }
                } else {
                    if (account.getAccountNum().compareTo("") == 0) {
                        JOptionPane.showMessageDialog(f, "Account not found");
                    } else if (client.getCNIC().compareTo("") == 0) {
                        JOptionPane.showMessageDialog(f, "Client not found");
                    }

                    account = null;
                    client = null;
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
                AccountMenuForm accountMenu = new AccountMenuForm();
                accountMenu.openAccountantMenu(frame, accountant);
            }
        });
        JButton btn_sign_out = new JButton("Sign Out");
        btn_sign_out.setBackground(new Color(0, 204, 153));
        btn_sign_out.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\logout.png"));
        btn_sign_out.setForeground(Color.white);
        btn_sign_out.setBounds(650, 30, 120, 30);
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
