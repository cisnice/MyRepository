-- 1.1 문장과 절
select * from emp;

-- 1.2 특정 데이터만 보기
select empno, ename from emp;
select ename, sal from emp;

-- 1.3 산술연산자
select ename, sal, sal*12 from emp;

-- 1.4 Null 연산시 주의할 점
select ename, sal, comm, sal*12+comm from emp;    -- 연산에 NULL 이 있으면 결과는 NULL 이 나온다.
select ename, sal, comm, sal*12+nvl(comm, 0) from emp;    -- nvl 함수 호출. comm 이 null 이면 0

-- 함수 -> 실행 블록
-- 메소드 -> 객체(실행블록(기능)) => 객체 안에 있는 실행블록

-- 1.5 컬럼 이름에 별칭 지정하기
select ename as 이름, sal as 월급, comm 보너스, sal*12+nvl(comm, 0) 연봉 from emp;   -- as 생략가능

-- 1.6 Concatenation 연산자의 정의와 사용 (문자열 결합)
select empno || '-' || ename as 이름 from emp;
select ename || '의 직급은 ' || job || ' 입니다.' from emp;
  
-- 1.7 DISTINCT 키워드(중복제거)
-- 사원이 있는 부서 번호는?
SELECT DEPTNO FROM EMP;
SELECT DISTINCT DEPTNO FROM EMP;

-------------------------------------------------------------------------------------------

-- 조건절 작성
SELECT ENAME 
  FROM EMP 
 WHERE DEPTNO=20;

-- 2.1 비교 연산자
SELECT ENAME 
  FROM EMP 
 WHERE DEPTNO!=20;   -- 같지 않다. !=, <> 

SELECT ENAME
  FROM EMP
 WHERE SAL>=500;

-- 2.1.1 문자 데이터 조회
SELECT * FROM EMP WHERE ENAME = '이문세';

-- 2.1.2 날짜 데이터 조회
-- 2005년 1월 1일 이전에 입사한 사원의 정보
SELECT * 
  FROM EMP
 WHERE HIREDATE < '2005/1/1';   -- '2005/1/1', '05/1/1', '2005-1-1', '2005.1.1' 전부 된다. 컴파일러가 알아서 날짜형식으로 변형해준다.

SELECT * 
  FROM EMP
 WHERE HIREDATE < TO_DATE('2005/1/1', 'YYYY/MM/DD');    -- 날짜 형식 지정. TO_DATE 문자 -> 날짜

-- 2.2 논리 연산자
-- 2.2.1 AND 연산자
-- 10번 부서에 소속된 사원 중에서 직급이 과장인 사원의 정보
SELECT * 
  FROM EMP 
 WHERE DEPTNO = 10 
   AND JOB = '과장';
   
-- 2.2.2 OR 연산자
-- 10번 부서에 소속된 사원과 또는 직급이 과장인 사원의 정보
   
SELECT * 
  FROM EMP 
 WHERE DEPTNO = 10 
    OR JOB = '과장';   

-- 2.2.3 NOT 연산자
-- 10번 부서가 아닌 사원의 정보

SELECT * 
  FROM EMP 
 WHERE DEPTNO != 10;   
 
-- 2.3 BETWEEN AND 연산자
-- 월급이 400 이상, 500 이하인 사원의 정보
SELECT * FROM EMP WHERE 400 <= SAL AND SAL <= 500;
SELECT * FROM EMP WHERE SAL BETWEEN 400 AND 500;
SELECT * FROM EMP WHERE ENAME BETWEEN '바' AND '장';
   
-- 2.4 IN 연산자
-- 보너스가 80 이거나, 100 이거나 200 인 사원의 정보
SELECT * FROM EMP WHERE COMM = 80 OR COMM = 100 OR COMM = 200;
SELECT * FROM EMP WHERE COMM IN(80, 100, 200);

-- 2.5 LIKE 연산자와 와일드카드
-- 2.5.1 와일드카드(%) 사용하기
-- 성이 이씨인 사원의 정보
SELECT * FROM EMP WHERE ENAME LIKE '이%';

-- 이름 중에 '성'이 포함된 사원의 정보
SELECT * FROM EMP WHERE ENAME LIKE '%성%';

-- 2.5.1 와일드카드(_) 사용하기
-- 이름 중에 두번째 글자가 '성'인 사원의 정보
SELECT * FROM EMP WHERE ENAME LIKE '_성%';

-- 이름 중에 '성'이 포함되지 않는 사원의 정보
SELECT * FROM EMP WHERE ENAME NOT LIKE '%성%';
SELECT * FROM EMP WHERE NOT ENAME LIKE '%성%';

-- 2.6 NULL 을 위한 연산자 
-- 보너스가 없는(NULL)인 사원의 정보
SELECT * FROM EMP WHERE COMM IS NULL;   -- COMM = NULL 은 안된다. NULL이 저장되어 있는 경우에는 (=) 연산자로 판단할 수 없다.
SELECT * FROM EMP WHERE COMM IS NOT NULL;

-- 3.1 오름차순 정렬을 위한 ASC
SELECT * FROM EMP ORDER BY SAL;
SELECT * FROM EMP ORDER BY SAL ASC;

-- 3.2 내림차순 정렬을 위한 DESC
SELECT * FROM EMP ORDER BY SAL DESC;
SELECT * FROM EMP ORDER BY HIREDATE DESC;

-- 입사날 내림차순 순서(1차 정렬) -> 이름 올림 차순(2차 정렬)
SELECT * FROM EMP ORDER BY HIREDATE DESC, ENAME ASC;

-- 30번 부서에서 월급이 400 이상인 사원의 번호, 이름, 연봉(내림차순)을 출력하시오.
SELECT EMPNO, ENAME, SAL*12+NVL(COMM,0) YEARSAL
  FROM EMP
 WHERE SAL > 400
   AND DEPTNO=30
 ORDER BY YEARSAL DESC;

SELECT DEPTNO, DNAME 
  FROM DEPT 
 WHERE DNAME like '%개발%';




  