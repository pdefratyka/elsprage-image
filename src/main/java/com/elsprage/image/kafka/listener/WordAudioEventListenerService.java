package com.elsprage.image.kafka.listener;

import com.elsprage.external.words.avro.WordImageEvent;
import com.elsprage.image.kafka.config.KafkaConstants;
import com.elsprage.image.service.ImageProcessingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class WordAudioEventListenerService {

    private final ImageProcessingService imageProcessingService;

    @KafkaListener(topics = KafkaConstants.IMAGE_TOPIC, groupId = KafkaConstants.GROUP_ID)
    public void consumeMessage(WordImageEvent message) {
        log.info("Received message: {}", message);
        imageProcessingService.processImageUpdate(message.getKey().toString(), message.getLanguage().toString(), message.getWordId());
    }
}
