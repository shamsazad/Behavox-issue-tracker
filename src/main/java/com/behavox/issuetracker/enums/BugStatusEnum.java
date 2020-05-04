package com.behavox.issuetracker.enums;

public enum BugStatusEnum {
	
	OPEN(1),
	IN_PROGRESS(2),
	RESOLVED(3),
	CLOSED(4),
	RE_OPEN(5);
	
	private Integer value;
	
	BugStatusEnum(Integer val) {
		this.value = val;
	}

	public Integer getValue() {
		return value;
	}
}
