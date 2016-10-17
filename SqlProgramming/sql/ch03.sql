
-- Section01 DUAL 테이블 (가상의 테이블)
SELECT * FROM DUAL;
SELECT 10+20 FROM DUAL;
SELECT SYSDATE FROM DUAL;   -- 현재 오라클 DB 의 날짜

-- Section02 숫자 함수
-- 2.1 절대값을 구하는 ABS 함수
SELECT ABS(-10) FROM dual;
SELECT ABS(-15) "Absolute"
  FROM DUAL;
  
------------------------------------
UPDATE EMP SET SAL=SAL/7;
SELECT * FROM EMP;
--ROLLBACK;
------------------------------------

-- 소수 첫째자리까지 나타내기(반올림)
SELECT SAL, ROUND(SAL) FROM EMP;
SELECT SAL, ROUND(SAL, 1) FROM EMP;

-- 바로 아래 정수
SELECT SAL, FLOOR(SAL) FROM EMP;

-- 바로 위 정수
SELECT SAL, CEIL(SAL) FROM EMP;

-- 소수 첫째자리까지 나타내기(잘라내기)
SELECT SAL, TRUNC(SAL, 1) FROM EMP;

-- SECTION03 문자 처리 함수
-- 3.1 대소문자 변환함수 (영어만) - UPPER, LOWER
SELECT * FROM EMPLOYEES;

SELECT PHONE_NUMBER 
  FROM EMPLOYEES 
 WHERE UPPER(FIRST_NAME) = 'STEVEN';

-- 3.3 문자 조작 함수
-- 3.3.1 문자열 일부만 추출하는 SUBSTR 함수
SELECT * FROM EMPLOYEES;

SELECT SUBSTR(FIRST_NAME, 1, 5) FROM EMPLOYEES;

-- 3.3.5 특정 기호로 채우는 LPAD/RPAD 함수
SELECT LPAD('ORACLE', 20, '*') FROM DUAL;
SELECT RPAD('ORACLE', 20, '*') FROM DUAL;

-- 10자리 공간에 사원이름(FIRST_NAME)을 5자리까지만 나오게 하고, 나머지는 오른쪽 '*' 처리하시오. 
SELECT RPAD(SUBSTR(FIRST_NAME, 1, 5), 10, '*') FROM EMPLOYEES;

-- SECTION04 형 변환 함수
-- 4.1.1 날짜형을 문자형으로 변환하기 (TO_CHAR)
SELECT HIRE_DATE, TO_CHAR(HIRE_DATE, 'YYYY.MM.DD DAY') FROM EMPLOYEES;

-- 4.2 문자형을 날짜형으로 변환하기 (TO_DATE)
SELECT FIRST_NAME, HIRE_DATE FROM EMPLOYEES WHERE HIRE_DATE = '2003/06/17';
SELECT FIRST_NAME, HIRE_DATE FROM EMPLOYEES WHERE HIRE_DATE = '06-17-2003';
SELECT FIRST_NAME, HIRE_DATE FROM EMPLOYEES WHERE HIRE_DATE = TO_DATE('06-17-2003', 'MM-DD-YYYY');

-- SECTION05 날짜 함수
-- 5.1 DBMS의 현재 날짜
SELECT SYSDATE FROM DUAL;

-- DBMS의 현재 날짜를 "2016.10.17 월요일" 의 형태로 변환
SELECT TO_CHAR(SYSDATE, 'YYYY.MM.DD DAY') FROM DUAL;

-- SECTION06 NULL을 다른 값으로 변환하는 NVL 함수
SELECT salary*12 + NVL(commission_pct, 0)*salary FROM EMPLOYEES;
SELECT NVL2(COMMISSION_PCT,             -- COMMISSION_PCT이 NULL 이 아니면 2번째 인자, NULL 이면 3번째 인자 실행. 3항 연산자
           (SALARY*12+COMMISSION_PCT), 
           SALARY*12) 
  FROM EMPLOYEES;


SELECT EMPLOYEE_ID, FIRST_NAME FROM EMPLOYEES WHERE lower(FIRST_NAME) LIKE '%is%';




