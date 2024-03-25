-- 코드를 입력하세요
SELECT TITLE, B.BOARD_ID, REPLY_ID, R.WRITER_ID, R.CONTENTS, DATE_FORMAT(R.CREATED_DATE, "%Y-%m-%d") as CREATED_DATE
from USED_GOODS_BOARD B
join USED_GOODS_REPLY R on B.BOARD_ID = R.BOARD_ID
where DATE_FORMAT(B.CREATED_DATE, "%Y-%m") = "2022-10"
order by R.CREATED_DATE, TITLE