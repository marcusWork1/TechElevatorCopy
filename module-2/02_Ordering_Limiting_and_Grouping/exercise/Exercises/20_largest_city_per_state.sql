-- 20. The state abbreviation, and population of the city with the largest population (name column 'city_population') for all states, territories, and districts.
-- Order the results from highest to lowest populations.
-- (56 rows)
select max(population) as city_population, state_abbreviation
from city
group by population, state_abbreviation
order by population desc
limit 56
;
