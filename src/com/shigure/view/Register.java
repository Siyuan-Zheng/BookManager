/*
 * Created by JFormDesigner on Tue Nov 28 16:01:46 CST 2017
 */

package com.shigure.view;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
//import com.jgoodies.forms.factories.*;

/**
 * @author siyuan zheng
 */
public class Register extends JFrame {
    public Register() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - siyuan zheng
        label1 = new JLabel();
        label2 = new JLabel();
        textField2 = new JTextField();
        label3 = new JLabel();
        label4 = new JLabel();
        textField4 = new JTextField();
        label6 = new JLabel();
        passwordField1 = new JPasswordField();
        passwordField2 = new JPasswordField();
        textField5 = new JTextField();
        label9 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        label8 = new JLabel();
        label7 = new JLabel();

        //======== this ========
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u7528\u6237\u540d");
        label1.setFont(new Font(".SF NS Display", Font.PLAIN, 16));
        label1.setForeground(new Color(204, 204, 204));
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(210, 140), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u5bc6\u7801");
        label2.setFont(new Font(".SF NS Text", Font.PLAIN, 16));
        label2.setForeground(new Color(204, 204, 204));
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(225, 185), label2.getPreferredSize()));

        //---- textField2 ----
        textField2.setBorder(null);
        textField2.setBackground(new Color(70, 73, 74));
        textField2.setForeground(new Color(204, 204, 204));
        contentPane.add(textField2);
        textField2.setBounds(285, 273, 290, 25);

        //---- label3 ----
        label3.setText("\u786e\u8ba4\u5bc6\u7801");
        label3.setFont(new Font(".SF NS Text", Font.PLAIN, 16));
        label3.setForeground(new Color(204, 204, 204));
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(195, 230), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText("\u59d3\u540d");
        label4.setFont(new Font(".SF NS Text", Font.PLAIN, 16));
        label4.setForeground(new Color(204, 204, 204));
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(225, 275), label4.getPreferredSize()));

        //---- textField4 ----
        textField4.setBorder(null);
        textField4.setBackground(new Color(70, 73, 74));
        textField4.setForeground(new Color(204, 204, 204));
        contentPane.add(textField4);
        textField4.setBounds(285, 138, 290, 25);

        //---- label6 ----
        label6.setText("\u8054\u7cfb\u65b9\u5f0f");
        label6.setFont(new Font(".SF NS Text", Font.PLAIN, 16));
        label6.setForeground(new Color(204, 204, 204));
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(195, 320), label6.getPreferredSize()));

        //---- passwordField1 ----
        passwordField1.setBackground(new Color(70, 73, 74));
        passwordField1.setBorder(null);
        passwordField1.setForeground(new Color(204, 204, 204));
        contentPane.add(passwordField1);
        passwordField1.setBounds(285, 183, 290, 25);

        //---- passwordField2 ----
        passwordField2.setBorder(null);
        passwordField2.setBackground(new Color(70, 73, 74));
        passwordField2.setForeground(new Color(204, 204, 204));
        contentPane.add(passwordField2);
        passwordField2.setBounds(285, 228, 290, 25);

        //---- textField5 ----
        textField5.setBorder(null);
        textField5.setBackground(new Color(70, 73, 74));
        textField5.setForeground(new Color(204, 204, 204));
        contentPane.add(textField5);
        textField5.setBounds(285, 318, 290, 25);

        //---- label9 ----
        label9.setText("\u65b0\u7528\u6237\u6ce8\u518c");
        label9.setFont(new Font(".SF NS Text", Font.PLAIN, 28));
        label9.setForeground(new Color(204, 204, 204));
        contentPane.add(label9);
        label9.setBounds(new Rectangle(new Point(350, 60), label9.getPreferredSize()));

        //---- button1 ----
        button1.setText("\u6ce8\u518c");
        button1.setContentAreaFilled(false);
        button1.setFont(new Font(".SF NS Text", Font.PLAIN, 14));
        button1.setForeground(new Color(204, 204, 204));
        button1.setBorder(null);
        contentPane.add(button1);
        button1.setBounds(485, 370, 90, 35);

        //---- button2 ----
        button2.setText("\u91cd\u7f6e");
        button2.setContentAreaFilled(false);
        button2.setFont(new Font(".SF NS Text", Font.PLAIN, 14));
        button2.setForeground(new Color(204, 204, 204));
        button2.setBorder(null);
        contentPane.add(button2);
        button2.setBounds(285, 370, 90, 35);

        //---- label8 ----
        label8.setIcon(new ImageIcon("/Users/zhengsiyuan/Downloads/\u6ce8\u518c-4.png"));
        contentPane.add(label8);
        label8.setBounds(new Rectangle(new Point(250, 50), label8.getPreferredSize()));

        //---- label7 ----
        label7.setIcon(new ImageIcon(getClass().getResource("/com/shigure/material/LoginBackground.jpg")));
        contentPane.add(label7);
        label7.setBounds(0, 0, 750, 470);

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
    private JLabel label2;
    private JTextField textField2;
    private JLabel label3;
    private JLabel label4;
    private JTextField textField4;
    private JLabel label6;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JTextField textField5;
    private JLabel label9;
    private JButton button1;
    private JButton button2;
    private JLabel label8;
    private JLabel label7;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
