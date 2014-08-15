create database ale;

create user 'ale-admin'@'%' identified by 'ale2014krakau';
create user 'ale-admin'@'localhost' identified by 'ale2014krakau';

grant all on ale.* to 'ale-admin'@'%';
grant all on ale.* to 'ale-admin'@'localhost';

flush privileges;
