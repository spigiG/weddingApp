CREATE TABLE menuoptions(
id bigint auto_increment,
type bigint,
title varchar(255),
description varchar(255),
constraint pk_menuoptions primary key (id),
constraint fk_menuoptions_menutypes foreign key (type) references menutypes(type_id)
)
ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_hungarian_ci;

insert into menuoptions(type, title, description)
    values
    (1, 'Avokádó krém', 'Avokádó krém petrezselyemmel'),
    (3, 'Töltött kápposzta', 'Töltött káposzta tejföllel'),
    (4, 'Rizskoch', 'Rizskoch baracklekvárral'),
    (2, 'Sajtkrémleves', 'Sajtkrémleves 4 féle sajtból');
