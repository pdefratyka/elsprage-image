package com.elsprage.image.external.image;

import com.elsprage.image.common.constants.Constants;
import com.elsprage.image.external.WebClientProperties;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = ImageApiProperties.PREFIX)
@Data
public class ImageApiProperties extends WebClientProperties {
    public static final String PREFIX = Constants.ELSPRAGE_PREFIX + ".image.api";
    private String authorization;
}
