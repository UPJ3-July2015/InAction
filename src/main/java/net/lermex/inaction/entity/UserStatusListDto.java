package net.lermex.inaction.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import net.lermex.inaction.json.ViewsHolder;

public class UserStatusListDto {
	
	@JsonView(ViewsHolder.Post.class)
	private List<UserStatus> list;
	
	@JsonView(ViewsHolder.Post.class)
	private Long minId;
	
	@JsonView(ViewsHolder.Post.class)
	private Long maxId;
	
	public UserStatusListDto() {}
		
	public UserStatusListDto(List<UserStatus> list, Long minId, Long maxId) {		
		this.list = list;
		this.minId = minId;
		this.maxId = maxId;
	}

	public List<UserStatus> getList() {
		return list;
	}
	public void setList(List<UserStatus> list) {
		this.list = list;
	}
	public Long getMinId() {
		return minId;
	}
	public void setMinId(Long minId) {
		this.minId = minId;
	}
	public Long getMaxId() {
		return maxId;
	}
	public void setMaxId(Long maxId) {
		this.maxId = maxId;
	}	

}
