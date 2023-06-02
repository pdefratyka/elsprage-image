package com.elsprage.image.external.image;


import com.elsprage.image.model.response.ImageApiResponse;

public interface ImageApiService {
    ImageApiResponse getImage(String keyword);
}
