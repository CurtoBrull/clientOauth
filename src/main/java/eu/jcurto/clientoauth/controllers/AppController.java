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
        return List.of(
                new Message("Hello, World!"),
                new Message("Goodbye, World!")
        );
    }

    @PostMapping("/createMessage")
    public Message createMessage(@RequestBody Message message) {
        return new Message("Message created: " + message.getMessageText());
    }

    public Map<String, String> auth(@RequestParam String code) {
        return Collections.singletonMap("code", code);
    }

}