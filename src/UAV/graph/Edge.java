/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UAV.graph;

/**
 *
 * @author Mustan
 */
public class Edge {
    private Node toNode;
    private double weight;
    private double speedweight;
    
    

    public double getSpeedweight() {
		return speedweight;
	}

	public void setSpeedweight(double speedweight) {
		this.speedweight = speedweight;
	}

	public Node getToNode() {
        return toNode;
    }

    public void setToNode(Node toNode) {
        this.toNode = toNode;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    
}
