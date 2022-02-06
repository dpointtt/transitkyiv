insert into tk_user(first_name, last_name, password, user_name)
values
       ('Денис', 'Цишевський', 'pass', 'dpointtt');

insert into user_roles(role, tk_user_id)
values
       ('user', 1),
       ('admin', 1);