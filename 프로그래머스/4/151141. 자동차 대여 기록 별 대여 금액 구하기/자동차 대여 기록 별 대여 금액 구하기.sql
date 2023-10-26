SELECT HISTORY_ID, ROUND(C.DAILY_FEE*(DATEDIFF(END_DATE, START_DATE)+1)*(1-IFNULL(DISCOUNT_RATE, 0)/100),0) AS FEE
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY AS R
JOIN CAR_RENTAL_COMPANY_CAR AS C ON C.CAR_ID = R.CAR_ID
LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN AS D ON C.CAR_TYPE = D.CAR_TYPE AND
      D.DURATION_TYPE=(CASE
                       WHEN DATEDIFF(R.END_DATE, R.START_DATE)+1 BETWEEN 7 AND 29 THEN "7일 이상"
                       WHEN DATEDIFF(R.END_DATE, R.START_DATE)+1 BETWEEN 30 AND 89 THEN "30일 이상"
                       WHEN DATEDIFF(R.END_DATE, R.START_DATE)+1 >= 90 THEN "90일 이상"
                       ELSE "" END)
WHERE C.CAR_TYPE="트럭"
ORDER BY FEE DESC, R.HISTORY_ID DESC