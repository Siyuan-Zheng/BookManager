/*
 * Created by JFormDesigner on Sat Nov 25 18:40:13 CST 2017
 */

package com.shigure.view;

import java.awt.event.*;
import com.shigure.dao.ManagerDao;
import com.shigure.dao.UserDao;
import com.shigure.model.Manager;
import com.shigure.model.User;
import com.shigure.util.StringUtil;

import java.awt.*;
import java.sql.Connection;
import javax.swing.*;

import static com.shigure.util.DbUtil.*;


/**
 * @author siyuan zheng
 */
public class Login extends JFrame {
    private ManagerDao managerDao = new ManagerDao();
    private UserDao userDao = new UserDao();
    ReaderDashBoard readerDashBoard = new ReaderDashBoard();
    public Login() {
        initComponents();
    }

    //调用注册窗口
    private void button1ActionPerformed(ActionEvent e) {
        new Register().setVisible(true);
    }

    //登陆
    private void button2ActionPerformed(ActionEvent e) {

        boolean managerFlag = this.managerCheck.isSelected();           //判断管理员选框是否被选中
        boolean readerFlag = this.readerCheck.isSelected();             //判断读者选框是否被选中

        String userName = userNameField.getText();                      //获取输入框内用户名
        String password =new String(passwordField.getPassword());       //获取输入框内密码

        if(StringUtil.isEmpty(userName)){                               //用户名为空时报错
            JOptionPane.showMessageDialog(null,"用户名不能为空");
            return;
        }
        if(StringUtil.isEmpty(password)){                               //密码为空时报错
            JOptionPane.showMessageDialog(null,"密码不能为空");
            return;
        }

        if(managerFlag){                                                //当管理员选项被选中时
            Manager manager = new Manager(userName,password);
            Connection con = null;
            try {
                con = getConnection();
                Manager currentManager =managerDao.login(con,manager);  //进行登陆
                if(currentManager !=null) {
                    this.dispose();
                    new ManagerDashBoard().setVisible(true);            //当管理员选项被选中是关闭登陆窗口，调用管理员主菜单
                } else {                                                //登录失败时报错
                    JOptionPane.showMessageDialog(null,"登录失败");
                }
            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null,"登录失败");
            }finally {
                free(con);                                              //断开数据库连接
            }
        }else if(readerFlag){
            User user = new User(userName,password,null,null);
            Connection con = null;
            try {
                con = getConnection();
                User currentUser =userDao.login(con,user);      //进行登陆
                User id = userDao.userTypeList(con,user);
                readerDashBoard.getUserId(id);
                    if(currentUser !=null) {
                    this.dispose();
                    new ReaderDashBoard().setVisible(true);     //当读者选项被选中是关闭登陆窗口，调用管理员主菜单
                } else {
                    JOptionPane.showMessageDialog(null,"登录失败");
                }
            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null,"登录失败");
            }finally {
                free(con);
            }
        }
    }




    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - siyuan zheng
        title = new JLabel();
        userNameLabel = new JLabel();
        passwordLabel = new JLabel();
        userNameField = new JTextField();
        passwordField = new JPasswordField();
        registerButton = new JButton();
        loginButton = new JButton();
        readerCheck = new JCheckBox();
        managerCheck = new JCheckBox();
        titleIcon = new JLabel();
        background = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- title ----
        title.setText("\u56fe\u4e66\u4fe1\u606f\u7ba1\u7406\u7cfb\u7edf");
        title.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 30));
        title.setForeground(new Color(204, 204, 204));
        contentPane.add(title);
        title.setBounds(195, 75, 255, title.getPreferredSize().height);

        //---- userNameLabel ----
        userNameLabel.setText("\u7528\u6237\u540d");
        userNameLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        userNameLabel.setForeground(new Color(204, 204, 204));
        contentPane.add(userNameLabel);
        userNameLabel.setBounds(new Rectangle(new Point(100, 205), userNameLabel.getPreferredSize()));

        //---- passwordLabel ----
        passwordLabel.setText("\u5bc6\u7801");
        passwordLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        passwordLabel.setForeground(new Color(204, 204, 204));
        contentPane.add(passwordLabel);
        passwordLabel.setBounds(new Rectangle(new Point(115, 300), passwordLabel.getPreferredSize()));

        //---- userNameField ----
        userNameField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        userNameField.setBorder(null);
        userNameField.setForeground(new Color(204, 204, 204));
        userNameField.setBackground(new Color(70, 73, 74));
        contentPane.add(userNameField);
        userNameField.setBounds(170, 205, 290, 25);

        //---- passwordField ----
        passwordField.setBackground(new Color(70, 73, 74));
        passwordField.setBorder(null);
        passwordField.setForeground(new Color(204, 204, 204));
        contentPane.add(passwordField);
        passwordField.setBounds(170, 300, 290, 25);

        //---- registerButton ----
        registerButton.setBackground(new Color(102, 102, 102));
        registerButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        registerButton.setForeground(new Color(204, 204, 204));
        registerButton.setAutoscrolls(true);
        registerButton.setContentAreaFilled(false);
        registerButton.setBorder(null);
        registerButton.setIcon(new ImageIcon(getClass().getResource("/com/shigure/material/New.png")));
        registerButton.setBorderPainted(false);
        registerButton.addActionListener(e -> {
			button1ActionPerformed(e);
			button1ActionPerformed(e);
		});
        contentPane.add(registerButton);
        registerButton.setBounds(115, 465, 115, 110);

        //---- loginButton ----
        loginButton.setBackground(new Color(102, 102, 102));
        loginButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        loginButton.setForeground(new Color(204, 204, 204));
        loginButton.setContentAreaFilled(false);
        loginButton.setBorder(null);
        loginButton.setIcon(new ImageIcon(getClass().getResource("/com/shigure/material/Plane.png")));
        loginButton.setBorderPainted(false);
        loginButton.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(loginButton);
        loginButton.setBounds(370, 465, 115, 110);

        //---- readerCheck ----
        readerCheck.setText("\u8bfb\u8005");
        readerCheck.setContentAreaFilled(false);
        readerCheck.setBorder(null);
        readerCheck.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        readerCheck.setBackground(new Color(102, 102, 102));
        readerCheck.setForeground(new Color(204, 204, 204));
        contentPane.add(readerCheck);
        readerCheck.setBounds(new Rectangle(new Point(220, 375), readerCheck.getPreferredSize()));

        //---- managerCheck ----
        managerCheck.setText("\u7ba1\u7406\u5458");
        managerCheck.setContentAreaFilled(false);
        managerCheck.setBorder(null);
        managerCheck.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        managerCheck.setBackground(new Color(102, 102, 102));
        managerCheck.setForeground(new Color(204, 204, 204));
        contentPane.add(managerCheck);
        managerCheck.setBounds(new Rectangle(new Point(345, 375), managerCheck.getPreferredSize()));

        //---- titleIcon ----
        titleIcon.setIcon(new ImageIcon(getClass().getResource("/com/shigure/material/ManagerIcon.png")));
        contentPane.add(titleIcon);
        titleIcon.setBounds(new Rectangle(new Point(120, 70), titleIcon.getPreferredSize()));

        //---- background ----
        background.setIcon(new ImageIcon(getClass().getResource("/com/shigure/material/\u672a\u6807\u9898-1.png")));
        background.setBorder(null);
        contentPane.add(background);
        background.setBounds(0, 0, 575, 640);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());

        //---- buttonGroup1 ----
        ButtonGroup buttonGroup1 = new ButtonGroup();
        buttonGroup1.add(readerCheck);
        buttonGroup1.add(managerCheck);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - siyuan zheng
    private JLabel title;
    private JLabel userNameLabel;
    private JLabel passwordLabel;
    private JTextField userNameField;
    private JPasswordField passwordField;
    private JButton registerButton;
    private JButton loginButton;
    private JCheckBox readerCheck;
    private JCheckBox managerCheck;
    private JLabel titleIcon;
    private JLabel background;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
