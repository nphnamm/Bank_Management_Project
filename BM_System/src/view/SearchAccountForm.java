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
import model.Manager;

public class SearchAccountForm {
    public SearchAccountForm() {
    }

    void openSearchAccount(final JFrame frame, final Manager manager) {
        final JPanel f = new JPanel();
        f.setBackground(Color.white);
        JLabel lSearch = new JLabel("Search Account");
        lSearch.setFont(lSearch.getFont().deriveFont(30.0F));
        lSearch.setBounds(150, 50, 250, 40);
        f.add(lSearch);
        JLabel lAccNum = new JLabel("Enter account number:");
        lAccNum.setBounds(150, 100, 150, 40);
        f.add(lAccNum);
        final JTextField tfAccNum = new JTextField();
        tfAccNum.setBounds(150, 140, 180, 25);
        f.add(tfAccNum);
        final JLabel lCName = new JLabel("Name: ");
        lCName.setBounds(150, 170, 250, 40);
        lCName.setVisible(false);
        f.add(lCName);
        final JLabel lCCNIC = new JLabel("CNIC: ");
        lCCNIC.setBounds(150, 200, 250, 40);
        lCCNIC.setVisible(false);
        f.add(lCCNIC);
        final JLabel lCAccNum = new JLabel("Account No: ");
        lCAccNum.setBounds(150, 230, 250, 40);
        lCAccNum.setVisible(false);
        f.add(lCAccNum);
        final JLabel lCAccType = new JLabel("Account Type: ");
        lCAccType.setBounds(150, 260, 250, 40);
        lCAccType.setVisible(false);
        f.add(lCAccType);
        final JLabel lCAccBalance = new JLabel("Balance: ");
        lCAccBalance.setBounds(150, 290, 250, 40);
        lCAccBalance.setVisible(false);
        f.add(lCAccBalance);
        final JLabel lCAccStatus = new JLabel("Status: ");
        lCAccStatus.setBounds(150, 320, 250, 40);
        lCAccStatus.setVisible(false);
        f.add(lCAccStatus);
        final JLabel lCAccODate = new JLabel("Opening Date: ");
        lCAccODate.setBounds(150, 350, 250, 40);
        lCAccODate.setVisible(false);
        f.add(lCAccODate);
        JButton btnSearch = new JButton("Search");
        btnSearch.setBackground(new Color(0, 204, 153));
        btnSearch.setForeground(Color.white);
        btnSearch.setBounds(350, 130, 110, 40);
        btnSearch.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\search-small.png"));
        f.add(btnSearch);
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Bank_Account account = manager.getAccountInfo(tfAccNum.getText());
                Client client = manager.getClientInfo(tfAccNum.getText());
                if (account.getAccountNum().compareTo("") != 0 && client.getCNIC().compareTo("") != 0) {
                    lCName.setText("Name:  " + client.getFName() + " " + client.getLName());
                    lCCNIC.setText("CNIC:  " + client.getCNIC());
                    lCAccNum.setText("Account No:  " + account.getAccountNum());
                    lCAccType.setText("Account Type:  " + account.getType());
                    lCAccBalance.setText("Balance:  " + account.getBalance());
                    String temp = "Open";
                    if (Integer.valueOf(account.getStatus()) == 0) {
                        temp = "Close";
                    } else if (Integer.valueOf(account.getStatus()) == 2) {
                        temp = "Block";
                    }

                    lCAccStatus.setText("Status:  " + temp);
                    lCAccODate.setText("Opening Date:  " + account.getOpeningDate());
                    lCName.setVisible(true);
                    lCCNIC.setVisible(true);
                    lCAccNum.setVisible(true);
                    lCAccType.setVisible(true);
                    lCAccBalance.setVisible(true);
                    lCAccStatus.setVisible(true);
                    lCAccODate.setVisible(true);
                } else {
                    lCName.setVisible(false);
                    lCCNIC.setVisible(false);
                    lCAccNum.setVisible(false);
                    lCAccType.setVisible(false);
                    lCAccBalance.setVisible(false);
                    lCAccStatus.setVisible(false);
                    lCAccODate.setVisible(false);
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
        btn_mm.setBounds(50, 400, 130, 30);
        btn_mm.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\home.png"));
        f.add(btn_mm);
        btn_mm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.remove(f);
                frame.repaint();
                frame.validate();
                ManagerMenuForm managerMenuForm = new ManagerMenuForm();
                managerMenuForm.openManagerMenu(frame, manager);
            }
        });
        JButton btn_sign_out = new JButton("Sign Out");
        btn_sign_out.setBackground(new Color(0, 204, 153));
        btn_sign_out.setForeground(Color.white);
        btn_sign_out.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\logout.png"));
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
