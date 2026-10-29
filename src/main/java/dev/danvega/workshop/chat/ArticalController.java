package dev.danvega.workshop.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticalController {

    public final ChatClient chatClient;

    public ArticalController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/post/new")
    public String newPost(@RequestParam(value = "topic" , defaultValue  = "JDK Virtual Threads") String topic) {


        var system = """
                
                
                        Blog Post Generator guidline:
                        1. with two bullet point
                                2.with some code
                                3. real world example
                                4.simple tone and style
                                5.response should be in text or code
                """;
        return chatClient.prompt()
                .user(promptUserSpecu -> {
                    ChatClient.PromptSystemSpec u = null;
                    u.text("write me a blog post about{topic}");
                    u.param("topic", topic);
                })
                .system(system)
                .call()
                .content();
    }
}
