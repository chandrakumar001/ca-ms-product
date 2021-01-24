insert into product.customer (customer_id, action,created_by, created_date, last_modified_by, last_modified_date,address,is_deleted, name, unique_id)
values
('af15b7db-8cff-4e33-b297-00b228258af1','INSERTED','Naresh', '2020-10-04 13:08:18.49','Naresh', '2020-10-04 13:08:18.49','Bangalore',true,'chandrakumar','cha@gamil.com')
,('af15b7db-8cff-4e33-b297-00b228258af2','INSERTED','Naresh', '2020-10-04 13:08:18.49','Naresh', '2020-10-04 13:08:18.49','Bangalore',true,'chandrakumar','cha1@gamil.com')
,('af15b7db-8cff-4e33-b297-00b228258af3','INSERTED','Naresh', '2020-10-04 13:08:18.49','Naresh', '2020-10-04 13:08:18.49','Bangalore',true,'chandrakumar','cha2@gamil.com')
,('af15b7db-8cff-4e33-b297-00b228258af4','INSERTED','Naresh', '2020-10-04 13:08:18.49','Naresh', '2020-10-04 13:08:18.49','Bangalore',true,'chandrakumar','cha3@gamil.com')
,('af15b7db-8cff-4e33-b297-00b228258af5','INSERTED','Naresh', '2020-10-04 13:08:18.49','Naresh','2020-10-04 13:08:18.49','Bangalore',true,'chandrakumar','cha4@gamil.com')
,('af15b7db-8cff-4e33-b297-00b228258af6','INSERTED','Naresh', '2020-10-04 13:08:18.49','Naresh', '2020-10-04 13:08:18.49','Bangalore',true,'chandrakumar','cha5@gamil.com')
,('af15b7db-8cff-4e33-b297-00b228258af7','INSERTED','Naresh', '2020-10-04 13:08:18.49','Naresh', '2020-10-04 13:08:18.49','Bangalore',true,'chandrakumar','cha6@gamil.com')
,('af15b7db-8cff-4e33-b297-00b228258af8','INSERTED','Naresh', '2020-10-04 13:08:18.49','Naresh','2020-10-04 13:08:18.49','Bangalore',true,'chandrakumar','cha7@gamil.com')
;

insert into product.room (room_name, id) values ('test-1', 1);
insert into product.item (name, room_id, id) values
('chair', 1, 1)
,('table', 1, 2)
,('laptop', 1, 3)
;

insert into product.room (room_name, id) values ('test-2', 2);
insert into product.item (name, room_id, id) values
('chair', 2, 4)
,('table', 2, 5)
,('laptop', 2, 6)
;
