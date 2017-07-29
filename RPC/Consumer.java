package RPC;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.Socket;
import java.net.UnknownHostException;

public class Consumer {
	/**
	 * ���������߹ؼ�����
	 * 
	 * �Ȼ�ýӿ����ơ���Ҫ���õķ�������Ҫ���ݵĲ��� ��ͨ��Socket�������ݵ������ṩ��
	 * ���ȴ������ṩ������Ӧ��ʵ���ϻؽ���ĳɷ�������ʽ�������ϵͳ��������
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws IOException 
	 * @throws UnknownHostException 
	 * @throws ClassNotFoundException 
	 */
   public  void  consume() throws NoSuchMethodException, SecurityException, UnknownHostException, IOException, ClassNotFoundException{
	   //����ӿ�����
	   String interfaceNames=SayHelloService.class.getName();
	   Method method=SayHelloService.class.getMethod("sayHello", String.class);
	   Object [] arguments={"hello"};
	   Socket  socket=new Socket("127.0.0.1", 1234);
	   //���������ƺͲ������ݵ�Զ�ˣ�
	   ObjectOutputStream  obbjectput=new  ObjectOutputStream(socket.getOutputStream());
	   obbjectput.writeUTF(interfaceNames);//�ӿ���
	   obbjectput.writeUTF(method.getName());
	   obbjectput.writeObject(method.getParameterTypes());
	   obbjectput.writeObject(arguments);
	   //��Զ�˻�ȡ����ִ�н��
	   ObjectInputStream input=new  ObjectInputStream(socket.getInputStream());
	   Object  result=input.readObject();
   }
}
