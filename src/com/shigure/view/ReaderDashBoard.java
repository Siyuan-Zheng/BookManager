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

    public void tetId(User id){
        ReaderDashBoard.uid = id.getId();
        //System.out.println(uid);
    }

    private void button1ActionPerformed(ActionEvent e) {
        System.out.println(uid);
        new ReaderBookLookUp().setVisible(true);
    }

    private void button2ActionPerformed(ActionEvent e) {
        new ReaderBorrowManage().setVisible(true);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - siyuan zheng
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- button1 ----
        button1.setText("text");
        button1.addActionListener(e -> button1ActionPerformed(e));
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(105, 95), button1.getPreferredSize()));

        //---- button2 ----
        button2.setText("text");
        button2.addActionListener(e -> button2ActionPerformed(e));
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(405, 100), button2.getPreferredSize()));

        //---- button3 ----
        button3.setText("text");
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(110, 345), button3.getPreferredSize()));

        //---- button4 ----
        button4.setText("text");
        contentPane.add(button4);
        button4.setBounds(new Rectangle(new Point(420, 360), button4.getPreferredSize()));

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
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
