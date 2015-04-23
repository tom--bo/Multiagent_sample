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
		
		double[] subtable = table[task.getRequire()];
		double sum = 0.0d;
		for(double d:subtable) {
			sum += d;
		}
		
		double value = random.nextDouble() * sum;
		int selected_id = 0;
		double msum = 0.0d;
		for(int i=0; i<(Main.LEADER_AGENT_NUM + Main.MEMBER_AGENT_NUM); i++){
			if(msum < value){
                selected_id = i;
                break;
			}
			msum += subtable[i];
		}
		
		Agent sendagent = Main.getAgents().get(selected_id);
		sendagent.addMessage(new Message(this, task));
	}

}
