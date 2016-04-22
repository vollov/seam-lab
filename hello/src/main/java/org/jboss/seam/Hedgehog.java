package org.jboss.seam;

public class Hedgehog {

	private String name;

	public Hedgehog() {
	}

	public String getName() {
		return name;
	}

	@Override
	  public String toString() {
	    final StringBuilder sb = new StringBuilder();
	    sb.append("Hedgehog");
	    sb.append("{name='").append(name).append("'");
	    sb.append("}");
	    return sb.toString();
	  }

	public void setName(String name) {
		this.name = name;
	}

	public Hedgehog(String name) {
		this.name = name;
	}
}