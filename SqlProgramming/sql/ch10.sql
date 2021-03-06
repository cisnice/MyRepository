-- SECTION03 EQUI JOIN(=INNER JOIN)
-- 조인 대상이 되는 두 테이블에서 공통으로 존재하는 컬럼의 값이 일치하는 행을 연결하여 결과를 생성하는 조인 방법
-- 101번 사원의 부서 이름은?
SELECT EMP.EMPLOYEE_ID, EMP.DEPARTMENT_ID, DEPT.DEPARTMENT_ID, DEPT.DEPARTMENT_NAME
  FROM EMPLOYEES EMP, DEPARTMENTS DEPT
 WHERE EMP.DEPARTMENT_ID = DEPT.DEPARTMENT_ID     -- 두 테이블의 연결 조건. (조인된 테이블의 수 - 1)
   AND EMP.EMPLOYEE_ID = 101;
   
-- ANSI INNER JOIN 문법
SELECT EMP.EMPLOYEE_ID, EMP.DEPARTMENT_ID, DEPT.DEPARTMENT_ID, DEPT.DEPARTMENT_NAME
  FROM EMPLOYEES EMP INNER JOIN DEPARTMENTS DEPT
    ON EMP.DEPARTMENT_ID = DEPT.DEPARTMENT_ID     
 WHERE EMP.EMPLOYEE_ID = 101;
   
-------------------------------------------------------------------------------- 

-- SALES 부서가 있는 도시는?
SELECT DEPT.DEPARTMENT_NAME, LOC.CITY
  FROM DEPARTMENTS DEPT, LOCATIONS LOC
 WHERE DEPT.LOCATION_ID = LOC.LOCATION_ID
   AND DEPT.DEPARTMENT_NAME = 'Sales';
   
-- ANSI INNER JOIN 문법   
SELECT DEPT.DEPARTMENT_NAME, LOC.CITY
  FROM DEPARTMENTS DEPT INNER JOIN LOCATIONS LOC
    ON DEPT.LOCATION_ID = LOC.LOCATION_ID
 WHERE DEPT.DEPARTMENT_NAME = 'Sales';   
   
--------------------------------------------------------------------------------

-- 101번 사원의 부서 번호와 부서 이름은?
SELECT DEPT.DEPARTMENT_ID, DEPT.DEPARTMENT_NAME
  FROM DEPARTMENTS DEPT, EMPLOYEES EMP
 WHERE DEPT.DEPARTMENT_ID = EMP.DEPARTMENT_ID
   AND EMP.EMPLOYEE_ID = 101;

-- ANSI INNER JOIN 문법
SELECT DEPT.DEPARTMENT_ID, DEPT.DEPARTMENT_NAME
  FROM DEPARTMENTS DEPT INNER JOIN EMPLOYEES EMP
    ON DEPT.DEPARTMENT_ID = EMP.DEPARTMENT_ID
 WHERE EMP.EMPLOYEE_ID = 101;

--------------------------------------------------------------------------------

-- 101번 사원의 근무 도시는?
SELECT EMP.EMPLOYEE_ID, LOC.CITY
  FROM EMPLOYEES EMP, DEPARTMENTS DEPT, LOCATIONS LOC
 WHERE EMP.DEPARTMENT_ID = DEPT.DEPARTMENT_ID
   AND DEPT.LOCATION_ID = LOC.LOCATION_ID
   AND EMP.EMPLOYEE_ID = 101;

-- ANSI INNER JOIN 문법
SELECT EMP.EMPLOYEE_ID, LOC.CITY
  FROM EMPLOYEES EMP INNER JOIN DEPARTMENTS DEPT ON EMP.DEPARTMENT_ID = DEPT.DEPARTMENT_ID
                     INNER JOIN LOCATIONS LOC ON DEPT.LOCATION_ID = LOC.LOCATION_ID     
   AND EMP.EMPLOYEE_ID = 101;

--------------------------------------------------------------------------------

-- 101번 사원의 사번, FIRST_NAME, 부서번호, 부서이름, 나라, 도시는?
SELECT EMP.EMPLOYEE_ID, EMP.FIRST_NAME, EMP.DEPARTMENT_ID, DEPT.DEPARTMENT_NAME, CO.COUNTRY_NAME, LOC.CITY
  FROM EMPLOYEES EMP, DEPARTMENTS DEPT, LOCATIONS LOC, COUNTRIES CO
 WHERE EMP.DEPARTMENT_ID = DEPT.DEPARTMENT_ID
   AND DEPT.LOCATION_ID = LOC.LOCATION_ID
   AND LOC.COUNTRY_ID = CO.COUNTRY_ID
   AND EMP.EMPLOYEE_ID = 101;

-- ANSI INNER JOIN 문법
SELECT EMP.EMPLOYEE_ID, EMP.FIRST_NAME, EMP.DEPARTMENT_ID, DEPT.DEPARTMENT_NAME, CO.COUNTRY_NAME, LOC.CITY
  FROM EMPLOYEES EMP INNER JOIN DEPARTMENTS DEPT ON EMP.DEPARTMENT_ID = DEPT.DEPARTMENT_ID
                     INNER JOIN LOCATIONS LOC ON DEPT.LOCATION_ID = LOC.LOCATION_ID
                     INNER JOIN COUNTRIES CO ON LOC.COUNTRY_ID = CO.COUNTRY_ID
 WHERE EMP.EMPLOYEE_ID = 101;

--------------------------------------------------------------------------------

-- SECTION04 SELF JOIN(=INNER JOIN)
-- 101번 사원의 관리자 이름은?
SELECT E2.FIRST_NAME
  FROM EMPLOYEES E1, EMPLOYEES E2
 WHERE E1.MANAGER_ID = E2.EMPLOYEE_ID
   AND E1.EMPLOYEE_ID = 101;

-- 5.3 ANSI OUTER JOIN
CREATE TABLE MEMBER (
  MID VARCHAR(10) PRIMARY KEY,
  MNAME VARCHAR(10) NOT NULL
);

CREATE TABLE BOARD (
  BNO NUMBER(5) PRIMARY KEY,
  BTITLE VARCHAR(100) NOT NULL,
  BWRITER VARCHAR(10) REFERENCES MEMBER(MID)
);

INSERT INTO MEMBER VALUES('USER1', '사용자1');
INSERT INTO MEMBER VALUES('USER2', '사용자2');
INSERT INTO MEMBER VALUES('USER3', '사용자3');
INSERT INTO MEMBER VALUES('USER4', '사용자4');
INSERT INTO MEMBER VALUES('USER5', '사용자5');

INSERT INTO BOARD VALUES(1, '제목1', 'USER1');
INSERT INTO BOARD VALUES(2, '제목2', 'USER2');
INSERT INTO BOARD VALUES(3, '제목3', 'USER3');

-- 게시물을 한번도 작성하지 않은 멤버의 MID 는?
SELECT MID, MNAME, BNO, BTITLE, BWRITER
  FROM MEMBER 
 INNER JOIN BOARD ON MEMBER.MID = BOARD.BWRITER;
 
-- LEFT OUTER JOIN
SELECT MID, MNAME, BNO, BTITLE, BWRITER
  FROM MEMBER  
  LEFT OUTER JOIN BOARD ON MEMBER.MID = BOARD.BWRITER
 WHERE BNO IS NULL;
 
SELECT MID, MNAME, BNO, BTITLE, BWRITER
  FROM BOARD
 RIGHT OUTER JOIN MEMBER ON BOARD.BWRITER = MEMBER.MID; 
 
SELECT MID, MNAME, BNO, BTITLE, BWRITER
  FROM MEMBER, BOARD  
 WHERE MEMBER.MID = BOARD.BWRITER(+);    -- LEFT JOIN. BOARD에 없는 것 까지 출력 

-- RIGHT OUTER JOIN
SELECT MID, MNAME, BNO, BTITLE, BWRITER
  FROM BOARD
 RIGHT OUTER JOIN MEMBER ON BOARD.BWRITER = MEMBER.MID
 WHERE BNO IS NULL;

SELECT MID, MNAME, BNO, BTITLE, BWRITER
  FROM MEMBER  
 RIGHT OUTER JOIN BOARD ON MEMBER.MID = BOARD.BWRITER;
 
SELECT MID, MNAME, BNO, BTITLE, BWRITER
  FROM MEMBER, BOARD  
 WHERE BOARD.BWRITER(+) = MEMBER.MID;    -- RIGHT JOIN 

-- FULL OUTTER JOIN
SELECT MID, MNAME, BNO, BTITLE, BWRITER
  FROM MEMBER  
  FULL OUTER JOIN BOARD ON MEMBER.MID = BOARD.BWRITER;











   
   
   