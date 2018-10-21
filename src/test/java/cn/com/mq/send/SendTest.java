package cn.com.mq.send;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2018-10-21
 * Time: 12:06
 */
public class SendTest {
    private static String QUEUE_NAME = "hello";

    private static String EXCHANGE_NAME = "logs";

    private static String[] senStrs = {"hello", "world", "wangplcg"};

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("47.100.23.48");
        factory.setPort(5672);
        factory.setUsername("wangplcg");
        factory.setPassword("951213");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // 消息持久化，防止消息挂掉
        boolean durable = true;
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);

//        channel.queueDeclare(QUEUE_NAME, durable, false, false, null);

        for (int i = 0; i < 20; i++) {
            String message = getMessage(senStrs) + i;
            channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");
        }
        channel.close();
        connection.close();
    }

    private static String getMessage(String[] strings){
        if (strings.length < 1)
            return "Hello World!";
        return joinStrings(strings, ".");
    }

    private static String joinStrings(String[] strings, String delimiter) {
        int length = strings.length;
        if (length == 0) return "";
        StringBuilder words = new StringBuilder(strings[0]);
        for (int i = 1; i < length; i++) {
            words.append(delimiter).append(strings[i]);
        }
        return words.toString();
    }
}