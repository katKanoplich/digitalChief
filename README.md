# Digital Chief - Book Management System

## Business Model

Бизнес-модель этого проекта состоит из двух сущностей: Book(Книга) и BookStore(Книжный магазин), с отношением "один ко многим".

Ключевые детали следующие:

**Book(Книга)**
- Представляет книгу в системе
- Атрибуты: `id`, `title`, `publisher`, `year`, `author`, `price`, `quantity`


**BookStore(Книжный магазин)**
- Представляет книжный магазин, который продает книги
- Атрибуты: `id`, `name`, `address`, `phone`
- One-to-many(один ко многим) отношения с сущностью `Book`, где один BookStore(Книжный магазин) может иметь несколько Books(Книг)

## Setup

Для запуска приложения требуется наличие следующих компонентов: 
- Java Development Kit (JDK) версии 21
- Apache Maven версии 3.8.x 
- PostgreSQL версии 12 
- IntelliJ IDEA или любая другая Java IDE Рекомендуемая версия: IntelliJ IDEA 2021.2 
- Spring Boot версии 3.2.7

### Database

Проект использует PostgreSQL в качестве базы данных. Следующие SQL-команды могут быть использованы для создания необходимых таблиц:

Для создания БД можно использовть следующий код

`CREATE DATABASE booktest;`

Таблицы создаются автоматически при запуске приложения, но можно создать их вручную:

CREATE TABLE books (
id SERIAL PRIMARY KEY,
title VARCHAR(100) NOT NULL,
author VARCHAR(100) NOT NULL,
publisher VARCHAR(100) NOT NULL,
year INT NOT NULL,
genre VARCHAR(50) NOT NULL,
price DECIMAL(10,2) NOT NULL,
quantity INT NOT NULL,
book_store_id BIGINT,
FOREIGN KEY (book_store_id) REFERENCES book_stores(id)
);

CREATE TABLE book_stores (
id SERIAL PRIMARY KEY,
name VARCHAR(100) NOT NULL,
address VARCHAR(200) NOT NULL,
contact VARCHAR(50) NOT NULL
);

## Application
Чтобы запустить приложение,необходимо выполнить следующие пункты:

- Клонируйте Git репозиторий:

  git clone https://github.com/katKanoplich/digitalChief.git

- Создайте базу данных PostgreSQL с именем booktest и настройте подключение к ней в файле application.yaml, указав там пароль и логин к своей БД.

- Перейдите в папку с проектом:

    cd digital-chief

- Соберите приложение с помощью команды:

    ./mvnw clean install
- Запустите приложение с помощью команды:

    ./mvnw spring-boot:run

Приложение будет запущено на порту http://localhost:8080.


## Dependencies

В проекте были использованы следующие технологии:

- Spring Boot
- Spring Data JPA (Hibernate)
- PostgreSQL Driver
- Jackson (for JSON serialization/deserialization)


## Postman Collection

Коллекция Postman предоставлена для тестирования конечных точек REST API. 

Коллекция включает в себя следующие запросы:

- GET /books: Получить список всех книг
- GET /books/{id}: Получить конкретную книгу по ID 
- POST /books: Создать новую книгу

тело запроса:

{
"title": "The Great Gatsby",
"genre": "Fiction",
"author": "F. Scott Fitzgerald",
"publisher": "Scribner",
"price": 10.99,
"year": 1925,
"quantity": 50,
"bookStoreId": 2

}

- PUT /books/{id}: Обновить существующую книгу(вместо 'id' необходимо ввести номер книги, которую хотите изменить)

тело запроса 

{
"title": "The Great Gatsby",
"genre": "Fiction",
"author": "F. Scott Fitzgerald",
"publisher": "Scribner",
"price": 20.99,
"year": 1925,
"quantity": 50,
"bookStoreId": 2

}

- DELETE /books/{id}: Удалить книгу (вместо 'id' необходимо ввести номер книги, которую хотите удалить)
- GET /bookstores: Получить список всех книжных магазинов 
- GET /bookstores/{id}: Получить конкретный книжный магазин по ID 
- POST /bookstores: Создать новый книжный магазин

тело запроса:

{
"name": "Main Street Books",
"address": "123 Main St, Anytown USA",
"contact": "555-1234"
}

- PUT /bookstores/{id}: Обновить существующий книжный магазин(вместо 'id' необходимо ввести номер магазины, который хотите изменить)

тело запроса:

{
"name": "Main Street Books",
"address": "123 Main St, Germany",
"contact": "555-1234"
}

- DELETE /bookstores/{id}: Удалить книжный магазин(вместо 'id' необходимо ввести номер магазина, который хотите удалить)
