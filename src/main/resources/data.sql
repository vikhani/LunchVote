INSERT INTO USERS (NAME, EMAIL, PASSWORD)
VALUES ('User', 'user@yandex.ru', '{noop}password'),
       ('Admin', 'admin@gmail.com', '{noop}admin'),
       ('Test', 'test', 'test'),
       ('Guest', 'guest@gmail.com', '{noop}guest');

INSERT INTO USER_ROLE (ROLE, USER_ID)
VALUES ('USER', 1),
       ('ADMIN', 2),
       ('USER', 2);

INSERT INTO MENUS (date_time, restaurant_name)
VALUES ('2021-09-30 12:00:00', 'Restaurant 1');

INSERT INTO MEALS (name, price, menu_id)
values ('First meal', 100, 1);
