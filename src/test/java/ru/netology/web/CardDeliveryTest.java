package ru.netology.web;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;

public class CardDeliveryTest {
    @Test
    void shouldTestFormCardDeliveryOrdering(){
        String date = LocalDate.now().plusDays(7).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));

     open("http://localhost:9999");
     $("[data-test-id='city'] input").setValue("Саратов");
     $("[data-test-id='date'] input").doubleClick().sendKeys(Keys.BACK_SPACE);
     $("[data-test-id='date'] input").setValue(date);
     $("[data-test-id='name'] input").setValue("Иванов Иван");
     $("[data-test-id='phone'] input").setValue("+79012345678");
     $("[data-test-id='agreement']").click();
     $(".grid-row [role='button' ]").click();
     $(withText("Встреча успешно")).shouldBe(Condition.visible,Duration.ofSeconds(15));







    }
}
