-- CH08: DML(Data Manipulation Language) - 데이터 관련된 명령어 => 반드시 COMMIT 해야 테이블에 저장된다.
--        : 저장(INSERT), 수정(UPDATE), 삭제(DELETE), 조회(SELECT)
--       DDL(Data Definition Language) - 데이터베이스 객체(OBJECT)와 관련된 명령어
--        : 생성(CREATE), 삭제(DROP), 수정(ALTER)
--       DCL(Data Control Language) - 권한 및 사용자와 관련된 명령어
--        : 권한할당(GRANT), 권한삭제(REVOKE), 작업반영(COMMIT), 작업취소(ROLLBACK)

-- SECTION01 테이블에 내용을 추가하는 INSERT 문
INSERT INTO MEMBER (MID, MNAME, MAGE, MBIRTH) VALUES('USER3', '사용자3', 10, '2006.5.15');
INSERT INTO MEMBER(MID, MNAME) VALUES('USER4', '사용자4');
INSERT INTO MEMBER(MID) VALUES('USER5');                     -- NOT NULL 컬럼에 값이 없으면 에러
INSERT INTO MEMBER VALUES('USER5','사용자5', null, null);    -- 컬럼명이 없어도 컬럼 순서대로 삽입된다. 컬럼의 수만큼 values 에 들어가야한다.

INSERT INTO BOARD(BNO, BTITLE, BCONTENT, BWRITER, BHITCOUNT, BDATE)
VALUES(4, '제목4', '내용4', 'USER2', 0, SYSDATE);

INSERT INTO BOARD
VALUES(5, '제목5', '내용5', 'USER3', 0, SYSDATE);

INSERT INTO BOARD
VALUES(6, '제목6', '내용6', 'USER2', NULL, NULL);

-- 삽입 작업이 성공하면 무조건 '1' 을 리턴한다. (1 행 이(가) 삽입되었습니다.)
-- 작업이 성공하지 못하면 예외가 발생한다.

-- SECTION02 테이블의 내용을 수정하는 UPDATE 문
UPDATE MEMBER SET MAGE=10 WHERE MID='USER4';   -- WHERE 절이 빠지면 모든 데이터의 해당 컬럼의 내용이 수정된다.
UPDATE MEMBER SET MAGE=20, MBIRTH='2001.08.10' WHERE MID='USER5';

UPDATE MEMBER SET MAGE=MAGE+1 WHERE MID='USER4';

-- SECTION03 테이블의 내용을 삭제하는 DELETE 문
DELETE FROM MEMBER WHERE MID='USER5';  -- FROM 생략 가능. WHERE 절이 빠지면 해당 테이블의 모든 데이터가 삭제된다.
DELETE FROM MEMBER WHERE MAGE<=20;


-- SECTION04 트랜잭션 관리
CREATE TABLE ACCOUNT(
  ANO VARCHAR(20) NOT NULL,
  ABALANCE NUMBER(10) NULL  
);

INSERT INTO ACCOUNT(ANO, ABALANCE) VALUES('111-111', 1000000);
INSERT INTO ACCOUNT(ANO, ABALANCE) VALUES('111-112', 0);

-- 계좌이체 : 출금작업+입금작업 => 트랜잭션 작업 = ALL OR NOTHING
    -- 출금작업 
    UPDATE ACCOUNT SET ABALANCE=ABALANCE-10000 WHERE ANO='111-111';
    
    -- 입금작업
    UPDATE ACCOUNT SET ABALANCE=ABALANCE+10000 WHERE ANO='111-113';
    
-- 출금은 성공했으나, 입금이 실패했기 때문에 전체를 실패처리 해야함
ROLLBACK;

-- 출금은 성공했고, 입금도 성공했다면 전체를 영구 반영 처리해야함
COMMIT;













