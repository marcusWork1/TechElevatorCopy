-----------------------------------------------------------------------------------------------
-- Ordering, Grouping Aggregate Functions Lecture Code
--------------------------------------------------------------------------------------------------------
--
-- ORDER BY -  Sequence of Rows in Result
--
--    ORDER BY          -- Ascending Sequence (low-high)
--    ORDER BY ASC      -- Ascending Sequence (low-high)
--    ORDER BY DESC     -- Descending Sequence (high-low)
--------------------------------------------------------------------------------------------------------
-- Limiting the number of rows in the result
--
-- LIMIT n   - Limit the number of rows in the result - always goes at the end of the SELECT
--------------------------------------------------------------------------------------------------------
-- Concatenating values 
--
-- the concat operator (||) may be used to concatenate character (string) values in a result
--
--------------------------------------------------------------------------------------------------------
-- Aggregate functions - produce one row in result for each group specified
--
-- The group used by the aggregate functions is determined by the GROUP BY clause
-- if no GROUP BY clause is specified, the group is the set of rows in the result
--
--     AVG(column-expression)   - arithmetic average for group of non-NULL values in expression 
--     SUM(column-expression)   - arithmetic sum for group of a non-NULL values in expression 
--     MIN(column-expression)   - lowest value for group of non-NULL values in expression 
--     MAX(column-expression)   - highest value for group of non-NULL values in expression 
--     COUNT(*)                 - number of rows in the group
--     COUNT(column-expression) - number of rows for the group of non-NULL values in expression 
--
--
-- AVG(), SUM() may only be used with numeric data types
-- MIN(), MAX() may be used with numeric, character, date, time datatypes
--
-- COUNT() is applied to rows (not columns)
--
--------------------------------------------------------------------------------------------------------
-- GROUP BY  - Specify the group to which the aggregate functions apply
--
--      GROUP BY column-expression
--
-- When using a GROUP BY the SELECT is limited to aggregate functions or columns in the GROUP BY
----------------------------------------------------------------------------------------------------------
--
-- ORDERING RESULTS

-- Populations of all states from largest to smallest.
select population --  columns included in result
from state --  table with columns
order by population desc -- sequence of rows
;

-- States sorted alphabetically (A-Z) within their census region. The census regions are sorted in reverse alphabetical (Z-A) order.
select state_name, census_region
from state
where  census_region is not null -- extra
order by census_region desc, state_name -- automatically sorts state_name ascending unless told otherwise

;

-- The biggest park by area
select park_name
from park
order by area desc
;


-- LIMITING RESULTS

-- The 10 largest cities by populations
select city_name
from city
order by population desc
limit 10
;

-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.
select park_name, date_established,  (CURRENT_DATE - date_established)/365 as age -- could do todays year - year established. not as exact
 -- calculate how many years ago a park was established
 -- date arithmetic, subtract current date from given dates to find years betweeen
 -- Current_date is a keyword that represents todays date

from park
order by date_established asc, park_name
limit 20
;


-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.
select city_name || '(' || state_abbreviation || ')' as city_state
from city
;

-- The all parks by name and date established.
select 'Park Name: ' || park_name || ' Date Established: ' || date_established as park_established
from park
order by date_established
;


-- The census region and state name of all states in the West & Midwest sorted in ascending order.
select census_region || ': ' || state_name as state_region
from state
where census_region = 'West' or census_region = 'Midwest'
order by census_region asc
;


-- AGGREGATE FUNCTIONS

-- Average population across all the states. Note the use of alias, common with aggregated values.
select AVG(population) as avg_population
from state
;

-- Total population in the West and South census regions
select census_region, SUM(population) as sum_west_and_midwest
from state
where census_region IN('West', 'South')
GROUP BY census_region
;

-- The number of cities with populations greater than 1 million
select COUnt(*) as bigCity
from city
where population > 1000000
;


-- The number of state nicknames.
select count(state_nickname) as nickNames
from state
;



-- The area of the smallest and largest parks.
select MIN(area), MAX(area)
from park
;


-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.
select state_abbreviation, count(*) as city_count
from city
group by state_abbreviation
order by city_count
;

-- Determine the average park area depending upon whether parks allow camping or not.


-- Sum of the population of cities in each state ordered by state abbreviation.


-- The smallest city population in each state ordered by city population.



-- Miscelleneous

-- While you can use LIMIT to limit the number of results returned by a query,
-- it's recommended to use OFFSET and FETCH if you want to get
-- "pages" of results.
-- For instance, to get the first 10 rows in the city table
-- ordered by the name, you could use the following query.
-- (Skip 0 rows, and return only the first 10 rows from the sorted result set.)



-- SUBQUERIES (optional)

-- Include state name rather than the state abbreviation while counting the number of cities in each state,


-- Include the names of the smallest and largest parks


-- List the capital cities for the states in the Northeast census region.

