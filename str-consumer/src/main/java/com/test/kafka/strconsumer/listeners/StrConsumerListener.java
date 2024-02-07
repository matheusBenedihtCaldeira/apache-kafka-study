package com.test.kafka.strconsumer.listeners;

import com.test.kafka.strconsumer.custom.StrConsumerCustomListner;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class StrConsumerListener {

    @SneakyThrows
    @StrConsumerCustomListner(groupId = "group-1")
    public void create(String message){
       log.info("CREATE ::: Receive message {}", message);
        throw new IllegalArgumentException("ERRO!!");
    }
    @StrConsumerCustomListner(groupId = "group-1")
    public void log(String message){
        log.info("LOG ::: Receive message {}", message);
    }

    @KafkaListener(groupId = "group-2", containerFactory = "validMessageContainerFactory", topics = "str-topic")
    public void history(String message){
        log.info("HISTORY  ::: Receive message {}", message);
    }
}
