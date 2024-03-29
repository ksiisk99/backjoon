-- 코드를 입력하세요
SELECT MONTH(START_DATE) AS month, CAR_ID, COUNT(HISTORY_ID) AS RECORDS
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
WHERE start_date>="2022-08-01" and start_date<"2022-11-01" and
    CAR_ID in (
    SELECT CAR_ID 
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE >= "2022-08-01"
        and START_DATE < "2022-11-01" 
    GROUP BY car_id
    HAVING count(history_id)>4)
GROUP BY month, CAR_ID
HAVING RECORDS > 0
ORDER BY month, CAR_ID DESC