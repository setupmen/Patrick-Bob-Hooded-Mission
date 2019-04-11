package com.setup_men.patrick_bob.view.figure.character;
/**
* @author Andrés Felipe Chaparro Rosas
* @date 4/04/2019
**/
public enum Lenght {
	SHORT("short"), MEDIUM("path"), LONG("path"), HOOD("hood");

	private String path;
	private Type type;

	private Lenght(String path) {
		this.path = path;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Type getType() {
		return type;
	}

	public String getPath() {
		if (path.equals(HOOD.path))
			return path + "/";
		return path + "/" + type.getPath();
	}

}