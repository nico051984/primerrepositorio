package com.rest;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import org.json.JSONException;

import com.model.Conectar;

import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.OPTIONS;

@Path("/")
public class QueryProcess {
	
	public String query;
	public String result;
	public Connection conn;
	public Conectar c;
	
	@Path("/query")
    @POST
	@Consumes(value= MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public Response conexion (String json){
    	System.out.println(json);
		//create JsonReader object
		JsonReader jsonReader = Json.createReader(new StringReader(json));
		//get JsonObject from JsonReader
		JsonObject jsonObject = jsonReader.readObject();
		//we can close IO resource and JsonReader now
		jsonReader.close();
		query = jsonObject.getString("query");
		try {
			/*if (jsonObject.getString("conexion").compareTo("sinconectar")==0) {
				Class.forName("com.ibm.as400.access.AS400JDBCDriver");
				conn = DriverManager.getConnection("jdbc:as400://"+"G10BBE6P", "d_nchialvo", "pocopelo35");
				result=json;
			}
	    	else {
	    		System.out.println("Ya estaba conectado");
	    		
	    	}*/
			Class.forName("com.ibm.as400.access.AS400JDBCDriver");
			conn = DriverManager.getConnection("jdbc:as400://"+"G10BBE6P", "d_nchialvo", "pocopelo35");
			Statement stmt = (Statement) this.conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = null ; 
			System.out.println("Paso");
			String tipoDato="";
			String clase="";
			rs = stmt.executeQuery(query);
		    while (rs.next()){
		    	tipoDato = rs.getString("ABALPH"); 
		    	clase = rs.getString("ABAN8");
		    }
		    rs.close();
		    System.out.println("ACA "+tipoDato+" "+clase);
		}
		catch (ClassNotFoundException cnf) {
		    System.out.println("ERROR: One of the JDBC drivers did not load.");
		}
		catch (SQLException e) {
			System.out.println("ERROR: " + e.getMessage());
		}
    	return Response.ok(result).header("Access-Control-Allow-Origin", "*")
    			.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
	}
}
