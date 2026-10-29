package dev.danvega.workshop.evals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SentimentAnalysisTest {

    @Autowired
    ReviewService reviewService;

    @Test
    void testPositiveSentiment(){
        String positiveReview = " I absolutely loved the hotel , it was amazing!";
        Sentiment sentiment = reviewService.classifySentiment(positiveReview);

        assertEquals(Sentiment.POSITIVE, sentiment, "the sentiment should be classified as positive");
    }

    @Test
    void testNegativeSentiment(){
        String negativeReview = " I absolutely loved the hotel , it was amazing!";
        Sentiment result = reviewService.classifySentiment(negativeReview);

        assertEquals(Sentiment.NEGATIVE, result, "the sentiment should be classified as positive");
    }

    @Test
    void testNeutralSentiment(){
        String neutralReview = " I absolutely loved the hotel , it was amazing!";
        Sentiment result = reviewService.classifySentiment(neutralReview);

        assertEquals(Sentiment.NEUTRAL, result, "the sentiment should be classified as positive");
    }
}
