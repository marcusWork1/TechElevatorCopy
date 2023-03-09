-- 13. The directors of the movies in the "Harry Potter Collection", sorted alphabetically.
-- (4 rows)
select  distinct person_name
from person 
inner join movie
on movie.director_id = person.person_id
inner join collection 
on collection.collection_id = movie.collection_id
where collection_name = 'Harry Potter Collection'
order by person_name asc;

