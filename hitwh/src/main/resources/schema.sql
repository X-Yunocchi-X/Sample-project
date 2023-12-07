CREATE TABLE IF NOT EXISTS Instructors (
    InstructorID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100),
    Age INT,
    Gender VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS Courses (
    CourseID INT PRIMARY KEY AUTO_INCREMENT,
    CourseName VARCHAR(100),
    StartDate DATE,
    DurationDays INT,
    InstructorID INT,
    FOREIGN KEY (InstructorID) REFERENCES Instructors(InstructorID)
);

CREATE TABLE IF NOT EXISTS Companies (
    CompanyID INT PRIMARY KEY AUTO_INCREMENT,
    CompanyName VARCHAR(100),
    Address VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS Roles (
    RoleID INT PRIMARY KEY AUTO_INCREMENT,
    Account VARCHAR(100),
    Password VARCHAR(100),
    Entity ENUM('Student', 'Instructor', 'Admin', 'Company'),
    EntityID INT
);

CREATE TABLE IF NOT EXISTS Students (
    StudentID INT PRIMARY KEY AUTO_INCREMENT,
    Name VARCHAR(100),
    Gender VARCHAR(10),
    CompanyOccupation VARCHAR(100),
    TechLevel VARCHAR(10),
    CompanyID INT,
    PaymentStatus BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (CompanyID) REFERENCES Companies(CompanyID)
);

CREATE TABLE IF NOT EXISTS Reviews (
    ReviewID INT PRIMARY KEY AUTO_INCREMENT,
    ReviewText TEXT,
    CourseID INT,
    StudentID INT,
    ReviewDate DATETIME DEFAULT NOW(),
    FOREIGN KEY (CourseID) REFERENCES Courses(CourseID),
    FOREIGN KEY (StudentID) REFERENCES Students(StudentID)
);

CREATE TABLE IF NOT EXISTS CompanyCourses (
    CompanyID INT,
    CourseID INT,
    PRIMARY KEY (CompanyID, CourseID),
    FOREIGN KEY (CompanyID) REFERENCES Companies(CompanyID),
    FOREIGN KEY (CourseID) REFERENCES Courses(CourseID)
);
