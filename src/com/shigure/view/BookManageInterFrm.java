/*
 * Created by JFormDesigner on Fri Dec 01 21:24:59 CST 2017
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
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.*;

import static com.shigure.util.DbUtil.free;
import static com.shigure.util.DbUtil.getConnection;

/**
 * @author siyuan zheng
 */
public class BookManageInterFrm extends JFrame {
    BookTypeDao bookTypeDao = new BookTypeDao();
    BookDao bookDao = new BookDao();

    public BookManageInterFrm() {
        initComponents();
        this.fillTable(new Book());
        this.fillBookType("search");
        this.fillBookType("modify");

    }

    private void resetValue(){
        this.idTxt.setText("");
        this.bookNameTxt.setText("");
        this.authorTxt.setText("");
        this.priceTxt.setText("");
        this.bookDescTxt.setText("");
        if(this.jcb_bookType.getItemCount() > 0){
            this.jcb_bookType.setSelectedIndex(0);
        }
    }

    private void fillBookType(String type){
        Connection con = null;
        BookType bookType = null;
        try {
            con = getConnection();
            ResultSet rs = BookTypeDao.bookTypeList(con,new BookType());
            if("search".equals(type)){
                bookType = new BookType();
                bookType.setBookTypeName("请选择...");
                bookType.setId(-1);
                this.s_jcb_bookType.addItem(bookType);
            }
            while(rs.next()){
                bookType = new BookType();
                bookType.setId(rs.getInt("id"));
                bookType.setBookTypeName(rs.getString("bookTypeName"));
                if("search".equals(type)){
                    this.s_jcb_bookType.addItem(bookType);
                }else if("modify".equals(type)){
                    this.jcb_bookType.addItem(bookType);
                }
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
        this.resetValue();
    }

    private void bookTableMousePressed(MouseEvent e) {
        int row = this.bookTable.getSelectedRow();
        this.idTxt.setText((Integer)bookTable.getValueAt(row,0)+"");
        this.bookNameTxt.setText((String)bookTable.getValueAt(row,1));
        this.authorTxt.setText((String)bookTable.getValueAt(row,2));
        this.priceTxt.setText((Float)bookTable.getValueAt(row,3)+"");
        this.bookDescTxt.setText((String)bookTable.getValueAt(row,4));
        String bookTypeName = (String)bookTable.getValueAt(row,5);
        int n = this.jcb_bookType.getItemCount();
        for(int i = 0; i<n; i++){
            BookType item = (BookType)this.jcb_bookType.getItemAt(i);
            if(item.getBookTypeName().equals((bookTypeName))){
                this.jcb_bookType.setSelectedIndex(i);
            }
        }
    }

    private void jb_deleteActionPerformed(ActionEvent e) {
        String id = this.idTxt.getText();
        if(StringUtil.isEmpty(id)){
            JOptionPane.showMessageDialog(null,"请选择要删除的记录");
            return;
        }
        int n = JOptionPane.showConfirmDialog(null,"确定要删除这条记录吗");
        if(n==0){
            Connection con = null;
            try {
                con= getConnection();
                int deleteNum = bookDao.bookDelete(con,id);
                if(deleteNum == 1){
                    JOptionPane.showMessageDialog(null,"删除成功");
                    this.resetValue();
                    this.fillTable(new Book());
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

    private void jb_modifyActionPerformed(ActionEvent e) {
        String id = this.idTxt.getText();
        if(StringUtil.isEmpty(id)){
            JOptionPane.showMessageDialog(null,"请选择要修改的记录");
            return;
        }

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

        BookType bookType = (BookType) this.jcb_bookType.getSelectedItem();
        int bookTypeId = bookType.getId();



        Book book = new Book(Integer.parseInt(id), bookName, author, Float.parseFloat(price), bookDesc, bookTypeId);
        Connection con = null;
        try {
            con= getConnection();
            int updateNum = bookDao.bookUpdate(con,book);
            if(updateNum == 1){
                JOptionPane.showMessageDialog(null,"修改成功");
                this.resetValue();
                this.fillTable(new Book());
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
        scrollPane1 = new JScrollPane();
        bookTable = new JTable();
        label1 = new JLabel();
        s_bookNameTxt = new JTextField();
        label4 = new JLabel();
        s_authorTxt = new JTextField();
        label5 = new JLabel();
        s_jcb_bookType = new JComboBox();
        jb_search = new JButton();
        label2 = new JLabel();
        idTxt = new JTextField();
        label3 = new JLabel();
        priceTxt = new JTextField();
        label6 = new JLabel();
        bookNameTxt = new JTextField();
        label7 = new JLabel();
        authorTxt = new JTextField();
        label8 = new JLabel();
        jcb_bookType = new JComboBox();
        label9 = new JLabel();
        scrollPane2 = new JScrollPane();
        bookDescTxt = new JTextArea();
        jb_modify = new JButton();
        jb_delete = new JButton();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- bookTable ----
            bookTable.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null},
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
        scrollPane1.setBounds(25, 175, 502, 140);

        //---- label1 ----
        label1.setText("\u56fe\u4e66\u540d\u79f0");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(35, 25), label1.getPreferredSize()));
        contentPane.add(s_bookNameTxt);
        s_bookNameTxt.setBounds(100, 20, 140, s_bookNameTxt.getPreferredSize().height);

        //---- label4 ----
        label4.setText("\u56fe\u4e66\u4f5c\u8005");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(285, 20), label4.getPreferredSize()));
        contentPane.add(s_authorTxt);
        s_authorTxt.setBounds(355, 15, 145, s_authorTxt.getPreferredSize().height);

        //---- label5 ----
        label5.setText("\u56fe\u4e66\u7c7b\u522b");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(40, 105), label5.getPreferredSize()));
        contentPane.add(s_jcb_bookType);
        s_jcb_bookType.setBounds(105, 100, 100, s_jcb_bookType.getPreferredSize().height);

        //---- jb_search ----
        jb_search.setText("\u67e5\u8be2");
        jb_search.addActionListener(e -> jb_searchActionPerformed(e));
        contentPane.add(jb_search);
        jb_search.setBounds(new Rectangle(new Point(330, 100), jb_search.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u7f16\u53f7");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(40, 340), label2.getPreferredSize()));

        //---- idTxt ----
        idTxt.setEditable(false);
        contentPane.add(idTxt);
        idTxt.setBounds(80, 335, 150, idTxt.getPreferredSize().height);

        //---- label3 ----
        label3.setText("\u4ef7\u683c");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(40, 410), label3.getPreferredSize()));
        contentPane.add(priceTxt);
        priceTxt.setBounds(85, 410, 150, priceTxt.getPreferredSize().height);

        //---- label6 ----
        label6.setText("\u56fe\u4e66\u540d\u79f0");
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(260, 340), label6.getPreferredSize()));
        contentPane.add(bookNameTxt);
        bookNameTxt.setBounds(325, 340, 160, bookNameTxt.getPreferredSize().height);

        //---- label7 ----
        label7.setText("\u56fe\u4e66\u4f5c\u8005");
        contentPane.add(label7);
        label7.setBounds(new Rectangle(new Point(260, 415), label7.getPreferredSize()));
        contentPane.add(authorTxt);
        authorTxt.setBounds(325, 415, 165, authorTxt.getPreferredSize().height);

        //---- label8 ----
        label8.setText("\u56fe\u4e66\u7c7b\u522b");
        contentPane.add(label8);
        label8.setBounds(new Rectangle(new Point(30, 510), label8.getPreferredSize()));
        contentPane.add(jcb_bookType);
        jcb_bookType.setBounds(95, 505, 115, jcb_bookType.getPreferredSize().height);

        //---- label9 ----
        label9.setText("\u56fe\u4e66\u63cf\u8ff0");
        contentPane.add(label9);
        label9.setBounds(new Rectangle(new Point(260, 495), label9.getPreferredSize()));

        //======== scrollPane2 ========
        {
            scrollPane2.setViewportView(bookDescTxt);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(330, 490, 165, 85);

        //---- jb_modify ----
        jb_modify.setText("\u4fee\u6539");
        jb_modify.addActionListener(e -> jb_modifyActionPerformed(e));
        contentPane.add(jb_modify);
        jb_modify.setBounds(new Rectangle(new Point(35, 565), jb_modify.getPreferredSize()));

        //---- jb_delete ----
        jb_delete.setText("\u5220\u9664");
        jb_delete.addActionListener(e -> jb_deleteActionPerformed(e));
        contentPane.add(jb_delete);
        jb_delete.setBounds(new Rectangle(new Point(135, 565), jb_delete.getPreferredSize()));

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
    private JTable bookTable;
    private JLabel label1;
    private JTextField s_bookNameTxt;
    private JLabel label4;
    private JTextField s_authorTxt;
    private JLabel label5;
    private JComboBox s_jcb_bookType;
    private JButton jb_search;
    private JLabel label2;
    private JTextField idTxt;
    private JLabel label3;
    private JTextField priceTxt;
    private JLabel label6;
    private JTextField bookNameTxt;
    private JLabel label7;
    private JTextField authorTxt;
    private JLabel label8;
    private JComboBox jcb_bookType;
    private JLabel label9;
    private JScrollPane scrollPane2;
    private JTextArea bookDescTxt;
    private JButton jb_modify;
    private JButton jb_delete;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
