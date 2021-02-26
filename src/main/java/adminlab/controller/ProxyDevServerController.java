package adminlab.controller;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import adminlab.common.ProxyBaseController;

@Controller
@ConditionalOnProperty("my.config.devServer")
public class ProxyDevServerController extends ProxyBaseController {

    @Autowired
    Environment environment;

    @RequestMapping("/**")
    public ResponseEntity<byte[]> proxyDevServer(HttpServletRequest request) throws IOException {
        String scheme = request.getScheme();
        String host = InetAddress.getLocalHost().getHostAddress();
        String port = "9528";
        String target = UriComponentsBuilder.newInstance().scheme(scheme).host(host).port(port).toUriString();
        String rewrite = UriComponentsBuilder.newInstance().path(request.getContextPath()).toUriString();
        return super.proxy(target, rewrite, request);
    }

}
