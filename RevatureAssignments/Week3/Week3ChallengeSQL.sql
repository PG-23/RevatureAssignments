--Week 3 Challenge - SQL
--By Patrick Guinn
--9/9/26

--1 Get all fields and records from customer
select *
from customer;

--2 Get all fields from customer, but only if they are from Arizona
select *
from customer
where state = 'AZ';

--3 Get all invoices older than 6 months
select *
from invoice
where invoice_date < NOW() - interval '6 months';

--4 (Pre query) for validating correct results of query 4
select count(*)
from customer
where phone !~ '^\+1 \d{3} \d{3}-\d{4}$';

--4 Update all customer phone numbers to NULL if they don’t follow this format: ‘+1 555 555-5555’
update customer
set phone = null
where phone !~ '^\+1 \d{3} \d{3}-\d{4}$';

--5 Get all tracks that are longer than 180000 milliseconds 
select *
from track
where milliseconds > 180000;

--6 (Pre query) Check to determine correct amount of updates for query 6
select count(*)
from customer 
where country != 'USA';

--6 Update all customers not in the USA so that their country=USA and address, city, & state are NULL
update customer
set country = 'USA', address = null, city = null, state = null
where country != 'USA';

--7 Given a customer_id, return their total spending across all invoices using a function 
create or replace function get_customer_total_spending(p_customer_id integer)
returns numeric as $$
	select coalesce(sum(total), 0)
	from invoice
	where customer_id = p_customer_id;
$$ language sql;

--7 Function test
select get_customer_total_spending(5);

--8 Given an employee_id + new_manager_id, create a stored procedure to update an Employee’s reports_to field.
create or replace procedure set_employee_reports_to(p_employee_id integer, p_manager_id integer)
language sql
as $$
	update employee
	set reports_to = p_manager_id
	where employee_id = p_employee_id;
$$;

--8 Find valid ID values to test procedure call
select employee_id
from employee
limit 10;

--8 Procedure test
call set_employee_reports_to(5, 8);

--9 Prevent an employee reporting to themselves, reporting to a non-existence employee, or creating a circular management relationship
create or replace procedure set_employee_reports_to(p_employee_id integer, p_manager_id integer)
language plpgsql
as $$
begin
	if p_employee_id = p_manager_id then
		raise exception 'Employee cannot report to themselves';
	end if;
	if not exists(select 1 from employee where employee_id = p_employee_id) then
		raise exception 'Employee % does not exist', p_employee_id;
	end if;
	if not exists(select 1 from employee where employee_id = p_manager_id) then
		raise exception 'Employee % does not exist', p_manager_id;
	end if;
	if exists (
		with recursive management_chain as (
			select employee_id, reports_to
			from employee
			where employee_id = p_manager_id
			union all 
			select e.employee_id, e.reports_to
			from employee e
			join management_chain mc on e.employee_id = mc.reports_to
		)
		select 1 from management_chain where employee_id = p_employee_id
	) then
		raise exception 'This assignment would create a circular management relationship';
	end if;
	update employee 
	set reports_to = p_manager_id
	where employee_id = p_employee_id;
end;
$$;

--9 Test cases
call set_employee_reports_to(5,5);
call set_employee_reports_to(5,99);
call set_employee_reports_to(99,3);
call set_employee_reports_to(5,3);
call set_employee_reports_to(3,5);

--10 Create a new schema: pets
create schema if not exists pets;

--11 Create two related tables: Customer + Pets
create table pets.customer(
	customer_id integer primary key,
	first_name text not null,
	last_name text not null,
	email text,
	phone text
);

create table pets.pet(
	pet_id integer primary key,
	customer_id integer not null,
	pet_name text not null,
	constraint fk_pet_customer
		foreign  key (customer_id) references pets.customer(customer_id)
);

--12 Demonstrate populating records into these tables
insert into pets.customer (customer_id, first_name, last_name, email, phone)
values
    (1, 'Jane', 'Doe', 'jane.doe@email.com', '+1 555 123-4567'),
    (2, 'John', 'Smith', 'john.smith@email.com', '+1 555 234-5678'),
    (3, 'Maria', 'Garcia', 'maria.garcia@email.com', '+1 555 345-6789');
insert into pets.pet (pet_id, customer_id, pet_name)
values
    (1, 1, 'Rex'),
    (2, 1, 'Whiskers'),
    (3, 2, 'Buddy'),
    (4, 3, 'Luna'),
    (5, 3, 'Max');

--12 Validation test
select count(*) from pets.customer;
select count(*) from pets.pet;
