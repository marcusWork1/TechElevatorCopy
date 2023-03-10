-- 3. Did you know Eric Stoltz was originally cast as Marty McFly in "Back to the Future"? Add Eric Stoltz to the list of actors for "Back to the Future" (1 ro
INSERT INTO movie_actor(movie_id, actor_id) VALUES

((SELECT movie_id FROM movie WHERE title = 'Back to the Future'),
 (SELECT person_id FROM person WHERE person_name = 'Eric Stoltz'))
 ;



select person_name, title, actor_id
from person
inner join movie_actor
on person.person_id = movie_actor.actor_id
inner join movie
on movie.movie_id = movie_actor.movie_id
where movie.title = 'Back to the Future'
;
