package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @name Ruofan
 * @surname Zhang
 * @studentID 1029050
 */

public class AddResultFrame extends TemplateFrame implements ActionListener {

    public AddResultFrame(String inMessage){
        this.setTitle("Add Result");
        JLabel label = new JLabel("Your add result");
        label.setFont(labelFont);
        label.setBounds(70,20,450,40);
        panel.add(label);
        JLabel resultLabel = new JLabel(inMessage);
        resultLabel.setBounds(80,80,300,40);
        resultLabel.setFont(boxFont);
        panel.add(resultLabel);
        JButton button = new JButton("Return");
        button.setBounds(160,150,100,40);
        button.setFont(buttonFont);
        button.addActionListener(this);
        panel.add(button);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        this.dispose();
        new SelectFrame();
    }

}
