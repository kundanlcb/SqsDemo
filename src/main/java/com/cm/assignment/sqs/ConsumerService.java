package com.cm.assignment.sqs;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class ConsumerService {

    @Value("${app.config.message.queue.topic}")
    private String messageQueueTopic;
    private final AmazonSQS amazonSQSClient;

    @Scheduled(fixedRate = 5000)
    public void pollQueue() {
        log.info("Poll queue cron called");
        GetQueueUrlResult queueUrl = amazonSQSClient.getQueueUrl(messageQueueTopic);

        ReceiveMessageResult messageResult = amazonSQSClient.receiveMessage(queueUrl.getQueueUrl());
        if (!messageResult.getMessages().isEmpty()) {
            log.info("Fetched list from queue");
            messageResult.getMessages().parallelStream().forEach(msg -> {
                        processMessage(msg.getBody());
                        amazonSQSClient.deleteMessage(queueUrl.getQueueUrl(), msg.getReceiptHandle());
                    }
            );
        } else {
            log.info("Queue List is empty");
        }

    }

    public void processMessage(String msg) {
        //TODO save to database
        log.info(msg);
    }

}
