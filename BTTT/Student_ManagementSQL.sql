CREATE DATABASE StudentManagement CHARACTER SET utf8 COLLATE utf8_general_ci;
use StudentManagement;
CREATE TABLE student(
	id int (11) PRIMARY KEY AUTO_INCREMENT,
    fist_name varchar(50) NOT NULL,
    last_name varchar (50) NOT NULL,
    gender varchar (6) NOT NULL,
    age int DEFAULT 18,
    telephone int CHECK (telephone REGEXP '[0-9]{10}'),
    score int NOT NULL CHECK ((score >= 0) AND (score <=100))
);

INSERT INTO student (fist_name, last_name, gender, age, telephone, score) VALUES ('Nguyen Thanh', 'Tai', 'male','20', '1234567890',100);
INSERT INTO student (fist_name, last_name, gender, age, telephone, score) VALUES ('Nguyen Đuc', 'Duy', 'male','20', '1234567891',90);
INSERT INTO student (fist_name, last_name, gender, age, telephone, score) VALUES ('Tran Minh', 'Hung', 'male','20', '1234567892',90);
INSERT INTO student (fist_name, last_name, gender, telephone, score) VALUES ('Nguyen Van', 'Thanh', 'male', '1234567890',100);
INSERT INTO student (fist_name, last_name, gender, age, telephone, score) VALUES ('Nguyen Thi', 'Tra Giang', 'female','20', '1234567890',95);
INSERT INTO student (fist_name, last_name, gender, age, telephone, score) VALUES ('Nguyen Van', 'Thinh', 'male','22', '1234567777',75);
INSERT INTO student (fist_name, last_name, gender, age, telephone, score) VALUES ('Nguyen Dinh', 'Loc', 'male','21', '1234567977',90);
INSERT INTO student (fist_name, last_name, gender, age, telephone, score) VALUES ('Banh', 'Van', 'male','25', '1234577877',20);
INSERT INTO student (fist_name, last_name, gender, telephone, score) VALUES ('Nguyen Thi', 'Phuong', 'female', '1234567800',25);
INSERT INTO student (fist_name, last_name, gender, age, telephone, score) VALUES ('Nguyen Thi', 'Hanh', 'female','19', '1234567677',54);
INSERT INTO student (fist_name, last_name, gender, age, telephone, score) VALUES ('Nguyen Van', 'Chinh', 'male','20', '1004567877',75);
INSERT INTO student (fist_name, last_name, gender, age, telephone, score) VALUES ('Nguyen Thi', 'Luong', 'female','21', '1230567877',64);
INSERT INTO student (fist_name, last_name, gender, telephone, score) VALUES ('Nguyen Van', 'Tuan Anh', 'male', '1234217890',15);
INSERT INTO student (fist_name, last_name, gender, age, telephone, score) VALUES ('Tran', 'Van', 'female','22', '1235467877',80);
INSERT INTO student (fist_name, last_name, gender, age, telephone, score) VALUES ('Nguyen Thao', 'Nguyen', 'female','22', '1298567877',90);
INSERT INTO student (fist_name, last_name, gender, telephone, score) VALUES ('Nguyen', 'Thanh', 'male', '1234907890',99);
INSERT INTO student (fist_name, last_name, gender, age, score) VALUES ('Tran Minh', 'Chien', 'male','22',87);
INSERT INTO student (fist_name, last_name, gender, score) VALUES ('Tran Van', 'Nguyen', 'male',65);
INSERT INTO student (fist_name, last_name, gender, age, score) VALUES ('Nguyen Ba', 'Thong', 'male','25',100);
INSERT INTO student (fist_name, last_name, gender, age, telephone, score) VALUES ('Nguyen Thi', 'Manh', 'female','22', '1984201877',85);
INSERT INTO student (fist_name, last_name, gender, age, score) VALUES ('Nike', 'Thuy', 'male','25',42);
INSERT INTO student (fist_name, last_name, gender, telephone, score) VALUES ('Nguyen', 'Nike', 'female', '1984201877',25);

-- In ra số lượng học sinh
SELECT COUNT(*) FROM student;

-- In ra số lượng học sinh nam
SELECT COUNT(*) FROM student where gender = 'male';

-- In ra danh sách học sinh nữ
SELECT * FROM student where gender = 'female';

-- In ra danh sách học sinh chưa cập nhật số điện thoại
SELECT * FROM student where telephone = NULL;

-- In ra danh sách học sinh trên 18 tuổi
SELECT * FROM student where age > 18;

-- In ra danh sách học sinh học giỏi (scores > 80)
SELECT * FROM student where score > 80;

-- In ra danh sách học sinh học yếu (scores < 45)
SELECT * FROM student where score < 45;

-- In ra danh sách học sinh có last_name hoặc first_name = ‘nike’
SELECT * FROM student where fist_name = 'nike' OR  last_name = 'nike';

