import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		System.out.println("Welcome to Workout Tracker!");
		
		WorkoutStorage ws = new WorkoutStorage();

		ArrayList<Workout> workouts = ws.loadWorkouts();
		
		for (Workout workout : workouts) {
			workout.displayWorkout();
		}
	}
}
