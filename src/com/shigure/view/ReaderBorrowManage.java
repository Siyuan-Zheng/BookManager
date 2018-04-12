/*
 * Created by JFormDesigner on Wed Dec 06 00:08:05 CST 2017
 */

package com.shigure.view;

import java.awt.event.*;
import com.shigure.dao.BookBorrowDao;
import com.shigure.model.BookBorrow;
import com.shigure.model.User;
import com.shigure.util.StringUtil;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

import static com.shigure.util.DbUtil.free;
import static com.shigure.util.DbUtil.getConnection;

/**
 * @author siyuan zheng
 */
class ReaderBorrowManage extends JFrame {
    private static int borrowId = 0;
    private static Date originalTime = null;
    private BookBorrowDao bookBorrowDao = new BookBorrowDao();
    ReaderBorrowManage() {
        initComponents();
        this.fillTable();
    }

    private static int differentDaysByMillisecond(Date date1, Date date2)
    {
        return (int) ((date2.getTime() - date1.getTime()) / (1000*3600*24));
    }

    private void fillTable(){
        int userId = ReaderDashBoard.uid;
        User user = new User(userId);
        Date date = new Date();
        SimpleDateFormat matter=new SimpleDateFormat("yyyy-MM-dd");

        DefaultTableModel dtm = (DefaultTableModel) borrowTable.getModel();
        dtm.setRowCount(0);
        Connection con = null;
        try {
            con = getConnection();
            ResultSet rs = bookBorrowDao.borrowList(con,user);
            while(rs.next()){
                Vector<Object> v = new Vector<>();
                v.add(rs.getInt("borrowId"));
                v.add(rs.getString("bookName"));
                v.add(rs.getString("author"));
                v.add(rs.getString("pressName"));
                v.add(rs.getString("bookTypeName"));

                Long returnTime = rs.getLong("returnTime");
                if(returnTime == 0L){
                    v.add("借阅中");
                }else {
                    v.add("已归还");
                }

                Date borrowTime = new Date();
                borrowTime.setTime(rs.getLong("borrowTime"));


                v.add(matter.format(borrowTime));

//                Long db_BorrowTime = rs.getLong("borrowTime");
//                System.out.println(db_BorrowTime);
//                Date borrowTime = new Date();
//                borrowTime.setTime(db_BorrowTime);
//                date = matter.parse(String.valueOf(date.getTime()));
                Long db_OriginalTime = rs.getLong("originalTime");
                Date originalTime0 = new Date();
                originalTime0.setTime(db_OriginalTime);
//                System.out.println(originalTime0.getTime());
//                System.out.println(date.getTime());
                int time = differentDaysByMillisecond(date,originalTime0);
                v.add(time);


                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            free(con);
        }
    }

    private void jb_deleteActionPerformed(ActionEvent e) {
        int borrowId = ReaderBorrowManage.borrowId;
//        Calendar calendar = new GregorianCalendar();
//        calendar.setTime(originalTime);
//        calendar.add(Calendar.DATE,30);
//        originalTime = calendar.getTime();
//        java.sql.Date newOriginalTime = new java.sql.Date(originalTime.getTime());
        if(borrowId == 0){
            JOptionPane.showMessageDialog(null,"请选择要续借的图书");
            return;
        }
        int n = JOptionPane.showConfirmDialog(null,"确定要续借该图书吗");
        if(n==0){
            Connection con = null;
            try {
                con = getConnection();
                ResultSet rs = bookBorrowDao.getOriginalTime(con,borrowId);
                rs.next();
                if(rs.getInt("reStatus") == 1){
                    JOptionPane.showMessageDialog(null,"已续借一次，无法再次续借");
                    return;
                }
                Long originalTime = Long.valueOf(rs.getString("originalTime"));
                Long newOriginalTime = originalTime+2592000000L;


                BookBorrow bookBorrow = new BookBorrow(borrowId,newOriginalTime);
                con= getConnection();
                int updateNum = bookBorrowDao.originalTimeUpdate(con,bookBorrow);
                if(updateNum == 1){
                    JOptionPane.showMessageDialog(null,"续借成功");
                    this.fillTable();
                }else {
                    JOptionPane.showMessageDialog(null, "续借失败");
                }

            } catch (Exception e1) {
                e1.printStackTrace();
                JOptionPane.showMessageDialog(null,"续借失败");
            }finally {
                free(con);
            }
        }
    }


    private void borrowTableMousePressed(MouseEvent e) {
        int row = this.borrowTable.getSelectedRow();
        ReaderBorrowManage.borrowId = Integer.parseInt(String.valueOf(borrowTable.getValueAt(row,0)));
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        scrollPane1 = new JScrollPane();
        borrowTable = new JTable();
        jb_reBorrow = new JButton();
        label1 = new JLabel();

        //======== this ========
        setTitle("\u501f\u9605\u7ba1\u7406");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== scrollPane1 ========
        {

            //---- borrowTable ----
            borrowTable.setModel(new DefaultTableModel(
                new Object[][] {
                    {null, null, null, null, null, null, null, null},
                },
                new String[] {
                    "\u501f\u9605\u7f16\u53f7", "\u56fe\u4e66\u540d\u79f0", "\u56fe\u4e66\u4f5c\u8005", "\u51fa\u7248\u793e", "\u56fe\u4e66\u7c7b\u522b", "\u501f\u9605\u72b6\u6001", "\u501f\u9605\u65e5\u671f", "\u5269\u4f59\u65f6\u957f"
                }
            ));
            {
                TableColumnModel cm = borrowTable.getColumnModel();
                cm.getColumn(6).setPreferredWidth(120);
            }
            borrowTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    borrowTableMousePressed(e);
                }
            });
            scrollPane1.setViewportView(borrowTable);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(20, 55, 650, 230);

        //---- jb_reBorrow ----
        jb_reBorrow.setText("\u56fe\u4e66\u7eed\u501f");
        jb_reBorrow.setFont(new Font(".SF NS Text", Font.PLAIN, 16));
        jb_reBorrow.addActionListener(e -> jb_deleteActionPerformed(e));
        contentPane.add(jb_reBorrow);
        jb_reBorrow.setBounds(new Rectangle(new Point(565, 320), jb_reBorrow.getPreferredSize()));
        contentPane.add(label1);
        label1.setBounds(0, 0, 685, 395);

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
    private JScrollPane scrollPane1;
    private JTable borrowTable;
    private JButton jb_reBorrow;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
