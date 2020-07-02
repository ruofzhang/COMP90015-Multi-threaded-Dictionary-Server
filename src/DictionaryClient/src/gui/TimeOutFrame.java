package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @name Ruofan
 * @surname Zhang
 * @studentID 1029050
 */

public class TimeOutFrame extends TemplateFrame implements ActionListener {

    public TimeOutFrame(String inMessage){
        this.setTitle("Time Out");
        JLabel label = new JLabel("Wrong");
        label.setFont(labelFont);
        label.setBounds(40,10,450,40);
        panel.add(label);
        JTextArea resultText = new JTextArea(inMessage);
        resultText.setEditable(false);
        resultText.setFont(boxFont);
        resultText.setLineWrap(true);
        resultText.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(resultText);
        scrollPane.setBounds(45,60,350,80);
        panel.add(scrollPane);
        JButton button = new JButton("Close");
        button.setBounds(170,150,100,40);
        button.setFont(buttonFont);
        button.addActionListener(this);
        panel.add(button);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
}
