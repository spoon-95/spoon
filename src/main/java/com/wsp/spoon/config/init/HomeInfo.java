package com.wsp.spoon.config.init;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "homeinfo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HomeInfo {
    private String title;
    private String href;
}
