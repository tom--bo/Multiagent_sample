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
			}
		}
		int size = affordable.size();
		if(size != 0) {
			Main.addSuccess();
		}
		messages.clear();
		return;
	}
}
