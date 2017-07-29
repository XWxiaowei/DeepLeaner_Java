package RPC;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;
import java.net.UnknownHostException;

public class Consumer {
	/**
	 * 服务消费者关键代码
	 * 
	 * 先获得接口名称、需要调用的方法和需要传递的参数 。通过Socket把它传递到服务提供方
	 * ，等待服务提供发的响应，实际上回将其改成非阻塞方式，来提高系统的推土量
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws IOException 
	 * @throws UnknownHostException 
	 * @throws ClassNotFoundException 
	 */
   public  void  consume() throws NoSuchMethodException, SecurityException, UnknownHostException, IOException, ClassNotFoundException{
	   //服务接口名称
	   String interfaceNames=SayHelloService.class.getName();
	   Method method=SayHelloService.class.getMethod("sayHello", String.class);
	   Object [] arguments={"hello"};
	   Socket  socket=new Socket("127.0.0.1", 1234);
	   //将方法名称和参数传递到远端：
	   ObjectOutputStream  obbjectput=new  ObjectOutputStream(socket.getOutputStream());
	   obbjectput.writeUTF(interfaceNames);//接口名
	   obbjectput.writeUTF(method.getName());
	   obbjectput.writeObject(method.getParameterTypes());
	   obbjectput.writeObject(arguments);
	   //从远端获取方法执行结果
	   ObjectInputStream input=new  ObjectInputStream(socket.getInputStream());
	   Object  result=input.readObject();
   }
}
