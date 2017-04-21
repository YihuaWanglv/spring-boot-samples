package com.iyihua.remote.base;

import java.util.List;

import com.iyihua.model.base.ProjectDTO;

public interface ProjectRemote {

	public List<ProjectDTO> findProjectByUserId(Long userId);
	
	public ProjectDTO saveProject(ProjectDTO project);
	
	public void deleteProject(Long projectId);
}
