import java.util.ArrayList;

import mineSweeper.*;

public class test {
	static Oracle oracle = new Oracle();
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
		int mid = 0;
		int count = 0;// 모르는 부분
		int mineCount = 0;
		ArrayList<Integer> x = new ArrayList<Integer>();
		ArrayList<Integer> y = new ArrayList<Integer>();

		/*
		 * ( i-1,j-1 )( i ,j-1 )( i+1,j-1 ) ( i-1, j )( i , j )( i+1, j )
		 * (i-1,j+1 )( i ,j+1 )( i+1,j+1 )
		 */

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {// 주위 actionperform 에서는 x,y가
													// 반대로 들어간다.
				// map[i][j]

				mid = map[i][j];
				if (i > 0 && i < map.length - 1 && j > 0 && j < map.length - 1) {
					if (map[i][j] > 0 && map[i][j] < 9) {
						for (int k = -1; k < 2; k++) {// 모르는 부분에 대한 갯수 파악
							for (int l = -1; l < 2; l++) {
								if (map[i + k][j + l] == 9) {
									count++;
									x.add(i + k);
									y.add(j + l);
								}
								if (map[i + k][j + l] == 99) {
									mineCount++;
								}
							}
						}
						if ((count - mineCount) == mid) {
							for (int n = 0; n < x.size(); n++) {
								System.out.println(oracle.getRemainedMines());
								updateMap(oracle.actionPerform(y.get(n),
										x.get(n), 1));
								System.out.println("catch mines");
							}
							oracle.currentStatus();
							viewMap();
						}

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
		// TODO Auto-generated method stub
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
			if (temp.size() > 3 || temp.isEmpty())
				loop = false;

		}
		viewMap();
		catchMines();
	}
}
