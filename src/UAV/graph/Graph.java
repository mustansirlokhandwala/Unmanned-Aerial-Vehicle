/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UAV.graph;

import java.util.AbstractList;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.Set;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;
/**
 *
 * @author Mustan
 */
public class Graph {
    
 public int TOTAL_VERTICE =0;
 public  ArrayList<Node> nodeList;
    public Graph() {       
        nodeList = new ArrayList<>();        
        } 
    
    
 
 public boolean noInDegrees(Node node){
     if(node.inDegreeEdges.isEmpty())
         return true;
     return false;
 } 
 
 public ArrayList<Node> TopologicalSort(Graph graph){
     Graph dummyGraph = graph;
     ArrayList<Node> sortedList = new ArrayList<>();
     Queue<Node> queue = new ArrayDeque<>();
     TOTAL_VERTICE = nodeList.size();
     for(int i = 0 ; i< dummyGraph.TOTAL_VERTICE ; i ++){
     if(dummyGraph.nodeList.get(i).inDegreeEdges.isEmpty()){
         Node node = dummyGraph.nodeList.get(i);
         queue.add(node);
         
     }
     }
     if(queue.isEmpty()){
         return null;
     }
     while(!queue.isEmpty()){
         Node node = queue.peek();
         sortedList.add(node);
         for(int i = 0 ; i < node.edgeList.size() ; i++){
             Node next = node.edgeList.get(i).getToNode();
             Edge edge = node.edgeList.get(i);
             next.inDegreeEdges.remove(edge);
             if(next.inDegreeEdges.isEmpty()){
                 queue.add(next);           
             }
                              
         }
         if(!sortedList.contains(node))
         sortedList.add(node);
         queue.remove();
     }
     
     if(sortedList.size() != 10){
         System.out.println("Graph is cyclic");
         return new ArrayList<Node>();
     }
     
     return sortedList;
 }
 
 
 
 public void loop(Node node , Stack<Node> stack){
     node.setVisited(true);
     Iterator<Edge> lt = node.getEdgeList().iterator();
     while(lt.hasNext()){
         Node n = lt.next().getToNode();
         if(!n.isVisited())
             loop(n, stack);
     }
     stack.push(node);
 }
 
 
    public  void DeptfirstSeach(Node n,ArrayList<Node> s){
                if(!n.isVisited()){
                    s.add(n);
                }
		
		n.setVisited(true);
		
		int edges=n.getEdgeList().size();

		
		Node [] outedge = new Node[edges+1];
		for (int i=0;i<edges;i++){
                    Edge e = n.edgeList.get(i);
                    outedge[i]=e.getToNode();
                }

	
		for (int i=0;i<edges;i++) {
			Node w=outedge[i];
			

			
			if(!w.isVisited()) {
				DeptfirstSeach(w,s);
			}
		}
		
		
     
     }
     
         


	
     
 public  ArrayList<Node> djak(Graph g ,String s , String d){
     Node source = null;
     Node destination = null;
     TOTAL_VERTICE = nodeList.size();
     for(Node node : nodeList){
         if(node.getName().equalsIgnoreCase(s))
             source = node;
         if(node.getName().equalsIgnoreCase(d))
             destination = node;
     }
          source.setDistance(0);
          PriorityQueue<Node> queue = new PriorityQueue<Node>();
          queue.add(source);

          while (!queue.isEmpty()) {
              Node node = queue.poll();

              for (Edge e :node.edgeList){
                  Node n = e.getToNode();
                  double weight = e.getWeight();
                  double distanceTo = node.getDistance() + weight;
                    if (distanceTo < n.getDistance()) {
                        queue.remove(n);

                        n.setDistance(distanceTo); 
                        n.setPrevious(node);
                        queue.add(n);
                        

                    }
                }
             }
          
          
         ArrayList<Node> path = new ArrayList<Node>();
         for (Node node = destination; node != null; node = node.getPrevious())
             path.add(node);

         Collections.reverse(path);
         return path;
             
     
 }
 
 public void calculateneighbours(Graph graph){
	 
	 double mindistance = 20;
	 Haversine haversine = new Haversine();
	 
	 ArrayList<Node> nodelist = graph.nodeList;
	 
	 for(Node node1 : nodeList){
		 for(Node node2:nodelist){
			 double distance = haversine.haversine(node1.getLattitude(), node1.getLongitude(), node2.getLattitude(), node2.getLongitude());
			 if(!node1.equals(node2)){
				 if(distance<=mindistance){
					 Edge edge1 = new Edge();
					 edge1.setToNode(node1);
					 edge1.setWeight(distance);
					 node2.edgeList.add(edge1);
					 Edge edge2 = new Edge();
					 edge2.setToNode(node2);
					 edge2.setWeight(distance);
					 node1.edgeList.add(edge2);
					 
					 
					 
				 }
			 }
		 }
	 }
	 
	 
 }
 
 
 public void calculateSpeed(Graph graph){
	 
	 ArrayList<Node> nodelist = graph.nodeList;
	 Random rand = new Random();
	 float uavspeed = 220;
	 
	 
	 
	 for(Node node: nodelist){
		 for(Edge e : node.edgeList){
			 float speed = uavspeed - rand.nextInt(100);
			 double v = 661.4788 * Math.sqrt(5*Math.pow((rand.nextInt(220)/29.92126 + 1),(2/7))-1);
			 e.setSpeedweight(speed * v);
			 
		 }
	 }
	 
	 
 }
 
 
 public  ArrayList<Node> djak2(Graph g ,String s , String d){
     for(Node nn:g.nodeList){
    	 nn.setDistance(Double.POSITIVE_INFINITY);
     }
	 Node source = null;
     Node destination = null;
     TOTAL_VERTICE = nodeList.size();
     for(Node node : g.nodeList){
         if(node.getName().equalsIgnoreCase(s))
             source = node;
         if(node.getName().equalsIgnoreCase(d))
             destination = node;
     }
          source.setDistance(0);
          PriorityQueue<Node> queue = new PriorityQueue<Node>();
          queue.add(source);

          while (!queue.isEmpty()) {
              Node node = queue.poll();

              for (Edge e :node.edgeList){
                  Node n = e.getToNode();
                  double weight = e.getSpeedweight();
                  double distanceTo = node.getDistance() + weight;
                    if (distanceTo < n.getDistance()) {
                        queue.remove(n);

                        n.setDistance(distanceTo); 
                        n.setPrevious(node);
                        queue.add(n);
                        

                    }
                }
             }
          
          
         ArrayList<Node> path = new ArrayList<Node>();
         for (Node node = destination; node != null; node = node.getPrevious())
             path.add(node);

         Collections.reverse(path);
         return path;
             
     
 }   
 
     
  
 




     
         
   
 }
 
    
  
     

