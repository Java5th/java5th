DROP TABLE userinfo;
DROP TABLE board;
DROP TABLE board2;
CREATE TABLE userinfo (
    userid VARCHAR(20) Primary KEY,
    password VARCHAR(20) NOT NULL
);

CREATE TABLE board ( -- 방명록 --
    board_id integer PRIMARY KEY,
    title VARCHAR(1000),
    content VARCHAR(5000),
    boardPw VARCHAR(1000)
);

CREATE table board2 ( -- 게시판 --
    board2_id integer PRIMARY KEY,
    title VARCHAR(1000),
    content VARCHAR(5000),
    board2Pw VARCHAR(1000)
);