SQL 쿼리 작성

1.월별 접속자 수
SELECT
    SUBSTRING(create_date, 1, 6) AS month,  -- 월 부분 추출
    COUNT(DISTINCT user_id) AS login_count  -- 사용자별로 로그인 수 카운트
FROM
    statistic.request_info
WHERE
    request_code = 'L'  -- 로그인 요청만 추출
GROUP BY
    month
ORDER BY
    month;


2.일자별 접속자 수
SELECT
    SUBSTRING(create_date, 1, 8) AS date,  -- create_date에서 일자 부분 추출
    COUNT(DISTINCT user_id) AS login_count  -- 사용자별로 로그인 수 카운트
FROM
    statistic.request_info
WHERE
    request_code = 'L'  -- 로그인 요청만 추출
GROUP BY
    date
ORDER BY
    date;



3.평균 하루 로그인 수
SELECT
    AVG(daily_logins) AS avg_daily_logins  -- 하루 평균 로그인 수
FROM (
    SELECT
        SUBSTRING(create_date, 1, 8) AS date,  -- 일자 추출
        COUNT(DISTINCT user_id) AS daily_logins  -- 하루 로그인 수
    FROM
        statistic.request_info
    WHERE
        request_code = 'L'  -- 로그인 요청만 추출
    GROUP BY
        date
) AS daily_logins_subquery;



4.휴일을 제외한 로그인 수(*휴일 정보 저장을 위한 별도의 테이블 필요!)
SELECT
    COUNT(DISTINCT ri.user_id) AS login_count_excluding_holidays
FROM
    statistic.request_info ri
LEFT JOIN
    holiday h ON SUBSTRING(ri.create_date, 1, 8) = h.holiday_date  -- 휴일을 제외
WHERE
    ri.request_code = 'L'  -- 로그인 요청만 추출
    AND h.holiday_date IS NULL  -- 휴일이 아닌 경우만



5.부서별 월별 로그인 수
SELECT
    ud.department_id,  -- 부서 ID
    SUBSTRING(ri.create_date, 1, 6) AS month,  -- 월 부분 추출
    COUNT(DISTINCT ri.user_id) AS login_count  -- 부서별 로그인 수
FROM
    statistic.request_info ri
JOIN
    user_department ud ON ri.user_id = ud.user_id  -- 부서 정보와 결합
WHERE
    ri.request_code = 'L'  -- 로그인 요청만 추출
GROUP BY
    ud.department_id, month
ORDER BY
    month, ud.department_id;

