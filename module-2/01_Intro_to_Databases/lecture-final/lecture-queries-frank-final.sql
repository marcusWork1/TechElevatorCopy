--------------------------------------------------------------------------------------------------------
-- Basic SELECT Lecture Code
--------------------------------------------------------------------------------------------------------
-- -- indicates a comment - anything following on the line is ignored
--
-- SQL SELECT statement - retrieve values from the database (Read)
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
--                 if the sequence of the rows in teh result matter - code an ORDER BY
--
--  SELECT and FROM are always required; other clause/words are optional
--
-- WHERE predicates: (a predicate is a condition)
--
--        not equals is either <>  or  !=
--        ! is the not operator
--
--        =  <>  !=  >  >=  <  <= 
--        IN(list-of-values)      -- alterative to a series of = OR
--        NOT IN(list-of-values)  -- alterative to a series of != AND
--        BETWEEN value AND value
--        IS NULL
--        IS NOT NULL
--        LIKE    (use wildcards: % means 0 to any number of any characters
--                                _ means exactly any one character)
--
--        LIKE '%string'  - ends with string
--        LIKE 'string%'  - starts with string
--        LIKE '%string%' - contains the string
--   
--        ILIKE   (case insensivtive LIKE - Postgres extension)
--
-- predicates may be combined using AND and OR
--
-- use parentheses to make your multi-predicate condition clear

-- a NULL is relational data represents a missing or unknown value
-- since a null is an unknown value, the usual prediates (=, !=, >, < . etc)
-- use IS NULL or IS NOT NULL to check for a column's nullness
--
-- any operation with a NULL results in a NULL

-- The DISTINCT clause on a SELECT removes duplicate values from the result
-- based on the all columns that follow
--
-- The DISTINCT ON(columns/expression) clause on a SELECT removes duplicate values from the result
-- based on the all columns/expression inside the parentheses that follow (Postgres extension)
------------------------------------------------------------------------------------------------------

-- SELECT
-- Use a SELECT statement to return a literal string
-- A string literal in SQL is enclosed in ' ' ('Frank' )
-- A numeric literal in SQL is coded like a number (24  34.56  -190)
--                                             Date format:    USA           ISO/JIS       EUR
-- A date literal in SQL is coded like a human date in ' ' ('03/06/2023'  '2023-06-03' '06.03.2023')

-- multiple SQL statements in the same file must be separated by semi-colon (;)

Select 'Frank', 23, '03/06/2023'
;   -- OK to put things on seperate lines - SQL does not care how many lines are in the query

Select 
       'Frank'       -- example of a string literal
       , 23           -- example of a numeric literal
       ,'06.03.2023' -- example of a date literal
;   -- OK to put things on seperate lines - SQL does not care how many lines are in the query

-- Use a SELECT statement to add two numbers together (and label the result "sum")
--
-- simple math may be done in the select
select '2 times 2 plus 45 is: ',  2 * 2 + 45
;

-- literal and calculations are called derived columns in the query
-- a derived column is a value in the result that did not come directly from a table column
-- as derived column does not have a name...
--    unless  you give it one with the 'AS' phrase
-- the 'AS' phrase is used to rename columns in a result
-- the value coded after the 'AS' is a single word (use _ to separate multiple words)

select '2 times 2 plus 45 is: ' as What_We_Did
     ,  2 * 2 + 45 as Math_We_Did  -- name the derived column in the result
;
select '2 times 2 plus 45 is: ' as What_We_Did
     ,  2 * (2 + 45) as Math_We_Did  -- name the derived column in the result
;

-- SELECT ... FROM
-- SELECT - columns you want in the result
--   FROM - table with those columns

-- Write queries to retrieve...

-- The names from all the records in the state table
select state_name   -- column(s) to see in the result
  From state        -- table with the column(s)
;

-- The names and populations of all cities
SeLect city_name, population
frOM city
;
-- The names and populations of all cities
-- the order of the SELECT 
-- determines the order of the columns in the result
SeLect population, city_name
frOM city
;


-- All columns from the park table
-- SELECT * - select all columns from a table

select *
from city
;


-- SELECT __ FROM __ WHERE
-- Write queries to retrieve...

-- The names of cities in California (CA)
select city_name   -- column(s) to see in result
  from city        -- table with the column(s)
 where state_abbreviation = 'CA' -- rows to see in the result 
;

-- its OK to include columns not request when building query
--     to verify your result is correct
select city_name, state_abbreviation   -- column(s) to see in result
  from city                            -- table with the column(s)
 where state_abbreviation = 'CA'       -- rows to see in the result 
;

-- The names and state abbreviations of cities NOT in California
select city_name, state_abbreviation   -- column(s) to see in result
  from city                            -- table with the column(s)
 where state_abbreviation != 'CA'      -- rows to see in the result 
;

-- The names and areas of cities smaller than 25 square kilometers 


-- The names from all records in the state table that have no assigned census region
-- if census region is missing it is null (saw this by looking at the data)

select state_name, census_region   -- columns in the resultt
  from state                       -- table with the columns
 where census_region is null       -- rows in the result
; 

-- The names and census regions from all records in the state table 
--    that have an assigned census region - not null
select state_name, census_region   -- columns in the resultt
  from state                       -- table with the columns
 where census_region is not null       -- rows in the result
; 



-- WHERE with AND/OR
-- Write queries to retrieve...

-- The names, areas, and populations of cities smaller than 25 sq. km. with more than 100,000 people
select city_name, area, population
 from city
 where area < 25 and population > 100000
;
-- The names and census regions of all states (and territories and districts) 
--  not in the Midwest region (including those that don't have any census region)
select state_name, census_region
  from state
 where census_region != 'Midwest'
    or census_region is null  -- teritories don'r have a census region
; 

-- The names, areas, and populations of cities in California (CA) or Florida (FL)


-- The names, areas, and populations of cities in New England -- Connecticut (CT), Maine (ME), Massachusetts (MA), New Hampshire (NH), Rhode Island (RI) and Vermont (VT)
select city_name, area, population, state_abbreviation
  from city
 where state_abbreviation = 'CT'
    or state_abbreviation = 'MA' 
	or state_abbreviation = 'ME'
	or state_abbreviation = 'NH'
	or state_abbreviation = 'VT'
	or state_abbreviation = 'RI)'
; 

-- IN clause is short-hand for a series of =/or predicates
-- NOT IN is short hand for a series of !=/and predicates
select city_name, area, population, state_abbreviation
  from city
 where state_abbreviation IN('CT', 'ME', 'MA', 'NH', 'VT', 'RI')
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
select city_name
  from city
 where city_name like 'A%'
;

-- The names of all cities that end with "Falls"
select city_name
  from city
 where city_name like '%Falls'
;

-- The names of all cities that contain a space
select city_name
  from city
 where city_name like '% %'
;


-- BETWEEN
-- Write a query to retrieve the names and areas of parks of at least 100 sq. kilometers but no more than 200 sq. kilometers



-- DATES
-- Write a query to retrieve the names and dates established of parks established before 1900

