package com.test.kafka.strconsumer.listeners;

import com.test.kafka.strconsumer.custom.StrConsumerCustomListner;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class StrConsumerListener {

    @StrConsumerCustomListner(groupId = "group-1")
    public void create(String message){
       log.info("CREATE ::: Receive message {}", message);
    }
    @StrConsumerCustomListner(groupId = "group-1")
    public void log(String message){
        log.info("LOG ::: Receive message {}", message);
    }

    @StrConsumerCustomListner(groupId = "group-2")
    public void history(String message){
        log.info("HISTORY  ::: Receive message {}", message);
    }
}
