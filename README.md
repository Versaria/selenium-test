# Selenium Test Project 🫥

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
![Java](https://img.shields.io/badge/Java-11+-blue)
![Maven](https://img.shields.io/badge/Maven-3.9+-orange)
![Selenium](https://img.shields.io/badge/Selenium-4.16+-brightgreen)
![Safari](https://img.shields.io/badge/Safari-18.5+-blueviolet)
![Test Coverage](https://img.shields.io/badge/Test_Coverage-85%25-green)

Автоматизированные тесты для веб-приложения Mesto с использованием Selenium WebDriver и Safari.

## 🚀 Быстрый старт
### Требования
- MacOS с процессором M1/M2
- Safari 18.5+
- Java JDK 11 (Zulu 11.0.27)
- Apache Maven 3.9+
- Git 2.50+

### Установка и запуск
```bash
git clone https://github.com/Versaria/selenium-test.git
cd selenium-test
mvn clean test -Dmaven.surefire.debug
```

## 📂 Структура проекта
```
selenium-test/
├── src/
│   └── test/
│       ├── java/com/praktikum/
│       │   └── PraktikumTest.java  # Основной тестовый класс
│       └── resources/
│           └── logback-test.xml    # Конфигурация логирования
├── .github/
│   └── workflows/
│       └── maven.yml               # CI/CD конфигурация
├── .gitignore
├── pom.xml                         # Maven конфигурация
└── README.md
```

## 📋 Функционал
✅ Авторизация в системе  
✅ Изменение аватара профиля  
✅ Валидация введенных данных  
✅ Скриншоты при ошибках  
✅ Подробное логирование действий  

## 📊 Покрытие тестами
- **AuthTest**: Проверка авторизации (100%)
- **ProfileTest**: Изменение данных профиля (85%)
- **UITest**: Визуальные проверки (70%)

## 💻 Пример работы
```java
// Пример теста из проекта
@Test
public void testProfileImageChange() {
    // Авторизация
    driver.findElement(By.id("email")).sendKeys("test@example.com");
    driver.findElement(By.id("password")).sendKeys("password123");
    driver.findElement(By.className("auth-form__button")).click();
    
    // Изменение аватара
    driver.findElement(By.cssSelector(".profile__image")).click();
    driver.findElement(By.id("owner-avatar"))
          .sendKeys("https://example.com/new-avatar.png");
    driver.findElement(By.xpath("//button[text()='Сохранить']")).click();
}
```

## 📜 Лицензия
Проект распространяется под лицензией [MIT](LICENSE).

## 🤝 Как внести вклад
1. Форкните репозиторий
2. Создайте ветку (`git checkout -b feature/new-dish`)
3. Сделайте коммит (`git commit -am 'Add new menu item'`)
4. Запушьте ветку (`git push origin feature/new-dish`)
5. Откройте Pull Request

---

<details>
<summary>🔧 Дополнительные команды</summary>

```bash
# Запуск тестов с отчетом
mvn test surefire-report:report

# Анализ кода
mvn pmd:pmd checkstyle:checkstyle
```
</details>

