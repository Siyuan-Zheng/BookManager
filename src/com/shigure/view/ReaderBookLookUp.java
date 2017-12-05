/*
 * Created by JFormDesigner on Tue Dec 05 21:55:28 CST 2017
 */

package com.shigure.view;

import com.shigure.dao.BookBorrowDao;
import com.shigure.dao.BookDao;
import com.shigure.dao.BookTypeDao;
import com.shigure.model.Book;
import com.shigure.model.BookBorrow;
import com.shigure.model.BookType;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;

import static com.shigure.util.DbUtil.free;
import static com.shigure.util.DbUtil.getConnection;

/**
 * @author siyuan zheng
 */
public class ReaderBookLookUp extends JFrame {
    BookDao bookDao = new BookDao();
    BookBorrowDao bookBorrowDao = new BookBorrowDao();
    static int bookId = 0;

    public ReaderBookLookUp() {
        initComponents();
        this.fillTable(new Book());
        this.fillBookType();
    }

    private void fillBookType(){
        Connection con = null;
        BookType bookType = null;
        try {
            con = getConnection();
            ResultSet rs = BookTypeDao.bookTypeList(con,new BookType());
                bookType = new BookType();
                bookType.setBookTypeName("请选择...");
                bookType.setId(-1);
                this.s_jcb_bookType.addItem(bookType);
            while(rs.next()){
                bookType = new BookType();
                bookType.setId(rs.getInt("id"));
                bookType.setBookTypeName(rs.getString("bookTypeName"));
                this.s_jcb_bookType.addItem(bookType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            free(con);
        }
    }

    private void fillTable(Book book){
        DefaultTableModel dtm = (DefaultTableModel) bookTable.getModel();
        dtm.setRowCount(0);
        Connection con = null;
        try {
            con = getConnection();
            ResultSet rs = bookDao.bookList(con, book);
            while(rs.next()){
                Vector v = new Vector<>();
                v.add(rs.getInt("id"));
                v.add(rs.getString("bookName"));
                v.add(rs.getString("author"));
                v.add(rs.getFloat("price"));
                v.add(rs.getString("bookDesc"));
                v.add(rs.getString("bookTypeName"));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            free(con);
        }
    }

    private void jb_searchActionPerformed(ActionEvent e) {
        String bookName = this.s_bookNameTxt.getText();
        String author = this.s_authorTxt.getText();
        BookType bookType = (BookType)this.s_jcb_bookType.getSelectedItem();
        int bookTypeId = bookType.getId();

        Book book = new Book(bookName, author, bookTypeId);

        this.fillTable(book);
    }

    private void jb_addBookBorrowActionPerformed(ActionEvent e) {
        int userId = ReaderDashBoard.uid;
        int bookId = ReaderBookLookUp.bookId;
        java.util.Date date = new java.util.Date();
        java.sql.Date borrowTime = new java.sql.Date(date.getTime());

        BookBorrow bookBorrow = new BookBorrow(userId,bookId,borrowTime);

        Connection con = null;

        try {
            con = getConnection();
            int addNum = bookBorrowDao.borrowAdd(con,bookBorrow);               //获取return值
            if(addNum == 1 ){                                                   //return为1时即添加成功
                JOptionPane.showMessageDialog(null,"图书借阅成功");
            }else {
                JOptionPane.showMessageDialog(null,"图书借阅失败");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null,"图书借阅失败");
        }finally {
            free(con);
        }
    }

    private void bookTableMousePressed(MouseEvent e) {
        int row = this.bookTable.getSelectedRow();
        ReaderBookLookUp.bookId = Integer.parseInt(String.valueOf(bookTable.getValueAt(row,0)));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - siyuan zheng
        label1 = new JLabel();
        s_bookNameTxt = new JTextField();
        label2 = new JLabel();
        s_authorTxt = new JTextField();
        label3 = new JLabel();
        jb_search = new JButton();
        scrollPane1 = new JScrollPane();
        bookTable = new JTable();
        s_jcb_bookType = new JComboBox();
        jb_addBookBorrow = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u56fe\u4e66\u540d\u79f0");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(30, 20), label1.getPreferredSize()));
        contentPane.add(s_bookNameTxt);
        s_bookNameTxt.setBounds(95, 20, 150, s_bookNameTxt.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u56fe\u4e66\u4f5c\u8005");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(295, 25), label2.getPreferredSize()));
        contentPane.add(s_authorTxt);
        s_authorTxt.setBounds(360, 20, 155, s_authorTxt.getPreferredSize().height);

        //---- label3 ----
        label3.setText("\u56fe\u4e66\u7c7b\u522b");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(25, 75), label3.getPreferredSize()));

        //---- jb_search ----
        jb_search.setText("\u67e5\u8be2");
        jb_search.addActionListener(e -> jb_searchActionPerformed(e));
        contentPane.add(jb_search);
        jb_search.setBounds(new Rectangle(new Point(305, 70), jb_search.getPreferredSize()));

        //======== scrollPane1 ========
        {

            //---- bookTable ----
            bookTable.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null},
                },
                new String[] {
                    "\u7f16\u53f7", "\u56fe\u4e66\u540d\u79f0", "\u56fe\u4e66\u4f5c\u8005", "\u56fe\u4e66\u4ef7\u683c", "\u56fe\u4e66\u63cf\u8ff0", "\u56fe\u4e66\u7c7b\u522b"
                }
            ) {
                boolean[] columnEditable = new boolean[] {
                    false, false, false, false, false, false
                };
                @Override
                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return columnEditable[columnIndex];
                }
            });
            bookTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    bookTableMousePressed(e);
                }
            });
            scrollPane1.setViewportView(bookTable);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(20, 135, 550, 220);
        contentPane.add(s_jcb_bookType);
        s_jcb_bookType.setBounds(105, 75, 120, s_jcb_bookType.getPreferredSize().height);

        //---- jb_addBookBorrow ----
        jb_addBookBorrow.setText("text");
        jb_addBookBorrow.addActionListener(e -> jb_addBookBorrowActionPerformed(e));
        contentPane.add(jb_addBookBorrow);
        jb_addBookBorrow.setBounds(new Rectangle(new Point(225, 435), jb_addBookBorrow.getPreferredSize()));

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
    private JTextField s_bookNameTxt;
    private JLabel label2;
    private JTextField s_authorTxt;
    private JLabel label3;
    private JButton jb_search;
    private JScrollPane scrollPane1;
    private JTable bookTable;
    private JComboBox s_jcb_bookType;
    private JButton jb_addBookBorrow;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
