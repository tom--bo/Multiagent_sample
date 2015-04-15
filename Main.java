import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
        List<Agent> agents = new ArrayList<Agent>();
        for(int i = 0; i<10; i++) {
        	agents.add(new Agent((int)(Math.random() * 9) +1));
		}
		for(Agent agent:agents) {
			agent.hello();
		}
	}

}
