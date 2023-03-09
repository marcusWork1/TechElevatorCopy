-- 9. The titles of movies directed by James Cameron, sorted alphabetically.
-- (6 rows)
select distinct title 
from movie
inner join movie_actor
on movie.movie_id = movie_actor.movie_id 
inner join person 
on person.person_id = movie.director_id
where person_name = 'James Cameron'
order by title asc
;
