package com.practise.recipemanagement.recipe;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.practise.recipemanagement.user.User;

@Entity
public class Recipe {
	
	@Id
	@GeneratedValue
	private Integer id;	
	
	private String title;	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonBackReference
	private User user;	
	
	private String instructions;
	
	@OneToMany(targetEntity=RecipeIngredient.class, fetch=FetchType.LAZY, mappedBy="recipe" )
	@JsonManagedReference
	private List<RecipeIngredient> ingredients = new ArrayList<RecipeIngredient>();
	
	protected Recipe() {
		
	}

	public Recipe(Integer id, String title, String instructions, User user) {
		super();
		this.id = id;
		this.title = title;
		this.instructions = instructions;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getInstructions() {
		return instructions;
	}

	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}

	public List<RecipeIngredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<RecipeIngredient> ingredients) {
		this.ingredients = ingredients;
	}
}
