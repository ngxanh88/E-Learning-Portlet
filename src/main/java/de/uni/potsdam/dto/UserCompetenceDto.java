package de.uni.potsdam.dto;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class UserCompetenceDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Map<String, List<CompetenceLink>> mapUserCompetenceLinks;

	public Map<String, List<CompetenceLink>> getMapUserCompetenceLinks() {
		return mapUserCompetenceLinks;
	}

	public void setMapUserCompetenceLinks(
			Map<String, List<CompetenceLink>> mapUserCompetenceLinks) {
		this.mapUserCompetenceLinks = mapUserCompetenceLinks;
	}

	@Override
	public String toString() {
		return "UserCompetenceDto [mapUserCompetenceLinks="
				+ mapUserCompetenceLinks + "]";
	}
}
