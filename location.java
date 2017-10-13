package ai;

public class location {
	private int X;
	private int Y;

	// 생성자
	public location() {
		this.Y = 0;
		this.X = 0; 
	}
	public location(int X, int Y) {
		this.X = X;
		this.Y = Y;
	}

	// rol 반환
	public int getX() {
		return X;
	}

	// col 반환
	public int getY() {
		return Y;
	}

	public int setX(int num) {
		X += num;
		return X;
	}

	// col 반환
	public int setY(int num) {
		Y += num;
		return Y;
	}

	public String toString() {
		return "(" + X + ", " + Y + ")";
	}

}
