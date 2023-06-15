-- 코드를 입력하세요
select m.member_name, r.review_text, date_format(r.review_date, "%Y-%m-%d") as review_date
from member_profile m join rest_review r
on m.member_id = r.member_id
where r.member_id in (select member_id 
    from rest_review
    group by member_id
    having count(member_id) =  
        ( SELECT count(*)
            from rest_review
            group by member_id
            order by count(*) desc limit 1)
        )
order by r.review_date asc, r.review_text asc






# SELECT member_id, count(member_id)
# from rest_review
# group by member_id
# order by count(member_id) desc;