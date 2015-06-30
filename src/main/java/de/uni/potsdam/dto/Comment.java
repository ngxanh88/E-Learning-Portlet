package de.uni.potsdam.dto;

public class Comment {

	private String userName;
	private long created;
	private String commentName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public long getCreated() {
		return created;
	}

	public void setCreated(long created) {
		this.created = created;
	}

	public String getCommentName() {
		return commentName;
	}

	public void setCommentName(String commentName) {
		this.commentName = commentName;
	}

	@Override
	public String toString() {
		return "Comment [userName=" + userName + ", created=" + created
				+ ", commentName=" + commentName + "]";
	}
}
