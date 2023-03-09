-- 17. The titles and taglines of movies that are in the "Family" genre that Samuel L. Jackson has acted in.
-- Order the results alphabetically by movie title.
-- (4 rows)
select title, tagline
from movie
inner join movie_actor
on movie_actor.movie_id = movie.movie_id
inner join person
on person.person_id = movie_actor.actor_id
inner join movie_genre
on movie_genre.movie_id = movie.movie_id
inner join genre 
on movie_genre.genre_id = genre.genre_id
where person_name = 'Samuel L. Jackson' and genre_name = 'Family'
order by title asc
;
