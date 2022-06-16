package com.example.demo.Client;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;
import java.io.*;

import com.example.demo.Bean.Employee;

public class Test {

	public static void main(String[] args) throws Exception,EOFException {
		int choice=-1;
		Scanner sn=new Scanner(System.in);
		Scanner sn1=new Scanner(System.in);

		ArrayList<Employee> a1=new ArrayList<Employee>();
		//CONVERT OBJECT INTO FILE
		
		File file=new File("/home/tectoro/sujatha/employee.txt");
		
		ObjectOutputStream oos=null;
		
		//CONVERT FILE INTO OBJECTS
		
		ObjectInputStream ois=null;
		if(file.isFile())
		{
			try
			{
			ois=new ObjectInputStream(new FileInputStream(file));
			a1=(ArrayList<Employee>) ois.readObject();
			ois.close();
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			
			
			
			
		}
		//for sequential data use listIterator
			
			ListIterator li=null;
	
				do {
			System.out.println("1.INSERT");
			System.out.println("2.DISPLAY");
			System.out.println("3.SEARCH");
			System.out.println("0.EXIT");
			System.out.println("enter your choice");
			 choice=sn.nextInt();
			
			switch(choice)
			{
			//insert
			case 1:
				
				System.out.println("enter how many times");
				int n=sn.nextInt();
				for(int i=1;i<=n;i++)
				{
				System.out.println("enter employee no");
				int empno=sn.nextInt();
				System.out.println("enter employee name");
				String ename=sn1.nextLine();
				System.out.println("enter phone no");
				int phoneno=sn.nextInt();
				a1.add(new Employee(empno, ename, phoneno));
				oos=new ObjectOutputStream(new FileOutputStream(file));
				oos.writeObject(a1);
				
				
				}
				oos.close();
				break;
			//display	
			case 2:
				
				
				System.out.println("-------------------");
				li = a1.listIterator();
				while (li.hasNext()) {
					System.out.println(li.next());
				System.out.println("----------------");	
					
				}
				
				break;
			//search an element	
			case 3:
				System.out.println("----------");
				if(file.isFile())
				{
					try
					{
					ois=new ObjectInputStream(new FileInputStream(file));
					a1=(ArrayList<Employee>) ois.readObject();
					ois.close();
					
					Boolean found=false;
					System.out.println("enter empno to search");
					int empno=sn.nextInt();
					li = a1.listIterator();
					
					while (li.hasNext()) {
						Employee e = (Employee) li.next();
						//System.out.println(e);
						if(e.getEmpno()==empno)
						{
							System.out.println(e);
							found=true;
						}
					
					}
					if(!found)
						
							System.out.println("record not found");
					}
					
					
					catch (Exception e) {
						// TODO: handle exception
					}
	
				
					
					
				}
				else
				{
					System.out.println("file not exists....");
				}
				
				break;	
			}
			
			
		}while(choice!=0);

	}

}
