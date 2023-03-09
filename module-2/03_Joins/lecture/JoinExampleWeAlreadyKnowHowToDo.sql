-- when data is need form multiple tables - DO a JOIN
-- a JOIN finds matching data between tables 
-- determine which columns contain matching data between the tables
-- columns containing the matching data may have different names 
-- if the columns with the matching have the same names
--   		you must dqualify the name by coding the table name.column to identify column
-- the condition identify the matching is coded on the WHERE clause
-- 		and is known as the join condition


-- show the city name, state name, census_region for each city
select city.city_name, state.state_name       -- columns to see in result
from city, state  -- table with the columns 
where city.state_abbreviation = state.state_abbreviation -- which rows you want from the table 
                 										-- rows from city that match the rows in the state
														  -- based on state_abbreviation
-- order by   												 -- any ordering or sequence row results

-- show the city name, state name, census_region for each city
-- only for cities in south census_region
select city_name, state_name, census_region 
from city, state
where city.state_abbreviation = state.state_abbreviation
 and census_region = 'South' 				-- filter condition 
-- order by -- any ordering or sequence of rows results