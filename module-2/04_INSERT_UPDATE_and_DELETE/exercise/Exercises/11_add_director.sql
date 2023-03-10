-- 11. Hollywood is remaking the classic movie "The Blob" and doesn't have a director yet.
--Add yourself to the person table, and assign yourself as the director of "The Blob" (the movie is already in the movie table). (1 record each)
insert into person
(person_id, person_name)
values (12369, 'Marcus Patterson')
;
select person_name
from person
where person_name like 'Marcus %'
;
update movie
set director_id = (select person_id from person where person_id = 12369)
where title = 'The Blob'
;
select person_name 
from person
inner join movie
on person.person_id = movie.director_id
where title = 'The Blob'
;