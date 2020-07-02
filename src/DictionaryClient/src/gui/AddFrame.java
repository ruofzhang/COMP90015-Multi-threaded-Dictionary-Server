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

public class AddFrame extends TemplateFrame implements ActionListener {
    private JTextField wordText;
    private JTextArea meaningText;

    public AddFrame(){
        this.setTitle("Add Word");
        JLabel wordlabel = new JLabel("Word");
        wordlabel.setFont(labelFont);
        wordlabel.setBounds(40,20,80,40);
        panel.add(wordlabel);
        wordText = new JTextField();
        wordText.setBounds(140,20,250,40);
        wordText.setFont(textFont);
        panel.add(wordText);
        JLabel meaninglabel = new JLabel("Meaning");
        meaninglabel.setFont(labelFont);
        meaninglabel.setBounds(40,60,100,40);
        panel.add(meaninglabel);
        meaningText = new JTextArea();
        meaningText.setLineWrap(true);
        meaningText.setWrapStyleWord(true);
        meaningText.setFont(textFont);
        JScrollPane scrollPane = new JScrollPane(meaningText);
        scrollPane.setBounds(140,70,250,80);
        panel.add(scrollPane);
        JButton button = new JButton("Submit");
        button.setBounds(180,160,100,40);
        button.setFont(buttonFont);
        button.addActionListener(this);
        panel.add(button);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String word = wordText.getText();
        String meaning = meaningText.getText();
        String response = null;
        if(word.equals("")){
            response = ServiceResultEnum.WORD_MISSED.getResult();
        }else if (meaning.equals("")){
            response = ServiceResultEnum.MEANING_MISSED.getResult();
        }else{
            String command = "add";
            String message = word + "," + meaning;
            Client client = new Client();
            response = client.connectServer(command, message);
        }
        if(response.equals(ServiceResultEnum.TIME_OUT.getResult())){
            new TimeOutFrame(response);
        }else{
            new AddResultFrame(response);
        }
        this.dispose();
    }

    public static void main(String[] args) {
    }
}
