package example.restapi.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    static final Logger logger = (Logger) LoggerFactory.getLogger(HelloController.class);

    @GetMapping(value="/hello", produces = "application/json")
    public Map<String, Object> helloSpringBoot() throws UnknownHostException {
        Map<String, Object> model = new HashMap<String, Object>();
        
        logger.info("hello~ greeting!");
     
        String address = InetAddress.getLocalHost().getHostAddress();
        String host = InetAddress.getLocalHost().getHostName();

        model.put("message", "Hello World!");
        model.put("address", address);
        model.put("host", host);

        return model;
    }
}
