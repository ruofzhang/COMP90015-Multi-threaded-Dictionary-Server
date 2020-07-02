package server;

import gui.FileNotFoundFrame;
import gui.WrongPortFrame;
import service.DictionaryServiceImpl;
import service.ServiceResultEnum;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @name Ruofan
 * @surname Zhang
 * @studentID 1029050
 */

public class Server {

    private String dicPath;
    private ServerSocket serverSocket;
    private Map<String, String> dic = new HashMap<>();

    public Server(int port){
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Map<String, String> loadDictionary(){
        try {
            BufferedReader br = new BufferedReader(new FileReader(dicPath));
            String rawEntry = null;
            while((rawEntry = br.readLine()) != null){
                String[] entry = rawEntry.split(",");
                dic.put(entry[0],entry[1]);
            }
        } catch (FileNotFoundException e) {
            new FileNotFoundFrame(ServiceResultEnum.BAD_FILEPATH.getResult());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dic;
    }

    public void saveDictionary(){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(dicPath));
            for(Map.Entry<String, String> entry : dic.entrySet()){
                String word = entry.getKey();
                String meaning = entry.getValue();
                String dicEntry = word + "," + meaning;
                bw.write(dicEntry);
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Socket run(){

        Socket responseSocket = null;
        try {
            responseSocket = this.serverSocket.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return responseSocket;
    }

    public void requestHandler(Socket serverResponse){
        try {
            DataInputStream dis = new DataInputStream(new BufferedInputStream(serverResponse.getInputStream()));
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(serverResponse.getOutputStream()));
            String[] inMessage = dis.readUTF().split(",");
            String command = inMessage[0];
            DictionaryServiceImpl dsi = new DictionaryServiceImpl();
            String response = null;
            synchronized (this){
                if(command.equals("query")){
                    response = dsi.query(inMessage[1].toLowerCase(), dic);
                }
                if(command.equals("add")){
                    response = dsi.addWord(inMessage[1].toLowerCase(),inMessage[2].toLowerCase(), dic);
                    this.saveDictionary();
                }
                if(command.equals("remove")){
                    response = dsi.removeWord(inMessage[1].toLowerCase(), dic);
                    this.saveDictionary();
                }
            }
            dos.writeUTF(response);
            dos.flush();
            serverResponse.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        try{
            int boundPort = Integer.parseInt(args[0]);
            String filePath = args[1];
            Server server = new Server(boundPort);
            server.dicPath = filePath;
            server.loadDictionary();
            ExecutorService es = new ThreadPoolExecutor(5,200,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(1024));
            int clientCounter = 0;
            while(true){
                Socket serverResponse = server.run();
                System.out.println("New request coming in");
                clientCounter++;
                System.out.println("Total requests：" + clientCounter);
                es.execute(() -> server.requestHandler(serverResponse));
            }
        } catch(NumberFormatException e){
            new WrongPortFrame(ServiceResultEnum.ILLEGAL_PORT.getResult());
        }
    }
}
