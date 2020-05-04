package com.behavox.issuetracker.enums;

public enum IssuePriorityEnum {
	
	CRITICAL(1),
	MAJOR(2),
	MINOR(3);

	private Integer value;
	
	IssuePriorityEnum(Integer val) {
		this.value = val;
	}

	public Integer getValue() {
		return value;
	}
}
