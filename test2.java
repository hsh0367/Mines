package ai;

import java.util.ArrayList;

import mineSweeper.*;

public class test2 {
	static Oracle oracle = new Oracle(1);
	static int map[][] = new int[oracle.getBoardSize()][oracle.getBoardSize()];
	static int mapSize = oracle.getBoardSize();
	static ArrayList <location> locations = new ArrayList<location>();
	// 맵 업데이트가 제데로 되고있지 않다 (왜 그런건지 모르겠다)\\
	static int mineCount = 0;

	public static int decisionMine(int i, int j) {
		int count = 0;
		int mid = map[i][j];
		mineCount = 0;

		if (i > 0 && i < mapSize - 1 && j > 0 && j < mapSize - 1) {
			if (map[i][j] != 0 && map[i][j] != 9 && map[i][j] != 99) {
				// 중점기준 모르는 부분 찾기
				location coor = new location();
				if (map[i - 1][j - 1] == 9) {
					count++;
					System.out.println("countUP " + count + " " + i + " " + j);

					coor.setX(j - 1);
					coor.setY(i - 1);
				}
				if (map[i - 1][j] == 9) {
					count++;
					System.out.println("countUP " + count + " " + i + " " + j);
					coor.setX(j);
					coor.setY(i - 1);
				}
				if (map[i - 1][j + 1] == 9) {
					count++;
					System.out.println("countUP " + count + " " + i + " " + j);
					coor.setX(j + 1);
					coor.setY(i - 1);
				}
				if (map[i][j - 1] == 9) {
					count++;
					System.out.println("countUP " + count + " " + i + " " + j);
					coor.setX(j - 1);
					coor.setY(i);
				}
				if (map[i][j + 1] == 9) {
					count++;
					System.out.println("countUP " + count + " " + i + " " + j);
					coor.setX(j + 1);
					coor.setY(i);
				}
				if (map[i + 1][j - 1] == 9) {
					count++;
					System.out.println("countUP " + count + " " + i + " " + j);
					coor.setX(j - 1);
					coor.setY(i + 1);
				}
				if (map[i + 1][j] == 9) {
					count++;
					System.out.println("countUP " + count + " " + i + " " + j);
					coor.setX(j);
					coor.setY(i + 1);
				}
				if (map[i + 1][j + 1] == 9) {
					count++;
					System.out.println("countUP " + count + " " + i + " " + j);
					;
					coor.setX(j + 1);
					coor.setY(i + 1);
				}
				// 지뢰 갯수 찾기

				if (map[i - 1][j - 1] == 99)
					mineCount++;
				if (map[i - 1][j] == 99)
					mineCount++;
				if (map[i - 1][j + 1] == 99)
					mineCount++;
				if (map[i][j - 1] == 99)
					mineCount++;
				if (map[i][j + 1] == 99)
					mineCount++;
				if (map[i + 1][j - 1] == 99)
					mineCount++;
				if (map[i + 1][j] == 99)
					mineCount++;
				if (map[i + 1][j + 1] == 99)
					mineCount++;
			}

		}
		if (mineCount == mid) { // 지뢰가 없을 때 0 반환
			System.out.println("catch not mines");
			return 0;
		} else if (count == mid - mineCount) {
			return 1; // 지뢰가 있을경우 1 반환
		} else {
			System.out.println("누를 곳이 없습니다. ");
			return 2; // 누를곳이 없을경우 2 반환
		}
	}

	public static void catchMines() {
		// 문제점 지뢰 놓았던곳에 또 놓아서 gameover
		// 반복문을 돌면서 마지막일때 놓을 곳이 없을경우 모르는 부분을 랜덤으로 찍는다.
		System.out.println("catch mines 실행 ");
		int mid = 0;
		int count = 0;// 모르는 부분
		int mineCount = 0;
		ArrayList<Integer> x = new ArrayList<Integer>();
		ArrayList<Integer> y = new ArrayList<Integer>();

		ArrayList<Coordinate> tt = new ArrayList<Coordinate>();

		/*
		 * ( i-1,j-1 )( i ,j-1 )( i+1,j-1 ) ( i-1, j )( i , j )( i+1, j )
		 * (i-1,j+1 )( i ,j+1 )( i+1,j+1 )
		 */

		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {// 주위 actionperform 에서는 x,y가
												// 반대로 들어간다.
				// map[i][j]
				ArrayList<ArrayList> temp = new ArrayList<ArrayList>();
				System.out.println(" i 값 : " + i + " j 값 " + j);
				System.out.println("카운트 : " + count + " 중앙값 : " + mid
						+ " 지뢰수 : " + mineCount);
				if (decisionMine(i, j) == 0) {
					for (int n = 0; n < x.size(); n++) {
						System.out.println("x축 y축 좌표 값 " + x.get(n) + " "
								+ y.get(n));
					}
					for (int n = 0; n < x.size(); n++) {
						temp.add(oracle.actionPerform(x.get(n), y.get(n), 0));
						viewMap();
						oracle.currentStatus();
						System.out.println();
					}
					if (!temp.equals(null)) {
						for (int n = 0; n < temp.size(); n++) {
							System.out.println("temp 출력 : " + temp.get(n));
							updateMap(temp.get(n));
						}
					}
					oracle.currentStatus();

				} else if (decisionMine(i, j) == 1) {
					System.out.println("catch mines");

					System.out.println();
					for (int n = 0; n < x.size(); n++) {
						System.out.println("위치 : " + j + " , " + i);
						System.out.println("지뢰 위치 : " + x.get(n) + " "
								+ y.get(n));
						System.out.println("범위안에 지뢰 갯수 : " + mineCount);
						System.out.println("범위안 모르는 갯수 : " + count);

						temp.add(oracle.actionPerform(x.get(n), y.get(n), 1));
						System.out.println(temp);
						oracle.currentStatus();

					}
					if (!temp.equals(null)) {
						for (int n = 0; n < temp.size(); n++) {
							System.out.println("temp 출력 : " + temp.get(n));
							if (!temp.get(n).equals(null))
								updateMap(temp.get(n));
						}
					}
					viewMap();
					System.out.println();

				} else {

					System.out.println("누를 곳이 없습니다. ");

				}
				// for (int n = 0; n < temp.size(); n++) {
				// System.out.println("temp 출력 : " + temp.get(n));
				// updateMap(temp.get(n));
				//
				// }

			}

		}
	}

	// 맵업데이트
	public static void updateMap(ArrayList<Coordinate> a) {
		if (!a.equals(null)) {
			for (int i = 0; i < a.size(); i++) {
				map[a.get(i).getY()][a.get(i).getX()] = a.get(i).getValue();
			}
		}
	}

	public static void viewMap() {
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void makeMap() { // 맵을
									// 제작
									// 한다.
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {
				map[i][j] = 9;
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Coordinate> temp = new ArrayList<Coordinate>();
		int x = 0;
		int y = 0;
		int size = oracle.getBoardSize();
		boolean loop = true;
		makeMap();
		while (loop) {
			x = (int) (Math.random() * (size - 1));
			y = (int) (Math.random() * (size - 1));
			System.out.println(oracle.getBoardSize());
			System.out.println(x + " , " + y);
			temp = oracle.actionPerform(x, y, 0);
			System.out.println(temp);
			updateMap(temp);
			oracle.currentStatus();
			if (temp.size() > 3) // 5개 이상 퍼질경우
				loop = false;
		}

		viewMap();
		// while (!oracle.isGameOver()) {
		System.out.println("마인 찾기 시작 ");
		for (int i = 0; i < 10; i++) {
			// System.out.println("마인 찾기 시작 " + i);

			catchMines();
			oracle.currentStatus();
			oracle.printScore();

		}
		// }
	}
}
