# Write your MySQL query statement below
select tweet_id from Tweets where
length(content)>15
group by tweet_id;