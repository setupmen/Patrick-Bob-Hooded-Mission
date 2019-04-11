package com.setup_men.patrick_bob.view.figure.character;
/**
* @author Andrés Felipe Chaparro Rosas
* @date 4/04/2019
**/
public enum Type {
	CURLY("curly"), STRAIGHT("straight");

	private String path;

	private Type(String path) {
		this.path = path;
	}

	public String getPath() {
		return path + "/";
	}

}