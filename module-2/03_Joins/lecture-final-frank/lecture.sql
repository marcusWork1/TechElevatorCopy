-- Keys, Joins and Unions
--
-- Primary Key - a column or set of columns that uniquely identify a row in a table (Parent table)
-- Foreign Key - a column or set of columns that match the primary key of another table (Dependent table)
--
-- Natural Key - Value(s) that exist for a table that can be used as primary keys
-- Surrogate Key - Artificially generated keys to use as a primary key
--
--  Joins are used when columns from multiple tables are required in a query
--
-- INNER JOIN - Matching rows between tables 
-- 
-- OUTER JOIN - All rows from both tables - the full set      
------------------------------------------------------------------------------------------------
-- Inner Join syntax - 2 forms
-- 
-- Classic join sytnax (original join syntax)
--
--  SELECT columns
--    FROM table1, table2  
--  WHERE table1.column = table2.column  -- join condition
--
-- If you omit join conditions the result is Cartersian Product
--    each from one table with each row in the other - IT'S NOT A JOIN
--
-- minimum # join conditions on WHERE = # tables - 1
--
-- Modern syntax (newer) - cannot forget the join condition
--
--  SELECT columns
--    FROM table1
--         INNER JOIN  -- or just JOIN
--         table2
--      on table1.column = table2.column -- join condition - error if omitted
--
-- Additional WHERE predicates may be added to either syntax to filter rows
------------------------------------------------------------------------------------------------
-- -- OUTER JOIN syntax 
--
--  SELECT columns
--    FROM table1
--         FULL OUTER JOIN
--         table2
--      on table1.column = table2.column
--
-- Additional WHERE predicates may be added to either syntax to filter rows
------------------------------------------------------------------------------------------------
-- UNION - Merging rows between two tables
--
-- Each SELECT must have the same number of columns in the same order and be compatible datatypes 
--      use literals if necessary to make the UNION work
--
-- SELECT columns
--   FROM table1
-- WHERE predicate
--
-- UNION   -- merge the results of the two selects
--
-- SELECT columns
--   FROM table2
-- WHERE predicate
------------------------------------------------------------------------------------------------
--
-- UNION All - Concatenating rows between two tables
--
-- Each SELECT must have the same number of columns in the same order and be compatible datatypes 
--      use literals if necessary to make the UNION work
--
-- SELECT columns
--   FROM table1
-- WHERE predicate
--
-- UNION ALL
--
-- SELECT columns
--   FROM table2
-- WHERE predicate
------------------------------------------------------------------------------------------------
-- INNER JOIN

-- Write a query to retrieve the name and state abbreviation for the 2 cities named "Columbus" in the database

--         city        city
select city_name, state_abbreviation -- columns in the result
from   city                          -- table(s) with the columns needed
where  city_name = 'Columbus'        -- filter the result for certain cities
;

-- Modify the previous query to retrieve the names of the states (rather than their abbreviations).

-- Classic syntax join
--         city      state
select city_name, state_name     -- columns in the result
from   city, state               -- table(s) with the columns needed
where  city_name = 'Columbus'    -- filter the result for certain cities
  and  city.state_abbreviation = state.state_abbreviation  -- join condition (1 required  (2 tables on from)
;
--
-- Modern syntax join
--         city      state
select city_name, state_name
  from  city      -- one of the table in the join (doesn't matter which one)
  inner join      -- type of join (coding just join is ok as it assumes inner join)
        state     -- another table in the join
	 on state.state_abbreviation = city.state_abbreviation -- join (order of columns in the predicate doesn't matter)  
 where  city_name = 'Columbus'    -- filter the result for certain cities
;


-- Write a query to retrieve the names of all the national parks with their state abbreviations.
-- (Some parks will appear more than once in the results, because they cross state boundaries.)

//        park      park_state
select  park_name, state_abbreviation  -- columns in the result
from    park   -- table with the columns
  inner join
        park_state
     on park.park_id = park_state.park_id
;

-- classic syntax

select park_name, state_abbreviation
  from park, park_state
  where park.park_id = park_state.park_id  -- join condition
;

-- The park_state table is an associative table that can be used to connect the park and state tables.

-- Modify the previous query to retrieve the names of the states rather than their abbreviations.
-- If there is no direct link (matching data) bewteen the table your need
-- You look for another table that connects/associates/relates to both tables
-- more than 2-table join is required to get teh table you need

--        park       state
select  park_name, state_name  -- columns in the result
from    park   -- table with the columns
  inner join park_state on park.park_id = park_state.park_id
  inner join state      on park_state.state_abbreviation = state.state_abbreviation		
;
-- classic syntax

select park_name, state_name
  from park
     , state
	 , park_state
  where park.park_id = park_state.park_id                         -- join condition
    and state.state_abbreviation = park_state.state_abbreviation  -- join condition
;

-- Modify the previous query to include the name of the state's capital city.
-- State table contains the city id for the capital city
-- match the city_id in city to the capital in state
-- (we could use state_abbreviation in this case instead, but in other situtaions we might not)
-- if a column in table has the data you want use it rather than another might be convenient
-- we want capital city name so we use use capital in state_abbreviation in state

--        park       state      city
select  park_name, state_name, city_name  -- columns in the result
from    park   -- table with the columns
  inner join park_state on park.park_id = park_state.park_id
  inner join state      on park_state.state_abbreviation = state.state_abbreviation	
  inner join city       on city_id = state.capital	
;

-- Modify the previous query to include the area of each park.
--        park       state      city      park
select  park_name, state_name, city_name, park.area  -- columns in the result
from    park   -- table with the columns
  inner join park_state on park.park_id = park_state.park_id
  inner join state      on park_state.state_abbreviation = state.state_abbreviation	
  inner join city       on city_id = state.capital	
;

-- A Correlation names is  nickname/alias for a table used in query
-- Designed to make the query easier to code or understand
-- assign a correlation name to a table when you specify the tabke in the query
--      table-name   correlation-name

--        park       state      city      park
select  park_name, state_name, city_name, p.area  -- columns in the result
from    park p          -- assign a correlation name to the table
  inner join park_state ps  on p.park_id = ps.park_id
  inner join state      st  on ps.state_abbreviation = st.state_abbreviation	
  inner join city           on city_id = st.capital	
;  

-- Write a query to retrieve the names and populations of all the cities in the Midwest census region.
select city_name, city.population
  from city inner join state on city.state_abbreviation = state.state_abbreviation    
where census_region = 'Midwest'
;

-- Write a query to retrieve the number of cities in the city table 
--     for each state in the Midwest census region.
--
-- sometimes you need a column from another table to solve the problem
--     even if it's not returned in the result on the select
select count(city), state.state_abbreviation 
  from city inner join state on city.state_abbreviation = state.state_abbreviation
  where state.census_region = 'Midwest'
  group by state.state_abbreviation
;

-- Modify the previous query to sort the results by the number of cities in descending order.
select count(city)  
  from city inner join state on city.state_abbreviation = state.state_abbreviation
  where state.census_region = 'Midwest'
;


-- LEFT JOIN

-- Write a query to retrieve the state name 
-- and the earliest date a park was established in that state (or territory) for every record in the state table that has park records associated with it.


-- Modify the previous query so the results include entries for all the records in the state table, even if they have no park records associated with them.



-- UNION

-- Outer Join is the combination of all rows from two tables (inner join is matching rows between two table)
-- UNION will merge results for two select statements
-- Merge means combine all data from two different sources
--
-- Outer Join may be accomplished with a UNION

"Select the data from one table"
UNION
"Select all the data from another table"


-- Write a query to retrieve all the place names in the city and state tables that begin with "W" sorted alphabetically. (Washington is the name of a city and a state
-- We want all cities and all states that start with 'W'

select city_name from city where city_name like 'W%'    -- all the cities starting with 'W'
union                                                   -- merge that with...
select state_name from state where state_name like 'W%' -- all the states that start with 'W'
;


select 'City',  city_name from city where city_name like 'W%'    -- all the cities starting with 'W'
union                                                   -- merge that with...
select 'State', state_name from state where state_name like 'W%' -- all the states that start with 'W'
;

-- how many times does it appear in the results?)


-- Modify the previous query to include a column that indicates whether the place is a city or state.



-- MovieDB
-- After creating the MovieDB database and running the setup script, make sure it is selected in pgAdmin and confirm it is working correctly by writing queries to retrieve...

-- The names of all the movie genres


-- The titles of all the Comedy movies

