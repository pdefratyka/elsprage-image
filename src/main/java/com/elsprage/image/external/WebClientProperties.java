package com.elsprage.image.external;

import lombok.Data;


@Data
public abstract class WebClientProperties {
    private String url;
    private String apiName;
}
