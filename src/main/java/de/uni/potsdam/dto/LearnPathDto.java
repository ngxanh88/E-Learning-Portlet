package de.uni.potsdam.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LearnPathDto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Map<String, String> nodeIdValues = new HashMap<String, String>();
	private List<Node> nodes = new ArrayList<Node>();
	private List<NodeRelation> triples = new ArrayList<NodeRelation>();

	public Map<String, String> getNodeIdValues() {
		return nodeIdValues;
	}

	public void setNodeIdValues(Map<String, String> nodeIdValues) {
		this.nodeIdValues = nodeIdValues;
	}

	public List<Node> getNodes() {
		return nodes;
	}

	public void setNodes(List<Node> nodes) {
		this.nodes = nodes;
	}

	public List<NodeRelation> getTriples() {
		return triples;
	}

	public void setTriples(List<NodeRelation> triples) {
		this.triples = triples;
	}

	@Override
	public String toString() {
		return "LearnPathDto [nodeIdValues=" + nodeIdValues + ",\n nodes="
				+ nodes + ",\n triples=" + triples + "]";
	}
}
