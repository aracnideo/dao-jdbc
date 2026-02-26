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
		
		sc.close();
		DB.closeConnection();
	}
}

