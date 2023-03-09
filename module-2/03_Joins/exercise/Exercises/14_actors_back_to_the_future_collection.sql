-- 14. The names of actors who've appeared in the movies in the "Back to the Future Collection", sorted alphabetically.
-- (28 rows)
select distinct person_name
from person
inner join movie_actor
on movie_actor.actor_id = person.person_id
inner join movie
on movie.movie_id = movie_actor.movie_id
inner join collection
on collection.collection_id = movie.collection_id
where collection_name = 'Back to the Future Collection'
order by person_name asc;
