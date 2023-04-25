package com.stmanager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Methods 
{
	Details in;
	public static boolean insert(Details dt) throws ClassNotFoundException, SQLException
	{
		Connection con = CC.conn();
		
		String query = "insert into Student(name,Fname,phone,standard) values(?,?,?,?)";
		
					PreparedStatement pd = con.prepareStatement(query);
					pd.setString(1, dt.getName());
					pd.setString(2,dt.getFname());
					pd.setString(3,dt.getPhone());
					pd.setInt(4, dt.getStandard());
					
					pd.execute();
					
		return true;
	}
	public static int delete(int id) throws ClassNotFoundException, SQLException
	{
		Scanner sc = new Scanner(System.in);
		Connection con = CC.conn();
		PreparedStatement ps = con.prepareStatement("select * from student where id=?");
		ps.setInt(1, id);
		ResultSet set = ps.executeQuery();
	
				while(set.next())
				{
					PreparedStatement pd = con.prepareStatement("delete from student where id=?");
					pd.setInt(1, id);
					
					var x=pd.executeUpdate();
					return x ;
				}
				System.err.println("No student is Present with this ID");
				System.out.println("++++++++++++++++++++++++++++++++++++++++");
					System.out.println("Enter the Proper ID Again");
					delete(sc.nextInt());
					return 0;
	}
	public static int update(int id) throws ClassNotFoundException, SQLException
	{
		Scanner sc = new Scanner(System.in);
		Connection con = CC.conn();
		PreparedStatement ps = con.prepareStatement("select * from student where id=?");
		ps.setInt(1, id);
		ResultSet set = ps.executeQuery();
	
				while(set.next())
				{
					PreparedStatement pd = con.prepareStatement("update student set name=?,Fname=?,phone=?,standard=? where id=?");
					System.out.println("Enter the new name");
					String name = sc.nextLine();
					System.out.println("Enter the new FatherName");
					String Fname = sc.nextLine();
					System.out.println("Enter the new phonenumber");
					String phone=sc.nextLine();
					System.out.println("Enter the new Standard");
					int standard = sc.nextInt();
					pd.setString(1,name);
					pd.setString(2,Fname);
					pd.setString(3, phone);
					pd.setInt(4, standard);
					pd.setInt(5, id);
					int up=pd.executeUpdate();
					
					return up;
				}
				System.err.println("No student is Present with this ID");
				System.out.println("++++++++++++++++++++++++++++++++++++++++");
				System.out.println("Enter the Proper ID Again");
					update(sc.nextInt());
				return 0;
		
	}
	public static void ShowingDetails(int id) throws ClassNotFoundException, SQLException  
	{
		Scanner sc = new Scanner(System.in);

		Connection con = CC.conn();
		
		PreparedStatement ps = con.prepareStatement("select * from student where id=?");
		ps.setInt(1, id);
		ResultSet set = ps.executeQuery();
	
				while(set.next())
				{
					System.out.println(set.getInt(1)+"\n"+set.getString(2)+"\n"+set.getString(3)+"\n"+set.getString(4)+"\n"+set.getInt(5));
					return;
				}
				System.err.println("No student is Present with this ID");
				System.out.println("++++++++++++++++++++++++++++++++++++++++");
					System.out.println("Enter the Proper ID Again");
					ShowingDetails(sc.nextInt());	
	}
	public static void showingdetails() throws ClassNotFoundException, SQLException
	{
		Connection con = CC.conn();
		PreparedStatement ps = con.prepareStatement("select * from student");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			System.out.println("Student Id :"+rs.getInt(1)+"\nStudent Name :"+rs.getString(2)+"\nStudent Father Name :"+rs.getString(3)+"\nStudent PhoneNumber :"+rs.getString(4)+"\nStudent Standard :"+rs.getInt(5));
		}
		
	}
}
