package com.ziadsyahrul.expandablerecyclerpercobaan.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ServeItem{

	@SerializedName("orientation")
	private String orientation;

	@SerializedName("account_id")
	private int accountId;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("unicode")
	private Object unicode;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("uncategorized")
	private int uncategorized;

	@SerializedName("group_link_id")
	private int groupLinkId;

	@SerializedName("position")
	private Object position;

	@SerializedName("title")
	private String title;

	@SerializedName("status")
	private int status;

	@SerializedName("child_link")
	private List<Object> childLink;

	public void setOrientation(String orientation){
		this.orientation = orientation;
	}

	public String getOrientation(){
		return orientation;
	}

	public void setAccountId(int accountId){
		this.accountId = accountId;
	}

	public int getAccountId(){
		return accountId;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setUnicode(Object unicode){
		this.unicode = unicode;
	}

	public Object getUnicode(){
		return unicode;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setUncategorized(int uncategorized){
		this.uncategorized = uncategorized;
	}

	public int getUncategorized(){
		return uncategorized;
	}

	public void setGroupLinkId(int groupLinkId){
		this.groupLinkId = groupLinkId;
	}

	public int getGroupLinkId(){
		return groupLinkId;
	}

	public void setPosition(Object position){
		this.position = position;
	}

	public Object getPosition(){
		return position;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	public void setChildLink(List<Object> childLink){
		this.childLink = childLink;
	}

	public List<Object> getChildLink(){
		return childLink;
	}

	@Override
 	public String toString(){
		return 
			"ServeItem{" + 
			"orientation = '" + orientation + '\'' + 
			",account_id = '" + accountId + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",unicode = '" + unicode + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",uncategorized = '" + uncategorized + '\'' + 
			",group_link_id = '" + groupLinkId + '\'' + 
			",position = '" + position + '\'' + 
			",title = '" + title + '\'' + 
			",status = '" + status + '\'' + 
			",child_link = '" + childLink + '\'' + 
			"}";
		}
}