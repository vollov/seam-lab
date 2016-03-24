package org.demo.gadget.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.jboss.seam.annotations.Name;

@Entity
@Table(name = "gadget")
@Name("gadget")
public class Gadget implements Serializable {
	
	private static final long serialVersionUID = -1L;
	private long id;
	private String description = "";
	private String type = "";

	public Gadget() {
	}

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column
	public String getDescription() {
		return description;
	}

	public void setDescription(String desc) {
		description = desc;
	}

	@Column
	public String getType() {
		return type;
	}

	public void setType(String t) {
		type = t;
	}

	@Transient
	public Map<String, String> getGadgetTypes() {
		Map<String, String> types = new HashMap<String, String>();
		for (GadgetType value : GadgetType.values()) {
			types.put(value.label(), value.name());
		}
		return types;
	}
}
