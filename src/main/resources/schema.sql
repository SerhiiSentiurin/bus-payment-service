create table if not exists payments (
    id INTEGER NOT NULL AUTO_INCREMENT,
    amount DECIMAL NOT NULL,
    status varchar(50),
    PRIMARY KEY (id)
);