package application;

import java.util.List;
import java.util.Scanner;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;
import model.entities.Seller;

public class Program2 {
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		System.out.println("---Test1: Department FindById---");
		Department department = departmentDao.findById(9);
		System.out.println(department);
		System.out.println();
		
		System.out.println();
		System.out.println("---Test2: Department FindAll---");
		List<Department> listDepartment = departmentDao.findAll();
		for (Department d : listDepartment) {
			System.out.println(d);
		}
		
		System.out.println("---Test3: Department Insert---");
		Department newDepartment = new Department(null, "Steel");
		departmentDao.insert(newDepartment);
		System.out.println("new department inserted. New id: " + newDepartment.getId());
		
		System.out.println("---Test4: Department Update---");
		department = departmentDao.findById(13);
		department.setName("Rock");
		departmentDao.update(department);
		System.out.println("Department updated.");
		
		System.out.println("---Test5: Department Delete---");
		System.out.println("Inform the Id to delete from department: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Deleted department with Id: " + id);
		listDepartment = departmentDao.findAll();
		for (Department d : listDepartment) {
			System.out.println(d);
		}
		
		sc.close();
		DB.closeConnection();
	}
}

