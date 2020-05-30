Create database mutilmedia CHARACTER SET utf8 COLLATE utf8_general_ci;
Use mutilmedia;
create table users(
	idUser int auto_increment,
	full_name nvarchar(100),
    id_card varchar(9) CHECK (id_card REGEXP '[0-9]{9}'),
    date_birth date,
    address nvarchar(100),
    phone_number varchar(10) CHECK (phone_number REGEXP '[0-9]{10}'),
    username varchar(100),
    passwords varchar(100),
    roles varchar(100) NOT NULL DEFAULT ('user'),
    primary key(idUser)
);

Insert into users(full_name, id_card,date_birth,address,phone_number,username,passwords,roles)
 values('Administrator', '206296123',null,'Quảng Nam','0123456789','admin','123','admin');
 SELECT * FROM users WHERE idUser = 1;
  SELECT * FROM users;
Create table product(
	id_product int auto_increment,
    name_product varchar(100),
    species_product varchar(100),
    quantity int,
    avatar varchar(1000),
    avatar_sv varchar(10000),
    price int ,
    status nvarchar(5000),
    primary key(id_product)
    );
    
Select * from product;
Select * from product where species_product = 'audi' ;
UPDATE product set name_product = 'Audi 500', species_product = 'Audi', quantity =1 , avatar = '222.jpg',avatar_sv='E:19JSP03_TTCarRentalWebContentimagesaudi1.jpg', price ='700000' WHERE id_product = 2;
Create table rental_contract(
	id_contract int auto_increment,
    id_product int ,
    idUser int,
	product_name varchar(100),
    product_species varchar(100),
    full_name nvarchar(100),
    price int not null,
    phone_number varchar(10),
    address_consign	nvarchar(100),
    quantity int,
    avatar varchar(100),
    avatar_sv varchar(100),
    hire_day varchar(100),
    pay_day varchar(100),
    foreign key (id_product) references product(id_product),
    foreign key (idUser) references users(idUser),
    primary key(id_contract)  
);
Select * from rental_contract;
create table comment_review(
	id_comment int auto_increment,
    id_product int ,
    idUser int,
    full_name varchar(100),
	foreign key (id_product) references product(id_product),
    foreign key (idUser) references users(idUser),
    comments nvarchar(1000),
    primary key(id_comment)
);

Insert into comment_review(id_product,idUser,full_name,comments) values(4,3,'Thanh Tai','Sp');
Select * from comment_review;
Select * from comment_review where id_product =4;





select * from rental_contract;
drop table users;

select * from users;	
select * from product;
drop database mutilmedia;
delete from product where id_product = 5;	
delete from expediency where id_expediency=4;
Select * from expediency where id_expediency=3;
Select * from expediency where name_expediency ='C';
Select * from expediency where species_expediency='MotorBike';
Update expediency Set name_expediency='XE' , species_expediency='XEDEP',acmount=2,avatar='oke',avatar_sv='oke oke',price=2323 where id_expediency=3;
Insert into rental_contract (id_expediency,name_renter,price,phone_number,address_consign_expediency,amount) values (1,'duyduy',1000,'0905967122','Quang Nam',1);
Insert Into users(name_users ,id_card,address,phone_number,username,passwords,roles)values('duyduy','206296126','Quang Nam','0905967122','duyvip','12345','admin');
Insert Into users(name_users ,id_card,date_bird,address,phone_number,username,passwords,roles)values('duyduy','206296126','1999/08/19','Quang Nam','0905967122','duynguyen','12345','user');


Select * from rental_contract where id_expediency= 4 ;
    


    
    
    
    