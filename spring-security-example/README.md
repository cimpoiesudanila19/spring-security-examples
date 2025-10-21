# 🔐 Spring Security Demo

Простое приложение на **Spring Boot**, демонстрирующее базовую аутентификацию с помощью **Spring Security**.

---

## 🚀 Возможности
- Авторизация через **formLogin()**
- Поддержка **Basic Auth** (для REST-запросов)
- Один пользователь, хранящийся **в памяти (In-Memory Authentication)**
- Пример защищённых и публичных эндпоинтов

---

## ⚙️ Технологии
- Java 17+
- Spring Boot 3.x
- Spring Security
- Maven

---

## 🧩 Настройки
Порт приложения: **8088**

```properties
server.port=8088

Доступные пути:

Endpoint	Описание	Доступ
/public/**	Публичные страницы	Без авторизации
/login	Форма входа	Все
/ или /secure	Защищённые страницы	Только после входа

👤 Данные для входа
Логин	Пароль	Роль
admin	password	USER

▶️ Как запустить

Убедись, что установлен Java 17+ и Maven

Выполни в терминале:

mvn spring-boot:run


Перейди по адресу:
👉 http://localhost:8088/login

🧠 Как это работает

Аутентификация настраивается в SecurityConfig.java:

http
    .authorizeHttpRequests(auth -> auth
        .requestMatchers("/public/**").permitAll()
        .anyRequest().authenticated()
    )
    .formLogin(Customizer.withDefaults())
    .httpBasic(Customizer.withDefaults());


Пользователи создаются в памяти:

User.builder()
    .username("admin")
    .password("{noop}password")
    .roles("USER")
    .build();

📦 Структура проекта
src/
 └── main/
     ├── java/org/example/
     │   ├── SecurityConfig.java
     │   └── MainApplication.java
     └── resources/
         └── application.properties
pom.xml

💡 Идеи для улучшения

Добавить регистрацию пользователей

Подключить базу данных (Spring Data JPA)

Реализовать JWT или OAuth2 авторизацию

Развернуть в Docker

© 2025 — пример для изучения Spring Security