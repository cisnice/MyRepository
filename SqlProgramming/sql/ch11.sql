-- SECTION01 서브쿼리의 기본 개념
-- 테이블간의 데이터를 연결(JOIN 문으로 변경 가능)
-- 이문세 사원의 부서 이름은?
SELECT DNAME
  FROM DEPT
 WHERE DEPTNO = ( SELECT DEPTNO FROM EMP WHERE ENAME = '이문세' ); 
 
SELECT DNAME
  FROM DEPT, EMP
 WHERE DEPT.DEPTNO = EMP.DEPTNO   -- 일치하는 것끼리 매칭하는데 시간이 소요된다. 행이 많을 수록 서브쿼리가 실행속도가 더 빠르다.
   AND ENAME = '이문세';
 
-- 1.1 단일행 서브 쿼리 
-- 이문세 사원의 부서명은?
SELECT DNAME
  FROM DEPT
 WHERE DEPTNO = ( SELECT DEPTNO FROM EMP WHERE ENAME = '이문세' );  -- 서브쿼리의 실행 결과하 하나인 경우 단일행 서브쿼리
 
-- 최저 봉급을 받아가는 사원의 정보는? 
SELECT *
  FROM EMP
 WHERE SAL = ( SELECT MIN(SAL) FROM EMP );

-- 평균 봉급 이상을 받아가는 사원의 수는?
SELECT COUNT(*)
  FROM EMP
 WHERE SAL >= ( SELECT AVG(SAL) FROM EMP ); 

-- SECTION02 다중행 서브 쿼리
-- 서울에 근무하는 사원의 이름은?
SELECT ENAME
  FROM EMP
 WHERE DEPTNO IN ( SELECT DEPTNO FROM DEPT WHERE LOC = '서울' );    -- 다중값일 경우 IN 으로 처리

-- 2.4 EXISTS 연산자
-- 사원이 1명이라도 존재하는 부서의 이름은?
SELECT DNAME
  FROM DEPT
 WHERE DEPTNO IN ( SELECT DEPTNO FROM EMP GROUP BY DEPTNO HAVING COUNT(DEPTNO) > 1 );

SELECT DISTINCT DNAME
  FROM EMP, DEPT
 WHERE EMP.DEPTNO = DEPT.DEPTNO; 
 
SELECT DNAME
  FROM DEPT
 WHERE EXISTS ( SELECT * FROM EMP WHERE EMP.DEPTNO = DEPT.DEPTNO );   -- 주 쿼리의 테이블을 서브쿼리에서 사용할 수 있다.

-- 사원이 존재하지 않는 부서의 이름은?
SELECT DNAME, EMPNO
  FROM EMP, DEPT
 WHERE DEPT.DEPTNO = EMP.DEPTNO(+)
   AND EMPNO IS NULL; 

SELECT DNAME
  FROM DEPT
 WHERE DNAME NOT IN ( SELECT DISTINCT DNAME
                        FROM EMP, DEPT
                       WHERE EMP.DEPTNO = DEPT.DEPTNO );  

SELECT DNAME
  FROM DEPT
 WHERE NOT EXISTS ( SELECT * FROM EMP WHERE EMP.DEPTNO = DEPT.DEPTNO );

-- SECTION03 서브쿼리를 이용하여 테이블을 생성하고 데이터를 조작하기
-- EMP 테이블 복제해서 EMP2로 만드세요(하나의 DDL 만 작성)
-- 제약 조건(PK, FK, CHECK, NOT NULL) 은 복제가 되지 않습니다.
-- 인덱스도 복제가 되지 않습니다.
CREATE TABLE EMP2 
AS 
SELECT * FROM EMP;

-- EMP 테이블의 구조만 복제해서 EMP3로 만드세요
-- 제약 조건과 인덱스는 복사하지 않아도 됨
-- 데이터가 없어야 한다. SELECT 절의 실행 결과가 아무것도 없어야 한다.
CREATE TABLE EMP3 
AS 
SELECT * FROM EMP WHERE 1=0;

-- 3.3 서브 쿼리로 데이터를 삽입하기
-- EMP3 을 만들었다면 EMP의 10번 부서의 사원들만 복사하세요
INSERT INTO EMP3 
SELECT * FROM EMP WHERE DEPTNO=10;  -- VALUES 는 한 행 추가, SELECT구문이 들어가면 출력된 결과 전부 추가

-- 3.4 서브 쿼리를 이용한 데이터 변경
UPDATE DEPT SET LOC = (SELECT LOC FROM DEPT WHERE DEPTNO=40) WHERE DEPTNO=20;

-- 3.5 서브 쿼리를 이용한 데이터 삭제 
-- 영업부서의 사원을 삭제하세요.
DELETE FROM EMP WHERE DEPTNO = ( SELECT DEPTNO FROM DEPT WHERE DNAME = '영업부' );


-- 오늘 배운데까지 도전 QUIZ 전부 숙제. 월요일 아침까지















