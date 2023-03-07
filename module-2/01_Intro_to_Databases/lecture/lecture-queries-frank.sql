--------------------------------------------------------------------------------------------------------
-- Basic SELECT Lecture Code
--------------------------------------------------------------------------------------------------------
-- -- indicates a comment - anything following on the line is ignored
--
-- SQL SELECT statement - retrieve values form the database (Read)
--
-- A SELECT statement is often referred to as a query
--
-- Basic syntax:
--
--      SELECT   - columns to include in the result (seperate mutiple column reqeusts with commas)
--      FROM     - table containing rows used in the query 
--      WHERE    - rows to include in the result
--      ORDER BY - sequence of rows in the result
--                 without an ORDER BY the sequence of the rows in the result is not predictable
--                 if the sequence of teh rows in teh result matter - code an ORDER BY
--
-- WHERE predicates:
--
--        =  <>  !=  >  >=  <  <= 
--        IN(list-of-values)      -- alterative to a series of = OR
--        NOT IN(list-of-values)  -- alterative to a series of != AND
--        BETWEEN value AND value
--        IS NULL
--        IS NOT NULL
--        LIKE    (use wildcards: % means 0 to any number of any characters
--                                _ means exactly any one character)
--        ILIKE   (case insensivtive LIKE - Postgres extension)
--
-- predicates may be combined using AND and OR
--
-- use parentheses to make your multi-predicate condition clear

-- The DISTINCT clause on a SELECT removes duplicate values from the result
-- based on the all columns that follow
--
-- The DISTINCT ON(columns/expression) clause on a SELECT removes duplicate values from the result
-- based on the all columns/expression inside the parentheses that follow (Postgres extension)
------------------------------------------------------------------------------------------------------

-- SELECT
-- Use a SELECT statement to return a literal string

Select  'Frank', 23, '03/06/2023';


-- Use a SELECT statement to add two numbers together (and label the result "sum")


-- Select 2+2,
Select '2 times 2 is:', 2 * 2;

Select '2 times 2 is:', 2 * 2 as Calculation -- name the derived column in the result
;
-- 'as' creates a new column 

-- SELECT ... FROM

-- select is the columns u want in result
-- From is the table with those columns

-- Write queries to retrieve...

-- The names from all the records in the state table
Select state_name -- columns to see in resulte
From state -- table that has columns
;

-- The names and populations of all cities
Select city_name, population
From city
;

-- All columns from the park table
-- * will select everything in table
Select *
From park
;



-- SELECT __ FROM __ WHERE


-- Write queries to retrieve...

-- The names of cities in California (CA)
Select city_name, state_abbreviation
From city
Where state_abbreviation = 'CA'
;


-- The names and state abbreviations of cities NOT in California

Select city_name, state_abbreviation
From city
Where state_abbreviation != 'CA'
;
-- The names and areas of cities smaller than 25 square kilometers 
Select city_name, area
From city
Where area < 25
;

-- The names from all records in the state table that have no assigned censusregion
Select state_name, census_region
From state 
Where census_region IS null
;
-- null represents missing or unknown value, so usual predicates(<, =, >, etc)
-- will not work. must use "IS" or "IS NOT"^
-- The names and census regions from all records in the state table that have an assigned census region



-- WHERE with AND/OR
-- Write queries to retrieve...

-- The names, areas, and populations of cities smaller than 25 sq. km. with more than 100,000 people
Select city_name, area, population
From city
Where area < 25 and population > 100000
;

-- The names and census regions of all states (and territories and districts) not in the Midwest region (including those that don't have any census region)
Select state_name, census_region
From state
Where census_region != 'Midwest' or census_region is null
;

-- The names, areas, and populations of cities in California (CA) or Florida (FL)
Select city_name, area, population 
From city
Where state_abbreviation = 'CA' 
or state_abbreviation = 'FL'
;
-- The names, areas, and populations of cities in New England -- Connecticut (CT), Maine (ME), Massachusetts (MA), New Hampshire (NH), Rhode Island (RI) and Vermont (VT)
Select city_name, area, population
from city
where state_abbreviation = 'CT'
or state_abbreviation = 'MA'
or state_abbreviation = 'ME'
or state_abbreviation = 'NH'
or state_abbreviation = 'VT'
or state_abbreviation = 'RI'
;
Select city_name, area, population
from city
where state_abbreviation IN('CT', 'MA', 'ME', 'NH', 'VT', 'RI')
;

-- SELECT statements involving math
-- Write a query to retrieve the names and areas of all parks in square METERS
-- (the values in the database are stored in square kilometers)
-- Label the second column "area_in_square_meters"



-- All values vs. distinct values

-- Write a query to retrieve the names of all cities and notice repeats (like Springfield and Columbus)


-- Do it again, but without the repeats (note the difference in row count)



-- LIKE
-- Write queries to retrieve...

-- The names of all cities that begin with the letter "A"
Select city_name
from city
where city_name LIKE 'A%'
;

-- The names of all cities that end with "Falls"


-- The names of all cities that contain a space
Select city_name
from city
where city_name Like '% %'
;



-- BETWEEN
-- Write a query to retrieve the names and areas of parks of at least 100 sq. kilometers but no more than 200 sq. kilometers



-- DATES
-- Write a query to retrieve the names and dates established of parks established before 1900

