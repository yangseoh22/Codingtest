import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		ArrayList<Integer> q = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if (cmd.equals("push")) {
				q.add(Integer.parseInt(st.nextToken()));
			} else if (cmd.equals("pop")) {
				if (q.isEmpty())
					sb.append(-1).append("\n");
				else {
					sb.append(q.get(0)).append("\n");
					q.remove(0);
				}
			} else if (cmd.equals("size")) {
				sb.append(q.size()).append("\n");
			} else if (cmd.equals("empty")) {
				sb.append(q.isEmpty() ? 1 : 0).append("\n");
			} else if (cmd.equals("front")) {
				if (q.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(q.get(0)).append("\n");
			} else if (cmd.equals("back")) {
				if (q.isEmpty())
					sb.append(-1).append("\n");
				else
					sb.append(q.get(q.size() - 1)).append("\n");
			}
		}
		System.out.println(sb);
	}

}
