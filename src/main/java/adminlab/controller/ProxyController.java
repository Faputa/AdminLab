package adminlab.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import adminlab.common.ProxyBaseController;

@Controller
public class ProxyController extends ProxyBaseController {

    @RequestMapping("/api_xxxx/**")
    public ResponseEntity<byte[]> proxy(HttpServletRequest request) throws IOException {
        return super.proxy("http://xxx.xxx.xxx.xxx:xxxx", request.getContextPath(), request);
    }
}
