/*
 * Created by JFormDesigner on Sun Dec 03 20:38:20 CST 2017
 */

package com.shigure.view;

import java.awt.event.*;
import com.shigure.model.User;

import java.awt.*;
import javax.swing.*;

/**
 * @author siyuan zheng
 */
public class ReaderDashBoard extends JFrame {
    public static int uid;

    //static User user = new User();
    public ReaderDashBoard() {
        initComponents();
    }

    public void getUserId(User id){
        ReaderDashBoard.uid = id.getId();
    }

    private void button1ActionPerformed(ActionEvent e) {
        new ReaderBookLookUp().setVisible(true);
    }

    private void button2ActionPerformed(ActionEvent e) {
        new ReaderBorrowManage().setVisible(true);
    }

    private void button3ActionPerformed(ActionEvent e) {
        new ReaderBookRecommend().setVisible(true);
    }

    private void button4ActionPerformed(ActionEvent e) {
        new ReaderBookRecommendManage().setVisible(true);
    }

    private void button5ActionPerformed(ActionEvent e) {
        new ReaderSelfimformationManage().setVisible(true);
    }

    private void button6ActionPerformed(ActionEvent e) {
        new About().setVisible(true);
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
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        label8 = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("\u8bfb\u8005\u4e3b\u754c\u9762");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setIcon(new ImageIcon(getClass().getResource("/com/shigure/material/Book-1.png")));
        button1.setBorder(null);
        button1.setBorderPainted(false);
        button1.setContentAreaFilled(false);
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(70, 45), button1.getPreferredSize()));

        //---- button2 ----
        button2.setIcon(new ImageIcon(getClass().getResource("/com/shigure/material/Pencil_note.png")));
        button2.setBorder(null);
        button2.setBorderPainted(false);
        button2.setContentAreaFilled(false);
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(300, 45), button2.getPreferredSize()));

        //---- button3 ----
        button3.setBorder(null);
        button3.setBorderPainted(false);
        button3.setContentAreaFilled(false);
        button3.setIcon(new ImageIcon(getClass().getResource("/com/shigure/material/Flag.png")));
        button3.addActionListener(e -> button3ActionPerformed(e));
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(70, 255), button3.getPreferredSize()));

        //---- button4 ----
        button4.setIcon(new ImageIcon(getClass().getResource("/com/shigure/material/Pen.png")));
        button4.setBorder(null);
        button4.setContentAreaFilled(false);
        button4.setBorderPainted(false);
        button4.addActionListener(e -> button4ActionPerformed(e));
        contentPane.add(button4);
        button4.setBounds(new Rectangle(new Point(300, 255), button4.getPreferredSize()));

        //---- button5 ----
        button5.setBorder(null);
        button5.setBorderPainted(false);
        button5.setContentAreaFilled(false);
        button5.setIcon(new ImageIcon(getClass().getResource("/com/shigure/material/ID-Card.png")));
        button5.addActionListener(e -> button5ActionPerformed(e));
        contentPane.add(button5);
        button5.setBounds(new Rectangle(new Point(70, 465), button5.getPreferredSize()));

        //---- button6 ----
        button6.setBorder(null);
        button6.setBorderPainted(false);
        button6.setContentAreaFilled(false);
        button6.setIcon(new ImageIcon(getClass().getResource("/com/shigure/material/Lightbulb.png")));
        button6.addActionListener(e -> button6ActionPerformed(e));
        contentPane.add(button6);
        button6.setBounds(new Rectangle(new Point(300, 465), button6.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u56fe\u4e66\u501f\u9605");
        label2.setFont(new Font(".SF NS Text", Font.PLAIN, 18));
        label2.setForeground(new Color(204, 204, 204));
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(85, 170), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u501f\u9605\u7ba1\u7406");
        label3.setFont(new Font(".SF NS Text", Font.PLAIN, 18));
        label3.setForeground(new Color(204, 204, 204));
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(315, 170), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("\u56fe\u4e66\u8350\u8d2d");
        label4.setFont(new Font(".SF NS Text", Font.PLAIN, 18));
        label4.setForeground(new Color(204, 204, 204));
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(85, 380), label4.getPreferredSize()));

        //---- label5 ----
        label5.setText("\u5efa\u8d2d\u7ba1\u7406");
        label5.setFont(new Font(".SF NS Text", Font.PLAIN, 18));
        label5.setForeground(new Color(204, 204, 204));
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(315, 380), label5.getPreferredSize()));

        //---- label6 ----
        label6.setText("\u4e2a\u4eba\u4fe1\u606f");
        label6.setFont(new Font(".SF NS Text", Font.PLAIN, 18));
        label6.setForeground(new Color(204, 204, 204));
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(85, 590), label6.getPreferredSize()));

        //---- label7 ----
        label7.setText("\u5173\u4e8e");
        label7.setFont(new Font(".SF NS Text", Font.PLAIN, 18));
        label7.setForeground(new Color(204, 204, 204));
        contentPane.add(label7);
        label7.setBounds(new Rectangle(new Point(335, 590), label7.getPreferredSize()));

        //---- label8 ----
        label8.setIcon(new ImageIcon(getClass().getResource("/com/shigure/material/\u672a\u6807\u9898-1.png")));
        contentPane.add(label8);
        label8.setBounds(0, 0, 470, 680);

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
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
