import java.util.*;
import java.io.*;

public class BOJ_14226 {
	static int S, min; // 만들 이모티콘 수, 시간의 최솟값
	static boolean[] visitedScreen, visitedClipBoard; // 두 가지 방문 배열

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = Integer.parseInt(br.readLine());
		min = 0;

		// S의 범위가 2이상 1000이하 이므로 방문배열은 2001로 잡기
		visitedScreen = new boolean[2001];
		visitedClipBoard = new boolean[2001];

		// bfs 탐색
		bfs();

		System.out.println(min);
	}

	// bfs 탐색
	static void bfs() {
		// Node 타입 큐 생성
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(1, 0, 0));
		// 스크린 이모티콘 개수 1, 클립보드 이모티콘 개수 0 방문 처리
		visitedScreen[1] = true;
		visitedClipBoard[0] = true;

		while (!q.isEmpty()) {
			Node cur = q.poll();

			// 화면에 이모티콘 S개 만들었다면 탐색 종료
			if (cur.screen == S) {
				min = cur.time;
				return;
			}

			// 화면 이모티콘 범위 벗어나면 skip
			if (cur.screen < 0 || cur.screen >= 1001) {
				continue;
			}

			// 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
			if (isNotVisited(cur.screen, cur.screen)) {
				q.offer(new Node(cur.screen, cur.screen, cur.time + 1));
				visitedScreen[cur.screen] = true;
				visitedClipBoard[cur.screen] = true;
			}

			// 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기 한다.
			if (cur.clipBoard != 0) {
				q.offer(new Node(cur.screen + cur.clipBoard, cur.clipBoard, cur.time + 1));
			}

			// 3. 화면에 있는 이모티콘 중 하나를 삭제한다.
			if (cur.screen > 1 && isNotVisited(cur.screen - 1, cur.clipBoard)) {
				q.offer(new Node(cur.screen - 1, cur.clipBoard, cur.time + 1));
				visitedScreen[cur.screen - 1] = true;
				visitedClipBoard[cur.clipBoard] = true;
			}
		}
	}

	// 방문 했는지 체크 함수
	static boolean isNotVisited(int s, int c) {
		return !(visitedScreen[s] && visitedClipBoard[c]);
	}

	// 화면의 이모티콘 수, 클립보드의 이모티콘 수, 시간을 나타내는 Node
	static class Node {
		int screen, clipBoard, time;

		public Node(int screen, int clipBoard, int time) {
			this.screen = screen;
			this.clipBoard = clipBoard;
			this.time = time;
		}
	}
}
