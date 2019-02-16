CREATE TABLE menutypes (
type_id bigint auto_increment,
name varchar(70),
constraint pk_menutypes primary key (type_id)
)
ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_hungarian_ci;

INSERT INTO menutypes (type_id, name)
    VALUES
    (1, 'előétel'),
    (2, 'leves'),
    (3, 'főétel'),
    (4, 'desszert');