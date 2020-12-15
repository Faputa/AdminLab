package adminlab.common;

import java.io.IOException;
import java.net.URI;
import java.util.Enumeration;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public abstract class ProxyBaseController {

    public ResponseEntity<String> proxy(String target, String rewrite, HttpServletRequest request) throws IOException {

        String path = request.getRequestURI().replaceFirst(Pattern.quote(rewrite), "");
        URI uri = UriComponentsBuilder.fromUriString(target).path(path).query(request.getQueryString()).build(true).toUri();

        HttpHeaders headers = new HttpHeaders();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            headers.set(headerName, request.getHeader(headerName));
        }

        String body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
        HttpEntity<String> httpEntity = new HttpEntity<>(body, headers);
        RestTemplate restTemplate = new RestTemplate();
        try {
            return restTemplate.exchange(uri, HttpMethod.resolve(request.getMethod()), httpEntity, String.class);
        } catch (RestClientResponseException e) {
            return ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString());
        }
    }
}
