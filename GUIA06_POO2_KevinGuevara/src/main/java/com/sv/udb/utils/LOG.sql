create table log(
codi_log int not null primary key auto_increment,
tipo_log varchar (5),
fech_log datetime default now(),
mens_log varchar(50)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;