create database Mini_Project;
use Mini_Project;

drop database Mini_Project;

CREATE TABLE Accounts(
	Username nvarchar(50) not null primary key,
    Password nvarchar(50) not null,
    Fullname nvarchar(50) not null,
    Email nvarchar(50) not null,
    Photo nvarchar(50) not null
) ENGINE = InnoDB;
select * from Accounts;
drop table Accounts;
INSERT Accounts (Username, Password, Fullname, Email, Photo) VALUES ('dinhlh','123','Lê Hoàng Dinh','hoangdinh@gmail.com','a.jpg');
INSERT Accounts (Username, Password, Fullname, Email, Photo) VALUES ('teonv','123','Nguyễn Văn Tèo','teonv@gmail.com','b.jpg');
INSERT Accounts (Username, Password, Fullname, Email, Photo) VALUES ('nva','123','Nguyễn Văn A','anv@gmail.com','b1.jpg');


CREATE TABLE Authorities(
     Id int not null primary key AUTO_INCREMENT,
     Username nvarchar(50) not null,
     RoleId nvarchar(10) not null
)ENGINE = InnoDB;
drop table Authorities;
INSERT Authorities (Id, Username, RoleId) VALUES ('101','dinhlh','ADMIN');
INSERT Authorities (Id, Username, RoleId) VALUES ('102','teonv','USER');
INSERT Authorities (Id, Username, RoleId) VALUES ('103','nva','PM');


CREATE TABLE Categories(
     Id char(4) not null primary key,
     Name nvarchar(50) not null
)ENGINE = InnoDB;
drop table Categories;
INSERT Categories (Id, Name) VALUES (N'1000', N'Đồng hồ đeo tay');
INSERT Categories (Id, Name) VALUES (N'1001', N'Máy tính xách tay');
INSERT Categories (Id, Name) VALUES (N'1002', N'Máy ảnh');
INSERT Categories (Id, Name) VALUES (N'1003', N'Điện thoại');
INSERT Categories (Id, Name) VALUES (N'1004', N'Nước hoa');
INSERT Categories (Id, Name) VALUES (N'1005', N'Nữ trang');
INSERT Categories (Id, Name) VALUES (N'1006', N'Nón thời trang');
INSERT Categories (Id, Name) VALUES (N'1007', N'Túi xách du lịch');


CREATE TABLE Products(
     Id int not null primary key auto_increment,
     Name nvarchar(50) not null,
     Image nvarchar(50) not null,
     Price float not null,
     CreateDate date NOT NULL,
     Available bit not null,
     CategoryId char(4) not null
)ENGINE = InnoDB;
drop table Products;
INSERT Products (Id, Name, Image, Price, CreateDate, Available, CategoryId) VALUES (1001, N'Aniseed Syrup', N'1001.jpg', 190, CAST('2021-09-02' AS Date), 1, N'1000');
INSERT Products (Id, Name, Image, Price, CreateDate, Available, CategoryId) VALUES (1002, N'Change', N'1002.jpg', 19, CAST('2021-09-02' AS Date), 1, N'1000');
INSERT Products (Id, Name, Image, Price, CreateDate, Available, CategoryId) VALUES (1003, N'Aniseed Syrup', N'1003.jpg', 10, CAST('2021-09-02' AS Date), 1, N'1001');
INSERT Products (Id, Name, Image, Price, CreateDate, Available, CategoryId) VALUES (1004, N'Chef Anton''s Cajun Seasoning', N'1004.jpg', 22, CAST('2021-09-02' AS Date), 1, N'1001');
INSERT Products (Id, Name, Image, Price, CreateDate, Available, CategoryId) VALUES (1005, N'Chef Anton''s Gumbo Mix', N'1005.jpg', 21.35, CAST('2021-09-02' AS Date), 1, N'1002');
INSERT Products (Id, Name, Image, Price, CreateDate, Available, CategoryId) VALUES (1006, N'Grandma''s Boysenberry Spread', N'1006.jpg', 25, CAST('2021-09-02' AS Date), 1, N'1001');
INSERT Products (Id, Name, Image, Price, CreateDate, Available, CategoryId) VALUES (1007, N'Uncle Bob''s Organic Dried Pears', N'1007.jpg', 30, CAST('2021-09-02' AS Date), 1, N'1006');
INSERT Products (Id, Name, Image, Price, CreateDate, Available, CategoryId) VALUES (1008, N'Northwoods Cranberry Sauce', N'1008.jpg', 40, CAST('2021-09-02' AS Date), 1, N'1001');
INSERT Products (Id, Name, Image, Price, CreateDate, Available, CategoryId) VALUES (1009, N'Mishi Kobe Niku', N'1009.jpg', 97, CAST('2021-09-02' AS Date), 1, N'1005');
INSERT Products (Id, Name, Image, Price, CreateDate, Available, CategoryId) VALUES (1010, N'Ikura', N'1010.jpg', 31, CAST('2021-09-02' AS Date), 1, N'1007');


CREATE TABLE Roles(
     Id nvarchar(10) not null primary key,
     Name nvarchar(50) not null
)ENGINE = InnoDB;
drop table Roles;
INSERT INTO Roles VALUES
('ADMIN','Admin'),
('PM','Project Manager'),
('USER','User');

ALTER TABLE Products  ADD  CONSTRAINT FK_CategoryId FOREIGN KEY(CategoryId)
REFERENCES Categories (Id) ON DELETE CASCADE ;

ALTER TABLE Authorities  ADD  CONSTRAINT FK_UserRoles FOREIGN KEY(Username)
REFERENCES Accounts (Username)
ON UPDATE CASCADE
ON DELETE CASCADE;

ALTER TABLE Authorities  ADD  CONSTRAINT FK_Roles FOREIGN KEY(RoleId)
REFERENCES Roles(Id)
ON UPDATE CASCADE
ON DELETE CASCADE;
