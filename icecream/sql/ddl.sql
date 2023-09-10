create database icecream default character set utf8;

GRANT ALL PRIVILEGES ON *.* TO 'iceadmin'@'localhost';
GRANT ALL PRIVILEGES ON *.* TO 'iceadmin'@'%'

-- 관리자(Admin) 테이블 생성
CREATE TABLE Admin (
  adminId varchar(50) NOT NULL,
  name varchar(50) NOT NULL,
  password varchar(10) NOT NULL,
  regdate datetime NOT NULL,
  PRIMARY KEY (adminid)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into admin values('test','test','test',now());

-- 제품(Product) 테이블 생성
CREATE TABLE Product (
    ProductID VARCHAR(255) PRIMARY KEY,
    ProductName VARCHAR(255) NOT NULL,
    Price INT NOT NULL,
    StockQuantity INT NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into product values('ice_choco','초코 아이스크림',2000,5);
insert into product values('ice_strawberry','딸기 아이스크림',2000,5);
insert into product values('ice_yogurt','요거트 아이스크림',3000,5);

-- 토핑(Topping) 테이블 생성
CREATE TABLE Topping (
    ToppingID VARCHAR(255) PRIMARY KEY,
    ToppingName VARCHAR(255) NOT NULL,
    AdditionalPrice INT NOT NULL,
    StockQuantity INT NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

insert into topping values('top_chocochip','초코칩',500,4);
insert into topping values('top_cherry','체리',1000,9);
insert into topping values('top_cereal','시리얼',500,3);

-- 주문(Orders) 테이블 생성
CREATE TABLE Orders (
    OrderID INT AUTO_INCREMENT PRIMARY KEY,
    OrderDateTime DATETIME NOT NULL,
    TotalAmount INT NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

alter table orders add column del boolean not null default false;

-- 주문상세(OrderDetail) 테이블 생성
CREATE TABLE OrderDetail (
    DetailID INT AUTO_INCREMENT PRIMARY KEY,
    OrderID INT,
    ProductID VARCHAR(255),
    Quantity INT NOT NULL,
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    FOREIGN KEY (ProductID) REFERENCES Product(ProductID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- 토핑상세(ToppingDetail) 테이블 생성
CREATE TABLE ToppingDetail (
    ToppingDetailID INT AUTO_INCREMENT PRIMARY KEY,
    OrderDetailID INT,
    ToppingID VARCHAR(255),
    ToppingQuantity INT NOT NULL,
    FOREIGN KEY (OrderDetailID) REFERENCES OrderDetail(DetailID),
    FOREIGN KEY (ToppingID) REFERENCES Topping(ToppingID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--join 
select o.orderid,o.OrderDateTime,o.TotalAmount, 
    			d.DetailID, d.productId,t.ToppingDetailID,
                t.ToppingID 
    			from orders o
    				left outer join orderdetail d
    			    on o.orderId = d.orderId 
    			    left outer join toppingdetail t
    			    on d.DetailID = t.OrderDetailID
    			where o.OrderID = 5;

-- 모든정보 join
SELECT
    o.OrderID,
    o.OrderDateTime,
    o.TotalAmount,
    d.DetailID,
    d.ProductID,
    p.ProductName,
    GROUP_CONCAT(DISTINCT t.ToppingDetailID) AS ToppingDetailIDs,
    GROUP_CONCAT(DISTINCT t.ToppingID) AS ToppingIDs,
    GROUP_CONCAT(DISTINCT top.ToppingName) AS ToppingNames
FROM orders o
LEFT OUTER JOIN orderdetail d ON o.OrderID = d.OrderID 
LEFT OUTER JOIN toppingdetail t ON d.DetailID = t.OrderDetailID
LEFT OUTER JOIN Product p ON d.ProductID = p.ProductID
LEFT OUTER JOIN Topping top ON t.ToppingID = top.ToppingID
WHERE o.OrderID = ?
GROUP BY
    o.OrderID,
    o.OrderDateTime,
    o.TotalAmount,
    d.DetailID,
    d.ProductID,
    p.ProductName;

    			
-- grouping
SELECT
    o.OrderID,
    o.OrderDateTime,
    o.TotalAmount,
    d.DetailID,
    d.ProductID,
    GROUP_CONCAT(DISTINCT t.ToppingDetailID) AS ToppingDetailIDs,
    GROUP_CONCAT(DISTINCT t.ToppingID) AS ToppingIDs,
    GROUP_CONCAT(DISTINCT p.ProductName) AS ProductNames,
    GROUP_CONCAT(DISTINCT top.ToppingName) AS ToppingNames
FROM orders o
LEFT OUTER JOIN orderdetail d ON o.OrderID = d.OrderID 
LEFT OUTER JOIN toppingdetail t ON d.DetailID = t.OrderDetailID
LEFT OUTER JOIN Product p ON d.ProductID = p.ProductID
LEFT OUTER JOIN Topping top ON t.ToppingID = top.ToppingID
WHERE o.OrderID = 4
GROUP BY
    o.OrderID,
    o.OrderDateTime,
    o.TotalAmount,
    d.DetailID,
    d.ProductID;