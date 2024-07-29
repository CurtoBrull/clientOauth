package eu.jcurto.clientoauth.controllers;

import eu.jcurto.clientoauth.models.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
public class AppController {

    @GetMapping("/messages")
    public List<Message> messageList() {
        return Collections.singletonList(new Message("Hello, World!"));
    }

    @PostMapping("/createMessage")
    public Message createMessage(@RequestBody Message message) {
        System.out.println("Message created: " + message.getMessageText());
        return message;
    }

    @GetMapping("/authorized")
    public Map<String, String> authorized(@RequestParam String code) {
        return Collections.singletonMap("code", code);
    }

}
