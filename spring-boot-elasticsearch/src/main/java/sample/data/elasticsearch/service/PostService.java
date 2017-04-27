package sample.data.elasticsearch.service;

import java.util.List;

import org.elasticsearch.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sample.data.elasticsearch.entity.Post;
import sample.data.elasticsearch.repository.PostRepository;

@Service
public class PostService {

	@Autowired PostRepository postRepository;
	
	public void savePost(Post post) {
		
		postRepository.save(post);
	}
	
	public List<Post> findAll() {
		
		return Lists.newArrayList(postRepository.findAll());
	}
}
