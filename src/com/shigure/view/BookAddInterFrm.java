/*
 * Created by JFormDesigner on Mon Nov 27 21:42:28 CST 2017
 */

package com.shigure.view;

import java.awt.event.*;
import com.shigure.dao.BookDao;
import com.shigure.dao.BookTypeDao;
import com.shigure.model.Book;
import com.shigure.model.BookType;
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
    private BookDao bookDao = new BookDao();

    BookAddInterFrm() {
        initComponents();
        this.fillBookType();
        //this.jcb_BookType.setSelectedIndex(0);
    }

    private void fillBookType(){                             //获取图书类型添加到选择框中
        Connection con = null;
        BookType bookType = null;
        try {
            con = getConnection();
            ResultSet rs = BookTypeDao.bookTypeList(con,new BookType());
            bookType = new BookType();
            bookType.setBookTypeName("请选择...");
            bookType.setId(-1);                             //将索引为-1的选项设为“请选择...”
            this.jcb_BookType.addItem(bookType);
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

    private void button2ActionPerformed(ActionEvent e) {        //重置输入框
        this.bookNameTxt.setText("");
        this.authorTxt.setText("");
        this.pressNameTxt.setText("");
        this.jcb_BookType.setSelectedIndex(0);
        this.bookDescTxt.setText("");
    }

    private void button1ActionPerformed(ActionEvent e) {        //添加图书
        String bookName = this.bookNameTxt.getText();
        String author = this.authorTxt.getText();
        String pressName = this.pressNameTxt.getText();
        String bookDesc = this.bookDescTxt.getText();

        if(StringUtil.isEmpty(bookName)){
            JOptionPane.showMessageDialog(null,"图书名称不能为空");
            return;
        }
        if(StringUtil.isEmpty(author)){
            JOptionPane.showMessageDialog(null,"图书作者不能为空");
            return;
        }
        if(StringUtil.isEmpty(pressName)){
            JOptionPane.showMessageDialog(null,"出版社不能为空");
            return;
        }

        BookType bookType = (BookType) this.jcb_BookType.getSelectedItem();     //获取选择框中的内容
        int bookTypeId = bookType.getId();                                      //获取bookTypeId

        Book book = new Book(bookName,author,pressName,bookDesc,bookTypeId);

        Connection con = null;

        try {
            con = getConnection();
            int addNum = bookDao.bookAdd(con,book);                             //获取return值
            if(addNum == 1 ){                                                   //return为1时即添加成功
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
        pressNameTxt = new JTextField();
        label5 = new JLabel();
        jcb_BookType = new JComboBox();
        label6 = new JLabel();
        jb_add = new JButton();
        jb_reset = new JButton();
        scrollPane1 = new JScrollPane();
        bookDescTxt = new JTextArea();
        label3 = new JLabel();

        //======== this ========
        setResizable(false);
        setTitle("\u56fe\u4e66\u6dfb\u52a0");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u56fe\u4e66\u540d\u79f0");
        label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        label1.setForeground(new Color(51, 51, 51));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(29, 65), label1.getPreferredSize()));

        //---- bookNameTxt ----
        bookNameTxt.setBackground(Color.white);
        bookNameTxt.setForeground(new Color(51, 51, 51));
        contentPane.add(bookNameTxt);
        bookNameTxt.setBounds(120, 63, 170, bookNameTxt.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u56fe\u4e66\u4f5c\u8005");
        label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        label2.setForeground(new Color(51, 51, 51));
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(320, 65), label2.getPreferredSize()));

        //---- authorTxt ----
        authorTxt.setBackground(Color.white);
        authorTxt.setForeground(new Color(51, 51, 51));
        contentPane.add(authorTxt);
        authorTxt.setBounds(410, 65, 170, 24);

        //---- label4 ----
        label4.setText("\u51fa\u7248\u793e");
        label4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        label4.setForeground(new Color(51, 51, 51));
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(45, 147), label4.getPreferredSize()));

        //---- pressNameTxt ----
        pressNameTxt.setBackground(Color.white);
        pressNameTxt.setForeground(new Color(51, 51, 51));
        contentPane.add(pressNameTxt);
        pressNameTxt.setBounds(120, 145, 170, 24);

        //---- label5 ----
        label5.setText("\u56fe\u4e66\u7c7b\u522b");
        label5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        label5.setForeground(new Color(51, 51, 51));
        contentPane.add(label5);
        label5.setBounds(320, 149, label5.getPreferredSize().width, 17);

        //---- jcb_BookType ----
        jcb_BookType.setBackground(Color.white);
        jcb_BookType.setForeground(new Color(51, 51, 51));
        jcb_BookType.setBorder(null);
        contentPane.add(jcb_BookType);
        jcb_BookType.setBounds(410, 145, 170, 24);

        //---- label6 ----
        label6.setText("\u56fe\u4e66\u63cf\u8ff0");
        label6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        label6.setForeground(new Color(51, 51, 51));
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(35, 230), label6.getPreferredSize()));

        //---- jb_add ----
        jb_add.setText("\u6dfb\u52a0");
        jb_add.setContentAreaFilled(false);
        jb_add.setForeground(new Color(51, 51, 51));
        jb_add.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        jb_add.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(jb_add);
        jb_add.setBounds(new Rectangle(new Point(515, 390), jb_add.getPreferredSize()));

        //---- jb_reset ----
        jb_reset.setText("\u91cd\u7f6e");
        jb_reset.setContentAreaFilled(false);
        jb_reset.setForeground(new Color(51, 51, 51));
        jb_reset.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 16));
        jb_reset.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(jb_reset);
        jb_reset.setBounds(new Rectangle(new Point(415, 390), jb_reset.getPreferredSize()));

        //======== scrollPane1 ========
        {
            scrollPane1.setBorder(null);

            //---- bookDescTxt ----
            bookDescTxt.setForeground(new Color(51, 51, 51));
            bookDescTxt.setBackground(Color.white);
            bookDescTxt.setLineWrap(true);
            scrollPane1.setViewportView(bookDescTxt);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(120, 225, 460, 120);

        //---- label3 ----
        label3.setIcon(null);
        contentPane.add(label3);
        label3.setBounds(0, 0, 620, 480);

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
    private JTextField pressNameTxt;
    private JLabel label5;
    private JComboBox jcb_BookType;
    private JLabel label6;
    private JButton jb_add;
    private JButton jb_reset;
    private JScrollPane scrollPane1;
    private JTextArea bookDescTxt;
    private JLabel label3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
