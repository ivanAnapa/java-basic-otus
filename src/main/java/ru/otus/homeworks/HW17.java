package ru.otus.homeworks;

public class HW17 {
    /**
     *      create schema otus;
     *      create table otus.question (
     *       id serial4 NOT null PRIMARY KEY,
     *       question varchar(50) not null
     *       );
     *
     *       INSERT INTO otus.question (question) VALUES ('Вопрос 1'),('Вопрос 2'),('Вопрос 3'),('Вопрос 4');
     *
     *       create table otus.answer (
     *       id serial4 PRIMARY KEY,
     *       question_id int not null,
     *       answer varchar(50) not null,
     *       is_true bool default false,
     *       FOREIGN KEY (question_id) REFERENCES otus.question(id)
     *      );
     *
     *       INSERT INTO otus.answer (question_id, answer, is_true) values
     *       (1, 'Ответ 1 на вопрос 1', true),
     *       (1, 'Ответ 2 на вопрос 1', false),
     *       (1, 'Ответ 3 на вопрос 1', false),
     *       (1, 'Ответ 4 на вопрос 1', false),
     *       (2, 'Ответ 1 на вопрос 2', false),
     *       (2, 'Ответ 2 на вопрос 2', true),
     *       (2, 'Ответ 3 на вопрос 2', false),
     *       (2, 'Ответ 4 на вопрос 2', false),
     *       (3, 'Ответ 1 на вопрос 3', true),
     *       (3, 'Ответ 2 на вопрос 3', false),
     *       (3, 'Ответ 3 на вопрос 3', false),
     *       (3, 'Ответ 4 на вопрос 3', false),
     *       (4, 'Ответ 1 на вопрос 4', false),
     *       (4, 'Ответ 2 на вопрос 4', false),
     *       (4, 'Ответ 3 на вопрос 4', false),
     *       (4, 'Ответ 4 на вопрос 4', true);
     *
     *       select * from otus.question;
     *       select * from otus.answer;
     *
     *       select q.id q_id, q.question, a.id a_id, a.answer answer_option, a.is_true
     *       from otus.question q
     *       join otus.answer a
     *       on q.id = a.question_id;
     */
}
