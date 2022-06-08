create table answer(
    id bigint not null auto_increment,
    message varchar(255) not null,
    dateCreate datetime not null,
    author_id bigint not null,
    topic_id bigint not null,
    solution int(1) not null,
    primary key(id),
    foreign key(author_id) references user(id),
    foreign key(topic_id) references topic(id)
)