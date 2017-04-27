package sample.data.elasticsearch.entity;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(indexName = "post", type = "post", shards = 1, replicas = 0, refreshInterval = "-1")
public class Post {

	@Id
	String pid;
	String iid;
	String title;
	String content;
	Integer status;
	Integer deleted;
	String creator;
	Date created;
	String lupdator;
	Date lupated;
	Integer up;
	Integer down;

}
