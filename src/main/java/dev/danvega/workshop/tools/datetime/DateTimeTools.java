package dev.danvega.workshop.tools.datetime;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.context.i18n.LocaleContextHolder;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateTimeTools {

    @Tool(description = "Get the current date and time in the users timezone")
    public String getCurrentDateTime(){
        return LocalDateTime.now().atZone(LocaleContextHolder.getTimeZone().toZoneId()).toString();

    }
}
