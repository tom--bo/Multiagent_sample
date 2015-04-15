
public class Message {
	private Agent from;
	private Task task;

	public Message(Agent from, Task task) {
		this.from = from;
		this.task = task;
	}
	
	public Agent getFrom() {
		return from;
	}
	
	public Task getTask() {
		return task;
	}
}
