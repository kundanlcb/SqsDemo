package com.cm.assignment.sqs;

import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.GetQueueUrlResult;
import com.amazonaws.services.sqs.model.InvalidMessageContentsException;
import com.amazonaws.services.sqs.model.QueueDoesNotExistException;
import com.cm.assignment.dto.ProductOrderDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PublisherService {

    @Value("${app.config.message.queue.topic}")
    private String messageQueueTopic;
    private final AmazonSQS amazonSQSClient;

    public void sendOrderToQueue(ProductOrderDto orderDto) {
        try {
            GetQueueUrlResult queueUrl = amazonSQSClient.getQueueUrl(messageQueueTopic);
            log.info("Reading SQS Queue done: URL {}", queueUrl.getQueueUrl());
            amazonSQSClient.sendMessage(queueUrl.getQueueUrl(), orderDto.toString());
        } catch (QueueDoesNotExistException | InvalidMessageContentsException e) {
            log.error("Queue does not exist {}", e.getMessage());
        }
    }

}
