### API Requirements

Create a REST API for the employee directory, REST Client should be able to
- Get a list of employees
- Get a single employee by Id
- Add a new employee
- Update an employee
- Delete an employee

### REST API

![img.png](img.png)

### Development Process

- Set-up Database dev environment
- Create spring boot project using spring initializr
- Get a list of employees
- Get single employee by Id
- Add a new employee
- Update an existing employee
- Delete an existing employee

### Application Architecture

![img_1.png](img_1.png)

### 1. Set-up Database dev environment

```mysql
CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `employee` VALUES 
	(1,'Leslie','Andrews','leslie@luv2code.com'),
	(2,'Emma','Baumgarten','emma@luv2code.com'),
	(3,'Avani','Gupta','avani@luv2code.com'),
	(4,'Yuri','Petrov','yuri@luv2code.com'),
	(5,'Juan','Vega','juan@luv2code.com');


```