create table Member
(Member_Number serial not null, -- system will generate member id
 Last_name char varying (100) not null, -- max 100 characters for last name
First_name char varying (100) not null,
 Constraint PK_Member_Member_Number primary key (Member_Number),
 Email_address char varying (100) not null,
 Phone_Number char varying (16) not null ,
 Date_of_Birth date not null,
 Reminder_Email boolean not null
)
create table Interest_Group
(Group_Number serial not null,
 group_name char varying (50) not null,
 Constraint PK_Interest_Group_Group_Number primary key (Group_Number)
)
create table Event_table
(Event_Number serial not null,
 Constraint PK_Event_Table_Event_Number primary key(Event_Number),
 Event_name char varying (100) not null,
 Event_Description char varying (1000),
 Event_date_time timestamp not null,
 Event_Duration integer not null,
 Group_Number int not null
)

Alter Table Event_table
Add foreign key (Group_Number)
References Interest_Group(Group_Number)


create table Member_Group
(Group_Number int not null,
 Member_Number int not null,
 Constraint PK_Member_Group_Group_Member primary key (Group_Number, Member_Number)
)
;
Alter Table Member_Group
Add foreign key (Group_Number)
References Interest_Group(Group_Number)
;
Alter Table Member_Group
Add foreign key (Member_Number)
References Member(Member_Number)
;


insert into member
( last_name, first_name, email_address, phone_number, date_of_birth, reminder_email)
Values ( 'suave', 'rico', 'ricosuave1@gmail.com', '(513)262-4851', '02/21/2001', true )
returning member_number
;
insert into member
( last_name, first_name, email_address, phone_number, date_of_birth, reminder_email)
Values ( 'seinfeld', 'jerry', 'jerrysf1@gmail.com', '(513)481-3245', '10/21/2002', true )
returning member_number
;
insert into member
( last_name, first_name, email_address, phone_number, date_of_birth, reminder_email)
Values ( 'james', 'lebron', 'lbj123@gmail.com', '(614)513-2142', '04/14/1980', false )
returning member_number
;
INSERT INTO member (last_name,first_name,email_address,phone_number,date_of_birth,reminder_email)
VALUES('Lewis', 'Joseph', 'chunkylover53@aol.com', '(555)555-5555','02/10/1923' , true)
 returning member_number;
 
insert into member
( last_name, first_name, email_address, phone_number, date_of_birth, reminder_email)
Values ( 'mahomes', 'patrick', 'pmahomes@gmail.com', '(513)484-9291', '02/21/1990', true )
returning member_number
;
INSERT INTO member (last_name,first_name,email_address,phone_number,date_of_birth,reminder_email)
VALUES('Victor', 'Vaughn, DOOM', 'elpresidente.latveria.gov', '(555)666-5555','02/26/1950' , false)
returning member_number
;

insert into member
( last_name, first_name, email_address, phone_number, date_of_birth, reminder_email)
Values ( 'brady', 'goat', 'tombrady12@gmail.com', '(818)265-4836', '05/20/1940', true )
returning member_number
;

INSERT INTO member (last_name,first_name,email_address,phone_number,date_of_birth,reminder_email)
VALUES('Lebowski', 'Jefferey', 'elduderino@netscape.com', '(323)555-5555','12/31/1950' , true)
returning member_number
;

insert into interest_group
(group_name)
Values('Sports')
;
insert into interest_group
(group_name)
values ('shows')
;
insert into interest_group
(group_name)
values('civilians')
;
insert into event_table 
(event_name, event_description, event_date_time, event_duration, group_number )
values ('Sporting_Event', 'this is where the athletes meet!','03/13/2023 10:30:00', 2, 1 )
;
insert into event_table 
(event_name, event_description, event_date_time, event_duration, group_number )
values ('Civilian_event', 'this is where the Civilians meet!','03/14/2023 10:30:00', 2, 1 )
;
insert into event_table 
(event_name, event_description, event_date_time, event_duration, group_number )
values ('Showpeople_Event', 'this is where the Show people meet!','03/15/2023 10:30:00', 2, 1 )
;
insert into event_table 
(event_name, event_description, event_date_time, event_duration, group_number )
values ('Everyone_event', 'this is where the everyone meets!','03/15/2023 13:30:00', 4, 1 )
;

