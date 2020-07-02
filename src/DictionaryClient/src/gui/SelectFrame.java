package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @name Ruofan
 * @surname Zhang
 * @studentID 1029050
 */

public class SelectFrame extends TemplateFrame implements ActionListener{
    private JComboBox comboBox;

    public SelectFrame(){
        this.setTitle("Simple Dictionary");
        JLabel label = new JLabel("Select the functionality you want");
        Font labelFont = new Font("Segoe UI", Font.BOLD, 20);
        label.setFont(labelFont);
        label.setBounds(65,20,450,40);
        panel.add(label);
        String[] boxOptions = {"query","add","remove"};
        comboBox = new JComboBox(boxOptions);
        Font boxFont = new Font("Segoe UI", Font.PLAIN, 20);
        comboBox.setBounds(70,80,300,40);
        comboBox.setFont(boxFont);
        panel.add(comboBox);
        JButton button = new JButton("Select");
        Font buttonFont = new Font("Segoe UI", Font.BOLD, 15);
        button.setBounds(160,150,100,40);
        button.setFont(buttonFont);
        button.addActionListener(this);
        panel.add(button);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = (String) comboBox.getSelectedItem();
        if (command.equals("query")) {
            this.dispose();
            new QueryFrame();
        }
        if (command.equals("add")) {
            this.dispose();
            new AddFrame();
        }
        if (command.equals("remove")) {
            this.dispose();
            new RemoveFrame();
        }
    }

}
