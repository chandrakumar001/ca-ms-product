CREATE SCHEMA product;
CREATE SEQUENCE product.hibernate_sequence INCREMENT 1 START 1 MINVALUE 1;
CREATE SEQUENCE hibernate_sequence INCREMENT 1 START 1 MINVALUE 1;

create table product.customer (customer_id UUID not null, action varchar(255),created_by varchar(255), created_date timestamp, last_modified_by varchar(255), last_modified_date timestamp,address varchar(255),is_deleted boolean not null, name varchar(255), unique_id varchar(255), primary key (customer_id));
create table product.item (id bigint not null, name varchar(255),room_id bigint not null, primary key (id));
create table product.room (id bigint not null,room_name varchar(255), primary key (id));
--alter table product.room add constraint room_tbl_fk foreign key (id) references product.item(id);
alter table product.item add constraint item_tbl_fk foreign key (room_id) references product.room(id);

--id UUID DEFAULT RANDOM_UUID() NOT NULL PRIMARY KEY
--create table role (id bigint not null, primary key (id))
--create table role_users (role_id bigint not null, users_id bigint not null)
--create table room_items (room_id bigint not null, items_id bigint not null)
--create table user (id bigint not null, primary key (id))
--create table user_roles (user_id bigint not null, roles_id bigint not null)
--alter table room_items drop constraint if exists UK_mo25uun4o471kw32frrpxf7kf
--alter table room_items add constraint UK_mo25uun4o471kw32frrpxf7kf unique (items_id)
--create sequence hibernate_sequence start with 1 increment by 1
--alter table role_users add constraint FKipeyaf3dve9njdrl1t23ndidv foreign key (users_id) references user
--alter table role_users add constraint FKele6ufqrv6w1uoxqw6h1vkki0 foreign key (role_id) references role
--alter table room_items add constraint FKh0pwjlprh7dvqo90sg6mw1i64 foreign key (items_id) references item
--alter table room_items add constraint FKiqatx5fjynvuuubfb6liaivtt foreign key (room_id) references room
--alter table user_roles add constraint FKj9553ass9uctjrmh0gkqsmv0d foreign key (roles_id) references role
--alter table user_roles add constraint FK55itppkw3i07do3h7qoclqd4k foreign key (user_id) references user
