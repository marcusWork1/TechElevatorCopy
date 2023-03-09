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
--   (rather than one row in result for each row in the table)
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


-- States sorted alphabetically (A-Z) within their census region. The census regions are sorted in reverse alphabetical (Z-A) order.


-- The biggest park by area



-- LIMITING RESULTS

-- The 10 largest cities by populations


-- The 20 oldest parks from oldest to youngest in years, sorted alphabetically by name.
-- calculate how many years ago a park was established
-- SQL will allows to do date arithmetic; we can add and subtract dates
-- subtract two dates gives the diference between the dates in days
-- CURRENT_DATE is a keyword the represents today's date
-- to calculate the number of years ago a park was established
--   how any days ago it was established / number of days in a year
--     (CURRENT_DATE - date_established) / 365
-- or  (CURRENT_DATE - date_established) / 365.25
select park_name, date_established
      , (CURRENT_DATE - date_established) / 365 AS Age
from park
order by date_established asc, park_name
limit 20
;
-- to calculate the number of years ago a park was established
--   today's year - year-establised
-- the date_part() function will extract the parts of a date
-- 'year', 'month', 'day'
--   date_part('year', current_date) - date('year', date-established)
select park_name, date_established
      , date_part('year', current_date) - date_part('year', date_established) AS Age
from park
order by date_established asc, park_name
limit 20
;


-- CONCATENATING OUTPUTS

-- All city names and their state abbreviation.
-- we want to see:  city name (state_abbreviation)
--
-- in Java:  cityName + " (" + state_abbreviation + ")"

select city_name || ' (' || state_abbreviation || ')' AS name_state
  from city
;
-- The all parks by name and date established.
-- We want to see:  'Park Name: ' park_name   ' Date Established: ' date_established

select 'Park Name: ' || park_name ||  ' Date Established: ' || date_established
    as park_info
from park
order by date_established
;

select 'Park Name: ' || park_name ||  ' Year Established: ' 
                     || date_part('year', date_established)
   as park_info
from park
order by date_established
;
-- The census region and state name of all states in the West & Midwest 
-- We want to see: census_region ': ' state_name								  
-- sorted in ascending order
select census_region || ': ' || state_name as james
from state
where census_region = 'West' or census_region = 'Midwest'
order by census_region, state
;
select census_region || ': ' || state_name as james
from state
where census_region = 'West' or census_region = 'Midwest'
order by james  -- as name may be used in the order by
				-- derived column name may be used in an order by				   
;								  
select census_region || ': ' || state_name as james
from state
where census_region = 'West' or census_region = 'Midwest'
order by 1  -- column position in the select may be used in the order by
			-- column position is used if the derived column has no name				   
;									  
select census_region || ': ' || state_name as james
from state
where census_region in('West' , 'Midwest')
order by james  -- as name may be used in the order by
				-- derived column name may be used in an order by				   
;
select census_region || ': ' || state_name as james
from state
where census_region iLike('%west')  -- ends with west ignoring case
order by james  -- as name may be used in the order by
				-- derived column name may be used in an order by				   
;
								  
								  
								  
-- AGGREGATE FUNCTIONS

-- Average population across all the states. 
-- Since the average is across all the rows in the table, there is no GROUP BY
-- Note the use of alias (AS phrase), common with aggregated values.
select avg(population) as average_state_population 
 from state
;

-- Total population in the West and South census regions
-- 'Total' indicates you want sum() 
-- 'in' or 'by' or 'for each' that indicates the GROUP BY
								
-- Typically the column(s) usedin the GROUP BY are included in the select								  
select census_region, sum(population) as total_population
from state
where census_region = 'West' or census_region = 'South'	-- census_region in ('West', 'South')							  
GROUP BY census_region -- produce the aggregate value for each census_region
					   -- one row in result for each census_region
;


-- The number of cities with populations greater than 1 million
-- 'number of' or 'how many' indicates COUNT	
Select count(*)
  from city
 where population > 1000000
;

-- The number of state nicknames.
-- count(*) - count rows in the table - ignores columns								  
select count(*) as Number_Of_State_with_Nicknames
from state								  
;
-- count(column-name) - counts rows in the table with non-null values in column-name
-- count(state_nickname) - countteh rows with non-null nicknames								  
select count(state_nickname) as Number_Of_State_with_Nicknames
from state								  
;	
-- we want to nicknames too...	
-- we can't (today).... 
-- when a aggregate expression is used on a select, 
--    only columns in the group by are allowed in the select 
--
-- when a column name not in a group is used in a select 
--    you're asking for 1 row in result	for each row in the table that satisfies the WHERE
-- when a aggregate function is used in a select 
--    you're asking for 1 row in result	for each group (specified in the GROUP BY)	
--
-- asking for 1 row for each row in the table conflicts with asking for 1 row per GROUP
--      results in an error (usually it's an ambgious reference error)	
-- his statement will generate an error!
--      column-name     aggregate function  on the same select								  
--select state_nickname, count(state_nickname) as Number_Of_State_with_Nicknames
--from state								  
--;									  

-- The area of the smallest and largest parks.



-- GROUP BY

-- Count the number of cities in each state, ordered from most cities to least.
select state_abbreviation, count(*) as city_count
  from city
group by state_abbreviation	
--order by 1 desc		-- use column position	
order by city_count     -- use the AS name
--order by count(*)	    -- use the calcualation used for the derived column							  
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
-- (Skip 0 rows, and return only the first 10 rows from the sorted resu
select city_name, population
from city								 
order by city_name
offset 20 rows fetch next 10 rows only -- offset indidcates the number of row to skip in result before returning data
-- fetch indicates how many rows to retrieve form the result(defult is all rows)
;								  
								  
-- SUBQUERIES (optional)

-- Include state name rather than the state abbreviation while counting the number of cities in each stat

-- state name is in different table than we need
-- state name is in the state table, we are using the city table
-- we can use a join or a sub query
select -- first select for the city table
(select state_name -- sub select for state name instead of join
 from state -- from state table
where state_abbreviation = city.state_abbreviation), -- match state abbreviation to current city state abbreviation
count(city_name) as city_count -- city table columns after first select
from city -- first select from city
group by state_abbreviation
order by city_count desc
;


-- Include the names of the smallest and largest parks
-- classic syntax below!

select park_name 
from park, -- comma says join park with the largest and smallest park areas as a table 
(select min(area) as smallest, max(area) as largest
from park) as areas -- new table with smallest and largest park area in a table
where park.area = areas.smallest or park.area = areas.largest
;

-- modern syntax below!!
select park_name
from park
inner join (select min(area) as smallest, max(area) as largest
from park) as areas
on park.area = areas.smallest or park.area = areas.largest
;

-- List the capital cities for the states in the Northeast census region.

