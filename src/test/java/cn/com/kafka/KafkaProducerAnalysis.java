package cn.com.kafka;

import cn.com.kafka.interceptor.ProducerInterceptorPrefix;
import cn.com.kafka.interceptor.ProducerInterceptorPrefixPlus;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.Future;

// 代码清单3-1 生产者客户端示例代码
public class KafkaProducerAnalysis {
    public static final String brokerList = "47.101.169.25:9092";
    public static final String topic = "topic-demo";

    public static Properties initConfig(){
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, brokerList);

        // Serializer 可以自实现序列化器

        // Partitioner 自定义分区器

        // ProducerInterceptor 生产者拦截器
        props.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG,
                ProducerInterceptorPrefix.class.getName() + ","
        + ProducerInterceptorPrefixPlus.class.getName());

        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "producer.client.id.demo");
        // 重试异常 配置重试次数 完成操作
        props.put(ProducerConfig.RETRIES_CONFIG, 10);
        return props;
    }

    public static void main(String[] args) {
        Properties props = initConfig();
        // KafkaProducer 线程安全 可以考虑 池化 进行处理
        KafkaProducer<String, String> producer = new KafkaProducer<>(props);
        ProducerRecord<String, String> record =
                new ProducerRecord<>(topic, "Hello, Kafka132213213!");
        // 发后即忘（fire-and-forget）、同步（sync）及异步（async）。
        try {
            Future<RecordMetadata> sendFuture = producer.send(record);
            // future get 实现同步发送 可以获取到 发送结果 保证发送的正确性
            // 1. RecordMetadata metadata = sendFuture.get();
            // 抛出异常分为重试 异常 和 不可重试异常
            // 重试异常 可通过 重试进行结果 不可重试异常比如消息体过大 则不能发送成功
            // NetworkException、
            // LeaderNotAvailableException、
            // UnknownTopicOrPartitionException、
            // NotEnoughReplicasException、NotCoordinatorException 等。
            // 比如 NetworkException 表示网络异常，这个有可能是由于网络瞬时故障而导致的异常，可以通过重试解决；
            // 又比如 LeaderNotAvailableException 表示分区的 leader 副本不可用，这个异常通常发生在 leader 副本下线而新的 leader 副本选举完成之前，重试之后可以重新恢复。
            //
            // 不可重试的异常，比如第2节中提及的 RecordTooLargeException 异常，暗示了所发送的消息太大
            // System.out.println(metadata.topic() + "-" + metadata.partition() + ":" + metadata.offset());


            // 2. 异步发送
            producer.send(record, (metadata, exception) -> {
                if (exception != null) {
                    exception.printStackTrace();
                } else {
                    System.out.println(metadata.topic() + "-" +
                            metadata.partition() + ":" + metadata.offset());
                }
            });

            // 批量发送后 close
            // int i = 0;
            // while (i < 100) {
            //     ProducerRecord<String, String> record =
            //             new ProducerRecord<>(topic, "msg"+i++);
            //     try {
            //         producer.send(record).get();
            //     } catch (InterruptedException | ExecutionException e) {
            //         e.printStackTrace();
            //     }
            // }
            // producer.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            producer.close();
        }
    }
}