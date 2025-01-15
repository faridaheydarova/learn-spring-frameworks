CREATE TABLE books (
  id INT NOT NULL AUTO_INCREMENT,
  name text NULL,
  price int NULL,
  pageCount int NULL,
  PRIMARY KEY (id));

insert into books
(name,price,pageCount)
values
('book1','123','200'),
('book2','123','200'),
('book3','123','200'),
('book4','123','200');