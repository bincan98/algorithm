-- 코드를 작성해주세요
select I.ITEM_ID, I.ITEM_NAME, I.RARITY
from ITEM_INFO I
where I.ITEM_ID not in (select distinct(T.PARENT_ITEM_ID)
from ITEM_TREE T
where T.PARENT_ITEM_ID is not null)
order by I.ITEM_ID desc