package com.behavox.issuetracker.enums;

public enum IssueTypeEnum {
	
	BUG(1),
	STORY(2);
	
	private Integer value;
	
	IssueTypeEnum(Integer val) {
		this.value = val;
	}

	public Integer getValue() {
		return value;
	}
}
