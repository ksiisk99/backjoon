-- 코드를 입력하세요
SELECT O.ANIMAL_ID, O.NAME FROM ANIMAL_OUTS AS O
LEFT OUTER JOIN ANIMAL_INS AS I
ON O.ANIMAL_ID=I.ANIMAL_ID
WHERE I.ANIMAL_ID is NULL