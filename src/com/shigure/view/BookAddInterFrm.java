/*
 * Created by JFormDesigner on Mon Nov 27 21:42:28 CST 2017
 */

package com.shigure.view;

import com.shigure.dao.BookDao;
import com.shigure.dao.BookTypeDao;
import com.shigure.model.BookType;
import com.shigure.util.DbUtil;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.*;

import static com.shigure.util.DbUtil.free;
import static com.shigure.util.DbUtil.getConnection;

/**
 * @author siyuan zheng
 */
public class BookAddInterFrm extends JFrame {

    DbUtil dbUtil = new DbUtil();
    BookTypeDao bookTypeDao = new BookTypeDao();
    BookDao bookDao = new BookDao();

    public BookAddInterFrm() {
        initComponents();
        this.setLocation(200,50);
        this.fillBookType();
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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - siyuan zheng
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        radioButton1 = new JRadioButton();
        radioButton2 = new JRadioButton();
        label4 = new JLabel();
        textField3 = new JTextField();
        label5 = new JLabel();
        jcb_BookType = new JComboBox();
        label6 = new JLabel();
        textArea1 = new JTextArea();
        button1 = new JButton();
        button2 = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u56fe\u4e66\u540d\u79f0");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(35, 45), label1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(100, 40, 145, textField1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u56fe\u4e66\u4f5c\u8005");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(275, 45), label2.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(330, 40, 125, textField2.getPreferredSize().height);

        //---- label3 ----
        label3.setText("\u6027\u522b");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(45, 125), label3.getPreferredSize()));

        //---- radioButton1 ----
        radioButton1.setText("\u7537");
        contentPane.add(radioButton1);
        radioButton1.setBounds(new Rectangle(new Point(115, 120), radioButton1.getPreferredSize()));

        //---- radioButton2 ----
        radioButton2.setText("\u5973");
        contentPane.add(radioButton2);
        radioButton2.setBounds(new Rectangle(new Point(180, 120), radioButton2.getPreferredSize()));

        //---- label4 ----
        label4.setText("\u56fe\u4e66\u4ef7\u683c");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(275, 130), label4.getPreferredSize()));
        contentPane.add(textField3);
        textField3.setBounds(335, 125, 125, textField3.getPreferredSize().height);

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
        contentPane.add(textArea1);
        textArea1.setBounds(110, 265, 345, 120);

        //---- button1 ----
        button1.setText("\u6dfb\u52a0");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(50, 425), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("\u91cd\u7f6e");
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
        buttonGroup1.add(radioButton1);
        buttonGroup1.add(radioButton2);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - siyuan zheng
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JLabel label4;
    private JTextField textField3;
    private JLabel label5;
    private JComboBox jcb_BookType;
    private JLabel label6;
    private JTextArea textArea1;
    private JButton button1;
    private JButton button2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
