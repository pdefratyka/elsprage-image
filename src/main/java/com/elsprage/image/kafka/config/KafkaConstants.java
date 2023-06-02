package com.elsprage.image.kafka.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class KafkaConstants {

    public static final String IMAGE_TOPIC = "elsprage-image";
    public static final String WORD_MODIFICATION_TOPIC = "elsprage-word-modification";
    public static final String GROUP_ID = "elsprage-image-group";
}
