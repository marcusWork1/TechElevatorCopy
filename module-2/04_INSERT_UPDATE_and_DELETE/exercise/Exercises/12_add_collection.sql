-- 12. Create a "Bill Murray Collection" in the collection table. For the movies that have Bill Murray in them, set their collection ID to the "Bill Murray Collection". (1 row, 6 rows)
insert into collection
(collection_name) 
values ('Bill Murray Collection')
;
select person_id
from person
where person_Name = 'Bill Murray'
; -- = 1532
update movie 
set collection_id = (select collection_id from collection where collection_name = 'Bill Murray Collection')
where movie_id IN
(select movie_id from movie_actor inner join
 person on movie_actor.actor_id = person.person_id where person_name = 'Bill Murray')
;

-- how to do it if assigning variables to tables
--UPDATE movie SET collection_id = 
--(SELECT collection_id FROM collection WHERE collection_name = 'Bill Murray Collection')
--WHERE movie_id IN (SELECT A.movie_id FROM movie_actor A JOIN person P ON A.actor_id = P.person_id WHERE P.person_name = 'Bill Murray');