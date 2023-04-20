drop table if exists expense;

create table expense (
    id int auto_increment primary key,
    item varchar(255) not null,
    category varchar(50) not null,
    amount numeric(20, 2) not null,
    expense_date timestamp with time zone not null
);