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
public class ReaderSelfInformationManage extends JFrame {
    UserDao userDao = new UserDao();
    public ReaderSelfInformationManage() {
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
//        String password = String.valueOf(this.passwordUpdateTxt.getPassword());
//        String passwordConf = String.valueOf(this.passwordConfTxt.getPassword());
        if(StringUtil.isEmpty(realName)){
            JOptionPane.showMessageDialog(null,"请输入要修改的姓名");
            return;
        }
        if(StringUtil.isEmpty(telPhone)){
            JOptionPane.showMessageDialog(null,"请输入要修改的联系方式");
            return;
        }
//        if(StringUtil.isEmpty(password)){
//            JOptionPane.showMessageDialog(null,"请输入要修改的密码");
//            return;
//        }
//        if(StringUtil.isEmpty(passwordConf)){
//            JOptionPane.showMessageDialog(null,"确认密码不能为空");
//            return;
//        }
//        if(!Objects.equals(password, passwordConf)){
//            JOptionPane.showMessageDialog(null,"两次密码输入不一致");
//            return;
//        }


        User user = new User(realName, telPhone, userId);
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

    private void jb_passwordUpdateActionPerformed(ActionEvent e) {
        int userId = ReaderDashBoard.uid;
        String password = String.valueOf(this.passwordUpdateTxt.getPassword());
        String passwordConf = String.valueOf(this.passwordConfTxt.getPassword());
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


        User user = new User(password, userId);
        Connection con = null;
        try {
            con= getConnection();
            int updateNum = UserDao.passwordUpdate(con,user);
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
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        telPhoneUpdateTxt = new JTextField();
        label3 = new JLabel();
        label1 = new JLabel();
        realNameUpdateTxt = new JTextField();
        userNameTxt = new JTextField();
        label2 = new JLabel();
        jb_userUpdate = new JButton();
        label7 = new JLabel();
        panel2 = new JPanel();
        passwordConfTxt = new JPasswordField();
        label5 = new JLabel();
        label4 = new JLabel();
        passwordUpdateTxt = new JPasswordField();
        jb_passwordUpdate = new JButton();
        label6 = new JLabel();
        label8 = new JLabel();

        //======== this ========
        setTitle("\u4e2a\u4eba\u4fe1\u606f\u7ba1\u7406");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== tabbedPane1 ========
        {
            tabbedPane1.setBorder(null);

            //======== panel1 ========
            {
                panel1.setLayout(null);
                panel1.add(telPhoneUpdateTxt);
                telPhoneUpdateTxt.setBounds(105, 135, 215, telPhoneUpdateTxt.getPreferredSize().height);

                //---- label3 ----
                label3.setText("\u7535\u8bdd");
                label3.setFont(new Font(".SF NS Text", Font.PLAIN, 16));
                panel1.add(label3);
                label3.setBounds(new Rectangle(new Point(40, 137), label3.getPreferredSize()));

                //---- label1 ----
                label1.setText("\u59d3\u540d");
                label1.setFont(new Font(".SF NS Text", Font.PLAIN, 16));
                panel1.add(label1);
                label1.setBounds(new Rectangle(new Point(40, 77), label1.getPreferredSize()));
                panel1.add(realNameUpdateTxt);
                realNameUpdateTxt.setBounds(105, 75, 215, realNameUpdateTxt.getPreferredSize().height);

                //---- userNameTxt ----
                userNameTxt.setEditable(false);
                panel1.add(userNameTxt);
                userNameTxt.setBounds(105, 18, 215, userNameTxt.getPreferredSize().height);

                //---- label2 ----
                label2.setText("\u7528\u6237\u540d");
                label2.setFont(new Font(".SF NS Text", Font.PLAIN, 16));
                panel1.add(label2);
                label2.setBounds(new Rectangle(new Point(30, 20), label2.getPreferredSize()));

                //---- jb_userUpdate ----
                jb_userUpdate.setText("\u4fee\u6539");
                jb_userUpdate.setFont(jb_userUpdate.getFont().deriveFont(jb_userUpdate.getFont().getSize() + 3f));
                jb_userUpdate.addActionListener(e -> jb_userUpdateActionPerformed(e));
                panel1.add(jb_userUpdate);
                jb_userUpdate.setBounds(new Rectangle(new Point(330, 175), jb_userUpdate.getPreferredSize()));
                panel1.add(label7);
                label7.setBounds(0, 0, 425, 225);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel1.getComponentCount(); i++) {
                        Rectangle bounds = panel1.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel1.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel1.setMinimumSize(preferredSize);
                    panel1.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u4e2a\u4eba\u4fe1\u606f\u4fee\u6539", panel1);

            //======== panel2 ========
            {
                panel2.setLayout(null);
                panel2.add(passwordConfTxt);
                passwordConfTxt.setBounds(135, 115, 215, passwordConfTxt.getPreferredSize().height);

                //---- label5 ----
                label5.setText("\u786e\u8ba4\u5bc6\u7801");
                label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 3f));
                panel2.add(label5);
                label5.setBounds(new Rectangle(new Point(50, 115), label5.getPreferredSize()));

                //---- label4 ----
                label4.setText("\u5bc6\u7801");
                label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 3f));
                panel2.add(label4);
                label4.setBounds(75, 45, label4.getPreferredSize().width, 20);
                panel2.add(passwordUpdateTxt);
                passwordUpdateTxt.setBounds(135, 40, 215, passwordUpdateTxt.getPreferredSize().height);

                //---- jb_passwordUpdate ----
                jb_passwordUpdate.setText("\u4fee\u6539");
                jb_passwordUpdate.setFont(jb_passwordUpdate.getFont().deriveFont(jb_passwordUpdate.getFont().getSize() + 3f));
                jb_passwordUpdate.addActionListener(e -> jb_passwordUpdateActionPerformed(e));
                panel2.add(jb_passwordUpdate);
                jb_passwordUpdate.setBounds(new Rectangle(new Point(325, 165), jb_passwordUpdate.getPreferredSize()));
                panel2.add(label6);
                label6.setBounds(0, 0, 425, 225);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel2.getComponentCount(); i++) {
                        Rectangle bounds = panel2.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel2.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel2.setMinimumSize(preferredSize);
                    panel2.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab("\u5bc6\u7801\u4fee\u6539", panel2);
        }
        contentPane.add(tabbedPane1);
        tabbedPane1.setBounds(70, 50, 425, 250);
        contentPane.add(label8);
        label8.setBounds(0, 0, 565, 400);

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
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTextField telPhoneUpdateTxt;
    private JLabel label3;
    private JLabel label1;
    private JTextField realNameUpdateTxt;
    private JTextField userNameTxt;
    private JLabel label2;
    private JButton jb_userUpdate;
    private JLabel label7;
    private JPanel panel2;
    private JPasswordField passwordConfTxt;
    private JLabel label5;
    private JLabel label4;
    private JPasswordField passwordUpdateTxt;
    private JButton jb_passwordUpdate;
    private JLabel label6;
    private JLabel label8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
