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
import javax.swing.JPanel;
import model.Login_Account;
import model.Manager;

public class ManagerMenuForm extends JFrame {
    JPanel f = new JPanel();

    void openManagerMenu(final JFrame frame, final Manager manager) {
        this.f.setBackground(Color.white);
        JButton btn_sign_out = new JButton("Sign Out");
        btn_sign_out.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\image\\logout.png"));
        btn_sign_out.setBackground(new Color(0, 204, 153));
        btn_sign_out.setForeground(Color.white);
        btn_sign_out.setBounds(700, 30, 120, 30);
        this.f.add(btn_sign_out);
        btn_sign_out.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.remove(ManagerMenuForm.this.f);
                frame.validate();
                Login_Account user = new Login_Account();
                SignForm sf = new SignForm();
                sf.openSignInForm(frame, user);
            }
        });
        JLabel lUser = new JLabel(manager.getName());
        lUser.setFont(lUser.getFont().deriveFont(40.0F));
        lUser.setBounds(100, 50, 300, 40);
        this.f.add(lUser);
        JLabel lDesg = new JLabel("Manager");
        lDesg.setFont(lDesg.getFont().deriveFont(30.0F));
        lDesg.setBounds(100, 80, 250, 120);
        this.f.add(lDesg);
        lDesg.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\image\\manager.png"));
        JButton btnCreateAcc = new JButton("Create Account");
        btnCreateAcc.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\image\\add.png"));
        btnCreateAcc.setBounds(100, 180, 200, 50);
        btnCreateAcc.setBackground(new Color(0, 204, 153));
        btnCreateAcc.setForeground(Color.white);
        this.f.add(btnCreateAcc);
        btnCreateAcc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CreateAccountFrom createAccount = new CreateAccountFrom();
                createAccount.openCreateAccountForm(frame, manager);
            }
        });
        JButton btnBlockAcc = new JButton("Block/Unblock Account");
        btnBlockAcc.setBounds(350, 180, 220, 50);
        btnBlockAcc.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\image\\block.png"));
        btnBlockAcc.setBackground(new Color(0, 204, 153));
        btnBlockAcc.setForeground(Color.white);
        this.f.add(btnBlockAcc);
        btnBlockAcc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.remove(ManagerMenuForm.this.f);
                frame.repaint();
                frame.validate();
                BlockOrUnblockAccountForm lockOrUnlockAccount = new BlockOrUnblockAccountForm();
                lockOrUnlockAccount.open_block_unblock_account_page(frame, manager);
            }
        });
        JButton btnCloseAcc = new JButton("Close Account");
        btnCloseAcc.setBounds(620, 180, 200, 50);
        btnCloseAcc.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\image\\cancel.png"));
        btnCloseAcc.setBackground(new Color(0, 204, 153));
        btnCloseAcc.setForeground(Color.white);
        this.f.add(btnCloseAcc);
        btnCloseAcc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CloseAccountForm closeAccount = new CloseAccountForm();
                closeAccount.open_close_account_page(frame, manager);
            }
        });
        JButton btnSearchAcc = new JButton("Search Account");
        btnSearchAcc.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\image\\search.png"));
        btnSearchAcc.setBounds(100, 250, 200, 50);
        btnSearchAcc.setBackground(new Color(0, 204, 153));
        btnSearchAcc.setForeground(Color.white);
        this.f.add(btnSearchAcc);
        btnSearchAcc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.remove(ManagerMenuForm.this.f);
                frame.repaint();
                frame.validate();
                SearchAccountForm searchAccount = new SearchAccountForm();
                searchAccount.openSearchAccount(frame, manager);
            }
        });
        JButton btnManageCard = new JButton("Manage Credit/Debit Card");
        btnManageCard.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\image\\credit-card.png"));
        btnManageCard.setBounds(350, 250, 220, 50);
        btnManageCard.setBackground(new Color(0, 204, 153));
        btnManageCard.setForeground(Color.white);
        this.f.add(btnManageCard);
        btnManageCard.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ManagerCardPageForm manageCardPage = new ManagerCardPageForm();
                manageCardPage.open_manage_card_page(frame, manager);
            }
        });
        JButton btnUpdateInfo = new JButton("Update Client Info");
        btnUpdateInfo.setIcon(new ImageIcon(System.getProperty("user.dir") + "\\src\\image\\update.png"));
        btnUpdateInfo.setBounds(100, 320, 200, 50);
        btnUpdateInfo.setBackground(new Color(0, 204, 153));
        btnUpdateInfo.setForeground(Color.white);
        this.f.add(btnUpdateInfo);
        btnUpdateInfo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.remove(ManagerMenuForm.this.f);
                frame.repaint();
                frame.validate();
                UpdateClientInfoForm updateClinetInfoform = new UpdateClientInfoForm();
                updateClinetInfoform.openUpdateClientInfo(frame, manager);
            }
        });
        this.f.setLayout((LayoutManager)null);
        frame.setContentPane(this.f);
        frame.setVisible(true);
    }

    public ManagerMenuForm() {
        this.f.setLayout((LayoutManager)null);
    }
}
