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
        this.jrb_male.setSelected(true);
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
        this.jrb_male.setSelected(true);
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

        String sex = "";
        if(this.jrb_male.isSelected()){
            sex = "男";
        }else if(this.jrb_female.isSelected()){
            sex = "女";
        }

        BookType bookType = (BookType) this.jcb_BookType.getSelectedItem();
        int bookTypeId = bookType.getId();

        Book book = new Book(bookName,author,sex,Float.parseFloat(price),bookDesc,bookTypeId);

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
        label3 = new JLabel();
        jrb_male = new JRadioButton();
        jrb_female = new JRadioButton();
        label4 = new JLabel();
        priceTxt = new JTextField();
        label5 = new JLabel();
        jcb_BookType = new JComboBox();
        label6 = new JLabel();
        bookDescTxt = new JTextArea();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u56fe\u4e66\u540d\u79f0");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(35, 45), label1.getPreferredSize()));
        contentPane.add(bookNameTxt);
        bookNameTxt.setBounds(100, 40, 145, bookNameTxt.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u56fe\u4e66\u4f5c\u8005");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(275, 45), label2.getPreferredSize()));
        contentPane.add(authorTxt);
        authorTxt.setBounds(330, 40, 125, authorTxt.getPreferredSize().height);

        //---- label3 ----
        label3.setText("\u6027\u522b");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(45, 125), label3.getPreferredSize()));

        //---- jrb_male ----
        jrb_male.setText("\u7537");
        contentPane.add(jrb_male);
        jrb_male.setBounds(new Rectangle(new Point(115, 120), jrb_male.getPreferredSize()));

        //---- jrb_female ----
        jrb_female.setText("\u5973");
        contentPane.add(jrb_female);
        jrb_female.setBounds(new Rectangle(new Point(180, 120), jrb_female.getPreferredSize()));

        //---- label4 ----
        label4.setText("\u56fe\u4e66\u4ef7\u683c");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(275, 130), label4.getPreferredSize()));
        contentPane.add(priceTxt);
        priceTxt.setBounds(335, 125, 125, priceTxt.getPreferredSize().height);

        //---- label5 ----
        label5.setText("\u56fe\u4e66\u7c7b\u522b");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(45, 195), label5.getPreferredSize()));
        contentPane.add(jcb_BookType);
        jcb_BookType.setBounds(120, 190, 115, jcb_BookType.getPreferredSize().height);

        //---- label6 ----
        label6.setText("\u56fe\u4e66\u63cf\u8ff0");
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(40, 270), label6.getPreferredSize()));
        contentPane.add(bookDescTxt);
        bookDescTxt.setBounds(110, 265, 345, 120);

        //---- button1 ----
        button1.setText("\u6dfb\u52a0");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(50, 425), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u91cd\u7f6e");
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(150, 425), button2.getPreferredSize()));

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
        buttonGroup1.add(jrb_male);
        buttonGroup1.add(jrb_female);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - siyuan zheng
    private JLabel label1;
    private JTextField bookNameTxt;
    private JLabel label2;
    private JTextField authorTxt;
    private JLabel label3;
    private JRadioButton jrb_male;
    private JRadioButton jrb_female;
    private JLabel label4;
    private JTextField priceTxt;
    private JLabel label5;
    private JComboBox jcb_BookType;
    private JLabel label6;
    private JTextArea bookDescTxt;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
