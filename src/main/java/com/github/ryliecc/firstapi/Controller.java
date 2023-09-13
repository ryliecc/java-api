package com.github.ryliecc.firstapi;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class Controller {
    Map<Integer, Message> messages = new HashMap<>();

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, World!";
    }
    @GetMapping("/hello/?{name}")
    public String sayHello(@PathVariable String name) {
        return "Hello, " + name + "!";
    }
    @PostMapping("/messages/{message}/{name}/{id}")
    public String greet(@PathVariable String message,@PathVariable String name, @PathVariable int id) {
        Message newMessage = new Message(name, message, id);
        messages.put(id, newMessage);
        return "Message: " + message + " with the name " + name + " and ID " + id + " added to List.";
    }
    @GetMapping("/messages")
    public Map<Integer, Message> listMessages() {
        return messages;
    }


    @DeleteMapping("/messages/{id}")
        public String delete(@PathVariable int id) {
            messages.remove(id);
            return "Message with ID  " + id + "removed.";

        }

}
