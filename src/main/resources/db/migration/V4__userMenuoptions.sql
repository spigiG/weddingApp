CREATE TABLE user_menuoptions (
user_id bigint,
menuoption_id bigint,
constraint fk_user_id foreign key (user_id) references users(id),
constraint fk_menuoption_id foreign key (menuoption_id) references menuoptions(id)
)
ENGINE = InnoDB DEFAULT CHARACTER SET = utf8 COLLATE = utf8_hungarian_ci;