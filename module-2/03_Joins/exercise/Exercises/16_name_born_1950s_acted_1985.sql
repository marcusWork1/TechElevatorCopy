-- 16. The names and birthdays of actors born in the 1950s who acted in movies that were released in 1985.
-- Order the results by actor from oldest to youngest.
-- (20 rows)
select distinct person_name, birthday
from person
inner join movie_actor
on movie_actor.actor_id = person.person_id
inner join movie
on movie_actor.movie_id = movie.movie_id
where date_part('year', birthday) >= 1950 and date_part('year', birthday) <1960 and date_part('year', release_date)=1985
order by birthday asc
;
