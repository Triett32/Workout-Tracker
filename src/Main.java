public class Main {
	public static void main(String[] args) {
		System.out.println("Welcome to Workout Tracker!");
		Workout workout = new Workout("2026-11-23", "Run", 5.0, 45);
		workout.displayWorkout();
	}
}
