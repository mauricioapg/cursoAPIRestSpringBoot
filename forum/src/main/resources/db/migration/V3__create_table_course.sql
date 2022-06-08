create table course(
    id bigint not null auto_increment,
    name varchar(50) not null,
    category_id bigint not null,
    primary key(id),
    foreign key(category_id) references category(id)
)