package com.techpalle;

import java.sql.*;

public class Student {
	        private static final String url="jdbc:mysql://localhost:3306/palle";
			private static String username="root";
			private static String password="rootpassword";
			
			private static Connection con=null;
			private static Statement s=null;
			private static PreparedStatement ps=null;
			private static ResultSet rs=null;

			public void creating() {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection(url,username,password);
					String qry ="create table Student(sno int primary key auto_increment,sname varchar(40),sub varchar(30),email varchar(80))";
					s=con.createStatement();
					s.executeUpdate(qry);
			}
				catch(ClassNotFoundException e) {
					e.printStackTrace();
					
					}
				catch(SQLSyntaxErrorException e) {
					System.out.println("table exists");
				}
				catch(SQLException e){
					e.printStackTrace();
					
					}
				finally {
					try {
						
						if(s !=null) 
						{
							s.close();
						}
					
						if(con !=null) 
						{
					con.close();
						}
					}
					catch(SQLException e) {
						e.printStackTrace();
						}
					}
			}
					
				
			public void inserting(String sname ,String sub,String  email)
			{
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection(url,username,password);
					
					ps=con.prepareStatement("insert into student(sname,sub,email) values (?,?,?)");
					ps.setString(1, sname);
					ps.setString(2, sub);
					ps.setString(3, email);
					
					ps.executeUpdate();
					
				}
					catch(ClassNotFoundException e) {
						e.printStackTrace();
						
						}
				catch(SQLException e) {
					e.printStackTrace();
					
				}
				finally {
					try {
						if(ps!=null) {
							ps.close();
						}
						if(con!=null) {
							con.close();
						}
					}
					catch(SQLException e) {
						e.printStackTrace();
					}
				}
		}
			public void update(int sno,String email,String sub) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection(url,username,password);
					String qry="update student set sub=?,email=? where sno=?";
					
					ps=con.prepareStatement(qry);
				
					ps.setString(1,sub);
					ps.setString(2,email);
					ps.setInt(3,sno);
					
					ps.executeUpdate();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				 catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
				
				finally {
					try {
						if(ps!=null) {
							ps.close();
						}
						if(con!=null) {
							con.close();
						}
						
					}
					catch(SQLException e) {
						e.printStackTrace();
						
					}
				}
				
				
			}
			public void delete(int sno) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con=DriverManager.getConnection(url,username,password);
				
					ps=con.prepareStatement("delete from Student where sno=?");
					ps.setInt(1, sno);
					ps.executeUpdate();
					
				}
				catch(ClassNotFoundException e) {
					e.printStackTrace();
					
					}
			catch(SQLException e) {
				e.printStackTrace();
				
			}
				finally {
					try {
						if(ps!=null) {
							ps.close();
						}
						if(con!=null) {
							con.close();
						}
				
			}
					catch(SQLException e) {
						e.printStackTrace();
						
					}
				}
					
			}
			public void read() {
				try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(url,username,password);
				
				s=con.createStatement();
				String qry="select*from Student";
				rs=s.executeQuery(qry);
				while(rs.next()) {
					System.out.println(rs.getInt(1));
					System.out.println(rs.getString(2));
					System.out.println(rs.getString(3));
					System.out.println(rs.getString(4));
					System.out.println();
					
				}
				}
				catch(ClassNotFoundException e) {
					e.printStackTrace();
					
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
				
				
			}
				
			
			
}
