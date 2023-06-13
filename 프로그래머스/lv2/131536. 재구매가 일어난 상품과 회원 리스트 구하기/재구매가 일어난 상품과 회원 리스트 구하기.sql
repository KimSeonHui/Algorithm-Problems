-- 코드를 입력하세요
SELECT user_id, product_id
from online_sale
group by user_id, product_id
having count(product_id) >= 2
order by user_id asc, product_id desc;

# SELECT o1.user_id, o1.product_id
# from online_sale o1 join online_sale o2
# on o1.user_id = o2.user_id
# group by user_id, product_id
# having count(o1.product_id) >=2
# order by user_id asc, product_id desc;