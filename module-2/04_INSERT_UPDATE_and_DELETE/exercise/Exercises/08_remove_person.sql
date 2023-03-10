-- 8. Remove "Penn Jillette" from the person table 
-- You'll have to remove data from another table before you can make him "disappear" (Get it? Because he's a magician...) (1 row each)
delete from movie_actor
where actor_id = ( select actor_id from movie_actor inner join person on person.person_id = movie_actor.actor_id where person_name = 'Penn Jillette') 
;
delete from person
where person_name = 'Penn Jillette'
;
 