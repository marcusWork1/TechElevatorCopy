-- 7. The genres of movies that Christopher Lloyd has appeared in, sorted alphabetically.
-- (8 rows) Hint: DISTINCT will prevent duplicate values in your query results.
select distinct genre_name
from genre
inner join movie_genre
on genre.genre_id = movie_genre.genre_id
inner join movie
on movie.movie_id = movie_genre.movie_id
inner join movie_actor
on movie_actor.movie_id = movie.movie_id
inner join person
on movie_actor.actor_id = person.person_id
where person.person_name = 'Christopher Lloyd'
order by genre_name asc
;
