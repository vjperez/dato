import java.net.*;
import java.io.*;
   
public class ClienteHttp {
   public static void main(String[] args) throws IOException {
      // The host and port to be connected.
      String host = "loteriasdepuertorico.com";
      int port = 80;
      // Create a TCP socket and connect to the host:port.
      Socket socket = new Socket(host, port);
      // Create the input and output streams for the network socket.
      BufferedReader in
         = new BufferedReader(
              new InputStreamReader(socket.getInputStream()));
      PrintWriter out
         = new PrintWriter(socket.getOutputStream(), true);
      // Send request to the HTTP server.
      out.println("GET /wp-content/themes/loterias/api/verification.php?id=28&year=2017&month=5&type_search=d HTTP/1.1\r");
      out.println("Host: www.loteriasdepuertorico.com\r");
      //out.println("Accept: application/json\r");
      out.println();   // blank line separating header & body
      out.flush();
      
      
      // Read the response and display on console.
      String line;
      // readLine() returns null if server close the network socket.
      boolean sigue = true;
      while(sigue){
        line = in.readLine();
        if(line == null){
            sigue = false;
        }else{
            System.out.println(line);
        }
      }
      //while((line = in.readLine()) != null) {
      //   System.out.println(line);
      //}
      // Close the I/O streams.
      in.close();
      out.close();
   }
}
