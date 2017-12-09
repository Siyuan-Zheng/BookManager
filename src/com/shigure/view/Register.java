/*
 * Created by JFormDesigner on Tue Nov 28 16:01:46 CST 2017
 */

package com.shigure.view;

import com.shigure.dao.ManagerDao;
import com.shigure.dao.UserDao;
import com.shigure.model.Manager;
import com.shigure.model.User;
import com.shigure.util.StringUtil;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.util.Objects;
import javax.swing.*;

import static com.shigure.util.DbUtil.free;
import static com.shigure.util.DbUtil.getConnection;
//import com.jgoodies.forms.factories.*;

/**
 * @author siyuan zheng
 */
public class Register extends JFrame {
    User user = new User();
    public Register() {
        initComponents();
    }

    //重置输入框
    private void jb_resetActionPerformed(ActionEvent e) {
        this.userNameTxt.setText("");
        this.passwordTxt.setText("");
        this.confPasswordTxt.setText("");
        this.realNameTxt.setText("");
        this.telPhoneTxt.setText("");
    }

    //注册新用户
    private void jb_registerActionPerformed(ActionEvent e) {
        String userRegisterName = this.userNameTxt.getText();
        String userRegisterPassword = new String(this.passwordTxt.getPassword());
        String userConfPassword = new String(this.confPasswordTxt.getPassword());
        String userRealName = this.realNameTxt.getText();
        String userTelPhone = this.telPhoneTxt.getText();
        if (StringUtil.isEmpty(userRegisterName)) {
            JOptionPane.showMessageDialog(null, "用户名不能为空");
            return;
        }
        if (StringUtil.isEmpty(userRegisterPassword)) {
            JOptionPane.showMessageDialog(null, "密码不能为空");
            return;
        }
        if (StringUtil.isEmpty(userConfPassword)) {
            JOptionPane.showMessageDialog(null, "重复密码不能为空");
            return;
        }
        if (StringUtil.isEmpty(userRealName)) {
            JOptionPane.showMessageDialog(null, "姓名不能为空");
            return;
        }
        if (StringUtil.isEmpty(userTelPhone)) {
            JOptionPane.showMessageDialog(null, "联系方式不能为空");
            return;
        }

        User user = new User(userRegisterName, userRegisterPassword, userRealName, userTelPhone);
        Connection con = null;
        try {
            if(!Objects.equals(userRegisterPassword, userConfPassword)){
                JOptionPane.showMessageDialog(null,"两次密码输入不同");
                return;
            }
            con = getConnection();
            int n = UserDao.userRegister(con, user);
            if (n == 1) {
                JOptionPane.showMessageDialog(null, "注册成功");
                this.dispose();
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - siyuan zheng
        label1 = new JLabel();
        label2 = new JLabel();
        realNameTxt = new JTextField();
        label3 = new JLabel();
        label4 = new JLabel();
        userNameTxt = new JTextField();
        label6 = new JLabel();
        passwordTxt = new JPasswordField();
        confPasswordTxt = new JPasswordField();
        telPhoneTxt = new JTextField();
        label9 = new JLabel();
        jb_register = new JButton();
        jb_reset = new JButton();
        label8 = new JLabel();
        label7 = new JLabel();

        //======== this ========
        setTitle("\u6ce8\u518c");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u7528\u6237\u540d");
        label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        label1.setForeground(new Color(204, 204, 204));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(210, 140), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u5bc6\u7801");
        label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        label2.setForeground(new Color(204, 204, 204));
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(225, 185), label2.getPreferredSize()));

        //---- realNameTxt ----
        realNameTxt.setBorder(null);
        realNameTxt.setBackground(new Color(70, 73, 74));
        realNameTxt.setForeground(new Color(204, 204, 204));
        contentPane.add(realNameTxt);
        realNameTxt.setBounds(285, 273, 290, 25);

        //---- label3 ----
        label3.setText("\u786e\u8ba4\u5bc6\u7801");
        label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        label3.setForeground(new Color(204, 204, 204));
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(195, 230), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("\u59d3\u540d");
        label4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        label4.setForeground(new Color(204, 204, 204));
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(225, 275), label4.getPreferredSize()));

        //---- userNameTxt ----
        userNameTxt.setBorder(null);
        userNameTxt.setBackground(new Color(70, 73, 74));
        userNameTxt.setForeground(new Color(204, 204, 204));
        contentPane.add(userNameTxt);
        userNameTxt.setBounds(285, 138, 290, 25);

        //---- label6 ----
        label6.setText("\u8054\u7cfb\u65b9\u5f0f");
        label6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        label6.setForeground(new Color(204, 204, 204));
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(195, 320), label6.getPreferredSize()));

        //---- passwordTxt ----
        passwordTxt.setBackground(new Color(70, 73, 74));
        passwordTxt.setBorder(null);
        passwordTxt.setForeground(new Color(204, 204, 204));
        contentPane.add(passwordTxt);
        passwordTxt.setBounds(285, 183, 290, 25);

        //---- confPasswordTxt ----
        confPasswordTxt.setBorder(null);
        confPasswordTxt.setBackground(new Color(70, 73, 74));
        confPasswordTxt.setForeground(new Color(204, 204, 204));
        contentPane.add(confPasswordTxt);
        confPasswordTxt.setBounds(285, 228, 290, 25);

        //---- telPhoneTxt ----
        telPhoneTxt.setBorder(null);
        telPhoneTxt.setBackground(new Color(70, 73, 74));
        telPhoneTxt.setForeground(new Color(204, 204, 204));
        contentPane.add(telPhoneTxt);
        telPhoneTxt.setBounds(285, 318, 290, 25);

        //---- label9 ----
        label9.setText("\u65b0\u7528\u6237\u6ce8\u518c");
        label9.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 28));
        label9.setForeground(new Color(204, 204, 204));
        contentPane.add(label9);
        label9.setBounds(new Rectangle(new Point(350, 60), label9.getPreferredSize()));

        //---- jb_register ----
        jb_register.setText("\u6ce8\u518c");
        jb_register.setContentAreaFilled(false);
        jb_register.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        jb_register.setForeground(new Color(204, 204, 204));
        jb_register.setBorder(null);
        jb_register.addActionListener(e -> jb_registerActionPerformed(e));
        contentPane.add(jb_register);
        jb_register.setBounds(485, 370, 90, 35);

        //---- jb_reset ----
        jb_reset.setText("\u91cd\u7f6e");
        jb_reset.setContentAreaFilled(false);
        jb_reset.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        jb_reset.setForeground(new Color(204, 204, 204));
        jb_reset.setBorder(null);
        jb_reset.addActionListener(e -> jb_resetActionPerformed(e));
        contentPane.add(jb_reset);
        jb_reset.setBounds(285, 370, 90, 35);

        //---- label8 ----
        label8.setIcon(new ImageIcon(getClass().getResource("/com/shigure/material/Register.png")));
        contentPane.add(label8);
        label8.setBounds(new Rectangle(new Point(250, 50), label8.getPreferredSize()));

        //---- label7 ----
        label7.setIcon(new ImageIcon(getClass().getResource("/com/shigure/material/LoginBackground.jpg")));
        contentPane.add(label7);
        label7.setBounds(0, 0, 750, 470);

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
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - siyuan zheng
    private JLabel label1;
    private JLabel label2;
    private JTextField realNameTxt;
    private JLabel label3;
    private JLabel label4;
    private JTextField userNameTxt;
    private JLabel label6;
    private JPasswordField passwordTxt;
    private JPasswordField confPasswordTxt;
    private JTextField telPhoneTxt;
    private JLabel label9;
    private JButton jb_register;
    private JButton jb_reset;
    private JLabel label8;
    private JLabel label7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
