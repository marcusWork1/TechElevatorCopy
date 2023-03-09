-- 3. For all actors with the last name of "Jones", display the actor's name and movie titles they appeared in. 
-- Order the results by the actor names (A-Z) and then by movie title (A-Z). 
-- (48 rows)
select person.person_name, movie.title
from person -- going to need movie and movie actor
inner join movie_actor
on movie_actor.actor_id = person.person_id
inner join movie 
on movie_actor.movie_id = movie.movie_id
where person.person_name like '% Jones'
order by person_name asc, title asc
;
