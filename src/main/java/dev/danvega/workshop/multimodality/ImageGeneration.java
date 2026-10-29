/*
package dev.danvega.workshop.multimodality;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentConfig;
import com.google.genai.types.GenerateContentResponse;
import com.google.genai.types.Part;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;

@RestController
public class ImageGeneration {

    private final Client client;

    public ImageGeneration(@Value("${spring.ai.google.genai.api-key}") String apiKey) {
        this.client = Client.builder().apiKey(apiKey).build();
    }

    @GetMapping("/generate-image")
    public Map<String, String> generateImage(
            @RequestParam(defaultValue = "A beautiful sunset over mountains") String prompt) throws Exception {

        GenerateContentResponse response = client.models.generateContent(
                "gemini-2.5-flash-image",
                prompt,
                GenerateContentConfig.builder().build());

        byte[] imageBytes = null;
        for (Part part : response.parts()) {
            if (part.inlineData().isPresent()) {
                imageBytes = part.inlineData().get().data().orElseThrow();
                break;
            }
        }

        if (imageBytes == null) {
            throw new IllegalStateException("No image returned by model");
        }

        Path file = Path.of("generated-image.png");
        Files.write(file, imageBytes);
        return Map.of("file", file.toAbsolutePath().toString());
    }
}*/
