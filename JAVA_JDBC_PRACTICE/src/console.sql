create database employs_db;
use employs_db;
create table User(
    user_id int primary key auto_increment,
    username_User varchar(255) not null,
    password_User varchar(255) not null check(length(password_User) > 8),
    status_User enum('ACTIVE','INACTIVE','LOCKED') not null
);
create table Departments(
    dpmt_id int primary key auto_increment,
    dpmt_name varchar(100) not null unique check (length(dpmt_name) between 10 and 100),
    dpmt_description varchar(255),
    dpmt_status enum('hoạt động', 'không hoạt động') not null
);
create table Employee(
    emp_id varchar(5) primary key not null check ( emp_id like 'E%' && length(emp_id) = 5),
    emp_name varchar(150) not null check (length(emp_name) between 15 and 150),
    emp_email varchar(100) not null unique check (emp_email like '%@%.%'),
    emp_phone varchar(15) not null unique check (emp_phone regexp '^0[359][0-9]{8}$'),
    emp_gender enum('MALE', 'FEMALE', 'OTHER'),
    emp_grade_salary int not null check ( emp_grade_salary > 0 ),
    emp_salary float not null check ( emp_salary > 0 ),
    emp_birthday date not null,
    emp_address varchar(255) not null check (length(emp_address) between 10 and 255),
    emp_status enum('ACTIVE','INACTIVE','ONLEAVE','POLICYLEAVE'),
    dpmt_id int,
    foreign key (dpmt_id) references Departments(dpmt_id) on delete cascade on update cascade
);
insert into User(username_User, password_User, status_User)
values ('admin', '123456789', 'INACTIVE');
INSERT INTO Departments (dpmt_name, dpmt_description, dpmt_status) VALUES
('Phòng Nhân sự tổng hợp', 'Quản lý công việc nhân sự, tuyển dụng và đào tạo', 'hoạt động'),
('Phòng Công nghệ Thông tin', 'Phụ trách hệ thống CNTT, phần mềm, bảo mật', 'hoạt động'),
('Phòng Tài chính - Kế toán', 'Quản lý tài chính, kế toán nội bộ và báo cáo', 'hoạt động'),
('Phòng Marketing & Truyền thông', 'Xây dựng chiến lược marketing và thương hiệu', 'không hoạt động');
INSERT INTO Employee (
    emp_id, emp_name, emp_email, emp_phone, emp_gender,
    emp_grade_salary, emp_salary, emp_birthday, emp_address, emp_status, dpmt_id
) VALUES
('E0001', 'Nguyễn Văn Thành Công', 'cong.nguyen@example.com', '0356789123', 'MALE', 3, 12000000, '1990-05-15', '123 Đường Lê Lợi, Quận 1, TP.HCM', 'ACTIVE', 1),
('E0002', 'Trần Thị Minh Châu', 'chau.tran@example.com', '0399998888', 'FEMALE', 4, 15000000, '1992-08-20', '456 Đường Trần Hưng Đạo, Quận 5, TP.HCM', 'ONLEAVE', 2),
('E0003', 'Lê Hoàng Nhật Minh', 'minh.le@example.com', '0901234567', 'MALE', 2, 10000000, '1995-01-10', '789 Đường Nguyễn Huệ, Quận 3, TP.HCM', 'ACTIVE', 2),
('E0004', 'Phạm Ngọc Bảo Hân', 'han.pham@example.com', '0355123456', 'FEMALE', 1, 8000000, '1998-12-25', '12 Đường Cách Mạng, Quận 10, TP.HCM', 'POLICYLEAVE', 3),
('E0005', 'Đặng Văn Quốc Anh', 'anh.dang@example.com', '0978123456', 'MALE', 5, 20000000, '1988-07-01', '89 Đường Pasteur, Quận 1, TP.HCM', 'INACTIVE', 1);
-- Đăng nhập
DELIMITER //
create procedure logIn(
    in p_username varchar(255),
    in p_password varchar(255),
    out return_code int
)
begin
    declare user_count int;
    select count(*) into user_count from User where username_User = p_username and password_User = p_password and status_User = 'ACTIVE';
    if user_count = 1 then
        set return_code = 1; -- Đăng nhập thành công
    else
        set return_code = 0; -- Đăng nhập thất bại
    end if;
end //
DELIMITER //
-- Đăng xuất
# DELIMITER //
# create procedure logOut()
# begin
#     select 'Đăng xuất thành công' as message;
# end //
# DELIMITER //

-- Phân trang phòng ban
DELIMITER //
create procedure getDepartments(
    in p_page int,
    in p_limit int
)
begin
    declare offset int;
    set offset = (p_page - 1) * p_limit;
    select * from Departments limit p_limit offset offset;
end //
DELIMITER //

-- Thêm mới phòng ban
DELIMITER //
create procedure addDepartment(
    in p_dpmt_name varchar(100),
    in p_dpmt_description varchar(255),
    in p_dpmt_status enum('hoạt động', 'không hoạt động'),
    out return_code int
)
begin
    declare dpmt_count int;
    select count(*) into dpmt_count from Departments where dpmt_name = p_dpmt_name;
    if dpmt_count > 0 then
        set return_code = 0; -- Phòng ban đã tồn tại
    else
        insert into Departments(dpmt_name, dpmt_description, dpmt_status)
        values (p_dpmt_name, p_dpmt_description, p_dpmt_status);
        set return_code = 1; -- Thêm mới phòng ban thành công
    end if;
end //
DELIMITER //

-- Câp nhật phòng ban
DELIMITER //
create procedure updateDepartment(
    in p_dpmt_id int,
    in p_dpmt_name varchar(100),
    in p_dpmt_description varchar(255),
    in p_dpmt_status enum('hoạt động', 'không hoạt động'),
    out return_code int
)
begin
    declare count_dpmt int;
    select count(*) into count_dpmt from Departments where dpmt_id = p_dpmt_id;
    if count_dpmt = 0 then
        set return_code = 0; -- Phòng ban không tồn tại
    else
        update Departments set dpmt_name = p_dpmt_name, dpmt_description = p_dpmt_description, dpmt_status = p_dpmt_status
        where dpmt_id = p_dpmt_id;
        set return_code = 1; -- Cập nhật phòng ban thành công
    end if;
end //
DELIMITER //

-- xoá phòng ban
DELIMITER //
create procedure deleteDepartment(
    in p_dpmt_id int,
    out return_code int
)
begin
    declare count_dpmt int;
    select count(*) into count_dpmt from Departments where p_dpmt_id = dpmt_id;
    if count_dpmt = 0 then
        set return_code = 0; -- Phòng ban không tồn tại
    else
        delete from Departments where dpmt_id = p_dpmt_id;
        set return_code = 1; -- Xoá phòng ban thành công
    end if;
end //
DELIMITER //

-- tìm kiếm phòng ban theo tên
DELIMITER //
create procedure searchDepartmentByName(
    in p_dpmt_name varchar(100)
)
begin
    select * from Departments where dpmt_name like concat('%', p_dpmt_name, '%');

end //
DELIMITER //

-- Phân trang nhân viên
DELIMITER //
create procedure getEmployees(
    in p_page int,
    in p_limit int
)
begin
    declare offset int;
    set offset = (p_page - 1) * p_limit;
    select * from Employee limit p_limit offset offset;
end //
DELIMITER //

-- Thêm mới nhân viên (chỉ được thêm vào phòng ban có trạng thái hoạt động)
DELIMITER //
create procedure addEmployee(
    in id_emp varchar(5),
    in name_emp varchar(150),
    in email_emp varchar(100),
    in phone_emp varchar(15),
    in gender_emp enum('MALE', 'FEMALE', 'OTHER'),
    in grade_salary_emp int,
    in salary_emp float,
    in birthday_emp date,
    in address_emp varchar(255),
    in status_emp enum('ACTIVE','INACTIVE','ONLEAVE','POLICYLEAVE'),
    in dpmt_id_emp int,
    out return_code int
)
begin
    declare emp_count int;
    declare dpmt_count int;
    select count(*) into emp_count from Employee where email_emp = email_emp or phone_emp = phone_emp;
    select count(*) into dpmt_count from Departments where dpmt_id = dpmt_id_emp;
    if emp_count > 1 then
        set return_code = 0; -- Nhân viên đã tồn tại
    else
        if emp_count = 0 && dpmt_count != 0 then
            insert into Employee (emp_id, emp_name, emp_email, emp_phone, emp_gender, emp_grade_salary, emp_salary, emp_birthday, emp_address, emp_status, dpmt_id)
            values (id_emp, name_emp, email_emp,phone_emp,gender_emp,grade_salary_emp,salary_emp,birthday_emp,address_emp,status_emp,dpmt_id_emp);
            set return_code = 1; -- Thêm mới nhân viên thành công
        else
            set return_code = 2; -- Thêm mới nhân viên thất bại
        end if;
    end if;
end //
DELIMITER //

-- Cập nhật thông tin nhân viên
DELIMITER //
create procedure updateEmployee(
    in id_emp varchar(5),
    in name_emp varchar(150),
    in email_emp varchar(100),
    in phone_emp varchar(15),
    in gender_emp enum('MALE', 'FEMALE', 'OTHER'),
    in grade_salary_emp int,
    in salary_emp float,
    in birthday_emp date,
    in address_emp varchar(255),
    in status_emp enum('ACTIVE','INACTIVE','ONLEAVE','POLICYLEAVE'),
    in dpmt_id_emp int,
    out return_code int
)
begin
    declare count_emp int;
    select count(*) into count_emp from Employee where emp_id = id_emp;
    if count_emp = 0 then
        set return_code = 0; -- Nhân viên không tồn tại
    else
        update Employee
            set emp_name = name_emp, emp_email = email_emp, emp_phone = phone_emp, emp_gender = gender_emp, emp_grade_salary = grade_salary_emp,
                emp_salary = salary_emp, emp_birthday = birthday_emp, emp_address = address_emp, emp_status = status_emp, dpmt_id = dpmt_id_emp
            where emp_id = id_emp;
        set return_code = 1; -- Cập nhật nhân viên thành công
    end if;
end //
DELIMITER //

-- Xoá nhân viên (cập nhật trạng thái nhân viên thành INACTIVE)
DELIMITER //
create procedure deleteEmployee(
    in id_emp varchar(5),
    out return_code int
)
begin
    declare count_emp int;
    select count(*) into count_emp from Employee where emp_id = id_emp;
    if count_emp = 0 then
        set return_code = 0; -- Nhân viên không tồn tại
    else
        update Employee set emp_status = 'INACTIVE' where emp_id = id_emp;
        set return_code = 1; -- Xoá nhân viên thành công
    end if;
end //
DELIMITER //

-- Tìm kiếm nhân viên theo tên
DELIMITER //
create procedure searchEmployeeByName(
    in p_emp_name varchar(150)
)
begin
    select * from Employee where emp_name like concat('%', p_emp_name, '%');
end //
DELIMITER //

-- tìm kiếm nhân viên theo khoảng tuổi
DELIMITER //
create procedure searchEmployeeByAge(
    in p_start_date date,
    in p_end_date date
)
begin
    select * from Employee where emp_birthday between p_start_date and p_end_date;
end //
DELIMITER //

-- sắp xếp nhân viên theo lương giảm dần
DELIMITER //
create procedure sortEmployeeBySalaryDesc()
begin
    select * from Employee order by emp_salary desc;
end //
DELIMITER //

-- sắp xếp nhân viên theo tên nhân viên tăng dần
DELIMITER //
create procedure sortEmployeeByNameAsc()
begin
    select * from Employee order by emp_name asc;
end //
DELIMITER //

-- thống kê Số lượng nhân viên theo từng phòng ban
DELIMITER //
create procedure countEmployeeByDepartment()
begin
    select d.dpmt_name, count(e.emp_id) as employee_count
    from Departments d
    left join Employee e on d.dpmt_id = e.dpmt_id
    group by d.dpmt_name;
end //
DELIMITER //

-- thống kê Tổng số nhân viên của toàn bộ hệ thống
DELIMITER //
create procedure countTotalEmployees()
begin
    select count(*) as total_employees from Employee;
end //
DELIMITER //

-- Thống kê phòng ban có nhiều nhân viên nhất
DELIMITER //
create procedure departmentWithMostEmployees()
begin
    select d.dpmt_name, count(e.emp_id) as employee_count
    from Departments d
    left join Employee e on d.dpmt_id = e.dpmt_id
    group by d.dpmt_name
    order by employee_count desc
    limit 1;
end //
DELIMITER //

-- thống kê phòng ban có lương cao nhất
DELIMITER //
create procedure departmentWithHighestSalary()
begin
    select d.dpmt_name, avg(e.emp_salary) as average_salary
    from Departments d
    left join Employee e on d.dpmt_id = e.dpmt_id
    group by d.dpmt_name
    order by average_salary desc
    limit 1;
end //
DELIMITER //

