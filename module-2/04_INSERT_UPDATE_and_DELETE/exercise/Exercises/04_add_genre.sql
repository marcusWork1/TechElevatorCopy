-- 4. Add a "Sports" genre to the genre table. Add the movie "Coach Carter" to the newly created genre. (1 row each)
insert into genre
(genre_name)
values ('Sports')
;
select genre_name
from genre
where genre_name = 'Sports'
;
insert into movie_genre
(movie_id, genre_id)
values ((Select movie_id from movie where title = 'Coach Carter'),
		(select genre_id from genre where  genre_name = 'Sports'))

;

select movie.movie_id, title, genre
from movie_genre
inner join movie
on movie.movie_id = movie_genre.movie_id
inner join genre
on genre.genre_id = movie_genre.genre_id
where genre_name = 'Sports' and title like 'Coach %'
;