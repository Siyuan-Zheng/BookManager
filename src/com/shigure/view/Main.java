/*
 * Created by JFormDesigner on Sun Nov 26 22:58:36 CST 2017
 */

package com.shigure.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * @author siyuan zheng
 */
class Main extends JFrame {
    Main() {
        initComponents();
    }

    private void jmiBookTypeManageActionPerformed(ActionEvent e) {
        BookTypeManageInterFrm BookTypeManageInterFrm = new BookTypeManageInterFrm();
        BookTypeManageInterFrm.setVisible(true);
        //this.table.add(BookTypeManageInterFrm);

    }

    private void jmiBookTypeAddActionPerformed(ActionEvent e) {
        BookTypeInterFrm bookTypeInterFrm = new BookTypeInterFrm();
        bookTypeInterFrm.setVisible(true);
        //this.table.add(bookTypeInterFrm);
    }

    private void jmiBookAddActionPerformed(ActionEvent e) {
        BookAddInterFrm BookAddInterFrm = new BookAddInterFrm();
        BookAddInterFrm.setVisible(true);
        //this.table.add(BookAddInterFrm);
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - siyuan zheng
        JMenuBar menuBar1 = new JMenuBar();
        JMenu menu1 = new JMenu();
        JMenu menu2 = new JMenu();
        JMenuItem jmiBookTypeAdd = new JMenuItem();
        JMenuItem jmiBookTypeManage = new JMenuItem();
        JMenu menu3 = new JMenu();
        JMenuItem jmiBookAdd = new JMenuItem();
        JMenuItem menuItem3 = new JMenuItem();
        JMenuItem menuItem1 = new JMenuItem();
        JLabel label1 = new JLabel();

        //======== this ========
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== menuBar1 ========
        {

            //======== menu1 ========
            {
                menu1.setText("\u57fa\u672c\u6570\u636e\u7ef4\u62a4");

                //======== menu2 ========
                {
                    menu2.setText("\u56fe\u4e66\u7c7b\u522b\u7ba1\u7406");

                    //---- jmiBookTypeAdd ----
                    jmiBookTypeAdd.setText("\u6dfb\u52a0\u56fe\u4e66\u7c7b\u522b");
                    jmiBookTypeAdd.addActionListener(this::jmiBookTypeAddActionPerformed);
                    menu2.add(jmiBookTypeAdd);

                    //---- jmiBookTypeManage ----
                    jmiBookTypeManage.setText("\u56fe\u4e66\u7c7b\u522b\u7ef4\u62a4");
                    jmiBookTypeManage.addActionListener(this::jmiBookTypeManageActionPerformed);
                    menu2.add(jmiBookTypeManage);
                }
                menu1.add(menu2);

                //======== menu3 ========
                {
                    menu3.setText("\u56fe\u4e66\u9986\u7ba1\u7406");

                    //---- jmiBookAdd ----
                    jmiBookAdd.setText("\u6dfb\u52a0\u56fe\u4e66");
                    jmiBookAdd.addActionListener(this::jmiBookAddActionPerformed);
                    menu3.add(jmiBookAdd);

                    //---- menuItem3 ----
                    menuItem3.setText("\u56fe\u4e66\u7ef4\u62a4");
                    menu3.add(menuItem3);
                }
                menu1.add(menu3);

                //---- menuItem1 ----
                menuItem1.setText("\u9000\u51fa\u7cfb\u7edf");
                menu1.add(menuItem1);
            }
            menuBar1.add(menu1);
        }
        setJMenuBar(menuBar1);

        //---- label1 ----
        label1.setText("text");
        contentPane.add(label1);
        label1.setBounds(0, 0, 400, 245);

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

    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
