package com.practise.recipemanagement.user;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.practise.recipemanagement.recipe.Recipe;

@SuppressWarnings("deprecation")
@RestController
public class UserResource {
	
	@Autowired
	UserRepository userRepo;
	
	@GetMapping(path="/users")
	public List<User> getAllUsers(){
		List<User> users = userRepo.findAll();
		return users;
	}
	
	@GetMapping(path="/users/{id}")
	public User getAllUsers(@PathVariable int id){
		Optional<User> user = userRepo.findById(id);
		User user2 = user.get();
		return user2;
	}
	
	//get /users/{id}/recipes -- retriveRecipesByUser 
	//--> retreive recipes for user {id}
	@GetMapping(path="/users/{id}/recipes")
	public List<Recipe> retreiveRecipeByUser(@PathVariable int id){
		Optional<User> user = userRepo.findById(id);
		User retreivedUser = user.get();
		List<Recipe> userRecipes = retreivedUser.getRecipes();
		return userRecipes;
	}
	
	
	@PostMapping(path="/users")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		User savedUser = userRepo.save(user);		
		URI location = ServletUriComponentsBuilder
			       .fromCurrentRequest()
			       .path("{id}")
			       .buildAndExpand(savedUser.getId()).toUri();
	return ResponseEntity.created(location).build();
	}

}
