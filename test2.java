package ai;

import java.util.ArrayList;

import mineSweeper.*;


public class test2 {
	static Oracle oracle = new Oracle(0);
	static int map[][] = new int[oracle.getBoardSize()][oracle.getBoardSize()];
	static int mapSize = oracle.getBoardSize();

	/*
	 * restart() 게임 재 시작 Method 게임 오버 및 클리어 후에는 자동으로 재 시작되지 않으므로 본 Method를 호출하여
	 * 재시작 시켜주어야 함
	 * 
	 * isGameOver() 현재 게임 상태를 반환 (Boolean type) 게임 오버 시에는 ture, 그렇지 않을 시 false
	 * 반환
	 * 
	 * gameBoardSize() 현재 게임 보드의 크기를 가져옴 (integer type) printScore() 지금까지 진행한
	 * 게임들의 Score를 출력
	 * 
	 * currentState() 현재 보드 상태를 콘솔에 출력 본 메소드는 자신의 프로그램이 정확히 작동하고 있는지 여부를 알아보기 위한
	 * 메소드로써, 디버그용임 현재 보드 상태 배열은 반환하지 않음 setMap(String filePath) 파일 경로를 받아 해당
	 * 경로의 파일을 읽어 맵을 생성 되도록 스테이지에 맞는 데이터를 주는걸 권장 (stage – stage 0: 8x8 10개,
	 * stage 1: 16x16 40개, stage 2: 32x32 150개)
	 * 
	 * actionPerform(int x, int y, int mine) 입력을 받아 그에 해당하는 출력을 반환하는 메소드 출력
	 * Type은 ArrayList<Coordinate> 임 좌표가 배열 크기를 벗어나거나 mine이 0, 1이 아닐 시에는 null을
	 * 반환하므로 주의 Coordinate Class Field: int x, int y, int value Constructor: new
	 * Coordinate(int x, int y, int value); Methods: getX() - return x getY() -
	 * return y getValue() - return value equals(Object c) - c와 비교하여 같은지 판단
	 * toString()
	 * 
	 * Value값 설명 해당 좌표 주위에 지뢰 없음: 0 해당 좌표 주위에 지뢰 있음: [주위에 있는 지뢰 수] 해당 좌표가 지뢰임:
	 * 99
	 */

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

				System.out.println(j + ", " + i);
				count = 0;
				mineCount = 0;
				mid = map[i][j];
				if (i > 0 && i < mapSize - 1 && j > 0 && j < mapSize - 1) {
					if (map[i][j] != 0 && map[i][j] != 9 && map[i][j] != 99) {
						// 중점기준 모르는 부분 찾기
						x = new ArrayList();
						y = new ArrayList();
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

						ArrayList<ArrayList> temp = new ArrayList<ArrayList>();
						System.out.println(" i 값 : " + i + " j 값 " + j);
						System.out.println("카운트 : " + count + " 중앙값 : " + mid + " 지뢰수 : " + mineCount);
						if (mineCount == mid) {
							System.out.println("catch not mines");

							for (int n = 0; n < x.size(); n++) {
								System.out.println("x축 y축 좌표 값 " + x.get(n) + " " + y.get(n));
							}
							for (int n = 0; n < x.size(); n++) {
								temp.add(oracle.actionPerform(x.get(n), y.get(n), 0));
								viewMap();
								oracle.currentStatus();
								System.out.println();
							}
							if (!temp.isEmpty()) {
								for (int n = 0; n < temp.size(); n++) {
									System.out.println("temp 출력 : " + temp.get(n));
									if (!temp.get(n).isEmpty())
										updateMap(temp.get(n));
								}
							}
							oracle.currentStatus();

						} else if (count == mid - mineCount) {
							System.out.println("catch mines");

							System.out.println();
							for (int n = 0; n < x.size(); n++) {
								System.out.println(oracle.getRemainedMines());
								System.out.println("위치 : " + j + " , " + i);
								System.out.println("지뢰 위치 : " + x.get(n) + " " + y.get(n));
								System.out.println("범위안에 지뢰 갯수 : " + mineCount);
								System.out.println("범위안 모르는 갯수 : " + count);

								temp.add(oracle.actionPerform(x.get(n), y.get(n), 1));
								System.out.println(temp);
								oracle.currentStatus();

							}
							if (!temp.isEmpty()) {
								for (int n = 0; n < temp.size(); n++) {
									System.out.println("temp 출력 : " + temp.get(n));
									if (!temp.get(n).isEmpty())
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
		}

	}

	// 맵업데이트
	public static void updateMap(ArrayList<Coordinate> a) {

		for (int i = 0; i < a.size(); i++) {
			map[a.get(i).getY()][a.get(i).getX()] = a.get(i).getValue();
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
