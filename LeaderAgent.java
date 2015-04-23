import java.awt.List;
import java.util.ArrayList;

public class LeaderAgent extends Agent {
	public LeaderAgent(int ability) {
		super(ability);
	}
	
	@Override
	public void action() {
		for(Message message:messages){
			message.getFrom().feedback(this, message.getTask(), false);
		}
		messages.clear();
		
		Task task = Main.getTask();
		if(task == null) {
			return;
		}
		
		Agent sendagent = selectAgent(task);
		sendagent.addMessage(new Message(this, task));
	}
	
	private Agent selectAgent(Task task) {
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
			}
			msum += subtable[i];
		}
		return Main.getAgents().get(selected_id);
	}
	@Override
	public void feedback(Agent from, Task task, boolean isok){
		double newvalue = isok ? 1.0d: 0.0d;
		double prevvalue = table[task.getRequire()][from.id];
		table[task.getRequire()][from.id] = (1.0d - learnRate) * prevvalue + learnRate * newvalue;
	}
}
