package com.wsp.spoon.config.init;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "logoinfo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogoInfo {
    private String title;
    private String image;
    private String href;
}
