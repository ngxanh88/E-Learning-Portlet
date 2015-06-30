package de.uni.potsdam.dto;

import java.io.Serializable;
import java.util.List;

public class CompetenceLink implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private List<Comment> comments;
	private boolean validated;
	private String evidenceTitel;
	private String evidenceUrl;
	private String abstractLinkId;

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public boolean isValidated() {
		return validated;
	}

	public void setValidated(boolean validated) {
		this.validated = validated;
	}

	public String getEvidenceTitel() {
		return evidenceTitel;
	}

	public void setEvidenceTitel(String evidenceTitel) {
		this.evidenceTitel = evidenceTitel;
	}

	public String getEvidenceUrl() {
		return evidenceUrl;
	}

	public void setEvidenceUrl(String evidenceUrl) {
		this.evidenceUrl = evidenceUrl;
	}

	public String getAbstractLinkId() {
		return abstractLinkId;
	}

	public void setAbstractLinkId(String abstractLinkId) {
		this.abstractLinkId = abstractLinkId;
	}

	@Override
	public String toString() {
		return "CompetenceLink [comments=" + comments + ", validated="
				+ validated + ", evidenceTitel=" + evidenceTitel
				+ ", evidenceUrl=" + evidenceUrl + ", abstractLinkId="
				+ abstractLinkId + "]";
	}
}
