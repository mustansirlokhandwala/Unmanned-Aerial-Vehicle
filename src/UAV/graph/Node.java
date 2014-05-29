/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UAV.graph;

import java.util.ArrayList;

/**
 *
 * @author Mustan
 */
public class Node implements Comparable<Node> {
    
    private String name;
    private Double lattitude;
    private Double longitude;
    public Double getLattitude() {
		return lattitude;
	}

	public void setLattitude(Double lattitude) {
		this.lattitude = lattitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	ArrayList<Edge> edgeList;
    ArrayList<Edge> inDegreeEdges;
    private boolean visited;
    private double distance = Double.POSITIVE_INFINITY;
    private Node previous;

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
    

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
    

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    
    public Node() {
        edgeList = new ArrayList<>();
        inDegreeEdges = new ArrayList<>();
    }

    public ArrayList<Edge> getInDegreeEdges() {
        return inDegreeEdges;
    }

    public void setInDegreeEdges(ArrayList<Edge> inDegreeEdges) {
        this.inDegreeEdges = inDegreeEdges;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Edge> getEdgeList() {
        return edgeList;
    }

    public void setEdgeList(ArrayList<Edge> edgeList) {
        this.edgeList = edgeList;
    }

    @Override
    public int compareTo(Node o) {
        return Double.compare(distance, o.distance);
    }
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return name;
    }
    
    
}
