package UAV.graph.google;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import UAV.graph.Graph;
import UAV.graph.Node;

public class Testing {

	public static void main(String[] args) {
		AddressConverter ac = new AddressConverter();
		String address = "Boston, Massachusetts";
//		String lattitude = ac.calculatelatitude(address);
//		String longitude = ac.calculateLongitude(address);
//		System.out.println(lattitude);
//		System.out.println(longitude);
		Graph massGraph = new Graph();
		String csvFile = "C:\\WorkSpace\\Java\\city.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		Map<String, String> maps = new HashMap<String, String>();
	 
		try {
	 
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
	 
			       
				String[] country = line.split(cvsSplitBy);
	            Node node = new Node();
	            node.setName(country[0]+","+country[1]);
	            node.setLattitude(Double.parseDouble(country[2]));
	            node.setLongitude(Double.parseDouble(country[3]));
	            massGraph.nodeList.add(node);
	            
	            
	 
			}
	 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		massGraph.calculateneighbours(massGraph);
		massGraph.calculateSpeed(massGraph);
		Graph dummyGraph = massGraph;
		ArrayList<Node> finalResult = new ArrayList<>();
		String startState = "Boston,MA";
		
			ArrayList<Node> noderesult = new ArrayList<>();
			ArrayList<Node> noderesult2 = new ArrayList<>();
//		    noderesult = massGraph.djak(dummyGraph, "Boston,MA", "Provincetown,MA");
		    noderesult2=massGraph.djak2(dummyGraph, "Boston,MA", "Provincetown,MA");
		    ArrayList<Node> best = new ArrayList<>();
		    for(Node node : noderesult){
		    	System.out.print("["+node.getName()+"],");
		    }
		    System.out.println("--------------------------------");
		    for(Node node : noderesult2){
		    	System.out.print("["+node.getName()+"],");
		    }
			
			
		
		
		
		
		
		
	 
		System.out.println("Done");
	  }
		
		

	}


