package de.uni.potsdam.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "competenceRoot")
//@XmlAccessorType(XmlAccessType.FIELD)
public class CompetenceDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private String name;

	private String treeTipp;

	private String icon;

	private List<CompetenceDto> children = new ArrayList<CompetenceDto>();

	private boolean isCompulsory;
	
	private Boolean isLearned = false;

	@XmlAttribute(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@XmlAttribute(name = "treetipp")
	public String getTreeTipp() {
		return treeTipp;
	}

	public void setTreeTipp(String treeTipp) {
		this.treeTipp = treeTipp;
	}

	@XmlAttribute(name = "icon")
	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	@XmlElement(name = "children")
	public List<CompetenceDto> getChildren() {
		return children;
	}

	public void setChildren(List<CompetenceDto> children) {
		this.children = children;
	}

	@XmlElement(name = "isCompulsory")
	public boolean isCompulsory() {
		return isCompulsory;
	}

	public void setCompulsory(boolean isCompulsory) {
		this.isCompulsory = isCompulsory;
	}
	
	public Boolean getLearned() {
		return isLearned;
	}

	public void setLearned(Boolean isLearned) {
		this.isLearned = isLearned;
	}

	@Override
	public String toString() {
		return "Competence [name=" + name + ", treeTipp=" + treeTipp
				+ ", icon=" + icon + ", children=" + children
				+ ", isCompulsory=" + isCompulsory + "]";
	}
}