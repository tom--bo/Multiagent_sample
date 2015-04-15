import java.util.ArrayList;
import java.util.List;

public abstract class Agent {
	private static int _id_sequence = 0;
	protected int id;
	protected int ability;
	
	public Agent(int ability) {
		this.id = _id_sequence;
		_id_sequence++;
		this.ability = ability;
	}
	
	public void hello() {
		System.out.println("Hello, I'm an agent.id = " + id + "/ ability = " + ability);
	}
	
	public abstract void action();
}
