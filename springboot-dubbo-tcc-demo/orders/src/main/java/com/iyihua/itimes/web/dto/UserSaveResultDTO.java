package com.iyihua.itimes.web.dto;

public class UserSaveResultDTO {
	private Long id;
	private String name;
	private String email;
	private String index;

	public UserSaveResultDTO() {
		super();
	}
	public UserSaveResultDTO(Long id, String name, String email, String index) {
		super();
		this.setId(id);
		this.name = name;
		this.email = email;
		this.index = index;
	}

	@Override
	public String toString() {
		return "UserSaveResultDTO [id=" + id + ", name=" + name + ", email=" + email + ", index=" + index + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIndex() {
		return index;
	}
	public void setIndex(String index) {
		this.index = index;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}
