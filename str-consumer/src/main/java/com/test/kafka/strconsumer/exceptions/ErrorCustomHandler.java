package com.test.kafka.strconsumer.exceptions;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class ErrorCustomHandler implements KafkaListenerErrorHandler {

    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception) {
        log.error("EXCEPTION ::: {}", exception.getMessage());
        log.info("EXCEPTION_INFO ::: Payload {}", message.getPayload());
        log.info("EXCEPTION_INFO ::: Headers {}", message.getHeaders());
        return null;
    }
}