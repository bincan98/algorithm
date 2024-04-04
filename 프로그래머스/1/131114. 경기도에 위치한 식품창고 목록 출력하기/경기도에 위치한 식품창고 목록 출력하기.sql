-- 코드를 입력하세요
SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, case when FREEZER_YN = "Y" then "Y" else "N" end as FREEZER_YN
from FOOD_WAREHOUSE
where WAREHOUSE_NAME like "%경기%"
order by WAREHOUSE_ID