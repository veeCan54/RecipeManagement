package com.practise.recipemanagement.user;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.practise.recipemanagement.recipe.Recipe;

import lombok.Data;

@Entity
@Data
public class User {
	
	@Id
	@GeneratedValue
	private Integer id;	
	
	private String firstName;	
	
	private String lastName;	
	
	private String emailAddress;	
	
	private boolean adminFlag;	
	
	private boolean approvedFlag;
	
	@OneToMany(targetEntity=Recipe.class, fetch=FetchType.LAZY, mappedBy="user" )
	private List<Recipe> recipes = new ArrayList();
	
	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	public User(Integer id, String firstName, String lastName, String emailAddress, boolean adminFlag,
			boolean approvedFlag) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.adminFlag = adminFlag;
		this.approvedFlag = approvedFlag;
	}
	
	protected User() {
		
	}	

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=").append(id).append(", firstName=").append(firstName).append(", lastName=")
				.append(lastName).append(", emailAddress=").append(emailAddress).append(", adminFlag=")
				.append(adminFlag).append(", approvedFlag=").append(approvedFlag).append("]");
		return builder.toString();
	}
	
	public Recipe addUserRecipes(Recipe recipe) {
		if(null == recipe.getId()) {
			recipe.setId(recipes.size() +1);
		}
		recipes.add(recipe);
		return recipe;
	}
}

