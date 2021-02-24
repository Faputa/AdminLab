package adminlab.controller;

import java.io.IOException;
import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import adminlab.common.ProxyBaseController;

@Controller
public class ProxyController extends ProxyBaseController {

    @Autowired
    Environment environment;

    @RequestMapping("/proxy/**")
    public ResponseEntity<byte[]> proxy(HttpServletRequest request) throws IOException {
        String scheme = request.getScheme();
        String host = InetAddress.getLocalHost().getHostAddress();
        String port = environment.getProperty("local.server.port");
        String target = UriComponentsBuilder.newInstance().scheme(scheme).host(host).port(port).toUriString();
        String rewrite = UriComponentsBuilder.newInstance().path(request.getContextPath()).path("proxy").toUriString();
        return super.proxy(target, rewrite, request);
    }

}
