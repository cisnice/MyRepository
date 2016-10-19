-- SECTION01 그룹함수 (반드시 SELECT 절에 와야한다)
-- 사원들의 전체 봉급의 합
SELECT SUM(SAL) FROM EMP;

-- 월급을 가장 많이 받아가는 사원의 정보
SELECT * FROM EMP WHERE SAL = (SELECT MAX(SAL) FROM EMP);

-- 평균 월급보다 많이 받아가는 사원의 정보
SELECT * FROM EMP WHERE SAL > (SELECT AVG(SAL) FROM EMP);

-- 전체 사원의 수 = 전체 행수
SELECT COUNT(*) FROM EMP;
SELECT COUNT(EMPNO) FROM EMP;
SELECT COUNT(COMM) FROM EMP;    -- NULL은 카운트에 포함하지 않는다.

-- 평균 월급보다 많이 받아가는 사원의 수
SELECT COUNT(*) FROM EMP WHERE SAL > (SELECT AVG(SAL) FROM EMP);

-- 1.1 그룹함수와 NULL 값
-- 1.2 그룹함수와 단순 컬럼
SELECT AVG(COMM) FROM EMP;      -- NULL은 카운트에 포함하지 않는다.
SELECT SUM(COMM) / COUNT(COMM) FROM EMP;
SELECT SUM(COMM) / COUNT(*) FROM EMP;

-- 사원의 직급 개수
SELECT COUNT(DISTINCT JOB) FROM EMP;


-- SECTION02 데이터 그룹 : GROUP BY 절

-- 부서별로 평균 봉급
-- WHERE 절에는 집계함수를 사용할 수 없다. HAVING 사용
-- GROUP BY 절에 있는 컬럼은 반드시 SELECT 절에 포함되어야 한다.
-- SELECT 그룹핑컬럼 + 집계함수 FROM 테이블명 GROUP BY 그룹핑컬럼
SELECT DEPTNO, AVG(SAL) FROM EMP GROUP BY DEPTNO;  

-- 직급별 평균 봉급은?
SELECT JOB, AVG(SAL) FROM EMP GROUP BY JOB;

-- 부서별(1차 그룹핑), 직급별(2차 그룹핑) 평균 봉급은?
SELECT DEPTNO, JOB, AVG(SAL) FROM EMP GROUP BY DEPTNO, JOB ORDER BY DEPTNO;


-- SECTION03 그룹 결과 제한 : HAVING 절
-- 부서별 평균 봉급이 500 이상인 부서번호와 평균 봉급은?
SELECT DEPTNO, AVG(SAL) FROM EMP GROUP BY DEPTNO HAVING AVG(SAL) > 500;

-- 그룹핑 전의 조건문 WHERE
-- 그룹핑 후의 조건문 HAVING
-- 사원중에서 부서별 평균 봉급이 300 이상인 부서와 평균 봉급은?
SELECT DEPTNO, AVG(SAL) FROM EMP WHERE JOB='사원' GROUP BY DEPTNO HAVING AVG(SAL)>=300;

-- 사원중에서 부서별 평균 봉급이 300 이상인 부서와 평균 봉급 및 사원 수?
SELECT DEPTNO, AVG(SAL), COUNT(EMPNO) FROM EMP WHERE JOB='사원' GROUP BY DEPTNO HAVING AVG(SAL)>=300;

-- 급여 총액이 1000 이상인 직급에 대해서 직급과 급여 총액을 표시하되 직급이 사원인 사람은 제외시킨 후 급여 총액에 따라 정렬
SELECT JOB, SUM(SAL) as salary FROM EMP WHERE JOB != '사원' GROUP BY JOB HAVING SUM(SAL) >= 1000 ORDER BY salary;









