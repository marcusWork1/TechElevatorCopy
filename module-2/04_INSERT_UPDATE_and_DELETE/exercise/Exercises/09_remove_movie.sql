-- 9. Remove "Memento" from the movie table
-- You'll have to remove data from two other tables before you can remove it (13 rows, 2 rows, 1 row)
select title, tagline
from movie
where title like '%Memento%' or tagline like '%Memento%'
;
delete from movie_genre
where movie_id = (select movie_id from movie where movie.title = 'Memento')
  ;
delete from movie_actor
where movie_id = (select movie_id from movie where movie.title = 'Memento')
;

delete from movie
where title = 'Memento'
;

(select movie_genre.movie_id from movie_genre inner join movie on movie.movie_id = movie_genre.movie_id where movie.title = 'Memento')
;