/*
 * Created by JFormDesigner on Sat Dec 09 16:54:07 CST 2017
 */

package com.shigure.view;

import java.awt.event.*;

import com.shigure.dao.BookDao;
import com.shigure.dao.BookRecommendDao;
import com.shigure.model.Book;
import com.shigure.model.BookRecommend;
import com.shigure.model.BookType;
import com.shigure.model.User;
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
public class BookRecommendManage extends JFrame {
    BookDao bookDao = new BookDao();
    BookRecommendDao bookRecommendDao = new BookRecommendDao();
    static int recommendId = 0;
    static String bookName = null;
    static String author = null;
    static String pressName = null;
    static String bookDesc = null;
    static String bookTypeName = null;
    static int bookTypeId = 0;
    public BookRecommendManage() {
        initComponents();
        fillTable();
    }

    private void fillTable(){
        int userId = ReaderDashBoard.uid;
        BookRecommend bookRecommend = new BookRecommend();
        User user = new User(userId);
        DefaultTableModel dtm = (DefaultTableModel) recommendTable.getModel();
        dtm.setRowCount(0);
        Connection con = null;
        try {
            con = getConnection();
            ResultSet rs = bookRecommendDao.recommendList(con,bookRecommend);
            while(rs.next()){
                Vector v = new Vector<>();
                v.add(rs.getInt("recommendId"));
                v.add(rs.getString("userName"));
                v.add(rs.getString("bookName"));
                v.add(rs.getString("author"));
                v.add(rs.getString("pressName"));
                v.add(rs.getString("bookDesc"));
                v.add(rs.getString("bookTypeName"));
                v.add(rs.getString("recommendStatus"));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            free(con);
        }
    }

    private void jb_adoptActionPerformed(ActionEvent e) {
        if(recommendId == 0){
            JOptionPane.showMessageDialog(null,"请选择要添加的图书");
            return;
        }
        Connection con = null;
        BookRecommend bookRecommend = new BookRecommend();
        BookRecommend recommendStatus = new BookRecommend(recommendId,"已典藏");

        try {
            con = getConnection();
            ResultSet rs = bookRecommendDao.recommendList(con,bookRecommend);
            while(rs.next()) {
                bookTypeId = rs.getInt("bookTypeId");
            }
            Book book = new Book(bookName,author,pressName,bookDesc,bookTypeId);
            int addNum = bookDao.bookAdd(con,book);
            if(addNum == 1 ){
                JOptionPane.showMessageDialog(null,"图书添加成功");
                try {
                    int updateNum = bookRecommendDao.recommendUpdate(con,recommendStatus);
                    if(updateNum == 1){
                        this.fillTable();
                    }else {
                        JOptionPane.showMessageDialog(null, "建购状态修改失败");
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, "建购状态修改失败");
                }
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

    private void recommendTableMousePressed(MouseEvent e) {
        int row = this.recommendTable.getSelectedRow();
        recommendId = (int) recommendTable.getValueAt(row,0);
        bookName = String.valueOf(recommendTable.getValueAt(row,2));
        author = String.valueOf(recommendTable.getValueAt(row,3));
        pressName = String.valueOf(recommendTable.getValueAt(row,4));
        bookDesc = String.valueOf(recommendTable.getValueAt(row,5));
        bookTypeName = String.valueOf(recommendTable.getValueAt(row,6));
    }

    private void jb_rejectActionPerformed(ActionEvent e) {
        if(recommendId == 0){
            JOptionPane.showMessageDialog(null,"请选择荐购图书");
            return;
        }
        BookRecommend recommendStatus = new BookRecommend(recommendId,"已拒绝");
        Connection con = null;
        try {
            con= getConnection();
            int updateNum = bookRecommendDao.recommendUpdate(con,recommendStatus);
            if(updateNum == 1){
                this.fillTable();
            }else {
                JOptionPane.showMessageDialog(null, "建购状态修改失败");
            }
        } catch (Exception e1) {
            e1.printStackTrace();
            JOptionPane.showMessageDialog(null,"建购状态修改失败");
        }finally {
            free(con);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - siyuan zheng
        scrollPane1 = new JScrollPane();
        recommendTable = new JTable();
        jb_adopt = new JButton();
        jb_reject = new JButton();
        label1 = new JLabel();

        //======== this ========
        setTitle("\u5efa\u8d2d\u7ba1\u7406");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- recommendTable ----
            recommendTable.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null, null},
                },
                new String[] {
                    "\u5efa\u8d2d\u7f16\u53f7", "\u5efa\u8d2d\u8005", "\u56fe\u4e66\u540d\u79f0", "\u56fe\u4e66\u4f5c\u8005", "\u51fa\u7248\u793e", "\u56fe\u4e66\u63cf\u8ff0", "\u56fe\u4e66\u7c7b\u578b", "\u5efa\u8d2d\u72b6\u6001"
                }
            ));
            recommendTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    recommendTableMousePressed(e);
                }
            });
            scrollPane1.setViewportView(recommendTable);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(25, 65, 630, 240);

        //---- jb_adopt ----
        jb_adopt.setText("\u901a\u8fc7");
        jb_adopt.setFont(jb_adopt.getFont().deriveFont(jb_adopt.getFont().getSize() + 3f));
        jb_adopt.addActionListener(e -> jb_adoptActionPerformed(e));
        contentPane.add(jb_adopt);
        jb_adopt.setBounds(new Rectangle(new Point(155, 355), jb_adopt.getPreferredSize()));

        //---- jb_reject ----
        jb_reject.setText("\u62d2\u7edd");
        jb_reject.setFont(jb_reject.getFont().deriveFont(jb_reject.getFont().getSize() + 3f));
        jb_reject.addActionListener(e -> jb_rejectActionPerformed(e));
        contentPane.add(jb_reject);
        jb_reject.setBounds(new Rectangle(new Point(440, 355), jb_reject.getPreferredSize()));

        //---- label1 ----
        label1.setText("text");
        contentPane.add(label1);
        label1.setBounds(0, 0, 680, 450);

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
    private JTable recommendTable;
    private JButton jb_adopt;
    private JButton jb_reject;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
