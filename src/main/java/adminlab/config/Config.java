package adminlab.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("config")
public class Config {

    /** 是否开启devServer */
    private boolean devServer = false;

    public boolean isDevServer() {
        return devServer;
    }

    public void setDevServer(boolean devServer) {
        this.devServer = devServer;
    }

}
