package com.stmanager;


import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Student {
	
	public static int check()
	{
		int input=0;
		try {
			Scanner sc = new Scanner(System.in);
			
			 input = sc.nextInt();
		}
		catch(InputMismatchException e)
		{
			
			System.err.println("Enter the Value in Interger Format");
			
		}
		return input;
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Scanner sc = new Scanner(System.in);
		
			boolean flag = false;
			
			while(!flag)
			{
					System.out.println("Choose Your Choice\n1.For Enter New Student Details\n2.Remove the Student Details\n3.Update the Student Details\n4.Showing Details of Paticular Student\n5.All the Student Details \n6.Exit ");
					
						try {
							
								switch(check())
								{
								case 1:
								{
									System.out.println("Enter the name");
									String name = sc.nextLine();
									System.out.println("Enter the FatherName");
									String Fname = sc.nextLine();
									System.out.println("Enter the phonenumber");
									String phone=sc.nextLine();
									if(!(phone.length()==10))
									{
										System.err.println("Please enter the Mobile Number in Proper 10 Digits");
										phone=sc.nextLine();
									}
									System.err.println("Enter the Standard in Interger Format");
									int standard = sc.nextInt();
									
									Details df = new Details(name,Fname,phone,standard);
									
									boolean	 b = Methods.insert(df);
									if(b)
									{
										System.out.println("Succesfully Inserted");
									}
									else {
										System.out.println("OOps Something went wrong");
									}
									
								}
									break;
								case 2:
								{
									System.out.println("Enter the id of Student");
									int id = sc.nextInt();
									
									int b1 = Methods.delete(id);
									
									if(b1>=0)
									{
										System.out.println("Student details are Removed......");
									}
								}
									break;
								case 3:
								{
									System.out.println("Enter the id of Student");
									int id = sc.nextInt();
								
									int b2 = Methods.update(id);
									if(b2>=0)
									{
										System.out.println("Student details are updated......");
									}
									
								}
									break;
								case 4 :
								{
									System.out.println("Enter the id of Student");
									int id = sc.nextInt();
									Methods.ShowingDetails(id);
								}
								break;
								case 5 :{
									Methods .showingdetails();
								}
								break;
								case 6:
								{
									flag=true;
								}break;
								default :
								{
									System.err.println("Choose the option within the below listed");
									System.out.println();
								}
							}
						}
						catch(InputMismatchException e)
						{
							System.out.println("Enter the Valid Input");
						}
				}
			sc.close();
		}
		
	}


