package com.swiftacad.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "api")
public class TestController {
	
	@RequestMapping(value = "test", method = RequestMethod.GET)
	public String test() {
		return "<strong>HELLoO Spring boottt</strong>";
	}
}
