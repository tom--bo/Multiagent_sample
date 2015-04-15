import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Agent {
	private static int _id_sequence = 0;
	protected int id;
	protected int ability;
	protected List<Message> messages;
	protected static Random random = new Random(10000007);
	
	public Agent(int ability) {
		this.id = _id_sequence;
		_id_sequence++;
		this.ability = ability;
		messages = new ArrayList<Message>();
	}
	
	public void hello() {
		System.out.println("Hello, I'm an agent.id = " + id + "/ ability = " + ability);
	}
	
	public void addMessage(Message message) {
		messages.add(message);
	}
	
	public abstract void action();
}
