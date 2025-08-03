package com.praktikum;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PraktikumTest {

    private WebDriver driver;

    @Test
    public void testChangeProfileImage() {
        // Настройка драйвера Safari
        SafariOptions options = new SafariOptions();
        options.setCapability("safari:diagnose", true);
        driver = new SafariDriver(options);
        driver.manage().window().maximize();

        // Открытие страницы
        driver.get("https://qa-mesto.praktikum-services.ru/");

        // Авторизация
        driver.findElement(By.id("email")).sendKeys("versaria.o@yandex.ru");
        driver.findElement(By.id("password")).sendKeys("qaswef-ketped-3motKo");
        driver.findElement(By.className("auth-form__button")).click();

        // Ожидание загрузки профиля
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".profile__image")));

        // Клик по изображению профиля
        driver.findElement(By.cssSelector(".profile__image")).click();

        // Ввод ссылки на новое изображение
        driver.findElement(By.id("owner-avatar"))
                .sendKeys("https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/avatarSelenium.png");

        // Сохранение нового изображения
        driver.findElement(By.xpath(".//form[@name='edit-avatar']/button[text()='Сохранить']")).click();
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}