package com.cts.dailyshareprice.exception;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ExceptionDetailsTest {
    private ExceptionDetails details = new ExceptionDetails(LocalDateTime.now(),"message");
    @Test
    void testMessageSetter() {
        details.setMessage("new message");
        assertThat(details.getMessage().equals("new message"));
    }
    @Test
    void testTimeStampSetter() {
        LocalDateTime date = LocalDateTime.now();
        details.setTimeStamp(date);
        assertThat(details.getTimeStamp().equals(date));
    }
}




