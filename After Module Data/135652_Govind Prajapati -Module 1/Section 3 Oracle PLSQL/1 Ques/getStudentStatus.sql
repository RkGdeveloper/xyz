CREATE OR REPLACE PROCEDURE getStatus IS

CURSOR stud_cur is
		SELECT m.studNo,s.studName,m.module1,m.module2,m.module3,m.module4 FROM Marks m, Student s WHERE s.studno = m.studno;

stud_rec stud_cur%ROWTYPE;
STATUS VARCHAR2(20);

BEGIN

OPEN stud_cur;

	
	DBMS_OUTPUT.PUT_LINE('---------------------------------------------');
	DBMS_OUTPUT.PUT_LINE('StudNo     Student Name    Status');
	DBMS_OUTPUT.PUT_LINE('---------------------------------------------');
	
		IF(stud_cur%ROWCOUNT = 0) THEN
			RAISE NO_DATA_FOUND;
	
	LOOP

		FETCH stud_cur INTO stud_rec;


		DBMS_OUTPUT.PUT_LINE('------>'||stud_cur%ROWCOUNT);
	
			STATUS := 'PASS';

		
			IF(stud_rec.module1 < 50 OR stud_rec.module2 < 50 OR stud_rec.module3 < 50 OR stud_rec.module4 < 50) THEN
				STATUS := 'FAIL';
			ELSE	
				STATUS := 'PASS';			
			END IF;	
	
		DBMS_OUTPUT.PUT_LINE(stud_rec.studNo||'         '||stud_rec.studname||'           '||STATUS);
		

		EXIT WHEN stud_cur%NOTFOUND;

	END LOOP;

	DBMS_OUTPUT.PUT_LINE('---------------------------------------------');


	EXCEPTION
		WHEN NO_DATA_FOUND THEN
			DBMS_OUTPUT.PUT_LINE('Student Relation have no records');
		WHEN OTHERS THEN
			DBMS_OUTPUT.PUT_LINE('Other Exception');
			
		
END getStatus;
/