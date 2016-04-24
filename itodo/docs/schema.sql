DROP TABLE IF EXISTS todo;

CREATE TABLE todo (
    id INT(11) unsigned NOT NULL AUTO_INCREMENT,
    description varchar(64) NOT NULL,
    created date DEFAULT NULL,
    deadline date DEFAULT NULL,
    priority int(5),
    finished TINYINT(1),
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO todo VALUES 
(1,'requirement collection','2012-06-01','2012-06-11',1,0),
(2,'build prototype','2012-06-03','2012-06-22',12,0),
(3,'write code and documents','2012-06-12','2012-07-15',15,0);