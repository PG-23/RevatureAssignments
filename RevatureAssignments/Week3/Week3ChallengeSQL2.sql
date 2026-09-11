--Week 3 Challenge - SQL
--By Patrick Guinn
--9/11/26

--Challenge Slide 1
--1 Get all invoice ids with the customers first name, last name, and the invoice total 
select i.invoice_id, c.first_name, c.last_name, i.total 
from invoice i
left join customer c
	on i.customer_id = c.customer_id;

--2 Print the invoice id, customer's first name, and invoice total. But only if the invoice is over $30
select i.invoice_id, c.first_name, i.total 
from invoice i 
left join customer c
	on i.customer_id = c.customer_id 
where i.total > 30;

--3 Get all the invoices for USA customers in the last 6 months. Use a CTE. 
with us_customers as (
	select customer_id
	from customer
	where country = 'USA'
)
select *
from invoice
where invoice_date >= NOW() - interval '6 months';

--Challenge Slide 2
--1. Create a new table called record_logs
--   Fields: log_id, record_id, field_changed, last_update, old_value, new_value
create table if not exists record_logs ( 
	log_id serial primary key,
	record_id int,
	field_changed varchar,
	last_update timestamp,
	old_value varchar,
	new_value varchar	
);

--1. Verification test for above
select *
from record_logs;

--2. Create a trigger that tracks changes to customer records and logs the changes in our new table
create or replace function log_customer_change()
returns trigger as $$
begin
	if old.first_name is distinct from new.first_name then
		insert into record_logs (record_id, field_changed, last_update, old_value, new_value)
		values (new.customer_id, 'first_name', now(), old.first_name, new.first_name);
	end if;
	if old.last_name is distinct from new.last_name then
		insert into record_logs (record_id, field_changed, last_update, old_value, new_value)
		values (new.customer_id, 'last_name', now(), old.last_name, new.last_name);
	end if;
	if old.company is distinct from new.company then
		insert into record_logs (record_id, field_changed, last_update, old_value, new_value)
		values (new.customer_id, 'company', now(), old.company, new.company);
	end if;
	if old.address is distinct from new.address then
		insert into record_logs (record_id, field_changed, last_update, old_value, new_value)
		values (new.customer_id, 'address', now(), old.address, new.address);
	end if;
	if old.city is distinct from new.city then
		insert into record_logs (record_id, field_changed, last_update, old_value, new_value)
		values (new.customer_id, 'city', now(), old.city, new.city);
	end if;
	if old.state is distinct from new.state then
		insert into record_logs (record_id, field_changed, last_update, old_value, new_value)
		values (new.customer_id, 'state', now(), old.state, new.state);
	end if;
	if old.country is distinct from new.country then
		insert into record_logs (record_id, field_changed, last_update, old_value, new_value)
		values (new.customer_id, 'country', now(), old.country, new.country);
	end if;
	if old.postal_code is distinct from new.postal_code then
		insert into record_logs (record_id, field_changed, last_update, old_value, new_value)
		values (new.customer_id, 'postal_code', now(), old.postal_code, new.postal_code);
	end if;
	if old.phone is distinct from new.phone then
		insert into record_logs (record_id, field_changed, last_update, old_value, new_value)
		values (new.customer_id, 'phone', now(), old.phone, new.phone);
	end if;
	if old.fax is distinct from new.fax then
		insert into record_logs (record_id, field_changed, last_update, old_value, new_value)
		values (new.customer_id, 'fax', now(), old.fax, new.fax);
	end if;
	if old.email is distinct from new.email then
		insert into record_logs (record_id, field_changed, last_update, old_value, new_value)
		values (new.customer_id, 'email', now(), old.email, new.email);
	end if;
	if old.support_rep_id is distinct from new.support_rep_id then
		insert into record_logs (record_id, field_changed, last_update, old_value, new_value)
		values (new.customer_id, 'support_rep_id', now(), old.support_rep_id, new.support_rep_id);
	end if;
	return new;
end;
$$ language plpgsql;

drop trigger if exists trg_log_customer_change on customer;

create trigger trg_log_customer_change
after update on customer
for each row
execute function log_customer_change();

--2. Test for trigger
--Find email of user
select email
from customer c
where c.customer_id = 1;
--Initial value = luisg@embraer.com.br

--Change email value 
update customer c 
set email = 'luisg@revature.net'
where c.customer_id = 1;
--Find if record_logs table properly was updated
select *
from record_logs rl
order by rl.log_id
desc limit 5;