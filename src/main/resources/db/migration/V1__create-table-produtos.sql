create table produtos(
                         id bigint not null auto_increment,
                         name varchar(100) not null ,
                         price double(10) not null,
                         estoque int(100),
                         descricao char(250),

                         primary key(id)
)