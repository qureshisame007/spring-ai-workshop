package dev.danvega.workshop.structuredOutput;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VacationPlan {

    public final ChatClient chatClient;

    public VacationPlan(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/vacation/unstructured")
    public String unstructured(){
        return chatClient.prompt()
                .user("i want to plan a trip to hawaii, give me list of things to do ")
                .call()
                .content();
    }

    @GetMapping("/vacation/structured")
    public Itinerary structured(){
        return chatClient.prompt()
                .user("i want to plan a trip to hawaii, give me list of things to do")
                .call()
                .entity(Itinerary.class);
    }
}
