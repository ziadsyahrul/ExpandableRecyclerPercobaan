package com.ziadsyahrul.expandablerecyclerpercobaan.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseHome {

	@SerializedName("serve")
	private List<ServeItem> serve;

	@SerializedName("message")
	private String message;

	public void setServe(List<ServeItem> serve){
		this.serve = serve;
	}

	public List<ServeItem> getServe(){
		return serve;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"ResponseHome{" +
			"serve = '" + serve + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}