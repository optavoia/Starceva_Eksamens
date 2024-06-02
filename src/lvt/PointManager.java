package lvt;

import java.util.ArrayList;
import java.util.List;

public class PointManager {
	private int points = 0;
	private List<Integer> incQuestions = new ArrayList<>();
	
	
	public void addPoints(int pointsToAdd) {
        points += pointsToAdd;
    }

    public int getPoints() {
        return points;
    }
    
    public void resetPoints() {
        points = 0;
        incQuestions.clear();
    }
    
    public void addIncQuestion(int questionNumber) {
        incQuestions.add(questionNumber);
    }
    
    public List<Integer> getIncQuestions() {
        return new ArrayList<>(incQuestions);
    }
}
