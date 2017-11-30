/*
 * Created by JFormDesigner on Tue Nov 28 20:50:55 CST 2017
 */

package com.shigure.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author siyuan zheng
 */
public class BookManagerDashBoard extends JFrame {
    public BookManagerDashBoard() {
        initComponents();
    }

    private void button4ActionPerformed(ActionEvent e) {
        new BookAddInterFrm().setVisible(true);
    }

    private void button3ActionPerformed(ActionEvent e) {
        new BookTypeInterFrm().setVisible(true);
    }

    private void button1ActionPerformed(ActionEvent e) {
        new BookTypeManageInterFrm().setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - siyuan zheng
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        button5 = new JButton();
        button6 = new JButton();
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

        //---- button1 ----
        button1.setIcon(new ImageIcon(getClass().getResource("/com/shigure/material/Pen.png")));
        button1.setBorder(null);
        button1.setContentAreaFilled(false);
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(495, 320), button1.getPreferredSize()));

        //---- button2 ----
        button2.setIcon(new ImageIcon(getClass().getResource("/com/shigure/material/Pencil_note.png")));
        button2.setContentAreaFilled(false);
        button2.setBorder(null);
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(495, 75), button2.getPreferredSize()));

        //---- button3 ----
        button3.setIcon(new ImageIcon(getClass().getResource("/com/shigure/material/Books.png")));
        button3.setContentAreaFilled(false);
        button3.setBorder(null);
        button3.addActionListener(e -> button3ActionPerformed(e));
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(125, 320), button3.getPreferredSize()));

        //---- button4 ----
        button4.setIcon(new ImageIcon(getClass().getResource("/com/shigure/material/Book-1.png")));
        button4.setBorder(null);
        button4.setContentAreaFilled(false);
        button4.addActionListener(e -> button4ActionPerformed(e));
        contentPane.add(button4);
        button4.setBounds(new Rectangle(new Point(125, 75), button4.getPreferredSize()));

        //---- button5 ----
        button5.setIcon(new ImageIcon(getClass().getResource("/com/shigure/material/Myspace.png")));
        button5.setBorder(null);
        button5.setContentAreaFilled(false);
        contentPane.add(button5);
        button5.setBounds(new Rectangle(new Point(125, 545), button5.getPreferredSize()));

        //---- button6 ----
        button6.setContentAreaFilled(false);
        button6.setBorder(null);
        button6.setIcon(new ImageIcon(getClass().getResource("/com/shigure/material/Lightbulb.png")));
        contentPane.add(button6);
        button6.setBounds(new Rectangle(new Point(495, 545), button6.getPreferredSize()));

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
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
