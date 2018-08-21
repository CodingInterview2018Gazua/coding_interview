package Chapter4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DirectedGragh {
	private Map<Vertex, Set<Vertex>> mMap;
	
	public DirectedGragh() {
		mMap = new HashMap<Vertex, Set<Vertex>>();
	}
	
	public boolean addVertex(Vertex vertex) {
        if(!mMap.containsKey(vertex)) {
            mMap.put(vertex, new HashSet<>());
            return true;
        }
        return false;
    }
	
	public boolean addEdge(Vertex from, Vertex to) {
        if(mMap.containsKey(from)) {
        	Set<Vertex> dests = mMap.get(from);
            if(!dests.contains(to)) {
            	dests.add(to);
                return true;
            }
        }
        
        return false;
    }
}
