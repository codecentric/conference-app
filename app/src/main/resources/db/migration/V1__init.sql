create table developer (
	id INT(10) NOT NULL AUTO_INCREMENT,
    fullname varchar(255) not null,
	githubusername varchar(255) not null,
	primary key (id)
);
insert into developer (fullname, githubusername) values ('Bastian Spanneberg', 'spanneberg');
insert into developer (fullname, githubusername) values ('Alex Klimova', 'test');
insert into developer (fullname, githubusername) values ('Henning Treu', 'test');
insert into developer (fullname, githubusername) values ('Marcel Birkner', 'marcelbirkner');
insert into developer (fullname, githubusername) values ('Laura', 'Nighty2010');