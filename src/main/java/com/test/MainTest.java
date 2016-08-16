package com.test;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dao.ICustomerDAO;
import com.entity.Customer;

@SuppressWarnings("all")
public class MainTest {

	public static void main(String[] args) throws Exception {
		
		 ApplicationContext ctx=null;
		 ctx=new ClassPathXmlApplicationContext("ApplicationContext.xml");
		 ICustomerDAO dao = (ICustomerDAO) ctx.getBean("cusDao");
		 
		 Customer cus = new Customer();
		 
		 Scanner scanner = new Scanner(System.in);
		 boolean flag = true;
		 
		 do{
			 
			 System.out.println("请输入FirstName(first_name):");
			 String first_name = scanner.next();
			 
			 System.out.println("请输入LastName(last_name):");
			 String last_name = scanner.next();
			 
			 System.out.println("请输入Email(email):");
			 String email = scanner.next();
			 
			 Integer address_id;
			 do{
				 System.out.println("请输入AddressId(address_id):");
				try {
					address_id = scanner.nextInt();
				} catch (Exception e) {
					System.out.println("你输入的addressid不合法，拜拜！");
					e.printStackTrace();
					return;
				}
				
//				System.out.println(address_id+"**************");
//				int s = dao.testt();
//				
				String s = dao.findAddressIdisE(address_id);
				System.out.println(s+"11111111111111");
				if(s==null){
					System.out.println("你输入的AddressId不存在，请重新输入");
				}else{
					flag = false;
				}
				
			 }while(flag);
			 
			 
			 try {
				
				 System.out.println("Before Insert Customer Data");
				
				cus = new Customer(first_name, last_name, email, address_id);
			} catch (Exception e) {
				System.out.println("添加失败，请重新启动程序再次尝试！");
				e.printStackTrace();
				return;
			}
			 
			 break;
			 
		 }while(true);
		
		 
		 System.out.println("已保存的数据如下：");
		 System.out.println("ID: "+cus.getCustomer_id());
		 System.out.println("FirstName: "+cus.getFirst_name());
		 System.out.println("LastName: "+cus.getLast_name());
		 System.out.println("Email: "+cus.getEmail());
		 System.out.println("Address: "+dao.findAddressById(cus.getAddress_id()));
		 
		 System.out.println("After Insert Customer Data");
		 
		 System.out.println("请输入你要删除的Customerd的ID：");
		 Integer customer_id;
		 try {
			customer_id = scanner.nextInt();
		} catch (Exception e) {
			System.out.println("你输入的ID不合法，请重启程序重新输入！");
			e.printStackTrace();
			return;
		}
		 
		 if(dao.findCid(customer_id)!=null){
			 
			 dao.delCus(customer_id);
			 
			 System.out.println("你输入的ID为  "+customer_id+" 已经删除。");
			 return;
		 }else{
			 System.out.println("你输入的ID为  "+customer_id+" 删除失败,结束程序！");
			 return;
		 }
		 
		 
	}

}
