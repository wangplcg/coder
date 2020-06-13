package cn.com.kafka;

import cn.com.kafka.interceptor.ConsumerInterceptorTTL;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class ConsumerFastStart {
    public static final String brokerList = "47.101.169.25:9092";
    public static final String topic = "topic-demo";
    public static final String groupId = "group.demo2";

    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.put("key.deserializer", 
                "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("value.deserializer", 
                "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put("bootstrap.servers", brokerList);
        // 消费者参数
        // fetch.min.bytes  拉取的最小数据量 1B
        // fetch.max.bytes  拉取的最大数据量  500M    服务端接收最大消息通过 message.max.bytes 参数设置
        // max.poll.records 一次拉取的最大消息数 默认 500
        // connections.max.idle.ms 关闭闲置链接时间 默认 540000（ms） 9min
        // exclude.internal.topics 内部主题是否向消费者公开  默认true  不能使用 subscribe(Pattern) 方式订阅主题
        // receive.buffer.bytes socket 接收缓存取大小  默认值为65536（B），即64KB
        // send.buffer.bytes 发送缓存区大小   与receive.buffer.bytes参数一样，如果设置为-1，则使用操作系统的默认值。
        //  request.timeout.ms 最长等待时间 默认30000（ms)
        // metadata.max.age.ms 元数据过期时间默认 300000（ms） 5min
        // isolation.level 事务隔离级别
        // 字符串类型，有效值为“read_uncommitted”和“read_committed”，表示消费者所消费到的位置，
        // 如果设置为“read_committed”，那么消费者就会忽略事务未提交的消息，即只能消费到LSO（LastStableOffset）的位置，
        // 默认情况下为“read_uncommitted”，即可以消费到 HW（High Watermark）处的位置。

        // 消费者拦截器
        // 判断消息是否超时 超时则进行丢弃
        // properties.put(ConsumerConfig.INTERCEPTOR_CLASSES_CONFIG,
        //         ConsumerInterceptorTTL.class.getName());
        // commitSync 同步提交
        // commitAsync 异步提交
        // 手动位移提交
        // props.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);


        // 设置消费组的名称，具体的释义可以参见第3章
        properties.put("group.id", groupId);
        // 创建一个消费者客户端实例
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        //         // 订阅主题
        consumer.subscribe(Collections.singletonList(topic));
        // 订阅主题的特殊分区
        // public void assign(Collection<TopicPartition> partitions)

        // 查询主题元数据信息 -- 分区等等信息
        // public List<PartitionInfo> partitionsFor(String topic)

        // 获取posotion 下一次拉去消息 offset
        // public long position(TopicPartition partition)

        // 已经消费到的位置
        // public OffsetAndMetadata committed(TopicPartition partition)

        // 循环消费消息
        while(true) {
            ConsumerRecords<String, String> records =
                    consumer.poll(Duration.ofMillis(1000));
            for (ConsumerRecord<String, String> record : records) {
                System.out.println(record.key());
                System.out.println(record.value());
            }
        }
    }
}