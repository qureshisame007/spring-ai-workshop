/*
package dev.danvega.workshop.multimodality.audio;

import com.google.genai.Client;
import com.google.genai.types.GenerateContentConfig;
import com.google.genai.types.PrebuiltVoiceConfig;
import com.google.genai.types.SpeechConfig;
import com.google.genai.types.VoiceConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.List;

@RestController
public class AudioGeneration {

    private final Client client;

    public AudioGeneration(@Value("${spring.ai.google.genai.api-key}") String apiKey) {
        this.client = Client.builder().apiKey(apiKey).build();
    }

    @GetMapping("/speach")
    public ResponseEntity<byte[]> generateSpeach(
            @RequestParam(defaultValue = "it is a great time to be a java & spring developer") String text) {

        GenerateContentConfig config = GenerateContentConfig.builder()
                .responseModalities(List.of("AUDIO"))
                .speechConfig(SpeechConfig.builder()
                        .voiceConfig(VoiceConfig.builder()
                                .prebuiltVoiceConfig(PrebuiltVoiceConfig.builder()
                                        .voiceName("Kore")
                                        .build())
                                .build())
                        .build())
                .build();

        var response = client.models.generateContent("gemini-2.5-flash-preview-tts", text, config);

        byte[] pcm = response.parts().stream()
                .filter(p -> p.inlineData().isPresent())
                .findFirst()
                .orElseThrow()
                .inlineData().get()
                .data().orElseThrow();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"speach.wav\"")
                .contentType(MediaType.parseMediaType("audio/wav"))
                .body(toWav(pcm));
    }

    // Gemini raw PCM deta hai (24kHz, mono, 16-bit), isliye WAV header add karna zaroori hai
    private byte[] toWav(byte[] pcm) {
        ByteBuffer buf = ByteBuffer.allocate(44 + pcm.length).order(ByteOrder.LITTLE_ENDIAN);
        buf.put("RIFF".getBytes()).putInt(36 + pcm.length).put("WAVE".getBytes())
                .put("fmt ".getBytes()).putInt(16).putShort((short) 1).putShort((short) 1)
                .putInt(24000).putInt(24000 * 2).putShort((short) 2).putShort((short) 16)
                .put("data".getBytes()).putInt(pcm.length).put(pcm);
        return buf.array();
    }
}*/
