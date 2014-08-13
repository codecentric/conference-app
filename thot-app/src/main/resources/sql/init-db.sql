create database thot;

create user thot@'%' identified by 'thot';
create user thot@'localhost' identified by 'thot';

grant all on thot.* to thot@'%';
grant all on thot.* to thot@'localhost';

flush privileges;
