CREATE database app;

use app;

CREATE TABLE company
(
  id_company      int PRIMARY KEY AUTO_INCREMENT,
  name            varchar(200)    default '',
  contributors    int             default 0,
  projects        int             default 0,
  occupation_area varchar(200)    default ''
);

CREATE TABLE user
(
  id_user    int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  username   varchar(100)    NOT NULL,
  name       varchar(200)    NOT NULL,
  password   varchar(100)    NOT NULL,
  id_company int             NOT NULL,
  role       varchar(5)      NOT NULL,

  CONSTRAINT user_id_company_fk
  FOREIGN KEY (id_company) REFERENCES company (id_company)
);

CREATE UNIQUE INDEX user_username_uindex
  ON user (username);

CREATE TABLE reference_model
(
  id_reference_model   int PRIMARY KEY AUTO_INCREMENT,
  name                 varchar(200) NOT NULL,
  knowledge_areas json
);