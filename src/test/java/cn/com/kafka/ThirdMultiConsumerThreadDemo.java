package cn.com.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static cn.com.kafka.KafkaProducerAnalysis.initConfig;

//代码清单14-2 第三种多线程消费实现方式
public class ThirdMultiConsumerThreadDemo {
    public static final String brokerList = "localhost:9092";
    public static final String topic = "topic-demo";
    public static final String groupId = "group.demo";

    //省略initConfig()方法，具体请参考代码清单14-1
    public static void main(String[] args) {
        Properties props;
        props = initConfig();
        KafkaConsumerThread consumerThread = 
                new KafkaConsumerThread(props, topic,
                Runtime.getRuntime().availableProcessors());
        consumerThread.start();
    }

    public static class KafkaConsumerThread extends Thread {
        private KafkaConsumer<String, String> kafkaConsumer;
        private ExecutorService executorService;
        private int threadNumber;

        public KafkaConsumerThread(Properties props, 
                String topic, int threadNumber) {
            kafkaConsumer = new KafkaConsumer<>(props);
            kafkaConsumer.subscribe(Collections.singletonList(topic));
            this.threadNumber = threadNumber;
            Map<TopicPartition, OffsetAndMetadata> offsets = new HashMap<>();

            executorService = new ThreadPoolExecutor(threadNumber, threadNumber,
                    0L, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(1000),
                    new ThreadPoolExecutor.CallerRunsPolicy());
        }

        @Override
        public void run() {
            try {
                while (true) {
                    ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(100));
                    if (!records.isEmpty()) {
                        executorService.submit(new RecordsHandler(records));
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                kafkaConsumer.close();
            }
        }

    }

    public static class RecordsHandler extends Thread{
        public final ConsumerRecords<String, String> records;
        public RecordsHandler(ConsumerRecords<String, String> records) {
            this.records = records;
        }

        @Override
        public void run(){
            for (TopicPartition tp : records.partitions()) {
                List<ConsumerRecord<String, String>> tpRecords = records.records(tp);
                //处理tpRecords.
                long lastConsumedOffset = tpRecords.get(tpRecords.size() - 1).offset();
                //
                // synchronized (offsets) {
                //     if (!offsets.containsKey(tp)) {
                //         offsets.put(tp, new OffsetAndMetadata(lastConsumedOffset + 1));
                //     }else {
                //         long position = offsets.get(tp).offset();
                //         if (position < lastConsumedOffset + 1) {
                //             offsets.put(tp, new OffsetAndMetadata(lastConsumedOffset + 1));
                //         }
                //     }
                // }
            }
            //处理records.
        }
    }
}