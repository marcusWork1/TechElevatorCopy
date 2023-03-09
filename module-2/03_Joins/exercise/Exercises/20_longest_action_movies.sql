-- 20. The titles, lengths, and release dates of the 5 longest movies in the "Action" genre. 
-- Order the movies by length (highest first), then by release date (latest first).
-- (5 rows, expected lengths around 180 - 200)
select title, length_minutes, release_date
from movie
inner join movie_genre
on movie_genre.movie_id = movie.movie_id
inner join genre
on genre.genre_id = movie_genre.genre_id
where genre_name = 'Action'
order by length_minutes desc, release_date desc
limit 5
;
