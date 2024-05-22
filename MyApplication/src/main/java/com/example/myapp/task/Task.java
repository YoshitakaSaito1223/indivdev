package com.example.myapp.task;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Task {

	public Task(@NotEmpty String taskname, String tasknote,boolean isSub, int userid) {
		super();
		this.taskname = taskname;
		this.tasknote = tasknote;
		this.iscompleted=false;
		this.isdeleted=false;
		this.isSub = isSub;
		this.userid = userid;
	}
	
	public Task(@NotEmpty String taskname, String tasknote, int userid) {
		super();
		this.taskname = taskname;
		this.tasknote = tasknote;
		this.iscompleted=false;
		this.isSub = false;
		this.isdeleted=false;
		this.userid = userid;
	}

	
	@Id
	@GeneratedValue
	private int id;
	
	@NotEmpty
	private String taskname;
	
	private String tasknote;
	
	private boolean iscompleted=false;
	
	private boolean isSub;
	
	private boolean isdeleted=false;
	
	private int userid;
	
}
