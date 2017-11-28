/*
 * Created by JFormDesigner on Mon Nov 27 21:42:28 CST 2017
 */

package com.shigure.view;

import java.awt.event.*;
import com.shigure.dao.BookDao;
import com.shigure.dao.BookTypeDao;
import com.shigure.model.Book;
import com.shigure.model.BookType;
import com.shigure.util.DbUtil;
import com.shigure.util.StringUtil;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.*;

import static com.shigure.util.DbUtil.free;
import static com.shigure.util.DbUtil.getConnection;

/**
 * @author siyuan zheng
 */
class BookAddInterFrm extends JFrame {

    DbUtil dbUtil = new DbUtil();
    BookTypeDao bookTypeDao = new BookTypeDao();
    BookDao bookDao = new BookDao();

    BookAddInterFrm() {
        initComponents();
        this.setLocation(200,50);
        this.fillBookType();
        this.jcb_BookType.setSelectedIndex(0);
    }

    private void fillBookType(){
        Connection con = null;
        BookType bookType = null;
        try {
            con = getConnection();
            ResultSet rs = BookTypeDao.bookTypeList(con,new BookType());
            while(rs.next()){
                bookType = new BookType();
                bookType.setId(rs.getInt("id"));
                bookType.setBookTypeName(rs.getString("bookTypeName"));
                this.jcb_BookType.addItem(bookType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            free(con);
        }
    }

    private void button2ActionPerformed(ActionEvent e) {
        this.bookNameTxt.setText("");
        this.authorTxt.setText("");
        this.priceTxt.setText("");
        this.jcb_BookType.setSelectedIndex(0);
        this.bookDescTxt.setText("");
    }

    private void button1ActionPerformed(ActionEvent e) {
        String bookName = this.bookNameTxt.getText();
        String author = this.authorTxt.getText();
        String price = this.priceTxt.getText();
        String bookDesc = this.bookDescTxt.getText();

        if(StringUtil.isEmpty(bookName)){
            JOptionPane.showMessageDialog(null,"图书名称不能为空");
            return;
        }
        if(StringUtil.isEmpty(author)){
            JOptionPane.showMessageDialog(null,"图书作者不能为空");
            return;
        }
        if(StringUtil.isEmpty(price)){
            JOptionPane.showMessageDialog(null,"图书价格不能为空");
            return;
        }



        BookType bookType = (BookType) this.jcb_BookType.getSelectedItem();
        int bookTypeId = bookType.getId();

        Book book = new Book(bookName,author,Float.parseFloat(price),bookDesc,bookTypeId);

        Connection con = null;

        try {
            con = getConnection();
            int addNum = bookDao.bookAdd(con,book);
            if(addNum == 1 ){
                JOptionPane.showMessageDialog(null,"图书添加成功");
            }else {
                JOptionPane.showMessageDialog(null,"图书添加失败");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null,"图书添加失败");
        }finally {
            free(con);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - siyuan zheng
        label1 = new JLabel();
        bookNameTxt = new JTextField();
        label2 = new JLabel();
        authorTxt = new JTextField();
        label4 = new JLabel();
        priceTxt = new JTextField();
        label5 = new JLabel();
        jcb_BookType = new JComboBox();
        label6 = new JLabel();
        bookDescTxt = new JTextArea();
        button1 = new JButton();
        button2 = new JButton();
        label3 = new JLabel();

        //======== this ========
        setResizable(false);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u56fe\u4e66\u540d\u79f0");
        label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        label1.setForeground(new Color(51, 51, 51));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(45, 65), label1.getPreferredSize()));

        //---- bookNameTxt ----
        bookNameTxt.setBorder(null);
        bookNameTxt.setBackground(new Color(204, 204, 204));
        bookNameTxt.setForeground(new Color(51, 51, 51));
        contentPane.add(bookNameTxt);
        bookNameTxt.setBounds(115, 60, 145, 25);

        //---- label2 ----
        label2.setText("\u56fe\u4e66\u4f5c\u8005");
        label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        label2.setForeground(new Color(51, 51, 51));
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(320, 65), label2.getPreferredSize()));

        //---- authorTxt ----
        authorTxt.setBorder(null);
        authorTxt.setBackground(new Color(204, 204, 204));
        authorTxt.setForeground(new Color(51, 51, 51));
        contentPane.add(authorTxt);
        authorTxt.setBounds(395, 60, 145, 25);

        //---- label4 ----
        label4.setText("\u56fe\u4e66\u4ef7\u683c");
        label4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        label4.setForeground(new Color(51, 51, 51));
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(45, 150), label4.getPreferredSize()));

        //---- priceTxt ----
        priceTxt.setBorder(null);
        priceTxt.setBackground(new Color(204, 204, 204));
        priceTxt.setForeground(new Color(51, 51, 51));
        contentPane.add(priceTxt);
        priceTxt.setBounds(115, 145, 145, 25);

        //---- label5 ----
        label5.setText("\u56fe\u4e66\u7c7b\u522b");
        label5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        label5.setForeground(new Color(51, 51, 51));
        contentPane.add(label5);
        label5.setBounds(320, 150, label5.getPreferredSize().width, 17);

        //---- jcb_BookType ----
        jcb_BookType.setBackground(new Color(204, 204, 204));
        jcb_BookType.setForeground(new Color(51, 51, 51));
        jcb_BookType.setBorder(null);
        contentPane.add(jcb_BookType);
        jcb_BookType.setBounds(395, 145, 145, 25);

        //---- label6 ----
        label6.setText("\u56fe\u4e66\u63cf\u8ff0");
        label6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 14));
        label6.setForeground(new Color(51, 51, 51));
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(45, 225), label6.getPreferredSize()));

        //---- bookDescTxt ----
        bookDescTxt.setBorder(null);
        bookDescTxt.setForeground(new Color(51, 51, 51));
        bookDescTxt.setBackground(new Color(204, 204, 204));
        contentPane.add(bookDescTxt);
        bookDescTxt.setBounds(115, 220, 425, 120);

        //---- button1 ----
        button1.setText("\u6dfb\u52a0");
        button1.setContentAreaFilled(false);
        button1.setBorder(null);
        button1.setForeground(new Color(51, 51, 51));
        button1.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(450, 375, 90, 35);

        //---- button2 ----
        button2.setText("\u91cd\u7f6e");
        button2.setBorder(null);
        button2.setContentAreaFilled(false);
        button2.setForeground(new Color(51, 51, 51));
        button2.setFont(new Font("Microsoft YaHei UI", Font.BOLD, 14));
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2);
        button2.setBounds(115, 375, 90, 35);

        //---- label3 ----
        label3.setIcon(new ImageIcon(getClass().getResource("/com/shigure/material/timg.jpg")));
        contentPane.add(label3);
        label3.setBounds(0, 0, 585, 470);

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
    private JTextField bookNameTxt;
    private JLabel label2;
    private JTextField authorTxt;
    private JLabel label4;
    private JTextField priceTxt;
    private JLabel label5;
    private JComboBox jcb_BookType;
    private JLabel label6;
    private JTextArea bookDescTxt;
    private JButton button1;
    private JButton button2;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
