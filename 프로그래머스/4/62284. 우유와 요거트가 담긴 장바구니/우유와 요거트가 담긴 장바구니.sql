-- 코드를 입력하세요
SELECT CART_ID
FROM CART_PRODUCTS C1
WHERE NAME = 'Milk'
    AND CART_ID IN (SELECT CART_ID
                    FROM CART_PRODUCTS C2
                   WHERE NAME='Yogurt')
ORDER BY CART_ID