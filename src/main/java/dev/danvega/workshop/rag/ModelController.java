/*
package dev.danvega.workshop.rag;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.vectorstore.QuestionAnswerAdvisor;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModelController {

    private final ChatClient chatClient;

    public ModelController(ChatClient.Builder builder, VectorStore vectorStore) {
        this.chatClient = builder
                .defaultAdvisors(new QuestionAnswerAdvisor(vectorStore))
                .build();
    }

    @GetMapping("/rag/models")
    public String faq(@RequestParam(value = "message", defaultValue = "give me a list of all model from OpenAI") String message) {
        return chatClient.prompt()
                .user(message)
                .call()
                .content();
    }
}*/
