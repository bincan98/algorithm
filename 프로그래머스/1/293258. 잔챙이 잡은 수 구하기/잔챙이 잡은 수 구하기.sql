-- 코드를 작성해주세요
select COUNT(*) as FISH_COUNT
from FISH_INFO
where LENGTH <= 10 or LENGTH is null