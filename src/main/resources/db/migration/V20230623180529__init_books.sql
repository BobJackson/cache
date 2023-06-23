create table if not exists books (
    id varchar(40) not null,
    title varchar(100) not null,
    subtitle varchar(255) not null,
    cover_url varchar(255) not null,
    primary key (id)
)