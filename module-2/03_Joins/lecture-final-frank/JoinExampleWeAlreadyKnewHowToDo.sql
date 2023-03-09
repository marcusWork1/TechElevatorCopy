-- When data is need from multiple tables - Do a JOIN
-- A JOIN finds matching data between tables
-- Determine which columns contain matching data between the tables
-- columns containing the matching data may have different names
-- if the columns with the matching have the same names
--        you must qualify the name by coding the table name.column to identify column
-- the condition identify the matching is coded on the WHERE clause
--     and is known as the join condition

-- Show the city name and state name for each city
select city.city_name, state.state_name  -- Columns to see in result
from   city, state            -- Table(s) with the columns
where  city.state_abbreviation = state.state_abbreviation  -- Which rows you want from the tables
                                                           -- rows from city that match the rows in state
					                                       --    based on state_abbreviation
--order by             -- any ordering or sequence of rows results
;

-- Show the city name, state name, census_region for each city
--  only for city in the South census region
select city_name, state_name, census_region  -- Columns to see in result
from   city, state            -- Table(s) with the columns
where  city.state_abbreviation = state.state_abbreviation  -- join condition/predicate
   and census_region = 'South'                             -- filter condition/predicate
--order by             -- any ordering or sequence of rows results
;