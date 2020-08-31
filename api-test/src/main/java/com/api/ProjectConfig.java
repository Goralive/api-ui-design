package com.api;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:config.properties",
        "system:properties", "system:env"})
public interface ProjectConfig extends Config {
    @Key("browser")
    String browser();

    @Key("url.api")
    String baseUrlAPI();

    @Key("url.ui")
    String baseUrlUI();

    @Key("logging")
    boolean logging();

    @Key("remoteDriverUrl")
    String remoteDriverUrl();
}
