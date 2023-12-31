package com.example.cruddemo;

import com.example.cruddemo.dao.StudentDao;
import com.example.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

//	create a command line app with dao injection
	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao){
	return runner ->{
		crudStudent(studentDao);
	};
}

	private void crudStudent(StudentDao studentDao) {
		//create student
//		Student student=new Student("Simran","Chadha","abc@xyz.com");

		//save student
//		studentDao.save(student);

		//print get query on DB toString() got from Student Class based on id
//		System.out.println(studentDao.findById(2).toString());

		// get all student list
//		System.out.println(studentDao.findAll());

		//get parameterized lastName
//		System.out.println(studentDao.findByLastName("Chadha"));

//		update object indv by id
//		first get the object using findById, set the propertiees using setter and then call the update fn
//		Student temp=studentDao.findById(1);
//		temp.setFirstName("Abhi");
//		temp.setLastName("Chadhs");
//		temp.setEmail("fgh@def.com");
//		studentDao.update(temp);

		// update multiple rows at once
//		System.out.println(studentDao.updateMultiple());

		// indv delete
//		studentDao.delete(1);

		// query delete
		System.out.println(studentDao.multipleDelete());
	}
}
