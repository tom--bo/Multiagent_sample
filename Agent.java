import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public abstract class Agent {
	private static int _id_sequence = 0;
	protected int id;
	protected int ability;
	protected List<Message> messages;
	protected static Random random = new Random(10000007);
	protected double[][] table;
	
	public Agent(int ability) {
		this.id = _id_sequence;
		_id_sequence++;
		this.ability = ability;
		messages = new ArrayList<Message>();
		table = new double[Main.TASK_REQUIRE_MAX+1][Main.LEADER_AGENT_NUM+Main.MEMBER_AGENT_NUM];
		for(int i=0; i<Main.TASK_REQUIRE_MAX+1; i++){
			Arrays.fill(table[i],  0.5d);;
		}
	}
	
	public void hello() {
		System.out.println("Hello, I'm an agent.id = " + id + "/ ability = " + ability);
	}
	
	public void addMessage(Message message) {
		messages.add(message);
	}
	
	public abstract void action();
}
