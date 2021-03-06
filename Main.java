import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Main {
	public static final int LEADER_AGENT_NUM = 5;
	public static final int MEMBER_AGENT_NUM = 50;
	public static final int TURN_NUM = 10000;
	public static final int ADD_TASK_PER_TURN = 20;
	public static final int TASK_REQUIRE_MAX = 15;
	private static Random random = new Random(1000000009);
	private static ArrayList<Agent> agents;
	private static Queue<Task> queue;
	private static int successCount;

	public static void main(String[] args) {
        agents = new ArrayList<Agent>();
        queue = new LinkedList<Task>();

        // agentの作成
        for(int i = 0; i<LEADER_AGENT_NUM; i++) {
        	agents.add(new LeaderAgent(random.nextInt(10)+1));
		}
        for(int i = 0; i<MEMBER_AGENT_NUM; i++) {
        	agents.add(new MemberAgent(random.nextInt(15)+1));
		}

        // ターンのループ
		for(int turn = 0; turn < TURN_NUM; turn++) {
			for(int t = 0; t < ADD_TASK_PER_TURN; t++){
				queue.add(new Task(random.nextInt(10)+1));
			}
			for(Agent agent: agents){
				agent.action();
			}
		}
		System.out.println(successCount);
	}

	public static Task getTask() {
		return queue.poll();
	}
	
	public static ArrayList<Agent> getAgents() {
		return agents;
	}
	
	public static void addSuccess() {
		successCount += 1;
	}
}
