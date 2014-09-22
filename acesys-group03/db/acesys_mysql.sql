drop schema acesys;
create schema acesys;
use acesys;

CREATE TABLE mailtb (
  mid int NOT NULL auto_increment,
  fromaddress varchar(35) default NULL,
  frompassword varchar(20) default NULL,
  toaddress varchar(32) default NULL,
  PRIMARY KEY(mid)
);

INSERT INTO mailtb VALUES(1,'admin@163.com','123','guest@163.com');

CREATE TABLE usr (
  uid int NOT NULL auto_increment,
  username varchar(32) default NULL,
  password varchar(32) default NULL,
  companyname varchar(32) default NULL,
  city varchar(32) default NULL,
  job varchar(32) default NULL,
  tel varchar(12) default NULL,
  email varchar(32) default NULL,
  country varchar(32) default NULL,
  zip char(6) default NULL,
  companyaddress varchar(128) default NULL,
  superuser char(1) default NULL,
  note varchar(256) default NULL,
  fullname varchar(32) default NULL,
  delsoft char(1) default NULL,
  PRIMARY KEY(uid)
);

INSERT INTO usr VALUES (1,'admin','123','hisoft','beijing','teacher','18610554598','yu.zhang9@hisoft.com','CN','100085','shangdi','3','','zhangyu','0');
INSERT INTO usr VALUES (2,'a','123','hisoft','beijing','teacher','18610554598','yu.zhang9@hisoft.com','CN','100085','shangdi','2','','zhangyu','0');
INSERT INTO usr VALUES (3,'b','123','hisoft','beijing','teacher','18610554598','yu.zhang9@hisoft.com','CN','100085','shangdi','1','','zhangyu','1');
INSERT INTO usr VALUES (4,'c','123','hisoft','beijing','teacher','18610554598','yu.zhang9@hisoft.com','CN','100085','shangdi','1','','zhangyu','0');


CREATE TABLE orders (
  oid int NOT NULL auto_increment,
  uid int default NULL,
  starttime varchar(19) default NULL, 
  endtime varchar(19) default NULL, 
  delsoft char(1) default NULL,
  status char(2) default NULL,
  PRIMARY KEY(oid),
  foreign key(uid) references usr(uid)
  on delete set null on update cascade
);

INSERT INTO orders VALUES (1,1,'2013-01-01 12:00','2013-01-01 12:30','0','1');
INSERT INTO orders VALUES (2,1,'2013-01-02 12:00','2013-01-02 12:30','0','0');
INSERT INTO orders VALUES (3,2,'2013-01-03 12:00','2013-01-03 12:30','0','1');
INSERT INTO orders VALUES (4,3,'2013-01-01 12:00','2013-01-01 12:30','0','0');


CREATE TABLE dictionary (
  did int NOT NULL auto_increment,
  columkey varchar(32) default NUll,
  columkeydesc varchar(32) default NULL,
  columvalue varchar(32) default NULL, 
  columvaluedsc varchar(32) default NULL,
  PRIMARY KEY(did)
);

CREATE TABLE category (
  category_name varchar(128) NOT NULL,
  categoryno char(3) NOT NULL,
  PRIMARY KEY(categoryno)
);

INSERT INTO category VALUES ('xiyao','001');
INSERT INTO category VALUES ('zhongyao','002');

CREATE TABLE product (
  pid int NOT NULL auto_increment,
  product_number char(12) NOT NULL,
  categoryno varchar(3) default NULL,
  note varchar(1024) default NULL,
  productname varchar(128) default NULL,
  delsoft char(1) default NULL,
  imagename varchar(64) default NULL,
  newproduct char(1) default NULL,
  normal_price double default NULL,
  vip_price double default NULL,
  realstock int default NULL,
  stock int default NULL,
  cas varchar(32) default NULL,
  mdlnumber varchar(256) default NULL,
  formula varchar(256) default NULL,
  weight double default NULL,
  PRIMARY KEY(pid),
  foreign key(categoryno) references category(categoryno)
  on delete set null on update cascade
);

INSERT INTO product VALUES (1,'A001','001','','aspilin','0','/image1','1',15.00,10.00,100,100,'sfd','123','sadf',5.00);
INSERT INTO product VALUES (2,'B002','001','','zhitong','0','/image2','1',20.00,15.00,100,100,'sdf','123','sdfsd',5.00);
INSERT INTO product VALUES (3,'C003','002','','ganmao','0','/image3','1',10.00,9.00,100,100,'sdf','123','sdfsd',5.00);
INSERT INTO product VALUES (4,'C003','002','','fashao','1','/image3','1',10.00,9.00,100,100,'sdf','123','sdfsd',5.00);

CREATE TABLE orderitem (
  oiid int NOT NULL auto_increment,
  oid int default NULL,
  pid int default NULL,
  quantity int default 0,
  PRIMARY KEY(oiid),
  foreign key(oid) references orders(oid)
  on delete set null on update cascade,
  foreign key(pid) references product(pid)
  on delete set null on update cascade
);

INSERT INTO orderitem VALUES (1,1,1,5);
INSERT INTO orderitem VALUES (2,1,2,5);
INSERT INTO orderitem VALUES (4,3,3,5);

CREATE TABLE user_product (
  upid int NOT NULL auto_increment,
  uid int default NULL,
  pid int default NULL,
  PRIMARY KEY(upid),
  foreign key(uid) references usr(uid)
  on delete set null on update cascade,
  foreign key(pid) references product(pid)
  on delete set null on update cascade
);

CREATE VIEW product_category AS select pid, product_number, note, productname, delsoft, imagename, newproduct,
normal_price, vip_price, stock, realstock, cas, mdlnumber, formula, weight, ca.categoryno, ca.category_name FROM
product p, category ca WHERE p.categoryno = ca.categoryno;
commit ;