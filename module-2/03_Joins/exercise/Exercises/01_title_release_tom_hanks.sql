-- 1. The titles and release dates of movies that Tom Hanks has appeared in. 
-- Order the results by release date, newest to oldest.
-- (47 rows)
select movie.title,  movie.release_date
from movie
inner join movie_actor
on movie_actor.movie_id = movie.movie_id
inner join person
on person.person_id = movie_actor.actor_id
where person_name like '%Tom Hanks%'
order by release_date desc
;
