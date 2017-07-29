package NIO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIO_lesson1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         readByNIO();
	}
    public static  void readByNIO(){
    	RandomAccessFile afile=null;
    	try {
			afile=new RandomAccessFile("E://InterView//exercise//NIO//nio.txt", "rw");
			FileChannel fileChanel=afile.getChannel();
			ByteBuffer byteBuffer=ByteBuffer.allocate(1024);//·ÖÅä1MµÄ»º³åÇø
			int bytesRead=fileChanel.read(byteBuffer);
			System.out.println(bytesRead);
			while(bytesRead!=-1){
				byteBuffer.flip();
				while(byteBuffer.hasRemaining()){
					System.out.print((char)byteBuffer.get());
				}
				byteBuffer.compact();
				bytesRead=fileChanel.read(byteBuffer);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
