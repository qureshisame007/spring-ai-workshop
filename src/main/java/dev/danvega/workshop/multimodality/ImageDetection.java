package dev.danvega.workshop.multimodality;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageDetection {

    public final ChatClient chatClient;

    @Value("classpath:/multimodal.test.png")
    Resource sampleImage;
    public ImageDetection(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }

    @GetMapping("/imagetotext")
    public String imageToText(){
        return chatClient.prompt()
                .user(u -> {
                    u.text("can you please describe what you see in following image");
                    u.media(MimeTypeUtils.IMAGE_PNG, (org.springframework.core.io.Resource) sampleImage);

                })
                .call()
                .content();
    }


}
