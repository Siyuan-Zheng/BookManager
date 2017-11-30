/*
 * Created by JFormDesigner on Sun Nov 26 22:50:16 CST 2017
 */

package com.shigure.view;

import com.shigure.dao.BookTypeDao;
import com.shigure.model.BookType;
import com.shigure.util.StringUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;

import static com.shigure.util.DbUtil.getConnection;

/**
 * @author siyuan zheng
 */
class BookTypeInterFrm extends JFrame {
    private BookTypeDao bookTypeDao = new BookTypeDao();

    BookTypeInterFrm() {
        initComponents();
    }

    private void jb_ResetActionPerformed(ActionEvent e) {
        this.bookTypeNameTxt.setText("");
        this.bookTypeDescTxt.setText("");
    }

    private void jb_AddActionPerformed(ActionEvent e) {
        String bookTypeName = this.bookTypeNameTxt.getText();
        String bookTypeDesc = this.bookTypeDescTxt.getText();
        if(StringUtil.isEmpty(bookTypeName)){
            JOptionPane.showMessageDialog(null,"图书类别不能为空");
            return;
        }
        BookType bookType = new BookType(bookTypeName,bookTypeDesc);
        Connection con;
        try {
            con = getConnection();
            int n = bookTypeDao.bookTypeAdd(con,bookType);
            if(n==1){
                JOptionPane.showMessageDialog(null,"图书类别添加成功");
                this.bookTypeNameTxt.setText("");
                this.bookTypeDescTxt.setText("");
            }
            else {
                JOptionPane.showMessageDialog(null,"图书类别添加失败");
            }

        } catch (Exception e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null,"图书类别添加失败");

        }

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - siyuan zheng
        bookTypeNameTxt = new JTextField();
        scrollPane1 = new JScrollPane();
        bookTypeDescTxt = new JTextArea();
        jb_Add = new JButton();
        jb_Reset = new JButton();
        label1 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        contentPane.add(bookTypeNameTxt);
        bookTypeNameTxt.setBounds(185, 50, 120, bookTypeNameTxt.getPreferredSize().height);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(bookTypeDescTxt);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(155, 110, 210, 135);

        //---- jb_Add ----
        jb_Add.setText("\u6dfb\u52a0");
        jb_Add.addActionListener(e -> jb_AddActionPerformed(e));
        contentPane.add(jb_Add);
        jb_Add.setBounds(new Rectangle(new Point(145, 275), jb_Add.getPreferredSize()));

        //---- jb_Reset ----
        jb_Reset.setText("\u91cd\u7f6e");
        jb_Reset.addActionListener(e -> jb_ResetActionPerformed(e));
        contentPane.add(jb_Reset);
        jb_Reset.setBounds(new Rectangle(new Point(300, 280), jb_Reset.getPreferredSize()));

        //---- label1 ----
        label1.setText("text");
        label1.setIcon(new ImageIcon(getClass().getResource("/com/shigure/material/\u672a\u6807\u9898-1.png")));
        contentPane.add(label1);
        label1.setBounds(0, 0, 500, 350);

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
    private JTextField bookTypeNameTxt;
    private JScrollPane scrollPane1;
    private JTextArea bookTypeDescTxt;
    private JButton jb_Add;
    private JButton jb_Reset;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
