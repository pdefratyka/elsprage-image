package com.elsprage.image.service.impl;

import com.elsprage.image.kafka.producer.WordModificationEventProducer;
import com.elsprage.image.service.ImageProcessingService;
import com.elsprage.image.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ImageProcessingServiceImpl implements ImageProcessingService {

    private final ImageService imageService;
    private final WordModificationEventProducer wordModificationEventProducer;

    @Override
    public void processImageUpdate(String key, String language, Long wordId) {
        try {
            final byte[] image = imageService.getImage(key);
            if (image != null) {
                wordModificationEventProducer.sendMessage(wordId, image);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
