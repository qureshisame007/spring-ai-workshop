package dev.danvega.workshop.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/chat")
    public String chat(){
        return chatClient.prompt()
                .user("tell me interesting fact about java")
                .call()
                .content();

    }

    @GetMapping("/stream")
    public Flux<String> stream(){
        return chatClient.prompt()
                .user("i am visiting hilton head soon , can you give me 10 places i must  visit?")
                .stream()
                .content();
    }

    @GetMapping("/joke")
    public ChatResponse joke(){
        return chatClient.prompt()
                .user("tell me dad joke about dogs")
                .call()
                .chatResponse();

    }
}
