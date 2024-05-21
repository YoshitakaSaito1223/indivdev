package com.example.myapp.task;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class SubTask extends Task {
	
	public SubTask(@NotEmpty String taskname, String tasknote, int userid, Task task) {
		super(taskname, tasknote,true, userid);
		this.task = task;
	}

	@ManyToOne
	Task task;

}
