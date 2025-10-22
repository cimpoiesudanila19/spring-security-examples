# Spring Security JWT + RBAC Example

Простой пример проекта на Spring Boot с использованием:

- **Spring Security**
- **JWT (JSON Web Tokens)**
- **RBAC (Role-Based Access Control)**
- **REST API**

---

## Описание

Проект демонстрирует:

- Аутентификацию через JWT
- Разделение доступа на основе ролей (ADMIN и USER)
- Защиту REST API эндпоинтов
- Возможность расширения под любые роли и права

---

## Используемые технологии

- Java 17+
- Spring Boot 3.x
- Spring Security
- Maven
- JWT (io.jsonwebtoken / jjwt)
- In-memory хранилище пользователей (для простоты)

---

## Роли и пользователи

| Роль  | Логин  | Пароль    |
|-------|--------|-----------|
| ADMIN | admin  | admin123  |
| USER  | user   | user123   |

---

## Эндпоинты

| URL                  | Метод | Доступ       | Описание                     |
|---------------------|-------|-------------|-------------------------------|
| `/auth/login`        | POST  | Все         | Получение JWT по логину/паролю |
| `/admin/data`        | GET   | ADMIN       | Доступно только администратору |
| `/user/data`         | GET   | USER, ADMIN | Доступно пользователю или администратору |

---

## Как запустить проект

1. Клонируйте репозиторий:
   ```bash
   git clone <repo-url>
   cd <repo-folder>
Соберите и запустите проект:

bash
Copy code
mvn clean spring-boot:run
Отправьте POST запрос на логин:

bash
Copy code
curl -X POST http://localhost:8080/auth/login \
     -H "Content-Type: application/json" \
     -d '{"username":"admin","password":"admin123"}'
Вы получите JWT токен в ответе.

Используйте токен для доступа к защищённым эндпоинтам:

bash
Copy code
curl -H "Authorization: Bearer <JWT_TOKEN>" http://localhost:8080/admin/data
Расширение проекта
Добавление новых ролей и прав

Подключение базы данных для хранения пользователей

Интеграция с фронтендом

Настройка refresh-токенов

Примечания
Для простоты примера используется in-memory аутентификация.

В реальном проекте рекомендуется хранить пользователей в БД и использовать BCrypt для хеширования паролей.