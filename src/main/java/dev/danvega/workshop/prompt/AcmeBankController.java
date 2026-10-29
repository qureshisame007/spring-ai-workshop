package dev.danvega.workshop.prompt;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acme")
public class AcmeBankController {

    private final ChatClient chatClient;

    public AcmeBankController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/chat")
    public String chat(@RequestParam String message){
        var systemInstructions = """
                you are a customer service assistent for AcmeBank.
                you can only discuss:
        -Acount balances and trasaction
                -Branch location and hour
                -General Banking service

                if asked about else ,respond:" i can only help with banking-related Quections."
                """;
        return chatClient.prompt()
                .user(message)
                .system(systemInstructions)
                .call()
                .content();


    }
}
