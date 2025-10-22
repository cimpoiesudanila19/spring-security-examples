# 🔐 Spring Boot + Security + JWT Example

Простой пример REST API с аутентификацией через **JSON Web Token (JWT)**.  
Проект показывает, как защитить эндпоинты в Spring Boot и выдавать токен при входе.

---

## 🚀 Технологии

- **Spring Boot 3**
- **Spring Security 6**
- **JWT (JJWT)**
- **Lombok**
- **Spring Web**

---

## 📁 Структура проекта

src/
├─ main/java/com/example/demo/
│ ├─ config/
│ │ └─ SecurityConfig.java # Настройка безопасности
│ ├─ controller/
│ │ ├─ AuthController.java # Точка входа /auth/login
│ │ └─ HelloController.java # Пример защищённого эндпоинта
│ ├─ filter/
│ │ └─ JwtAuthFilter.java # Проверка JWT в каждом запросе
│ └─ service/
│ └─ JwtService.java # Генерация и валидация токенов
└─ resources/
└─ application.yml


---

## ⚙️ Настройка и запуск

### 1️⃣ Клонировать проект
```bash
git clone https://github.com/username/spring-jwt-demo.git
cd spring-jwt-demo
2️⃣ Запустить приложение

mvn spring-boot:run
Приложение будет доступно по адресу:

http://localhost:8080
🔑 Аутентификация
🔹 Вход
POST /auth/login

Тело запроса:

{
  "username": "admin",
  "password": "1234"
}
Ответ при успешном входе:

{
  "token": "eyJhbGciOiJIUzI1NiIsInR..."
}
🔹 Доступ к защищённому эндпоинту
GET /api/hello

Добавь в заголовки:

Authorization: Bearer <твой_токен>
Ответ:

Hello, secured world!
🧠 Как это работает
Пользователь отправляет логин/пароль → сервер проверяет → выдает JWT.

Клиент сохраняет токен (обычно в localStorage или Authorization header).

Каждый запрос к защищённым эндпоинтам проходит через JwtAuthFilter,
где токен проверяется и создаётся объект аутентификации.

Если токен корректен — запрос выполняется, иначе возвращается 401 Unauthorized.

🧩 Основные файлы
Файл	Описание
SecurityConfig.java	Конфигурирует фильтры и доступ
JwtService.java	Создаёт и проверяет JWT токены
JwtAuthFilter.java	Перехватывает запросы и извлекает пользователя
AuthController.java	Логин и выдача токена
HelloController.java	Пример защищённого эндпоинта

🛠 Пример запроса в Postman
1️⃣ Авторизация
Метод: POST

URL: http://localhost:8080/auth/login

Body → raw → JSON:

{ "username": "admin", "password": "1234" }
2️⃣ Доступ к API
Метод: GET

URL: http://localhost:8080/api/hello

Headers:

Authorization: Bearer <токен_из_предыдущего_запроса>
💡 Возможные улучшения
Подключить базу данных (PostgreSQL, MySQL, H2) для хранения пользователей.

Добавить Refresh Token.

Использовать BCryptPasswordEncoder для хранения хэшей паролей.

Добавить роли и разрешения (ROLE_USER / ROLE_ADMIN).

📄 Лицензия
Этот проект создан для обучения и свободно доступен под лицензией MIT.

✨ Автор: [твоё имя]
📧 Контакт: youremail@example.com
🌐 GitHub: github.com/username
