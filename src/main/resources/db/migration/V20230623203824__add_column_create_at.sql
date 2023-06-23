alter table books
    add column create_at timestamp not null default now();