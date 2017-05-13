package otrasCosas;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.IOException;

public class Servicio{
    private Servicio() {};
        
    public static void creaServicio() throws IOException {    
        ServerSocket listener = new ServerSocket(9090);
        try{
            while(true){
                Socket s = listener.accept();  
                try{
                    PrintWriter out = new PrintWriter(s.getOutputStream(), true);
                    out.println("Victor J. Perez por un socket.");
                }finally{
                    s.close();
                }
            }
        }finally{
            listener.close();
        }
    }

    public static void main(String[] args) throws IOException  {
        creaServicio();
    }
}
