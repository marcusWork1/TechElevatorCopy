---------------------------------------------------------------------------------------------------------------
--
-- DROP - remove a table and all it's data from the database
--
-- Consider referential constraints - cannot drop a parent if it has dependents
--
--      DROP TABLE table-name             - Will fail if table does not exist or if it has dependents
--
--      DROP TABLE IF EXISTS table-name   - Will run whether table exists or not; 
--                                          will fail if table has dependents
--
--      DROP TABLE IF EXISTS table-name  CASCADE   - Will run whether table exists or not 
--                                                   and whether has dependents or not
--                                                   This may delete multiple tables without notice
--
--
--  CREATE - define a table to the database manager
--
--       CREATE TABLE table-name
--       (column-name     data-type    NOT NULL,
--        column-name     data-type,             -- allow null in column
--        column-name     data-type    DEFAULT   default-value,
--        column-name     data-type    UNIQUE,
--        CONSTRAINT constraint-name PRIMARY KEY (column(s)-in-table),
--        CONSTRAINT constraint-name FOREIGN KEY(for-key-column(s)) REFERENCES parent-table(pri-key-column(s)),
--        CONSTRAINT consraint-name  CHECK (where-predicate)
--       )
--
--       Note: CONTRAINT is part of the set of column definitions (i.e. inside the parens for column specification)
--
-- 
-- ALTER - changing the definition of a table
--
-- Commonly used to add/remove constraints on tables or change existing table attributes
--
--
-- Add a FOREIGN KEY - Establish Parent/Dependant relationship
--
-- FOREIGN KEY must have the same-number, same-order, compatible-data-type as entire PRIMARY KEY of parent
--             and must have a matching value in the PRIMARY KEY in the parent table
--
-- When adding FOREIGN KEY after data has been loaded into table, all FOREIGN KEY values must have a match in parent
--
--      ALTER TABLE dependent-table-name ADD FOREIGN KEY(for-key-column(s)) REFERENCES parent-table(pri-key-column(s)) 
--
-- Remove a constraint from a table
--
--      ALTER TABLE table-name DROP CONSTRAINT constraint_name
--
--
-- Add a column to an existing table
--
-- Cannot add a NOT NULL column to a table with existing data
--
--      ALTER TABLE table-name ADD COLUMN new_column_name data_type constraint
--
--
-- Rename an existing column in a table
--
--      ALTER TABLE table-name RENAME column-name TO new-column-name;
--
--
-- Rename a table
--
--      ALTER TABLE table-name RENAME TO new-table-name  - Will fail if table does not exist
--
--      ALTER TABLE IF EXISTS table-name RENAME TO new-table-name  - Successful if table exists or not
--
---------------------------------------------------------------------------------------------------------------
--
-- drop and create the artist table
--
drop table if exists artist cascade;

create table artist
(artist_id    serial              not null,   -- system will generate the artist id (serial is an int)
 artist_name  char varying (100)  not null,    -- Artist name may be from 0 to 100 characters (storage efficiency)
 CONSTRAINT PK_artist_artist_ID PRIMARY KEY (artist_id)
)
;
--
-- Drop and create purchase table
--
drop table if exists purchase         cascade;

create table purchase
( purchase_id    serial        not null,  -- system generated (serial is an int)
  customer_id    int           not null,  -- match to customer_id is PK in customer table (serial)  
  purchase_date  date          not null default current_date,      
  purchase_price numeric(11,2) not null,  -- maximum 999,999,999.99 (11 digits, w/2 decimals)
  item_purchased int           not null,  -- match to inventory_id is PK in invetory table (serial) 
 CONSTRAINT PK_purchase_table  PRIMARY KEY (purchase_id)
)
;
--
-- drop and create inventory table
--
drop table if exists inventory cascade;

create table inventory
(inventory_id   serial        not null, -- system generated (serial is an int)
 asking_price   numeric(12,2),  -- maximum 9,999,999,999.99 (12 digits, w/2 decimals)
 piece_name     char(30)      not null,
  CONSTRAINT PK_inventory_inv_ID  PRIMARY KEY (inventory_id)
)
;
--
-- drop and create customer table
--
drop table if exists customer cascade;

create table customer
(customer_id     serial                  not null
,customer_name   character varying (50)  not null
,street_address  character varying (50)  not null 
,city            character varying (30)  not null
,state           character(2)            not null
,zip_code        character(10)           not null  -- 12345-1234
,phone_number    character(12)           -- optional 999-999-9999 
,CONSTRAINT PK_customer_customer_id  PRIMARY KEY (customer_id) 
);
--
--
--
drop table if exists artist_inventory_relator cascade;

create table artist_inventory_relator
(artist       int   not null
,inventory_id int   not null 
,CONSTRAINT PK_artist_inventory_relator  PRIMARY KEY (artist, inventory_id) 
);


--
-- Connect tables with foreign keys
--
-- Typically define after all the tables are defined
-- that the order in which you define tables doesn't matter
--
-- You could define the foreign keys when you create the tables
-- to do that you must be sure all parent tables are created before dependent tables
--
-- Both the parent and dependent must exist before connecting them with foreign keys
--
-- connect the dependent purchase table to inventory table 
--   using the FK in purchase and PK in inventory
ALTER TABLE purchase                  -- dependent table
    ADD FOREIGN KEY(item_purchased)   -- FK column in the dependent
	REFERENCES inventory(inventory_id)-- parent table and PK of the parent table
;

ALTER TABLE purchase                -- dependent table
    ADD FOREIGN KEY(customer_id)    -- FK column in the dependent
	REFERENCES customer(customer_id)-- parent table and PK of the parent table
;

ALTER TABLE artist_inventory_relator  -- dependent table
    ADD FOREIGN KEY(artist)           -- FK column in the dependent
	REFERENCES artist(artist_id)      -- parent table and PK of the parent table
;

ALTER TABLE artist_inventory_relator  -- dependent table
    ADD FOREIGN KEY(inventory_id)     -- FK column in the dependent
	REFERENCES inventory(inventory_id)-- parent table and PK of the parent table
;

--
-- populate tables with data
--
-- Parent data must be loaded before dependent data
--
-- generated values, li\ke primary keys, do not 
--      and should not be specified in the insert
-- 
insert into customer
(Customer_name, street_address, city, state, zip_code, phone_number)
Values
   ('Frank', '123 main street', 'Phoenix'   , 'AZ', '85339' , null)
 , ('Harry', 'Griffindor Hall', 'Hogwarts'  , 'UK', '00000' , '888-123-scar')
 , ('Kirk' , 'Captains Qtrs'  , 'Enterprise', 'MY', 'nc1701', '555-bea-meup')
;
select * from customer;

insert into artist
   (artist_name)
values
   ('Petey Picasso')
 , ('Lenny Da Vinci')
 , ('Mike DiAngelo')
 , ('Former Known As Prince')
;
select * from artist;


insert into inventory
(asking_price, piece_name)
values
  (19.95, 'Dogs Playing Poker')
 ,(13120123.01, 'Starry Night')
 ,(.01, 'Frank Teaching Java')
 ;
 Select * from inventory;


--
-- Note use of subqueries to get system generated ids
--      and information stored in another table 
--

insert into purchase
(customer_id, purchase_price, purchase_date, item_purchased)
values(
  (select customer_id  from customer where customer_name like 'Harry')
 ,(select asking_price from inventory where piece_name like 'Dogs%')
 ,'03/10/2023'
 ,(select inventory_id from inventory where piece_name like 'Dogs%')
);
select * from purchase;


