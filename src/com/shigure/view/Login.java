/*
 * Created by JFormDesigner on Sat Nov 25 18:40:13 CST 2017
 */

package com.shigure.view;

import com.shigure.dao.UserDao;
import com.shigure.model.User;
import com.shigure.dao.RegisterDao;
import com.shigure.util.StringUtil;

import java.awt.*;
import java.sql.Connection;
import javax.swing.*;

import static com.shigure.util.DbUtil.*;


/**
 * @author siyuan zheng
 */
public class Login extends JFrame {
    private RegisterDao registerDao = new RegisterDao();
    private UserDao userDao = new UserDao();
    public Login() {
        initComponents();
    }

    private void button1ActionPerformed() {
        String userRegisterName = this.userNameField.getText();
        String userRegisterPassword = new String(this.passwordField.getPassword());
        if (StringUtil.isEmpty(userRegisterName)) {
            JOptionPane.showMessageDialog(null, "用户名不能为空");
            return;
        }
        User user = new User(userRegisterName, userRegisterPassword);
        Connection con = null;
        try {
            con = getConnection();
            int n = registerDao.userRegister(con, user);
            if (n == 1) {
                JOptionPane.showMessageDialog(null, "注册成功");
            } else {
                JOptionPane.showMessageDialog(null, "注册失败");
            }

        } catch (Exception e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null, "注册失败");
        } finally {
            free(con);
        }
    }
    private void button2ActionPerformed() {

        String userName = userNameField.getText();
        String password =new String(passwordField.getPassword());
        if(StringUtil.isEmpty(userName)){
            JOptionPane.showMessageDialog(null,"用户名不能为空");
            return;
        }
        if(StringUtil.isEmpty(password)){
            JOptionPane.showMessageDialog(null,"密码不能为空");
            return;
        }
        User user = new User(userName,password);
        Connection con = null;
        try {
            con = getConnection();
            User currentUser=userDao.login(con,user);
            if(currentUser!=null) {
                JOptionPane.showMessageDialog(null, "登录成功");
                this.dispose();
                new Main().setVisible(true);
            }
            else {
                JOptionPane.showMessageDialog(null,"登录失败");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null,"登录失败");
        }finally {
            free(con);
        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - siyuan zheng
        JLabel title = new JLabel();
        JLabel userNameLabel = new JLabel();
        JLabel passwordLabel = new JLabel();
        userNameField = new JTextField();
        passwordField = new JPasswordField();
        JButton registerButton = new JButton();
        JButton loginButton = new JButton();
        JCheckBox studentCheck = new JCheckBox();
        JCheckBox teacherCheck = new JCheckBox();
        JLabel titleIcon = new JLabel();
        JLabel background = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- title ----
        title.setText("\u5b66\u751f\u6210\u7ee9\u7ba1\u7406\u7cfb\u7edf");
        title.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 28));
        title.setForeground(new Color(204, 204, 204));
        contentPane.add(title);
        title.setBounds(310, 75, 260, title.getPreferredSize().height);

        //---- userNameLabel ----
        userNameLabel.setText("\u7528\u6237\u540d");
        userNameLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        userNameLabel.setForeground(new Color(204, 204, 204));
        contentPane.add(userNameLabel);
        userNameLabel.setBounds(new Rectangle(new Point(190, 175), userNameLabel.getPreferredSize()));

        //---- passwordLabel ----
        passwordLabel.setText("\u5bc6\u7801");
        passwordLabel.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        passwordLabel.setForeground(new Color(204, 204, 204));
        contentPane.add(passwordLabel);
        passwordLabel.setBounds(new Rectangle(new Point(205, 235), passwordLabel.getPreferredSize()));

        //---- userNameField ----
        userNameField.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        userNameField.setBackground(new Color(204, 204, 204));
        userNameField.setBorder(null);
        userNameField.setForeground(new Color(51, 51, 51));
        contentPane.add(userNameField);
        userNameField.setBounds(260, 175, 290, 25);

        //---- passwordField ----
        passwordField.setBackground(new Color(204, 204, 204));
        passwordField.setBorder(null);
        passwordField.setForeground(new Color(51, 51, 51));
        contentPane.add(passwordField);
        passwordField.setBounds(260, 235, 290, 24);

        //---- registerButton ----
        registerButton.setText("\u6ce8\u518c");
        registerButton.setBorder(null);
        registerButton.setBackground(new Color(102, 102, 102));
        registerButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        registerButton.setForeground(new Color(204, 204, 204));
        registerButton.setAutoscrolls(true);
        registerButton.addActionListener(e1 -> button1ActionPerformed());
        contentPane.add(registerButton);
        registerButton.setBounds(260, 335, 90, 30);

        //---- loginButton ----
        loginButton.setText("\u767b\u9646");
        loginButton.setBorder(null);
        loginButton.setBackground(new Color(102, 102, 102));
        loginButton.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        loginButton.setForeground(new Color(204, 204, 204));
        loginButton.addActionListener(e -> button2ActionPerformed());
        contentPane.add(loginButton);
        loginButton.setBounds(465, 335, 90, 30);

        //---- studentCheck ----
        studentCheck.setText("\u5b66\u751f");
        studentCheck.setContentAreaFilled(false);
        studentCheck.setBorder(null);
        studentCheck.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        studentCheck.setBackground(new Color(102, 102, 102));
        contentPane.add(studentCheck);
        studentCheck.setBounds(new Rectangle(new Point(310, 285), studentCheck.getPreferredSize()));

        //---- teacherCheck ----
        teacherCheck.setText("\u6559\u5e08");
        teacherCheck.setContentAreaFilled(false);
        teacherCheck.setBorder(null);
        teacherCheck.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        teacherCheck.setBackground(new Color(102, 102, 102));
        contentPane.add(teacherCheck);
        teacherCheck.setBounds(new Rectangle(new Point(435, 285), teacherCheck.getPreferredSize()));

        //---- titleIcon ----
        titleIcon.setIcon(new ImageIcon(getClass().getResource("/com/shigure/material/ManagerIcon.png")));
        contentPane.add(titleIcon);
        titleIcon.setBounds(new Rectangle(new Point(235, 70), titleIcon.getPreferredSize()));

        //---- background ----
        background.setIcon(new ImageIcon(getClass().getResource("/com/shigure/material/LoginBackground.jpg")));
        background.setBorder(null);
        contentPane.add(background);
        background.setBounds(0, 0, 770, 495);

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
        buttonGroup1.add(studentCheck);
        buttonGroup1.add(teacherCheck);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    private JTextField userNameField;
    private JPasswordField passwordField;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
