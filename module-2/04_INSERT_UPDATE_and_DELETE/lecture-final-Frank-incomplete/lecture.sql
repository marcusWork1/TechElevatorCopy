---------------------------------------------------------------------------------------------------------------------------------------
-- Referential Integrity - Enforcement of the Parent-Dependent relatiohnship
--                         ie. Ensure that every foreign key value has a matching primary key
--
-- Constraints are rules regarding the data that must be complied with:
-- Constraints are applied when you INSERT, UPDATE, DELETE
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
--                      defining a complete process
-- 
-- BEGIN TRANSACTION - Mark the start of a unit of work
-- 
-- COMMIT - End a unit of work and save changes - can be automatically done if no errors
--          (save your work) 
--
-- ROLLBACK - End a unit of work and undo changes - can be automatically done if errors
--            (undo your work done in UOW)
---------------------------------------------------------------------------------------------------------------------------------------
--  INSERT - add a row to a table - constraints may stop the insert if violated
--
--  Format 1: INSERT INTO table-name 
--            (column-list)           -- must contain all non-null or non-default value columns 
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

-- Add Disneyland to the park table. 
-- (It was established on 7/17/1955, has an area of 2.1 square kilometers and does not offer camping.)
-- park_id is serial type which means the data base manager will generate a unique value for it
--       we do not have include columns defined with data base generated values (serial or default)

-- make this a unit of work so we can undo it untile se are sure it is correct

insert into park
       (park_name  , date_established, area, has_camping)
values('Disneyland', '7/17/1955'     , 2.1 , false)
;

-- select the new data from the data base to be sure it was added correctly
-- we can remove this select when we are done verifing the insert was done correct
select * from park where park_name = 'Disneyland';

-- pgAdmin will automatically commit after you run



-- Add Hawkins, IN (with a population of 30,000 and an area of 38.1 square kilometers) 
--  and Cicely, AK (with a popuation of 839 and an area of 11.4 square kilometers) to the city table.
-- add two separate sets of values into the same table
insert into city 
      (city_name, state_abbreviation, area, population) 
Values('Hawkins', 'IN'              , 38.1, 30000) 
      ,('Cicely' , 'AK'              , 11.4, 839);	 
-- Since Disneyland is in California (CA), add a record representing that to the park_state table.
select * from city
where city_name like 'Haw%' or city_name like 'Cice%'
;

-- copy data from one table to another
-- we will do this Monday
--insert into new_table
--(select * from source_table)
--;



-- UPDATE

-- Change the state nickname of California to "The Happiest Place on Earth."
update state
set state_nickname = 'The Happiest Place on Earth'
where state_abbreviation = 'CA'
;

select state_nickname from state where state_abbreviation = 'CA';

-- suppose don't know the state_abbreviation for 'California'?
-- we know the state_abbreviation is in a table - the databasse knows.
-- we can use a subquery to get the state_abbreviation from the database to use

update state
set state_nickname = 'The Happiest Place on Earth'
where state_abbreviation = (select state_abbreviation   -- go get the state_abbreviation for California from data base
							  from state 
							 where state_name = 'California')
;

select state_nickname from state where state_abbreviation = (select state_abbreviation   -- go get the state_abbreviation for California from data base
							                                from state 
							                                where state_name = 'California');

-- Increase Disneyland area by a factor of 2
-- park_id was assigned by database manager - we don't know what it is
--   use a subquery to get it and use in our update
update park
  set area = area * 2
  where park_id in (select park_id from park where park_name = 'Disneyland');

-- Increase the population of California by 1,000,000.


-- Change the capital of California to Anaheim.


-- Change California's nickname back to "The Golden State", reduce the population by 1,000,000, and change the capital back to Sacramento.



-- DELETE

-- Delete Hawkins, IN from the city table.
delete from city
where city_name = 'Hawkins' and state_abbreviation ='IN'
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
