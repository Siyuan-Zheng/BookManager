/*
 * Created by JFormDesigner on Sat Dec 09 01:41:41 CST 2017
 */

package com.shigure.view;

import java.awt.event.*;
import javax.swing.table.*;

import com.shigure.dao.BookBorrowDao;
import com.shigure.dao.UserDao;
import com.shigure.model.User;
import com.shigure.util.StringUtil;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import static com.shigure.util.DbUtil.free;
import static com.shigure.util.DbUtil.getConnection;

/**
 * @author siyuan zheng
 */
class UserInformationManage extends JFrame {
    private UserDao userDao = new UserDao();
    private BookBorrowDao bookBorrowDao = new BookBorrowDao();
    private static int borrowId = 0;

    UserInformationManage() {
        initComponents();
        this.fillUserTable();
    }

    private void fillUserTable(){
        DefaultTableModel dtm = (DefaultTableModel) userTable.getModel();
        dtm.setRowCount(0);
        Connection con = null;
        try {
            con = getConnection();
            ResultSet rs = userDao.userList(con);
            while(rs.next()){
                Vector<Object> v = new Vector<>();
                v.add(rs.getInt("id"));
                v.add(rs.getString("userName"));
                v.add(rs.getString("realName"));
                v.add(rs.getString("telPhone"));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            free(con);
        }
    }

    private static int differentDaysByMillisecond(Date date1, Date date2)
    {
        int days = (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
        return days;
    }

    private void fillBorrowTable(){
        int userId = Integer.parseInt(this.userIdTxt.getText());
        User user = new User(userId);
        Date date = new Date();
        SimpleDateFormat matter=new SimpleDateFormat("yyyy-MM-dd");

        DefaultTableModel dtm = (DefaultTableModel) borrowTable.getModel();
        dtm.setRowCount(0);
        Connection con = null;
        try {
            con = getConnection();
            ResultSet rs = bookBorrowDao.borrowList(con,user);
            while(rs.next()){
                Vector<Object> v = new Vector<>();
                v.add(rs.getInt("borrowId"));
                v.add(rs.getString("bookName"));
                v.add(rs.getString("author"));
                v.add(rs.getString("pressName"));
                v.add(rs.getString("bookTypeName"));
                v.add(rs.getString("borrowTime"));
                String db_BorrowTime = rs.getString("borrowTime");
                Date borrowTime = matter.parse(db_BorrowTime);
                int time = 30 - differentDaysByMillisecond(borrowTime,date);
                v.add(time);
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            free(con);
        }
    }

    private void userTableMousePressed(MouseEvent e) {
        int row = this.userTable.getSelectedRow();
        this.userIdTxt.setText(String.valueOf(userTable.getValueAt(row,0)));
        this.realNameTxt.setText(String.valueOf(userTable.getValueAt(row,2)));
        this.telPhoneTxt.setText(String.valueOf(userTable.getValueAt(row,3)));
        this.fillBorrowTable();

    }

    private void jb_userUpdateActionPerformed(ActionEvent e) {
        int userId = Integer.parseInt(this.userIdTxt.getText());
        String realName = this.realNameTxt.getText();
        String telPhone = this.telPhoneTxt.getText();
        String password = String.valueOf(this.passwordTxt.getPassword());
        String passwordConf = String.valueOf(this.passwordConfTxt.getPassword());
        if(StringUtil.isEmpty(realName)){
            JOptionPane.showMessageDialog(null,"请输入要修改的姓名");
            return;
        }
        if(StringUtil.isEmpty(telPhone)){
            JOptionPane.showMessageDialog(null,"请输入要修改的联系方式");
            return;
        }


        User user = new User(realName, telPhone, password, userId);
        Connection con = null;
        try {
            con= getConnection();
            int updateNum = UserDao.userUpdate(con,user);
            if(updateNum == 1){
                JOptionPane.showMessageDialog(null,"修改成功");
                this.fillUserTable();
                this.resetValue();
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
        if(StringUtil.isEmpty(this.userIdTxt.getText())){
            JOptionPane.showMessageDialog(null,"请选择用户");
        }
        int userId = Integer.parseInt(this.userIdTxt.getText());
        String password = String.valueOf(this.passwordTxt.getPassword());
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
                this.fillUserTable();
                this.resetValue();

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

    private void resetValue(){
        this.userIdTxt.setText("");
        this.realNameTxt.setText("");
        this.telPhoneTxt.setText("");
        this.passwordTxt.setText("");
        this.passwordConfTxt.setText("");
    }

    private void jb_borrowDeleteActionPerformed(ActionEvent e) {
        int borrowId = UserInformationManage.borrowId;
        if(borrowId == 0){
            JOptionPane.showMessageDialog(null,"请选择要删除的记录");
            return;
        }
        int n = JOptionPane.showConfirmDialog(null,"确定要删除这条记录吗");
        if(n==0){
            Connection con = null;
            try {
                con= getConnection();
                int deleteNum = bookBorrowDao.borrowDelete(con,borrowId);
                if(deleteNum == 1){
                    JOptionPane.showMessageDialog(null,"删除成功");
                    this.fillBorrowTable();
                }else {
                    JOptionPane.showMessageDialog(null, "删除失败");
                }

            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null,"删除失败");
            }finally {
                free(con);
            }
        }
    }

    private void borrowTableMousePressed(MouseEvent e) {
        int row = this.borrowTable.getSelectedRow();
        borrowId = (int) this.borrowTable.getValueAt(row,0);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - siyuan zheng
        scrollPane1 = new JScrollPane();
        userTable = new JTable();
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        realNameTxt = new JTextField();
        telPhoneTxt = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        label6 = new JLabel();
        userIdTxt = new JTextField();
        jb_userUpdate = new JButton();
        panel2 = new JPanel();
        passwordTxt = new JPasswordField();
        passwordConfTxt = new JPasswordField();
        label4 = new JLabel();
        label5 = new JLabel();
        jb_passwordUpdate = new JButton();
        scrollPane2 = new JScrollPane();
        borrowTable = new JTable();
        jb_borrowDelete = new JButton();
        label1 = new JLabel();

        //======== this ========
        setTitle("\u7528\u6237\u7ba1\u7406");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- userTable ----
            userTable.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null},
                    {null, null, null, null},
                },
                new String[] {
                    "\u7528\u6237ID", "\u7528\u6237\u540d", "\u59d3\u540d", "\u8054\u7cfb\u65b9\u5f0f"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            userTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    userTableMousePressed(e);
                }
            });
            scrollPane1.setViewportView(userTable);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(35, 25, 610, 180);

        //======== tabbedPane1 ========
        {

            //======== panel1 ========
            {
                panel1.setLayout(null);
                panel1.add(realNameTxt);
                realNameTxt.setBounds(400, 28, 180, realNameTxt.getPreferredSize().height);
                panel1.add(telPhoneTxt);
                telPhoneTxt.setBounds(105, 100, 180, telPhoneTxt.getPreferredSize().height);

                //---- label2 ----
                label2.setText("\u59d3\u540d");
                label2.setFont(label2.getFont().deriveFont(label2.getFont().getSize() + 3f));
                panel1.add(label2);
                label2.setBounds(new Rectangle(new Point(355, 30), label2.getPreferredSize()));

                //---- label3 ----
                label3.setText("\u8054\u7cfb\u65b9\u5f0f");
                label3.setFont(label3.getFont().deriveFont(label3.getFont().getSize() + 3f));
                panel1.add(label3);
                label3.setBounds(new Rectangle(new Point(25, 102), label3.getPreferredSize()));

                //---- label6 ----
                label6.setText("\u7528\u6237ID");
                label6.setFont(label6.getFont().deriveFont(label6.getFont().getSize() + 3f));
                panel1.add(label6);
                label6.setBounds(new Rectangle(new Point(41, 30), label6.getPreferredSize()));

                //---- userIdTxt ----
                userIdTxt.setEditable(false);
                panel1.add(userIdTxt);
                userIdTxt.setBounds(105, 28, 180, userIdTxt.getPreferredSize().height);

                //---- jb_userUpdate ----
                jb_userUpdate.setText("\u4fee\u6539");
                jb_userUpdate.setFont(jb_userUpdate.getFont().deriveFont(jb_userUpdate.getFont().getSize() + 3f));
                jb_userUpdate.addActionListener(e -> jb_userUpdateActionPerformed(e));
                panel1.add(jb_userUpdate);
                jb_userUpdate.setBounds(new Rectangle(new Point(440, 100), jb_userUpdate.getPreferredSize()));

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
            tabbedPane1.addTab("\u7528\u6237\u4fe1\u606f\u66f4\u6539", panel1);

            //======== panel2 ========
            {
                panel2.setLayout(null);
                panel2.add(passwordTxt);
                passwordTxt.setBounds(150, 30, 225, passwordTxt.getPreferredSize().height);
                panel2.add(passwordConfTxt);
                passwordConfTxt.setBounds(150, 100, 225, passwordConfTxt.getPreferredSize().height);

                //---- label4 ----
                label4.setText("\u5bc6\u7801");
                label4.setFont(label4.getFont().deriveFont(label4.getFont().getSize() + 3f));
                panel2.add(label4);
                label4.setBounds(new Rectangle(new Point(95, 34), label4.getPreferredSize()));

                //---- label5 ----
                label5.setText("\u91cd\u590d\u5bc6\u7801");
                label5.setFont(label5.getFont().deriveFont(label5.getFont().getSize() + 3f));
                panel2.add(label5);
                label5.setBounds(new Rectangle(new Point(63, 104), label5.getPreferredSize()));

                //---- jb_passwordUpdate ----
                jb_passwordUpdate.setText("\u4fee\u6539");
                jb_passwordUpdate.setFont(jb_passwordUpdate.getFont().deriveFont(jb_passwordUpdate.getFont().getSize() + 3f));
                jb_passwordUpdate.addActionListener(e -> jb_passwordUpdateActionPerformed(e));
                panel2.add(jb_passwordUpdate);
                jb_passwordUpdate.setBounds(new Rectangle(new Point(440, 100), jb_passwordUpdate.getPreferredSize()));

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
            tabbedPane1.addTab("\u7528\u6237\u5bc6\u7801\u66f4\u6539", panel2);
        }
        contentPane.add(tabbedPane1);
        tabbedPane1.setBounds(35, 220, 615, 185);

        //======== scrollPane2 ========
        {

            //---- borrowTable ----
            borrowTable.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                },
                new String[] {
                    "\u501f\u9605\u7f16\u53f7", "\u56fe\u4e66\u540d\u79f0", "\u56fe\u4e66\u4f5c\u8005", "\u51fa\u7248\u793e", "\u56fe\u4e66\u7c7b\u522b", "\u501f\u9605\u65e5\u671f", "\u5269\u4f59\u65f6\u957f"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false, true, true, true, true, true, true
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            {
                TableColumnModel cm = borrowTable.getColumnModel();
                cm.getColumn(5).setPreferredWidth(120);
            }
            borrowTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    borrowTableMousePressed(e);
                }
            });
            scrollPane2.setViewportView(borrowTable);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(35, 430, 615, 150);

        //---- jb_borrowDelete ----
        jb_borrowDelete.setText("\u5220\u9664\u501f\u9605");
        jb_borrowDelete.setFont(jb_borrowDelete.getFont().deriveFont(jb_borrowDelete.getFont().getSize() + 3f));
        jb_borrowDelete.addActionListener(e -> jb_borrowDeleteActionPerformed(e));
        contentPane.add(jb_borrowDelete);
        jb_borrowDelete.setBounds(new Rectangle(new Point(530, 610), jb_borrowDelete.getPreferredSize()));
        contentPane.add(label1);
        label1.setBounds(0, 0, 680, 670);

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
    private JScrollPane scrollPane1;
    private JTable userTable;
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTextField realNameTxt;
    private JTextField telPhoneTxt;
    private JLabel label2;
    private JLabel label3;
    private JLabel label6;
    private JTextField userIdTxt;
    private JButton jb_userUpdate;
    private JPanel panel2;
    private JPasswordField passwordTxt;
    private JPasswordField passwordConfTxt;
    private JLabel label4;
    private JLabel label5;
    private JButton jb_passwordUpdate;
    private JScrollPane scrollPane2;
    private JTable borrowTable;
    private JButton jb_borrowDelete;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
