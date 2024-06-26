Update salesman set grade = 200 where salesman_city = 'Rome';

Select * from salesman where salesman_city = 'Rome';

Update salesman set grade = 200 where salesman_name = 'James Hoog';

Select * from salesman;

Select * from salesman where salesman_name = 'James Hoog';

Update salesman set salesman_name = 'Pierre' where salesman_name = 'McLyon';

Select * from salesman where (salesman_name = 'James Hoog' or salesman_name = 'McLyon');

Select * from salesman where (salesman_name = 'Pierre' or salesman_name = 'McLyon');