package ai;

import java.util.ArrayList;

import mineSweeper.*;

public class test {
	static Oracle oracle = new Oracle();
	static int map[][] = new int[oracle.getBoardSize()][oracle.getBoardSize()];
	static int mapSize = oracle.getBoardSize();

	public static void catchMines() {
		System.out.println("catch mines 실행 ");
		int mid = 0;
		int count = 0;// 모르는 부분
		int mineCount = 0;
		int place = 0;
		ArrayList<Integer> x = new ArrayList<Integer>();
		ArrayList<Integer> y = new ArrayList<Integer>();

		/*
		 * ( i , j ) (i-1,j+1 )
		 */

		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {// 주위 actionperform 에서는 x,y가
												// 반대로 들어간다.
				// map[i][j]

				System.out.println(j + ", " + i);
				count = 0;
				mineCount = 0;
				mid = map[i][j];
				if (i == 0 || i == mapSize - 1 && j<mapSize -1 && j> 0) { // 왼쪽에 붙어 있을때
					// 중점기준 모르는 부분 찾기

					System.out.println(j + " " + i);
					if (i == 0) {

						if (map[i][j + 1] == 9) {
							count++;
							System.out.println("countUP " + count + " " + i + " " + j);
							y.add(i);
							x.add(j + 1);
						}

						if (map[i + 1][j] == 9) {
							count++;
							System.out.println("countUP " + count + " " + i + " " + j);
							y.add(i + 1);
							x.add(j);
						}
						if (map[i + 1][j - 1] == 9) {
							count++;
							System.out.println("countUP " + count + " " + i + " " + j);
							y.add(i + 1);
							x.add(j + 1);
						}
						if (map[i + 1][j + 1] == 9) {
							count++;
							System.out.println("countUP " + count + " " + i + " " + j);
							y.add(i + 1);
							x.add(j + 1);
						}
						if (map[i][j - 1] == 99 || map[i][j + 1] == 99 || map[i + 1][j - 1] == 99 || map[i + 1][j] == 99
								|| map[i + 1][j + 1] == 99) {
							mineCount++;
							System.out.println("MinecountUP " + mineCount + " " + i + " " + j);

						}
					} else {
						if (map[i - 1][j - 1] == 9) {
							count++;
							System.out.println("countUP " + count + " " + i + " " + j);
							y.add(i - 1);
							x.add(j - 1);
						}
						if (map[i - 1][j] == 9) {
							count++;
							System.out.println("countUP " + count + " " + i + " " + j);
							y.add(i - 1);
							x.add(j);
						}
						if (map[i - 1][j + 1] == 9) {
							count++;
							System.out.println("countUP " + count + " " + i + " " + j);
							y.add(i - 1);
							x.add(j + 1);
						}
						if (map[i][j - 1] == 9) {
							count++;
							System.out.println("countUP " + count + " " + i + " " + j);
							y.add(i);
							x.add(j - 1);
						}
						if (map[i][j + 1] == 9) {
							count++;
							System.out.println("countUP " + count + " " + i + " " + j);
							y.add(i);
							x.add(j + 1);
						}
						if (map[i - 1][j - 1] == 99 || map[i - 1][j] == 99 || map[i - 1][j + 1] == 99
								|| map[i][j - 1] == 99 || (map[i][j + 1] == 99)) {
							mineCount++;
							System.out.println("MinecountUP " + mineCount + " " + i + " " + j);

						}
					}
					// 지뢰 갯수 찾기

				} else if (j == 0 || j == mapSize - 1) { // 위에 붙어 있을때
					// 중점기준 모르는 부분 찾기
					System.out.println(j + " " + i);
					if (i == 0) {

						if (map[i][j - 1] == 9) {
							count++;
							System.out.println("countUP " + count + " " + i + " " + j);
							y.add(i);
							x.add(j - 1);
						}
						if (map[i][j + 1] == 9) {
							count++;
							System.out.println("countUP " + count + " " + i + " " + j);
							y.add(i);
							x.add(j + 1);
						}
						if (map[i + 1][j - 1] == 9) {
							count++;
							System.out.println("countUP " + count + " " + i + " " + j);
							y.add(i + 1);
							x.add(j - 1);
						}
						if (map[i + 1][j] == 9) {
							count++;
							System.out.println("countUP " + count + " " + i + " " + j);
							y.add(i + 1);
							x.add(j);
						}
						if (map[i + 1][j + 1] == 9) {
							count++;
							System.out.println("countUP " + count + " " + i + " " + j);
							y.add(i + 1);
							x.add(j + 1);
						}
						if (map[i - 1][j] == 99 || map[i - 1][j] == 99 || map[i - 1][j + 1] == 99 || map[i][j + 1] == 99
								|| map[i + 1][j] == 99 || map[i + 1][j + 1] == 99) {
							mineCount++;
							System.out.println("MinecountUP " + mineCount + " " + i + " " + j);

						}
					} else {
						if (map[i - 1][j - 1] == 9) {
							count++;
							System.out.println("countUP " + count + " " + i + " " + j);
							y.add(i - 1);
							x.add(j - 1);
						}
						if (map[i - 1][j] == 9) {
							count++;
							System.out.println("countUP " + count + " " + i + " " + j);
							y.add(i - 1);
							x.add(j);
						}

						if (map[i][j - 1] == 9) {
							count++;
							System.out.println("countUP " + count + " " + i + " " + j);
							y.add(i);
							x.add(j - 1);
						}

						if (map[i + 1][j - 1] == 9) {
							count++;
							System.out.println("countUP " + count + " " + i + " " + j);
							y.add(i + 1);
							x.add(j - 1);
						}
						if (map[i + 1][j] == 9) {
							count++;
							System.out.println("countUP " + count + " " + i + " " + j);
							y.add(i + 1);
							x.add(j);
						}
						// 지뢰 갯수 찾기
						if (map[i - 1][j - 1] == 99 || map[i - 1][j] == 99 || map[i][j - 1] == 99
								|| map[i + 1][j - 1] == 99 || map[i + 1][j] == 99) {
							mineCount++;
							System.out.println("MinecountUP " + mineCount + " " + i + " " + j);

						}
					}

				} else {// 끝에
						// 아닐때
					if (map[i][j] != 0 && map[i][j] != 9) {
						// 중점기준 모르는 부분 찾기
						System.out.println(j + " " + i);
						if (map[i - 1][j - 1] == 9) {
							count++;
							System.out.println("countUP " + count + " " + i + " " + j);
							y.add(i - 1);
							x.add(j - 1);
						}
						if (map[i - 1][j] == 9) {
							count++;
							System.out.println("countUP " + count + " " + i + " " + j);
							y.add(i - 1);
							x.add(j);
						}
						if (map[i - 1][j + 1] == 9) {
							count++;
							System.out.println("countUP " + count + " " + i + " " + j);
							y.add(i - 1);
							x.add(j + 1);
						}
						if (map[i][j - 1] == 9) {
							count++;
							System.out.println("countUP " + count + " " + i + " " + j);
							y.add(i);
							x.add(j - 1);
						}
						if (map[i][j + 1] == 9) {
							count++;
							System.out.println("countUP " + count + " " + i + " " + j);
							y.add(i);
							x.add(j + 1);
						}
						if (map[i + 1][j - 1] == 9) {
							count++;
							System.out.println("countUP " + count + " " + i + " " + j);
							y.add(i + 1);
							x.add(j - 1);
						}
						if (map[i + 1][j] == 9) {
							count++;
							System.out.println("countUP " + count + " " + i + " " + j);
							y.add(i + 1);
							x.add(j);
						}
						if (map[i + 1][j + 1] == 9) {
							count++;
							System.out.println("countUP " + count + " " + i + " " + j);
							y.add(i + 1);
							x.add(j + 1);
						}
						// 지뢰 갯수 찾기
						if (map[i - 1][j - 1] == 99 || map[i - 1][j] == 99 || map[i - 1][j + 1] == 99
								|| map[i][j - 1] == 99 || map[i][j + 1] == 99 || map[i + 1][j - 1] == 99
								|| map[i + 1][j] == 99 || map[i + 1][j + 1] == 99) {
							mineCount++;
							System.out.println("MinecountUP " + mineCount + " " + i + " " + j);

						}
					}
				}
				ArrayList<Coordinate> temp = new ArrayList();
				System.out.println("COUNT : " + count + " mid : " + mid + " mineCount : " + mineCount);
				if (count == mid - mineCount) {
					System.out.println("catch mines");

					viewMap();
					System.out.println();
					for (int n = 0; n < x.size(); n++) {
						System.out.println(oracle.getRemainedMines());
						System.out.println("위치 : " + j + " " + i);
						System.out.println("지뢰 위치 : " + x.get(n) + " " + y.get(n));
						System.out.println("범위안에 지뢰 갯수 : " + mineCount);
						System.out.println("범위안 모르는 갯수 : " + count);

						temp = oracle.actionPerform(x.get(n), y.get(n), 1);
						System.out.println(temp);
						oracle.currentStatus();
					}

				} else if (mineCount == mid) {
					System.out.println("catch not mines");

					viewMap();
					System.out.println();

					for (int n = 0; n < x.size(); n++) {
						temp = oracle.actionPerform(x.get(n), y.get(n), 0);
						oracle.currentStatus();
					}
				} else {
					place++;
					System.out.println("누를 곳이 없습니다. ");

				}
				if (!oracle.isGameOver())
					updateMap(temp);
			}

		}
	}

	// if (place == mapSize * mapSize)// 놓을 곳이 없다면 map에서 모르는곳 중애서 랜덤 클릭
	//
	// else // 놓을 곳이 있다면 계속 돌아가면서 지뢰 찾는다.

	// 맵업데이트
	public static void updateMap(ArrayList<Coordinate> a) {
		if (!a.isEmpty()) {
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
		for (int i = 0; i < 50; i++) {
			System.out.println("마인 찾기 시작 " + i);

			catchMines();
			oracle.currentStatus();
			oracle.printScore();

		}
		// }
	}
}
