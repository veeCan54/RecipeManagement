package com.practise.recipemanagement.recipe;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class RecipeIngredient {
	
	@Id
	@GeneratedValue
	private Integer id;	
	
	private String name;	
	
	private String quantity;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonBackReference
	private Recipe recipe;	
	
	
	protected RecipeIngredient() {
		
	}

	public RecipeIngredient(String name) {
		super();
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}
}

