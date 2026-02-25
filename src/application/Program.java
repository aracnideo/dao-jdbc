package application;

import java.time.LocalDate;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		Department department = new Department(1, "Books");

		Seller seller = new Seller(1, "Adam", "Adam@outlook.com", LocalDate.now(), 2500.0, department);
		System.out.println(seller);

	}

}
