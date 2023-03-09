---------------------------------------------------------------------------------------------------------------------------------------
-- Referential Integrity - Enforcement of the Parent-Dependent relatiohnship
--                         ie. Ensure that every foreign key value has a matching primary key
--
-- Constraints are rules regarding the data that must be complied with:
--
--  NOT NULL - Column must have a value
--
--  UNIQUE   - Column value must be unique with the table 
--
--  PRIMARY KEY - Column is part of the unique identifier for a row in the table
--                UNIQUE and NOT NULL are implied
--
--  FOREIGN KEY - Column is part of a foreign key for the table.  
--                Value must have a matching value in the primary key of the parent table
--                Establishes the parent-dependent relationship
--
--  CHECK  -  Specifies acceptable values for a column - any simple WHERE predicate is allowed
--
--  DEFAULT - Specify a default value for column if no value is supplied on INSER
---------------------------------------------------------------------------------------------------------------------------------------
-- Unit Of Work (UOW) - A recoverable sequence of operations within an application process
-- 
-- BEGIN TRANSACTION - Mark the start of a unit of work
-- 
-- COMMIT - End a unit of work and save changes - automatically done if no errors
-- 
-- ROLLBACK - End a unit of work and undo changes - automatically done if errors
---------------------------------------------------------------------------------------------------------------------------------------
--  INSERT - add a row to a table
--
--  Format 1: INSERT INTO table-name 
--            (column-list)           -- must contain all non-null columns
--            VALUES(value-list)      -- order of values must match order of columns specified
--
--
--  Format 2: INSERT INTO table-name 
--            VALUES(value-list)      -- order of values must match order of columns as defined in the table
--
--
--  Format 3: INSERT INTO table-name 
--            (SELECT statement)      -- order of columns in the SELECT must match the order of columns as defined in the table
--                                    -- () are optional
--                                            
---------------------------------------------------------------------------------------------------------------------------------------
--  UPDATE - change data in a table
--
--  UPDATE table-name
--  SET column = new-value
--  WHERE condition            -- scope of update - if omitted, all rows are updated                                         
---------------------------------------------------------------------------------------------------------------------------------------
--  DELETE - Remove rows from a table
--
--  DELETE FROM table-name
--  WHERE condition            -- scope of delete - if omitted, all rows are deleted                                        
---------------------------------------------------------------------------------------------------------------------------------------

-- INSERT

-- Add Disneyland to the park table. (It was established on 7/17/1955, has an area of 2.1 square kilometers and does not offer camping.)
Begin transaction; -- make this a unit of work so we can undo it until it is correct 

insert into park
(park_name, date_established, area, has_camping)
values('Disneyland', '7/17/1995', 2.1, false)
;
rollback; -- end unit of work, change this to a commit when we are sure it is correct

-- Add Hawkins, IN (with a population of 30,000 and an area of 38.1 square kilometers) and Cicely, AK (with a popuation of 839 and an area of 11.4 square kilometers) to the city table.
insert into city
(city_name,state_abbreviation, population, area)
values('Hawkins', 'IN', 30000, 38.1), ('Cicely', 'AK', 839, 11.4)
;

select city_name
from city
where state_abbreviation = 'IN'
;
-- Since Disneyland is in California (CA), add a record representing that to the park_state table.



-- UPDATE

-- Change the state nickname of California to "The Happiest Place on Earth."
update state
set state_nickname = 'The Happiest Place on Earth'
where state_abbreviation = 'CA'
; 
select state_nickname from state where state_abbreviation = 'CA'
;

-- Increase the population of California by 1,000,000.


-- Change the capital of California to Anaheim.


-- Change California's nickname back to "The Golden State", reduce the population by 1,000,000, and change the capital back to Sacramento.



-- DELETE

-- Delete Hawkins, IN from the city table.
delete from city
where city_name = 'Hawkins' and state_abbreviation = 'IN'
;
select * from city where city_name = 'Hawkins';

-- Delete all cities with a population of less than 1,000 people from the city table.



-- REFERENTIAL INTEGRITY

-- Try adding a city to the city table with "XX" as the state abbreviation.


-- Try deleting California from the state table.


-- Try deleting Disneyland from the park table. Try again after deleting its record from the park_state table.



-- CONSTRAINTS

-- NOT NULL constraint
-- Try adding Smallville, KS to the city table without specifying its population or area.


-- DEFAULT constraint
-- Try adding Smallville, KS again, specifying an area but not a population.


-- Retrieve the new record to confirm it has been given a default, non-null value for population.


-- UNIQUE constraint
-- Try changing California's nickname to "Vacationland" (which is already the nickname of Maine).


-- CHECK constraint
-- Try changing the census region of Florida (FL) to "Southeast" (which is not a valid census region).



-- TRANSACTIONS

-- Delete the record for Smallville, KS within a transaction.


-- Delete all of the records from the park_state table, but then "undo" the deletion by rolling back the transaction.


-- Update all of the cities to be in the state of Texas (TX), but then roll back the transaction.


-- Demonstrate two different SQL connections trying to access the same table where one is inside of a transaction but hasn't committed yet.
