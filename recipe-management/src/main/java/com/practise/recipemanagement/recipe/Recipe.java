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

import lombok.Data;

@Entity
@Data
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
	
}
