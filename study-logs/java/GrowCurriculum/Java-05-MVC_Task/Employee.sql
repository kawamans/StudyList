-- lesson_db2というデータベースを作成し、以下のSQLをコピペして実行してください。
-- ※INSERT文の内容は指示に従い書き換えてください。

CREATE TABLE Employee(
    EmpId CHAR(5) NOT NULL,
    Password VARCHAR(64) NOT NULL,
    Name VARCHAR(50) NOT NULL,
    Mail VARCHAR(255),
    ProgramingLanguage TEXT,
    Comment TEXT,
    CreateDate VARCHAR(19) NOT NULL,
    UpdateDate VARCHAR(19) NOT NULL,
    DeleteFlg CHAR(1) NOT NULL,
    CONSTRAINT pk_employee PRIMARY KEY(EmpId)
);

-- 登録データサンプル
-- TODO: Step-1: 名前〜意気込みの部分を、ご自身の内容に変更した上で実行してください。
-- その他の部分はそのままにして実行して下さい。
-- PASS java
INSERT INTO Employee VALUES(
    '00001',
    'cbb85c9e38b7f04075b5b70f1be40085776532bb05cdb5bb1e5bd1820f2a0d40',
    'Kawamitsu',
    'intecs.2509ap.02@gmail.com',
    'Java, PHP, HTML/CSS',
    '頑張ります',
    TO_CHAR(CURRENT_TIMESTAMP, 'yyyy/MM/dd HH24:mm:ss'),
    TO_CHAR(CURRENT_TIMESTAMP, 'yyyy/MM/dd HH24:mm:ss'),
    '0'
);

-- PASS java2
INSERT INTO Employee VALUES(
    '00002',
    '56855d8ff9f8b11a69e343c14e54b00e18ad894bbdb3c74a0eaa7549900b51af',
    'Tanaka',
    'intecs.2509ap.02@gmail.com',
    'Java, PHP, HTML/CSS',
    '頑張ります',
    TO_CHAR(CURRENT_TIMESTAMP, 'yyyy/MM/dd HH24:mm:ss'),
    TO_CHAR(CURRENT_TIMESTAMP, 'yyyy/MM/dd HH24:mm:ss'),
    '0'
);

-- PASS java3
INSERT INTO Employee VALUES(
    '00003',
    'ad7dacdf8bcf3fb75c469c5d766111a320ea955778f72942c59386fcaa6d6f52',
    'Yamada',
    'intecs.2509ap.02@gmail.com',
    'Java, PHP, HTML/CSS',
    '頑張ります',
    TO_CHAR(CURRENT_TIMESTAMP, 'yyyy/MM/dd HH24:mm:ss'),
    TO_CHAR(CURRENT_TIMESTAMP, 'yyyy/MM/dd HH24:mm:ss'),
    '0'
);


/* 確認用SQL */
SELECT * FROM Employee;