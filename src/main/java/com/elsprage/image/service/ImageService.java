package com.elsprage.image.service;

import java.io.IOException;

public interface ImageService {
    byte[] getImage(String keyword) throws IOException;
}
