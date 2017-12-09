/*
 * Created by JFormDesigner on Thu Dec 07 00:52:55 CST 2017
 */

package com.shigure.view;

import java.awt.event.*;
import com.shigure.dao.BookTypeDao;
import com.shigure.dao.UserDao;
import com.shigure.model.BookBorrow;
import com.shigure.model.BookType;
import com.shigure.model.User;
import com.shigure.util.StringUtil;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Objects;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import static com.shigure.util.DbUtil.free;
import static com.shigure.util.DbUtil.getConnection;

/**
 * @author siyuan zheng
 */
public class ReaderSelfimformationManage extends JFrame {
    UserDao userDao = new UserDao();
    public ReaderSelfimformationManage() {
        initComponents();
        this.fillTxt();
    }

    private void fillTxt(){
        int userId = ReaderDashBoard.uid;
        User user = new User(userId);
        Connection con = null;
        try {
            con = getConnection();
            ResultSet rs = userDao.userList(con,user);
            while(rs.next()){
                this.userNameTxt.setText(rs.getString("userName"));
                this.realNameUpdateTxt.setText(rs.getString("realName"));
                this.telPhoneUpdateTxt.setText(rs.getString("telPhone"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            free(con);
        }
    }


    private void jb_userUpdateActionPerformed(ActionEvent e) {
        int userId = ReaderDashBoard.uid;
        String realName = this.realNameUpdateTxt.getText();
        String telPhone = this.telPhoneUpdateTxt.getText();
        String password = String.valueOf(this.passwordUpdateTxt.getPassword());
        String passwordConf = String.valueOf(this.passwordConfTxt.getPassword());
        if(StringUtil.isEmpty(realName)){
            JOptionPane.showMessageDialog(null,"请输入要修改的姓名");
            return;
        }
        if(StringUtil.isEmpty(telPhone)){
            JOptionPane.showMessageDialog(null,"请输入要修改的联系方式");
            return;
        }
        if(StringUtil.isEmpty(password)){
            JOptionPane.showMessageDialog(null,"请输入要修改的密码");
            return;
        }
        if(StringUtil.isEmpty(passwordConf)){
            JOptionPane.showMessageDialog(null,"确认密码不能为空");
            return;
        }
        if(!Objects.equals(password, passwordConf)){
            JOptionPane.showMessageDialog(null,"两次密码输入不一致");
            return;
        }


        User user = new User(realName, telPhone, password, userId);
        Connection con = null;
        try {
            con= getConnection();
            int updateNum = UserDao.userUpdate(con,user);
            if(updateNum == 1){
                JOptionPane.showMessageDialog(null,"修改成功");
                this.fillTxt();
            }else {
                JOptionPane.showMessageDialog(null, "修改失败");
            }

        } catch (Exception e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null,"修改失败");
        }finally {
            free(con);
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - siyuan zheng
        realNameUpdateTxt = new JTextField();
        telPhoneUpdateTxt = new JTextField();
        userNameTxt = new JTextField();
        passwordUpdateTxt = new JPasswordField();
        passwordConfTxt = new JPasswordField();
        jb_userUpdate = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(realNameUpdateTxt);
        realNameUpdateTxt.setBounds(90, 120, 155, realNameUpdateTxt.getPreferredSize().height);
        contentPane.add(telPhoneUpdateTxt);
        telPhoneUpdateTxt.setBounds(325, 110, 205, telPhoneUpdateTxt.getPreferredSize().height);

        //---- userNameTxt ----
        userNameTxt.setEditable(false);
        contentPane.add(userNameTxt);
        userNameTxt.setBounds(85, 50, 145, userNameTxt.getPreferredSize().height);
        contentPane.add(passwordUpdateTxt);
        passwordUpdateTxt.setBounds(90, 225, 205, passwordUpdateTxt.getPreferredSize().height);
        contentPane.add(passwordConfTxt);
        passwordConfTxt.setBounds(95, 305, 215, passwordConfTxt.getPreferredSize().height);

        //---- jb_userUpdate ----
        jb_userUpdate.setText("text");
        jb_userUpdate.addActionListener(e -> jb_userUpdateActionPerformed(e));
        contentPane.add(jb_userUpdate);
        jb_userUpdate.setBounds(new Rectangle(new Point(400, 275), jb_userUpdate.getPreferredSize()));

        //---- label1 ----
        label1.setText("\u59d3\u540d");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(50, 125), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("id");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(45, 55), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u7535\u8bdd");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(275, 115), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("\u5bc6\u7801");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(30, 235), label4.getPreferredSize()));

        //---- label5 ----
        label5.setText("\u786e\u8ba4\u5bc6\u7801");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(30, 310), label5.getPreferredSize()));

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
    private JTextField realNameUpdateTxt;
    private JTextField telPhoneUpdateTxt;
    private JTextField userNameTxt;
    private JPasswordField passwordUpdateTxt;
    private JPasswordField passwordConfTxt;
    private JButton jb_userUpdate;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
