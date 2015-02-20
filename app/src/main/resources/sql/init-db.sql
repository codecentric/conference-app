create database ale CHARACTER SET utf8 COLLATE utf8_general_ci;

create user 'ale-admin'@'%' identified by 'ale2014krakau';
create user 'ale-admin'@'localhost' identified by 'ale2014krakau';

grant all on ale.* to 'ale-admin'@'%';
grant all on ale.* to 'ale-admin'@'localhost';

flush privileges;
