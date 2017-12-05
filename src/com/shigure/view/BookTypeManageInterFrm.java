/*
 * Created by JFormDesigner on Mon Nov 27 00:43:30 CST 2017
 */

package com.shigure.view;

import com.shigure.dao.BookDao;
import com.shigure.dao.BookTypeDao;
import com.shigure.model.BookType;
import com.shigure.util.StringUtil;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import static com.shigure.util.DbUtil.free;
import static com.shigure.util.DbUtil.getConnection;

/**
 * @author siyuan zheng
 */
class BookTypeManageInterFrm extends JFrame {
    private BookTypeDao bookTypeDao = new BookTypeDao();
    BookDao bookDao = new BookDao();
    BookTypeManageInterFrm() {
        initComponents();
        this.fillTable(new BookType());
    }

    private void fillTable(BookType bookType){
        DefaultTableModel dtm = (DefaultTableModel) bookTypeTable.getModel();
        dtm.setRowCount(0);
        Connection con = null;
        try {
            con = getConnection();
            ResultSet rs = bookTypeDao.bookTypeList(con,bookType);
            while(rs.next()){
                Vector<String> v = new Vector<>();
                v.add(rs.getString("id"));
                v.add(rs.getString("bookTypeName"));
                v.add(rs.getString("bookTypeDesc"));
                dtm.addRow(v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            free(con);
        }
    }

    private void jb_searchActionPerformed(ActionEvent e) {
        String s_bookTypeName = this.s_bookTypeNameTxt.getText();
        BookType bookType = new BookType();
        bookType.setBookTypeName(s_bookTypeName);
        this.fillTable(bookType);
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
                boolean flag = bookDao.getBookByBookTypeId(con,id);
                if(flag){
                    JOptionPane.showMessageDialog(null,"当前图书类别下仍有图书，不能删除该类别");
                    return;
                }
                int deleteNum = bookTypeDao.bookTypeDelete(con,id);
                if(deleteNum == 1){
                    JOptionPane.showMessageDialog(null,"删除成功");
                    this.resetValue();
                    this.fillTable(new BookType());
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

    private void resetValue(){
        this.idTxt.setText("");
        this.bookTypeNameTxt.setText("");
        this.bookTypeDescTxt.setText("");
    }

    private void jb_modifyActionPerformed(ActionEvent e) {
        String id = this.idTxt.getText();
        String bookTypeName = this.bookTypeNameTxt.getText();
        String bookTypeDesc = this.bookTypeDescTxt.getText();
        if(StringUtil.isEmpty(id)){
            JOptionPane.showMessageDialog(null,"请选择要修改的记录");
            return;
        }
        BookType bookType = new BookType(Integer.parseInt(id),bookTypeName,bookTypeDesc);
        Connection con = null;
        try {
            con= getConnection();
            int updateNum = bookTypeDao.bookTypeUpdate(con,bookType);
            if(updateNum == 1){
                JOptionPane.showMessageDialog(null,"修改成功");
                this.resetValue();
                this.fillTable(new BookType());
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

    private void bookTypeTableMousePressed(MouseEvent e) {
        int row = bookTypeTable.getSelectedRow();
        this.idTxt.setText((String)bookTypeTable.getValueAt(row,0));
        this.bookTypeNameTxt.setText((String)bookTypeTable.getValueAt(row,1));
        this.bookTypeDescTxt.setText((String)bookTypeTable.getValueAt(row,2));
    }

    private void scrollPane1MousePressed(MouseEvent e) {
        // TODO add your code here
    }




    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - siyuan zheng
        label1 = new JLabel();
        s_bookTypeNameTxt = new JTextField();
        jb_search = new JButton();
        scrollPane1 = new JScrollPane();
        bookTypeTable = new JTable();
        idTxt = new JTextField();
        label2 = new JLabel();
        label3 = new JLabel();
        bookTypeNameTxt = new JTextField();
        label4 = new JLabel();
        textArea1 = new JTextArea();
        scrollPane2 = new JScrollPane();
        bookTypeDescTxt = new JTextArea();
        jb_modify = new JButton();
        jb_delete = new JButton();

        //======== this ========
        setTitle("\u56fe\u4e66\u7c7b\u522b\u7ef4\u62a4");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u56fe\u4e66\u7c7b\u522b\u540d\u79f0\uff1a");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(40, 40), label1.getPreferredSize()));
        contentPane.add(s_bookTypeNameTxt);
        s_bookTypeNameTxt.setBounds(160, 35, 130, s_bookTypeNameTxt.getPreferredSize().height);

        //---- jb_search ----
        jb_search.setText("\u67e5\u8be2");
        jb_search.addActionListener(e -> jb_searchActionPerformed(e));
        contentPane.add(jb_search);
        jb_search.setBounds(new Rectangle(new Point(330, 35), jb_search.getPreferredSize()));

        //======== scrollPane1 ========
        {
            scrollPane1.setAutoscrolls(true);
            scrollPane1.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    scrollPane1MousePressed(e);
                    scrollPane1MousePressed(e);
                    scrollPane1MousePressed(e);
                }
            });

            //---- bookTypeTable ----
            bookTypeTable.setModel(new DefaultTableModel(
                new Object[][] {
                },
                new String[] {
                    "\u7f16\u53f7", "\u56fe\u4e66\u7c7b\u522b\u540d\u79f0", "\u56fe\u4e66\u7c7b\u522b\u63cf\u8ff0"
                }
            ));
            bookTypeTable.addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    bookTypeTableMousePressed(e);
                }
            });
            scrollPane1.setViewportView(bookTypeTable);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(20, 85, 455, 220);

        //---- idTxt ----
        idTxt.setEditable(false);
        contentPane.add(idTxt);
        idTxt.setBounds(70, 360, 125, idTxt.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u7f16\u53f7\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(25, 365), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u56fe\u4e66\u7c7b\u522b\u540d\u79f0\uff1a");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(215, 365), label3.getPreferredSize()));
        contentPane.add(bookTypeNameTxt);
        bookTypeNameTxt.setBounds(305, 360, 130, bookTypeNameTxt.getPreferredSize().height);

        //---- label4 ----
        label4.setText("\u63cf\u8ff0\uff1a");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(30, 410), label4.getPreferredSize()));
        contentPane.add(textArea1);
        textArea1.setBounds(new Rectangle(new Point(110, 400), textArea1.getPreferredSize()));

        //======== scrollPane2 ========
        {
            scrollPane2.setBorder(null);

            //---- bookTypeDescTxt ----
            bookTypeDescTxt.setLineWrap(true);
            scrollPane2.setViewportView(bookTypeDescTxt);
        }
        contentPane.add(scrollPane2);
        scrollPane2.setBounds(85, 410, 285, 55);

        //---- jb_modify ----
        jb_modify.setText("\u4fee\u6539");
        jb_modify.addActionListener(e -> jb_modifyActionPerformed(e));
        contentPane.add(jb_modify);
        jb_modify.setBounds(new Rectangle(new Point(45, 480), jb_modify.getPreferredSize()));

        //---- jb_delete ----
        jb_delete.setText("\u5220\u9664");
        jb_delete.addActionListener(e -> jb_deleteActionPerformed(e));
        contentPane.add(jb_delete);
        jb_delete.setBounds(new Rectangle(new Point(220, 480), jb_delete.getPreferredSize()));

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
    private JTextField s_bookTypeNameTxt;
    private JButton jb_search;
    private JScrollPane scrollPane1;
    private JTable bookTypeTable;
    private JTextField idTxt;
    private JLabel label2;
    private JLabel label3;
    private JTextField bookTypeNameTxt;
    private JLabel label4;
    private JTextArea textArea1;
    private JScrollPane scrollPane2;
    private JTextArea bookTypeDescTxt;
    private JButton jb_modify;
    private JButton jb_delete;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
