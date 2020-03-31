package com.swiftacad.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.swiftacad.dto.Cat;

@RestController
@RequestMapping("api")
public class CatController {

	private Map<String, Cat> cats = new HashMap<>();
	
	@RequestMapping(value = "cat", method = RequestMethod.POST)
	public void addCat(@RequestBody Cat cat) {
		if(!this.cats.containsKey(cat.getName())) {
			cats.put(cat.getName(), cat);
		}
	}
	
	@RequestMapping(value = "cat/{name}", method = RequestMethod.GET)
	public ResponseEntity<Cat> findCatByName(@PathVariable("name") String name) {
		Cat cat = this.cats.get(name);
		if(cat == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Cat>(cat, HttpStatus.OK);
	}
	
	@RequestMapping(value = "cats", method = RequestMethod.GET)
	public Map<String, Cat> fetchCats() {
		return this.cats;
	}
}
