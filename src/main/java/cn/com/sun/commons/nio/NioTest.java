package cn.com.sun.commons.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2018-08-25
 * Time: 18:13
 */

public class NioTest {

    public static void main(String[] args) throws IOException {
        FileInputStream fin = new FileInputStream(new File("F:\\Document\\a.txt"));
        FileChannel channel = fin.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate( 1024 );
        int bytesRead = channel.read(buffer);
        FileChannel inChannel = fin.getChannel();
        while (bytesRead != -1) {
            System.out.println("Read " + bytesRead);
            buffer.flip();
            while(buffer.hasRemaining()){
                System.out.print((char) buffer.get());
            }
            buffer.clear();
            bytesRead = inChannel.read(buffer);
        }
        fin.close();
    }
}
