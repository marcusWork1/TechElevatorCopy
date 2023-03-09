-- 15. The title of the movie and the name of director for movies where the director was also an actor in the same movie.
-- Order the results by movie title (A-Z)
-- (73 rows)
select title, person_name
from movie
inner join movie_actor
on movie.movie_id = movie_actor.movie_id
inner join person
on person.person_id = movie_actor.actor_id
where person.person_id = movie.director_id
order by title asc;


