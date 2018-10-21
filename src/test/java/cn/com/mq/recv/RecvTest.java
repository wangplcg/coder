package cn.com.mq.recv;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Think
 * Date: 2018-10-21
 * Time: 12:36
 */

public class RecvTest {

    private final static String QUEUE_NAME = "hello";

    private static String EXCHANGE_NAME = "logs";

    public static void main(String[] argv) throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("47.100.23.48");
        factory.setPort(5672);
        factory.setUsername("wangplcg");
        factory.setPassword("951213");
        Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();

        // 消息持久化，防止消息挂掉
        boolean durable = true;
//        channel.queueDeclare(QUEUE_NAME,durable,false,false,null);

        channel.queueBind(QUEUE_NAME, EXCHANGE_NAME,""); //不设置路由键
        channel.basicQos(1);

        System.out.println("wait Message");
        Consumer consumer = new DefaultConsumer(channel) {
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body)
                    throws IOException {
                String message = new String(body, "UTF-8");
                try {
                    doWork(message);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                channel.basicAck(envelope.getDeliveryTag(), false);
                System.out.println("Customer Received '" + message + "'");
            }
        };
        //关闭自动回复队列应答 -- RabbitMQ中的消息确认机制
        boolean autoAck = false;
        channel.basicConsume(QUEUE_NAME, autoAck, consumer);
//        channel.close();
//        connection.close();
    }

    private static void doWork(String task) throws InterruptedException {
        for (char ch: task.toCharArray()) {
            if (ch == '.') Thread.sleep(1000);
        }
    }
}