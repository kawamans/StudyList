DROP DATABASE IF EXISTS book;
CREATE DATABASE IF Not EXISTS book;

use book;

DROP TABLE IF EXISTS books;

CREATE TABLE
 books
 (
  isbn char(20),
  title varchar(255),
  price int(11),
  publish varchar(30),
  publish_date date,
  category_id char(5),
  PRIMARY KEY (isbn)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


LOCK TABLES books WRITE;
INSERT INTO 
 books
VALUES 
 ('978-4798024035','わかりやすいJava入門編',2940,'秀和システム ','2009-10-01','PJ001'),
 ('978-4797344387','基礎からのMySQL ',3129,'ソフトバンククリエイティブ','2007-12-26','DB001'),
 ('978-4797339536','明解Java　入門編',2730,'ソフトバンククリエイティブ','2007-08-08','PJ001'),
 ('978-4844330868','スッキリわかるJava入門',2730,'インプレスジャパン','2011-10-07 ','PJ001'),
 ('978-4774138213','図解でよくわかる ネットワークの重要用語解説',2079,'技術評論社','2009-03-25 ','NW001'),
 ('978-4839919849','30日でできる! OS自作入門',3990,'毎日コミュニケーションズ ','2006-03-01 ','OS001'),
 ('978-4797311129','オブジェクト指向における再利用のためのデザインパターン',5040,'ソフトバンククリエイティブ','1999-10-01','DP001'),
 ('978-4877832391','12ステップで作る組込みOS自作入門',4410,'カットシステム','2010-05-01','OS001'),
 ('978-4797359091','ネットワーク超入門講座',2079,'ソフトバンククリエイティブ','2010-03-20','NW001'),
 ('978-4798027685','Visual Basic 2010逆引き大全555の極意',2730,'秀和システム','2010-11-01','VB001'),
 ('978-4894714991','Effective Java',3780,'ピアソンエデュケーション','2008-11-27','PJ001'),
 ('978-4781910246','リレーショナルデータベース入門―データモデル・SQL・管理システム',2730,'サイエンス社','2003-03-01','DB001'),
 ('978-4822294229','プログラムを作ろう！ Microsoft Visual Basic 2010 入門',1995,'日経BP社','2010-09-02','VB001'),
 ('978-4839933142','よくわかるPHPの教科書',2604,'毎日コミュニケーションズ','2010-09-14','PH001')
;
UNLOCK TABLES;


DROP TABLE IF EXISTS author;
CREATE TABLE 
 author 
 (
  author_id char(5),
  name varchar(30),
  name_kana varchar(100),
  PRIMARY KEY  (author_id)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES author WRITE;
INSERT INTO 
 author 
VALUES 
 ('K0001','川場 隆','カワバタカシ'),
 ('N0001','西沢 夢路','ニシザワユメジ'),
 ('S0001','柴田 望洋','シバタボウヨウ'),
 ('N0002','中山 清喬','ナカヤマキヨタカ'),
 ('K0002','きたみ りゅうじ','キタミリュウジ'),
 ('K0003','川合 秀実','カワイヒデミ'),
 ('E0001','Erich Gamma','エリックガンマ'),
 ('S0002','坂井 弘亮','サカイヒロアキ'),
 ('M0001','三上 信男','ミカミノブオ'),
 ('I0001','池谷 京子','イケタニキョウコ'),
 ('S0003','柴田芳樹','シバタヒデキ')
 
;
UNLOCK TABLES;


DROP TABLE IF EXISTS author_books;
CREATE TABLE 
 author_books 
 (
  isbn char(20),
  author_id char(5),
  PRIMARY KEY  (isbn, author_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


LOCK TABLES author_books WRITE;
INSERT INTO 
 author_books 
VALUES 
 ('978-4798024035','K0001'),
 ('978-4797344387','N0001'),
 ('978-4797339536','S0001'),
 ('978-4844330868','N0002'),
 ('978-4774138213','K0002'),
 ('978-4839919849','K0003'),
 ('978-4797311129','E0001'),
 ('978-4877832391','S0002'),
 ('978-4797359091','M0001'),
 ('978-4798027685','I0001'),
 ('978-4894714991','S0003');
UNLOCK TABLES;


DROP TABLE IF EXISTS category;
CREATE TABLE 
 category 
 (
  category_id char(5),
  category_name varchar(50),
  PRIMARY KEY  (category_id)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES category WRITE;
INSERT INTO 
 category 
VALUES 
 ('PJ001','Java'),
 ('DM001','データベース'),
 ('NW001','ネットワーク'),
 ('OS001','OS'),
 ('VB001','Visual Basic'),
 ('PH001', 'PHP');
UNLOCK TABLES;


DROP TABLE IF EXISTS product;
CREATE TABLE 
 product 
 (
  product_id char(10),
  product_name varchar(255),
  price int(11),
  PRIMARY KEY  (product_id)
 )COLLATE='utf8_general_ci'
ENGINE=InnoDB;

LOCK TABLES product WRITE;
INSERT INTO
 product
VALUES 
 ('DE00000001','電卓',600),
 ('IS00000001','椅子',10000),
 ('MA00000001','マウスパッド',1500),
 ('PB00000001','黒ボールペン',100),
 ('PB00000002','赤ボールペン',100),
 ('TO00000001','トナー黒',1000),
 ('TO00000002','トナー赤',1000),
 ('TU00000001','机',15000);
UNLOCK TABLES;

DROP TABLE IF EXISTS users;
CREATE TABLE
users
 (
  user_id char(7) NOT NULL,
  l_name varchar(20),
  f_name varchar(20),
  l_name_kana varchar(100),
  f_name_kana varchar(100),
  prefecture varchar(15),
  city varchar(20),
  o_address varchar(100),
  tel varchar(20),
  email varchar(255),
  PRIMARY KEY (user_id)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
DROP TABLE IF EXISTS ejdic;
CREATE TABLE
ejdic
 (
  english varchar(30),
  japanese varchar(30),
  PRIMARY KEY (english)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;
LOCK TABLES ejdic WRITE;
INSERT INTO 
 ejdic 
VALUES 
 ('apple','りんご'),
 ('orange','みかん'),
 ('banana','バナナ'),
 ('fig','いちじく'),
 ('apricot','アンズ');
UNLOCK TABLES;

DROP TABLE IF EXISTS user;
CREATE TABLE
user
 (
  id char(3) NOT NULL,
  name varchar(20),
  balance int,
  PRIMARY KEY (id)
 )ENGINE=InnoDB DEFAULT CHARSET=utf8;
 LOCK TABLES user WRITE;
INSERT INTO 
 user 
VALUES 
 ('001','村上 晋', 2500),
 ('002','菱山 毅', 0);
UNLOCK TABLES;
