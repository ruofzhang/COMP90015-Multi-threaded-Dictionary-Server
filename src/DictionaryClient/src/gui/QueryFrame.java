package gui;

import client.Client;
import service.ServiceResultEnum;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @name Ruofan
 * @surname Zhang
 * @studentID 1029050
 */

public class QueryFrame extends TemplateFrame implements ActionListener {
    private JTextField textField;

    public QueryFrame() {
        this.setTitle("Query");
        JLabel label = new JLabel("Enter the word to be searched");
        label.setFont(labelFont);
        label.setBounds(65,20,450,40);
        panel.add(label);
        textField = new JTextField();
        textField.setBounds(70,80,300,40);
        textField.setFont(boxFont);
        panel.add(textField);
        JButton button = new JButton("Enter");
        button.setBounds(160,150,100,40);
        button.setFont(buttonFont);
        button.addActionListener(this);
        panel.add(button);
        this.setVisible(true);
    }

//    public static void main(String[] args) {
//        new QueryFrame();
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = "query";
        String targetWord = textField.getText();
        String response = ServiceResultEnum.WORD_MISSED.getResult();
        if(!targetWord.equals("")){
            Client client = new Client();
            response = client.connectServer(command, targetWord);
        }
        if(response.equals(ServiceResultEnum.TIME_OUT.getResult())){
            new TimeOutFrame(response);
        }else{
            new QueryResultFrame(response);
        }
        this.dispose();
    }
}
