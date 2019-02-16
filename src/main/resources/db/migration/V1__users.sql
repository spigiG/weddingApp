CREATE TABLE users (
id bigint auto_increment,
email varchar(255),
constraint pk_users primary key (id)
)
ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_hungarian_ci;

insert into users (email)
    values
    ('mano@gmail.com'),
    ('tucsok@gmail.com'),
    ('cicc@gmail.com');

