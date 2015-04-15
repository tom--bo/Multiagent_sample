import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
	public static final int AGENT_NUM = 10;
	private static Random random = new Random(1000000009);

	public static void main(String[] args) {
        List<Agent> agents = new ArrayList<Agent>();

        for(int i = 0; i<AGENT_NUM; i++) {
        	agents.add(new Agent(random.nextInt(10)+1));
		}
		for(Agent agent:agents) {
			agent.hello();
		}
	}

}
