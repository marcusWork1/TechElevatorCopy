-- 11. The titles of the movies in the "Star Wars Collection" ordered by release date, most recent first. 
-- (9 rows)
select title
from movie
inner join collection
on collection.collection_id = movie.collection_id 
where collection_name = 'Star Wars Collection'
order by release_date desc
;
