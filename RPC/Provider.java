package RPC;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Provider {
		
  public  void  provide() throws IOException{
	  ServerSocket  serverSocket=new  ServerSocket(1234);
	  while(true){
		  Socket  socket=serverSocket.accept();
		  ObjectInputStream  objectInputStream=new  ObjectInputStream(socket.getInputStream());
		  
	  }
	  
  }
}
