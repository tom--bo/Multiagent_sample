import java.awt.List;
import java.util.ArrayList;


public class LeaderAgent extends Agent {
	public LeaderAgent(int ability) {
		super(ability);
	}
	
	@Override
	public void action() {
		Task task = Main.getTask();
		if(task == null) {
			return;
		}
		
		ArrayList<Agent> agents = Main.getAgents();
		int tosend = random.nextInt(agents.size());
		
		Agent sendagent = agents.get(tosend);
		sendagent.addMessage(new Message(this, task));
	}

}
