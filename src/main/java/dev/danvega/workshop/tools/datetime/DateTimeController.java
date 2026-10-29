package dev.danvega.workshop.tools.datetime;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DateTimeController {

    public final ChatClient chatClient;

    public DateTimeController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/tools")
    public String tools(){
        return chatClient.prompt()
                .user("what is tommorow date?")
                .tools(new DateTimeTools())
                .call()
                .content();
    }
}
