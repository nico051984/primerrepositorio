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

@Path("/MainRestBar")
public class MainRestBar {

	@Path("/conecta")
    @POST
	@Consumes(value= MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public Response conexion (String json){
		String result="";
		System.out.println("Prueba y terror");
		return Response.ok(result).header("Access-Control-Allow-Origin", "*")
    			.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT").build();
	}
}
