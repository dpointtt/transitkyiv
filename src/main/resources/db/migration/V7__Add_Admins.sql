insert into tk_user(first_name, last_name, tkpassword, user_name)
values
       ('Денис', 'Цишевський', 'pass', 'dpointtt');

insert into user_roles(tk_role, tk_user_id)
values
       ('user', 1),
       ('admin', 1);