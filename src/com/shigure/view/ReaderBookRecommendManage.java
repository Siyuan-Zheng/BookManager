/*
 * Created by JFormDesigner on Wed Dec 06 22:33:05 CST 2017
 */

package com.shigure.view;

import java.awt.event.*;
import com.shigure.dao.BookRecommendDao;
import com.shigure.model.BookBorrow;
import com.shigure.model.BookRecommend;
import com.shigure.model.User;

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
public class ReaderBookRecommendManage extends JFrame {
    static int recommendId = 0;
    BookRecommendDao bookRecommendDao = new BookRecommendDao();
    public ReaderBookRecommendManage() {
        initComponents();
        this.fillTable(new BookRecommend());
    }


    private void fillTable(BookRecommend bookRecommend){
        int userId = ReaderDashBoard.uid;
        User user = new User(userId);
        DefaultTableModel dtm = (DefaultTableModel) recommendTable.getModel();
        dtm.setRowCount(0);
        Connection con = null;
        try {
            con = getConnection();
            ResultSet rs = bookRecommendDao.recommendList(con,bookRecommend,user);
            while(rs.next()){
                Vector v = new Vector<>();
                v.add(rs.getInt("recommendId"));
                v.add(rs.getString("bookName"));
                v.add(rs.getString("author"));
                v.add(rs.getString("pressName"));
                v.add(rs.getString("bookTypeName"));
                v.add(rs.getString("bookDesc"));
                v.add(rs.getString("recommendStatus"));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            free(con);
        }
    }

    private void jb_deleteActionPerformed(ActionEvent e) {
        int recommendId = ReaderBookRecommendManage.recommendId;
        if(recommendId == 0){
            JOptionPane.showMessageDialog(null,"请选择要删除的记录");
            return;
        }
        int n = JOptionPane.showConfirmDialog(null,"确定要删除这条记录吗");
        if(n==0){
            Connection con = null;
            try {
                con= getConnection();
                int deleteNum = bookRecommendDao.recommendDelete(con,recommendId);
                if(deleteNum == 1){
                    JOptionPane.showMessageDialog(null,"删除成功");
                    this.fillTable(new BookRecommend());
                }else {
                    JOptionPane.showMessageDialog(null, "删除失败");
                }

            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null,"删除失败");
            }finally {
                free(con);
            }
        }    }

        private void recommendTableMousePressed(MouseEvent e) {
            int row = this.recommendTable.getSelectedRow();
            ReaderBookRecommendManage.recommendId = Integer.parseInt(String.valueOf(recommendTable.getValueAt(row,0)));
        }



    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - siyuan zheng
        scrollPane1 = new JScrollPane();
        recommendTable = new JTable();
        jb_delete = new JButton();
        label1 = new JLabel();

        //======== this ========
        setTitle("\u8350\u8d2d\u7ba1\u7406");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- recommendTable ----
            recommendTable.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null, null},
                    {null, null, null, null, null, null, null},
                },
                new String[] {
                    "\u8350\u8d2d\u7f16\u53f7", "\u56fe\u4e66\u540d\u79f0", "\u56fe\u4e66\u4f5c\u8005", "\u51fa\u7248\u793e", "\u56fe\u4e66\u7c7b\u578b", "\u56fe\u4e66\u63cf\u8ff0", "\u8350\u8d2d\u72b6\u6001"
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
        scrollPane1.setBounds(30, 40, 645, 205);

        //---- jb_delete ----
        jb_delete.setText("\u5220\u9664\u8350\u8d2d");
        jb_delete.setFont(jb_delete.getFont().deriveFont(jb_delete.getFont().getSize() + 3f));
        jb_delete.addActionListener(e -> jb_deleteActionPerformed(e));
        contentPane.add(jb_delete);
        jb_delete.setBounds(new Rectangle(new Point(580, 285), jb_delete.getPreferredSize()));
        contentPane.add(label1);
        label1.setBounds(0, 0, 695, 355);

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
    private JButton jb_delete;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
