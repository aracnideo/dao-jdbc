package application;

import java.util.List;
import java.util.Scanner;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		SellerDao sellerDao = DaoFactory.createSellerDao();
		System.out.println("---Test1: Seller FindById---");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);
		System.out.println();
		System.out.println("---Test2: Seller FindByDepartment ---");
		Department department = new Department(2, null);
		List<Seller> listSeller = sellerDao.findByDepartment(department);
		for (Seller s : listSeller) {
			System.out.println(s);
		}
		System.out.println();
		System.out.println("---Test3: Seller FindAll---");
		listSeller = sellerDao.findAll();
		for (Seller s : listSeller) {
			System.out.println(s);
		}
//		System.out.println("---Test4: Seller Insert---");
//		Seller newSeller = new Seller(null, "Braulio", "braulio@gmail.dale", LocalDate.of(1998, 4, 21), 3000.0, department);
//		sellerDao.insert(newSeller);
//		System.out.println("new seller inserted. New id: " + newSeller.getId());

//		System.out.println("---Test5: Seller Update---");
//		seller = sellerDao.findById(5);
//		seller.setName("Cassio");
//		sellerDao.update(seller);
//		System.out.println("Seller updated.");

		System.out.println("---Test6: Seller Delete---");
		System.out.println("Inform the Id to delete from seller: ");

		int id = sc.nextInt();
		sellerDao.deleteById(id);
		System.out.println("Deleted seller with Id: " + id);
		listSeller = sellerDao.findAll();
		for (Seller s : listSeller) {
			System.out.println(s);
		}

		sc.close();
		DB.closeConnection();

	}

}
