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

public class UpdateClientInfoForm {
    public UpdateClientInfoForm() {
    }

    void openUpdateClientInfo(final JFrame frame, final Manager manager) {
        final JPanel f = new JPanel();
        f.setBackground(Color.white);
        JLabel lUCInfo = new JLabel("Update Client Info");
        lUCInfo.setFont(lUCInfo.getFont().deriveFont(30.0F));
        lUCInfo.setBounds(150, 50, 300, 40);
        f.add(lUCInfo);
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
        final JLabel lCid = new JLabel("");
        lCid.setBounds(450, 170, 100, 40);
        lCid.setVisible(false);
        f.add(lCid);
        final JLabel lCCNIC = new JLabel("CNIC: ");
        lCCNIC.setBounds(150, 200, 250, 40);
        lCCNIC.setVisible(false);
        f.add(lCCNIC);
        final JLabel lCPhone = new JLabel("Phone No: ");
        lCPhone.setBounds(150, 230, 250, 40);
        lCPhone.setVisible(false);
        f.add(lCPhone);
        final JTextField tfPhone = new JTextField();
        tfPhone.setBounds(250, 240, 180, 25);
        tfPhone.setVisible(false);
        f.add(tfPhone);
        final JLabel lCEmail = new JLabel("Account Type: ");
        lCEmail.setBounds(150, 260, 250, 40);
        lCEmail.setVisible(false);
        f.add(lCEmail);
        final JTextField tfEmail = new JTextField();
        tfEmail.setBounds(250, 270, 180, 25);
        tfEmail.setVisible(false);
        f.add(tfEmail);
        final JLabel lCAddress = new JLabel("Address: ");
        lCAddress.setBounds(150, 290, 250, 40);
        lCAddress.setVisible(false);
        f.add(lCAddress);
        final JTextField tfAddress = new JTextField();
        tfAddress.setBounds(250, 300, 180, 25);
        tfAddress.setVisible(false);
        f.add(tfAddress);
        JButton btnSearch = new JButton("Search");
        btnSearch.setBackground(new Color(0, 204, 153));
        btnSearch.setForeground(Color.white);
        btnSearch.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\search-small.png"));
        btnSearch.setBounds(350, 130, 110, 40);
        f.add(btnSearch);
        final JButton btnUpdate = new JButton("Update");
        btnUpdate.setBackground(new Color(0, 204, 153));
        btnUpdate.setForeground(Color.white);
        btnUpdate.setBounds(150, 330, 110, 40);
        btnUpdate.setIcon(new ImageIcon("D:\\Study\\Java\\BM_System\\src\\image\\save.png"));
        btnUpdate.setVisible(false);
        f.add(btnUpdate);
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Bank_Account account = manager.getAccountInfo(tfAccNum.getText());
                Client client = manager.getClientInfo(tfAccNum.getText());
                if (account.getAccountNum().compareTo("") != 0 && client.getCNIC().compareTo("") != 0) {
                    lCid.setText(client.getClientID());
                    lCName.setText("Name:  " + client.getFName() + " " + client.getLName());
                    lCCNIC.setText("CNIC:  " + client.getCNIC());
                    tfPhone.setText(client.getPhone());
                    tfEmail.setText(client.getEmail());
                    tfAddress.setText(client.getAddress());
                    lCName.setVisible(true);
                    lCCNIC.setVisible(true);
                    lCPhone.setVisible(true);
                    lCEmail.setVisible(true);
                    lCAddress.setVisible(true);
                    tfPhone.setVisible(true);
                    tfEmail.setVisible(true);
                    tfAddress.setVisible(true);
                    btnUpdate.setVisible(true);
                } else {
                    lCName.setVisible(false);
                    lCCNIC.setVisible(false);
                    lCPhone.setVisible(false);
                    lCEmail.setVisible(false);
                    lCAddress.setVisible(false);
                    tfPhone.setVisible(false);
                    tfEmail.setVisible(false);
                    tfAddress.setVisible(false);
                    btnUpdate.setVisible(false);
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
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                manager.updateClientInfo(lCid.getText(), tfPhone.getText(), tfEmail.getText(), tfAddress.getText());
                JOptionPane.showMessageDialog(f, "Info Updated");
                frame.remove(f);
                frame.repaint();
                frame.validate();
                ManagerMenuForm managerMenuForm = new ManagerMenuForm();
                managerMenuForm.openManagerMenu(frame, manager);
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
