-- 코드를 입력하세요
SELECT
    COUNT(*)
FROM(
SELECT
    *
FROM ANIMAL_INS
WHERE NAME IS NOT NULL
GROUP BY NAME
    ) S