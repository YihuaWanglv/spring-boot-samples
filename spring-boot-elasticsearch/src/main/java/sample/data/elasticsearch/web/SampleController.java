package sample.data.elasticsearch.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sample.data.elasticsearch.service.PostService;

@RestController
public class SampleController {
	
	@Autowired PostService postService;

	@RequestMapping(value="/all")
	public Object findAll() {
		return postService.findAll();
	}
}
