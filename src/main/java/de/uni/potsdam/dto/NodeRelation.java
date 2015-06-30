package de.uni.potsdam.dto;

import java.io.Serializable;

public class NodeRelation implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long node2id;
	private long node1id;
	private boolean directed;
	private String label;
	private String toNode;

	public long getNode2id() {
		return node2id;
	}

	public void setNode2id(long node2id) {
		this.node2id = node2id;
	}

	public long getNode1id() {
		return node1id;
	}

	public void setNode1id(long node1id) {
		this.node1id = node1id;
	}

	public boolean isDirected() {
		return directed;
	}

	public void setDirected(boolean directed) {
		this.directed = directed;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getToNode() {
		return toNode;
	}

	public void setToNode(String toNode) {
		this.toNode = toNode;
	}

	public String getFromNode() {
		return fromNode;
	}

	public void setFromNode(String fromNode) {
		this.fromNode = fromNode;
	}

	private String fromNode;

	@Override
	public String toString() {
		return "NodeRelation [node2id=" + node2id + ", node1id=" + node1id
				+ ", directed=" + directed + ", label=" + label + ", toNode="
				+ toNode + ", fromNode=" + fromNode + "]";
	}

}
