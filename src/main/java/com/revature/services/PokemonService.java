package com.revature.services;

import java.util.HashMap;
import java.util.Optional;

import com.revature.exceptions.HttpException;

/**
 * The service layer is responsible for executing application
 * business logic. Business logic is the application of business rules.
 *
 */
public class PokemonService {

	HashMap<Integer, String> pokemap =
			new HashMap<>();
	
	{
		pokemap.put(25, 
				"{\"name\":\"Pikachu\",\"id\":25}");
		pokemap.put(1, 
				"{\"name\":\"Bulbasaur\",\"id\":1}");
		pokemap.put(4, 
				"{\"name\":\"Charmander\",\"id\":4}");
	}

	public String getPokemon(int id) throws HttpException {
		return Optional
				.ofNullable(pokemap.get(id)).orElseThrow(
					() -> new HttpException("Pokemon not found.", 404));
	}
	
}
