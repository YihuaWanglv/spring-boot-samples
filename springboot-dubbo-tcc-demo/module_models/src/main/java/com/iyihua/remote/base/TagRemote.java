package com.iyihua.remote.base;

import java.util.List;

import com.iyihua.model.base.TagDTO;

public interface TagRemote {

	public List<TagDTO> findTagsByUserId(Long userId);
	
	public TagDTO saveTags(TagDTO tags);
	
	public void deleteTags(Long tagsId);
}
