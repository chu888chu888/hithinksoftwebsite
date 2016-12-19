
    create table authorities (
        username varchar(50) not null,
        authority varchar(50),
        primary key (username)
    );

    create table contact_request (
        id bigint not null auto_increment,
        created_at datetime,
        updated_at datetime,
        contact varchar(50),
        contact_request_status varchar(25) not null,
        email varchar(255),
        enterprise_name varchar(50),
        requirement_description longtext,
        telephone varchar(13),
        website varchar(255),
        primary key (id)
    );

    create table group_authorities (
        group_id bigint not null,
        authority varchar(255) not null,
        primary key (group_id, authority)
    );

    create table group_members (
        username varchar(50) not null,
        group_id bigint not null,
        primary key (username, group_id)
    );

    create table groups (
        id bigint not null auto_increment,
        created_at datetime,
        updated_at datetime,
        description varchar(255),
        enabled bit not null,
        group_name varchar(255) not null,
        name varchar(255) not null,
        primary key (id)
    );

    create table jobs (
        id bigint not null auto_increment,
        created_at datetime,
        updated_at datetime,
        job_content longtext not null,
        job_name varchar(255) not null,
        location varchar(255) not null,
        number_requirement integer,
        primary key (id)
    );

    create table news (
        id bigint not null auto_increment,
        created_at datetime,
        updated_at datetime,
        detail longtext,
        digest longtext,
        popular bit not null,
        thumb varchar(250) not null,
        title varchar(250) not null,
        primary key (id)
    );

    create table permissions (
        id bigint not null auto_increment,
        created_at datetime,
        updated_at datetime,
        authority varchar(255) not null,
        enabled bit not null,
        name varchar(10) not null,
        path varchar(255) not null,
        primary key (id)
    );

    create table solution (
        id bigint not null auto_increment,
        created_at datetime,
        updated_at datetime,
        detail longtext not null,
        title varchar(250) not null,
        solution_group_id bigint,
        primary key (id)
    );

    create table solution_group (
        id bigint not null auto_increment,
        created_at datetime,
        updated_at datetime,
        name varchar(255) not null,
        primary key (id)
    );

    create table users (
        id bigint not null auto_increment,
        created_at datetime,
        updated_at datetime,
        enabled bit not null,
        name varchar(10) not null,
        password varchar(255) not null,
        username varchar(12),
        primary key (id)
    );

    alter table groups
        add constraint UK_7o859iyhxd19rv4hywgdvu2v4 unique (group_name);

    alter table permissions
        add constraint UK_anu82966n7wtxrgf01aady9np unique (authority);

    alter table permissions
        add constraint UK_pnvtwliis6p05pn6i3ndjrqt2 unique (name);

    alter table users
        add constraint UK_r43af9ap4edm43mmtq01oddj6 unique (username);

    alter table authorities
        add constraint FKhjuy9y4fd8v5m3klig05ktofg
        foreign key (username)
        references users (username);

    alter table group_authorities
        add constraint FKruy9mx1ch59gog4lw18kgnd67
        foreign key (group_id)
        references groups (id);

    alter table group_members
        add constraint FKkv9vlrye4rmhqjq4qohy2n5a6
        foreign key (group_id)
        references groups (id);

    alter table solution
        add constraint FK1swwcqyv0029pfhqe6eymapff
        foreign key (solution_group_id)
        references solution_group (id);