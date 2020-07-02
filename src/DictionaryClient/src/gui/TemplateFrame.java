package gui;

import javax.swing.*;
import java.awt.*;

/**
 * @name Ruofan
 * @surname Zhang
 * @studentID 1029050
 */

public class TemplateFrame extends JFrame {

    JPanel panel = new JPanel();
    Font labelFont = new Font("Segoe UI", Font.BOLD, 20);
    Font textFont = new Font("Segoe UI", Font.PLAIN, 20);
    Font boxFont = new Font("Segoe UI", Font.PLAIN, 20);
    Font buttonFont = new Font("Segoe UI", Font.BOLD, 15);

    public TemplateFrame(){
        this.setSize(450, 250);
        this.panel.setLayout(null);
        this.add(panel);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((dim.width - this.getWidth()) / 2, (dim.height - this.getHeight()) / 2);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }
}
