package lvt;

public class PointManager {
	private int points = 0;
	
	public void addPoints(int pointsToAdd) {
        points += pointsToAdd;
    }

    public int getPoints() {
        return points;
    }
    
    public void resetPoints() {
        points = 0;
    }
}
