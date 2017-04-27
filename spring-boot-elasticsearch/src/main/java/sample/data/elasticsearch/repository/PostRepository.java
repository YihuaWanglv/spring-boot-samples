package sample.data.elasticsearch.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import sample.data.elasticsearch.entity.Post;

public interface PostRepository extends ElasticsearchRepository<Post, String> {

}
