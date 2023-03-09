-- 8. The genres of movies that Robert De Niro has appeared in that were released in 2010 or later, sorted alphabetically.
-- (6 rows)
select distinct genre_name
from genre
inner join movie_genre
on genre.genre_id = movie_genre.genre_id
inner join movie_actor
on movie_actor.movie_id = movie_genre.movie_id
inner join person
on movie_actor.actor_id = person.person_id
inner join movie
on movie.movie_id = movie_actor.movie_id
where person_name = 'Robert De Niro' and date_part('year', release_date) > 2010
order by genre_name asc
;
