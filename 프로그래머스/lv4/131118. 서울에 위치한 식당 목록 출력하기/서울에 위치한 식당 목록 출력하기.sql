-- 코드를 입력하세요
SELECT i.rest_id, i.rest_name, i.food_type, i.favorites, i.address, r.score
from rest_info i join (select rest_id, round(avg(review_score), 2) as score
    from rest_review
    where review_score > 0
    group by rest_id) r
on i.rest_id = r.rest_id
where address like "서울%"
order by r.score desc, i.favorites desc;