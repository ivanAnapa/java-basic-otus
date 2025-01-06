package ru.otus.homeworks;

public class HW17 {
    /**
     * create table otus.question (
     * id serial4 NOT null,
     * "question" varchar(50) not null,
     * CONSTRAINT question_pk PRIMARY KEY (id)
     * );
     *
     * INSERT INTO otus.question (question) VALUES ('Вопрос 1'),('Вопрос 2'),('Вопрос 3'),('Вопрос 4');
     *
     * create table otus.answer (
     * id serial4 NOT null,
     * "question_id" int not null,
     * "answer" varchar(50) not null,
     * is_true bool default false,
     * CONSTRAINT answer_fk FOREIGN KEY (question_id) REFERENCES otus.question(id)
     * );
     *
     * INSERT INTO otus.answer (question_id, answer, is_true) values
     * (1, 'Ответ 1 на вопрос 1', true),
     * (1, 'Ответ 2 на вопрос 1', false),
     * (1, 'Ответ 3 на вопрос 1', false),
     * (1, 'Ответ 4 на вопрос 1', false),
     * (2, 'Ответ 1 на вопрос 2', false),
     * (2, 'Ответ 2 на вопрос 2', true),
     * (2, 'Ответ 3 на вопрос 2', false),
     * (2, 'Ответ 4 на вопрос 2', false),
     * (3, 'Ответ 1 на вопрос 3', true),
     * (3, 'Ответ 2 на вопрос 3', false),
     * (3, 'Ответ 3 на вопрос 3', false),
     * (3, 'Ответ 4 на вопрос 3', false),
     * (4, 'Ответ 1 на вопрос 4', false),
     * (4, 'Ответ 2 на вопрос 4', false),
     * (4, 'Ответ 3 на вопрос 4', false),
     * (4, 'Ответ 4 на вопрос 4', true)
     * ;
     *
     * select * from otus.question;
     * select * from otus.answer;
     */
}
