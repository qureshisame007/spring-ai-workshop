package dev.danvega.workshop.multimodality;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageToText {

    private final ChatClient chatClient;

    public ImageToText(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/image")
    public String describeImage() {
        return chatClient.prompt()
                .user(u -> u.text("Explain what do you see on this picture?")
                        .media(MimeTypeUtils.IMAGE_PNG,
                                new ClassPathResource("multimodal.test.png")))
                .call()
                .content();
    }
}