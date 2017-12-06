/*
 * Created by JFormDesigner on Wed Dec 06 21:54:52 CST 2017
 */

package com.shigure.view;

import com.shigure.dao.BookRecommendDao;
import com.shigure.dao.BookTypeDao;
import com.shigure.model.Book;
import com.shigure.model.BookRecommend;
import com.shigure.model.BookType;
import com.shigure.util.StringUtil;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.*;

import static com.shigure.util.DbUtil.free;
import static com.shigure.util.DbUtil.getConnection;

/**
 * @author siyuan zheng
 */
public class ReaderBookRecommend extends JFrame {
    BookRecommendDao bookRecommendDao = new BookRecommendDao();

    public ReaderBookRecommend() {
        initComponents();
        this.fillBookType();
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


    private void jb_recommendAddActionPerformed(ActionEvent e) {
        int userId = ReaderDashBoard.uid;
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

        BookRecommend bookRecommend = new BookRecommend(userId,bookName,author,"待处理",pressName,bookDesc,bookTypeId);

        Connection con = null;

        try {
            con = getConnection();
            int addNum = bookRecommendDao.recommendAdd(con,bookRecommend);                             //获取return值
            if(addNum == 1 ){                                                   //return为1时即添加成功
                JOptionPane.showMessageDialog(null,"图书建购成功");
            }else {
                JOptionPane.showMessageDialog(null,"图书建购失败");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null,"图书建购失败");
        }finally {
            free(con);
        }    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - siyuan zheng
        label1 = new JLabel();
        bookNameTxt = new JTextField();
        label2 = new JLabel();
        authorTxt = new JTextField();
        label3 = new JLabel();
        pressNameTxt = new JTextField();
        label4 = new JLabel();
        jcb_BookType = new JComboBox();
        label5 = new JLabel();
        scrollPane1 = new JScrollPane();
        bookDescTxt = new JTextArea();
        jb_recommendAdd = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u56fe\u4e66\u540d\u79f0");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(20, 25), label1.getPreferredSize()));
        contentPane.add(bookNameTxt);
        bookNameTxt.setBounds(90, 25, 100, bookNameTxt.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u4f5c\u8005");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(310, 25), label2.getPreferredSize()));
        contentPane.add(authorTxt);
        authorTxt.setBounds(350, 20, 115, authorTxt.getPreferredSize().height);

        //---- label3 ----
        label3.setText("\u51fa\u7248\u793e");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(20, 85), label3.getPreferredSize()));
        contentPane.add(pressNameTxt);
        pressNameTxt.setBounds(95, 80, 105, pressNameTxt.getPreferredSize().height);

        //---- label4 ----
        label4.setText("\u56fe\u4e66\u7c7b\u522b");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(255, 85), label4.getPreferredSize()));
        contentPane.add(jcb_BookType);
        jcb_BookType.setBounds(new Rectangle(new Point(365, 85), jcb_BookType.getPreferredSize()));

        //---- label5 ----
        label5.setText("\u56fe\u4e66\u63cf\u8ff0");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(50, 190), label5.getPreferredSize()));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(bookDescTxt);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(125, 195, 175, 160);

        //---- jb_recommendAdd ----
        jb_recommendAdd.setText("text");
        jb_recommendAdd.addActionListener(e -> jb_recommendAddActionPerformed(e));
        contentPane.add(jb_recommendAdd);
        jb_recommendAdd.setBounds(new Rectangle(new Point(350, 215), jb_recommendAdd.getPreferredSize()));

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
    private JLabel label3;
    private JTextField pressNameTxt;
    private JLabel label4;
    private JComboBox jcb_BookType;
    private JLabel label5;
    private JScrollPane scrollPane1;
    private JTextArea bookDescTxt;
    private JButton jb_recommendAdd;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
