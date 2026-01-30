DROP TABLE IF EXISTS Order_Detail;
DROP TABLE IF EXISTS Order_Header;
DROP TABLE IF EXISTS Stocks;
DROP TABLE IF EXISTS Shop;
DROP TABLE IF EXISTS Goods;
DROP TABLE IF EXISTS Area;
DROP TABLE IF EXISTS Purchaser;
DROP TABLE IF EXISTS Staff;

CREATE TABLE Staff(
	Id CHAR(4) NOT NULL,
	Name  VARCHAR(50) NOT NULL,
	Entrance_year  INTEGER,
	Section  VARCHAR(30),
	CONSTRAINT pk_staff PRIMARY KEY(Id)
);

CREATE TABLE Area(
	AreaCode  CHAR(2) NOT NULL,
	AreaName  VARCHAR(20) NOT NULL,
	CONSTRAINT pk_area PRIMARY KEY(AreaCode)
);

CREATE TABLE Shop(
	ShopCode CHAR(3) NOT NULL,
	ShopName VARCHAR(50) NOT NULL,
	ShopNameAbc VARCHAR(50) NOT NULL,
	AreaCode CHAR(2) NOT
	NULL,UpdateDate DATE NOT NULL,
	CONSTRAINT pk_shop PRIMARY KEY(ShopCode),
	CONSTRAINT fk_areacode FOREIGN KEY(AreaCode) REFERENCES Area(AreaCode)
);

CREATE TABLE Goods(
	GoodsCode CHAR(4) NOT NULL,
	GoodsName VARCHAR(50) NOT NULL,
	UnitPrice INTEGER default 0,
	UpdateDate DATE NOT NULL,
	CONSTRAINT pk_goods PRIMARY KEY(GoodsCode)
);

CREATE TABLE Stocks(
	GoodsCode CHAR(4) NOT NULL,
	ShopCode CHAR(3) NOT NULL,
	Quantity INTEGER default 0,
	UpdateDate DATE NOT NULL,
	CONSTRAINT pk_stocks PRIMARY KEY(GoodsCode, ShopCode),
	CONSTRAINT fk_goodscode FOREIGN KEY(GoodsCode) REFERENCES Goods(GoodsCode),
	CONSTRAINT fk_shopcode FOREIGN KEY(ShopCode) REFERENCES Shop(ShopCode)
);

CREATE TABLE Purchaser(
	PurchaserCode CHAR(4) NOT NULL,
	PurchaserName VARCHAR(50) NOT NULL,
	Address VARCHAR(100) NOT NULL,
	Telephone VARCHAR(15),
	CONSTRAINT pk_purchaser PRIMARY KEY(PurchaserCode)
);

CREATE TABLE Order_Header(
	OrderNo INTEGER NOT NULL,
	PurchaserCode CHAR(4) NOT NULL,
	ShopCode CHAR(3) NOT NULL,
	OrderTimestamp Date NOT NULL,
	Total INTEGER,
	CONSTRAINT pk_order_header PRIMARY KEY(OrderNo),
	CONSTRAINT fk_purchasercode FOREIGN KEY(PurchaserCode) REFERENCES Purchaser(PurchaserCode)
);

CREATE TABLE Order_Detail(
	OrderNo INTEGER NOT NULL,
	DetailNo INTEGER NOT NULL,
	GoodsCode CHAR(4) NOT NULL,
	Quantity INTEGER NOT NULL,
	SubTotal INTEGER,
	CONSTRAINT pk_order_detail PRIMARY KEY(OrderNo, DetailNo),
	CONSTRAINT fk_order_header FOREIGN KEY(OrderNo) REFERENCES Order_header(OrderNo),
	CONSTRAINT fk_goodscodeorder FOREIGN KEY(GoodsCode) REFERENCES Goods(GoodsCode)
);
commit;
