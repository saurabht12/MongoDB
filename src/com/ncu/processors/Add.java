package com.ncu.processors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;
 
import com.mongodb.DB;
import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;  
import com.mongodb.client.MongoCollection;  
import com.mongodb.client.MongoDatabase;  
import org.bson.types.ObjectId;
public class Add extends HttpServlet{
public void doGet(HttpServletRequest req,HttpServletResponse res)
throws ServletException,IOException
{

res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.println("<form  action='add' method='GET'>");
out.println("<html><body style='background-color: darkorange';> ");
out.println("<head><h1 align='center' style='margin-top:30px;' ><u>Add User</u></h1></head>");
out.print("<table align='center' style='margin-top:70px;height:300px;' border=1>");  
out.println("<tr><td>Name</td><td><input type='text' name='uname'></td></tr>");
out.println("<tr><td>Mobile No</td><td><input type='text' name='mob' ></td></tr>");
out.println("<tr><td>Password</td><td><input type='password' name='pass'></td></tr>");
out.println("<tr><td>Email</td><td><input type='text' name='email'></td></tr></table>");
 out.println("<input type='submit' align='center' style='margin-left:630;width:90px;height:40px;margin-top:30px;' value='submit'>");
String getValue=req.getParameter("uname");
if(!getValue.equals(null))
{
	
String str=req.getParameter("uname");
String str2=req.getParameter("mob");
String str1=req.getParameter("pass");
String str3=req.getParameter("email");
try
{
	MongoClient mongoClient = new MongoClient( "localhost" , 27017 );
	DB db = mongoClient.getDB("at");
            DBCollection collection = db.getCollection("people");
	        DBObject document1 = new BasicDBObject();
document1.put("name", str);
document1.put("pass", str1);
document1.put("mobile Number",str2);
document1.put("email",str3);

collection.insert(document1);
res.sendRedirect("login");
}
catch(Exception e)
{

}
}
out.println("hello");
 out.println("<input type='submit' value='Submit'></form>");

}
}