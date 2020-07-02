package client;

import gui.SelectFrame;
import gui.WrongPortFrame;
import service.ServiceResultEnum;
import java.io.*;
import java.net.Socket;

/**
 * @name Ruofan
 * @surname Zhang
 * @studentID 1029050
 */

public class Client {

    private static String host;
    private static int port;

    public Client() {
    }

    public String connectServer(String command, String message)  {
        String response = ServiceResultEnum.TIME_OUT.getResult();
        try {
            Socket request = new Socket(host, port);
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(request.getOutputStream()));
            DataInputStream dis = new DataInputStream(new BufferedInputStream(request.getInputStream()));
            dos.writeUTF(command + "," + message);
            dos.flush();
            response = dis.readUTF();
            System.out.println("Server response：" + response);
            request.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    public static void main(String[] args) {
        host = args[0];
        try{
            port = Integer.parseInt(args[1]);
            new SelectFrame();
        }catch(NumberFormatException e){
            new WrongPortFrame(ServiceResultEnum.ILLEGAL_PORT.getResult());
        }
    }

}

