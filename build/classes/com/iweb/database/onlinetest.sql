
use onlinetest;

DROP table if EXISTS TEST_USER;
CREATE TABLE TEST_USER(
id INT(8) PRIMARY KEY auto_increment,
loginname VARCHAR (64),
password VARCHAR (64),
email VARCHAR (64),
phone VARCHAR (64),
sex VARCHAR (64),
birth VARCHAR (64),
uname VARCHAR (64),
ulevel VARCHAR (64)
);

DROP TABLE if EXISTS QUESTION_SINGLE;
CREATE TABLE QUESTION_SINGLE(
id INT (8) PRIMARY KEY auto_increment,
question VARCHAR (128),
A VARCHAR (128),
B VARCHAR (128),
C VARCHAR (128),
D VARCHAR (128),
answer VARCHAR (128)
);

DROP TABLE if EXISTS QUESTION_JUDGMENT;
CREATE TABLE QUESTION_JUDGMENT(
id INT (8) PRIMARY KEY auto_increment,
question VARCHAR (128),
answer VARCHAR (128)
);

/**
添加管理员
 */
INSERT INTO TEST_USER (loginname, password, ulevel) VALUES ("admin", "admin", "1");
INSERT INTO TEST_USER (loginname, password) VALUES ("test1", "test1" );


insert into QUESTION_SINGLE(id,question,A,B,C,D,answer) values(1,'若集合A={x|–2x1}，B={x|x–1或x3}，则AB=','A.{x|–2x–1}','B.{x|–2x3}','C.{x|–1x1}','D.{x|1x3}','A');
INSERT INTO QUESTION_JUDGMENT(id,question,answer) values(1,'我是判断题题目','对');

insert into QUESTION_SINGLE(id,question,A,B,C,D,answer) values(2,'我是选择题题目','我是答案A','我是答案B','我是答案C','我是答案D','A');
INSERT INTO QUESTION_JUDGMENT(id,question,answer) values(2,'我是判断题题目','对');

insert into QUESTION_SINGLE(id,question,A,B,C,D,answer) values(3,'我是选择题题目','我是答案A','我是答案B','我是答案C','我是答案D','A');
INSERT INTO QUESTION_JUDGMENT(id,question,answer) values(3,'我是判断题题目','对');

insert into QUESTION_SINGLE(id,question,A,B,C,D,answer) values(4,'我是选择题题目','我是答案A','我是答案B','我是答案C','我是答案D','A');
INSERT INTO QUESTION_JUDGMENT(id,question,answer) values(4,'我是判断题题目','对');

insert into QUESTION_SINGLE(id,question,A,B,C,D,answer) values(5,'我是选择题题目','我是答案A','我是答案B','我是答案C','我是答案D','A');
INSERT INTO QUESTION_JUDGMENT(id,question,answer) values(5,'我是判断题题目','对');

insert into QUESTION_SINGLE(id,question,A,B,C,D,answer) values(6,'我是选择题题目','我是答案A','我是答案B','我是答案C','我是答案D','A');
INSERT INTO QUESTION_JUDGMENT(id,question,answer) values(6,'我是判断题题目','对');

insert into QUESTION_SINGLE(id,question,A,B,C,D,answer) values(7,'我是选择题题目','我是答案A','我是答案B','我是答案C','我是答案D','A');
INSERT INTO QUESTION_JUDGMENT(id,question,answer) values(7,'我是判断题题目','对');

insert into QUESTION_SINGLE(id,question,A,B,C,D,answer) values(8,'我是选择题题目','我是答案A','我是答案B','我是答案C','我是答案D','A');
INSERT INTO QUESTION_JUDGMENT(id,question,answer) values(8,'我是判断题题目','对');

insert into QUESTION_SINGLE(id,question,A,B,C,D,answer) values(9,'我是选择题题目','我是答案A','我是答案B','我是答案C','我是答案D','A');
INSERT INTO QUESTION_JUDGMENT(id,question,answer) values(9,'我是判断题题目','对');

insert into QUESTION_SINGLE(id,question,A,B,C,D,answer) values(10,'我是选择题题目','我是答案A','我是答案B','我是答案C','我是答案D','A');
INSERT INTO QUESTION_JUDGMENT(id,question,answer) values(10,'我是判断题题目','对');


