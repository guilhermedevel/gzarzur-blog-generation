CREATE TABLE posts (

       id INTEGER(11) NOT NULL AUTO_INCREMENT,
       title VARCHAR(50) NOT NULL,
       text VARCHAR(255) NOT NULL,
       date DATETIME NOT NULL,
       user_id INTEGER(11) NOT NULL,
       theme_id INTEGER(11) NOT NULL,

       PRIMARY KEY (id)

) ENGINE=InnoDB DEFAULT CHARSET=utf8;

ALTER TABLE posts ADD CONSTRAINT fk_user FOREIGN KEY(user_id) REFERENCES users(id);

ALTER TABLE posts ADD CONSTRAINT fk_theme FOREIGN KEY(theme_id) REFERENCES themes(id);