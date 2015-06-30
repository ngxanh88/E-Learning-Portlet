package de.uni.potsdam.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "competenceXMLTrees")
public class CourseCompetenceDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private CompetenceDto competence;

	@Override
	public String toString() {
		return "CourseCompetenceDto [Competence=" + competence + "]";
	}

	@XmlElement(name = "competenceRoot")
	public CompetenceDto getCompetence() {
		return competence;
	}

	public void setCompetence(CompetenceDto competence) {
		this.competence = competence;
	}

}
