select * from user;
select * from user_role;
delete from user_role where user_id = (select user_id from user where email = 'test@example.com');
delete from user where email = 'test@example.com';
insert into role (role) values ('USER');
