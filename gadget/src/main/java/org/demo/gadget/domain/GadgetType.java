package org.demo.gadget.domain;

public enum GadgetType {
	
	MOBILE_PHONE("Mobile phone"), 
	MEDIA_PLAYER("Personal media player"), 
	LAPTOP("Laptop/notebook"), 
	GPS("GPS");

	private final String label;

	GadgetType(String desc) {
		this.label = desc;
	}

	public String label() {
		return label;
	}
};