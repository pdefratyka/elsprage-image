package com.elsprage.image.kafka.producer;

import com.elsprage.external.words.avro.WordModificationActionType;
import com.elsprage.external.words.avro.WordModificationEvent;
import com.elsprage.image.kafka.config.KafkaConstants;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;

@Service
@AllArgsConstructor
@Slf4j
public class WordModificationEventProducer {

    private final KafkaTemplate<String, WordModificationEvent> kafkaTemplate;

    public void sendMessage(final Long wordId, byte[] imageFile) {
        log.info("Produce kafka message with image update for word with id; {}", wordId);
        final WordModificationEvent wordModificationEvent = WordModificationEvent.newBuilder()
                .setImageFile(ByteBuffer.wrap(imageFile))
                .setWordId(wordId)
                .setActionType(WordModificationActionType.IMAGE_UPDATE)
                .build();
        kafkaTemplate.send(KafkaConstants.WORD_MODIFICATION_TOPIC, wordModificationEvent);
    }
}
