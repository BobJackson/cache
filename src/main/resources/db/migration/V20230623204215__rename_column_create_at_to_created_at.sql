alter table books
    change create_at created_at timestamp default now() not null;