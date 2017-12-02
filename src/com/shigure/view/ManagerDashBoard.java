/*
 * Created by JFormDesigner on Tue Nov 28 20:50:55 CST 2017
 */

package com.shigure.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * @author siyuan zheng
 */
public class ManagerDashBoard extends JFrame {
    public ManagerDashBoard() {
        initComponents();
    }


    private void button3ActionPerformed(ActionEvent e) {
        //---- jb_AddBookType ----
        new BookTypeInterFrm().setVisible(true);
    }

    private void button1ActionPerformed(ActionEvent e) {
        //jb_BookTypeUpdate
        new BookTypeManageInterFrm().setVisible(true);
    }

    private void button2ActionPerformed(ActionEvent e) {
        //---- jb_BookUpdate ----
        new BookManageInterFrm().setVisible(true);
    }



    private void jb_AddBookActionPerformed() {
        new BookAddInterFrm().setVisible(true);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - siyuan zheng
        jb_AddBook = new JButton();
        jb_BookTypeUpdate = new JButton();
        jb_BookUpdate = new JButton();
        jb_AddBookType = new JButton();
        jb_ReaderManager = new JButton();
        jb_About = new JButton();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- jb_AddBook ----
        jb_AddBook.setIcon(new ImageIcon(getClass().getResource("/com/shigure/material/Book-1.png")));
        jb_AddBook.setBorderPainted(false);
        jb_AddBook.setContentAreaFilled(false);
        jb_AddBook.setBorder(null);
        jb_AddBook.addActionListener(e -> jb_AddBookActionPerformed());
        contentPane.add(jb_AddBook);
        jb_AddBook.setBounds(new Rectangle(new Point(125, 75), jb_AddBook.getPreferredSize()));

        //---- jb_BookTypeUpdate ----
        jb_BookTypeUpdate.setIcon(new ImageIcon(getClass().getResource("/com/shigure/material/Pen.png")));
        jb_BookTypeUpdate.setBorder(null);
        jb_BookTypeUpdate.setContentAreaFilled(false);
        jb_BookTypeUpdate.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(jb_BookTypeUpdate);
        jb_BookTypeUpdate.setBounds(new Rectangle(new Point(495, 320), jb_BookTypeUpdate.getPreferredSize()));

        //---- jb_BookUpdate ----
        jb_BookUpdate.setIcon(new ImageIcon(getClass().getResource("/com/shigure/material/Pencil_note.png")));
        jb_BookUpdate.setContentAreaFilled(false);
        jb_BookUpdate.setBorder(null);
        jb_BookUpdate.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(jb_BookUpdate);
        jb_BookUpdate.setBounds(new Rectangle(new Point(495, 75), jb_BookUpdate.getPreferredSize()));

        //---- jb_AddBookType ----
        jb_AddBookType.setIcon(new ImageIcon(getClass().getResource("/com/shigure/material/Books.png")));
        jb_AddBookType.setContentAreaFilled(false);
        jb_AddBookType.setBorder(null);
        jb_AddBookType.addActionListener(e -> button3ActionPerformed(e));
        contentPane.add(jb_AddBookType);
        jb_AddBookType.setBounds(new Rectangle(new Point(125, 320), jb_AddBookType.getPreferredSize()));

        //---- jb_ReaderManager ----
        jb_ReaderManager.setIcon(new ImageIcon(getClass().getResource("/com/shigure/material/Myspace.png")));
        jb_ReaderManager.setBorder(null);
        jb_ReaderManager.setContentAreaFilled(false);
        contentPane.add(jb_ReaderManager);
        jb_ReaderManager.setBounds(new Rectangle(new Point(125, 545), jb_ReaderManager.getPreferredSize()));

        //---- jb_About ----
        jb_About.setContentAreaFilled(false);
        jb_About.setBorder(null);
        jb_About.setIcon(new ImageIcon(getClass().getResource("/com/shigure/material/Lightbulb.png")));
        contentPane.add(jb_About);
        jb_About.setBounds(new Rectangle(new Point(495, 545), jb_About.getPreferredSize()));

        //---- label1 ----
        label1.setText("\u6dfb\u52a0\u56fe\u4e66");
        label1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        label1.setForeground(new Color(51, 51, 51));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(155, 220), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u4fee\u6539\u56fe\u4e66\u4fe1\u606f");
        label2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        label2.setForeground(new Color(51, 51, 51));
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(510, 220), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u6dfb\u52a0\u56fe\u4e66\u7c7b\u522b");
        label3.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        label3.setForeground(new Color(51, 51, 51));
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(140, 465), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("\u4fee\u6539\u56fe\u4e66\u7c7b\u522b");
        label4.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        label4.setForeground(new Color(51, 51, 51));
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(510, 465), label4.getPreferredSize()));

        //---- label5 ----
        label5.setText("\u7528\u6237\u7ba1\u7406");
        label5.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        label5.setForeground(new Color(51, 51, 51));
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(155, 695), label5.getPreferredSize()));

        //---- label6 ----
        label6.setText("\u5173\u4e8e");
        label6.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
        label6.setForeground(new Color(51, 51, 51));
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(545, 695), label6.getPreferredSize()));

        //---- label7 ----
        label7.setText("text");
        label7.setIcon(new ImageIcon(getClass().getResource("/com/shigure/material/\u672a\u6807\u9898-1.png")));
        contentPane.add(label7);
        label7.setBounds(0, 0, 725, 785);

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
    private JButton jb_AddBook;
    private JButton jb_BookTypeUpdate;
    private JButton jb_BookUpdate;
    private JButton jb_AddBookType;
    private JButton jb_ReaderManager;
    private JButton jb_About;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
