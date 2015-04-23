import java.util.ArrayList;
import java.util.List;


public class MemberAgent extends Agent {
	public MemberAgent(int ability) {
		super(ability);
	}
	
	@Override
	public void action() {
		List<Message> affordable = new ArrayList<Message>();
		for(Message message: messages) {
			if(message.getTask().getRequire() <= ability) {
				affordable.add(message);
			}else{
				message.getFrom().feedback(this,  message.getTask(),  false);
			}
		}
		int size = affordable.size();
		if(size == 0) {
			return;
		}
		
		int selected_message = random.nextInt(size);
		for(int i=0; i<size; i++){
			Message message = affordable.get(i);
			message.getFrom().feedback(this,  message.getTask(),  (i == selected_message));;
		}

		Main.addSuccess();
		messages.clear();
	}

	@Override
	public void feedback(Agent from, Task task, boolean isok) {
	}
}
