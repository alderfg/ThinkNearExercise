USE thinknear;
/* student */
insert into tb_student (studentId, firstName, lastName) values
(1, 'Eysson', 'Saucedo'),
(2, 'Nestor', 'Pareja'),
(3, 'Katherine', 'Nieves'),
(4, 'Karen', 'Guzman'),
(5, 'John', 'Snow'),
(6, 'Aegon', 'Targaryan')
;

/* class */
insert into tb_class (code, title, description) values
('C001', 'SASM', 'Safe Advance Scrum Master'),
('C002', 'ISTQB', 'ISTQB Certification'),
('C003', 'React JS', 'React JS')
 ;
 
 /* detail_student_class */
 insert into tb_detail_student_class(studentId, code) values
 (1, 'C002'),
 (3, 'C002'),
 (4, 'C002'),
 (2, 'C001'),
 (5, 'C001'),
 (6, 'C001'),
 (2, 'C003'),
 (6, 'C003');

 