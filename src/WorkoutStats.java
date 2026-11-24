import java.util.ArrayList;
import java.time.LocalDate;

public class WorkoutStats {

	public void displayWeeklyStats(ArrayList<Workout> workouts) {
		LocalDate today = LocalDate.now();
		int todayNum = today.getDayOfWeek().getValue();
		LocalDate startOfWeek = today.minusDays(todayNum - 1);
		LocalDate endOfWeek = startOfWeek.plusDays(6);
		
		System.out.println("Today: " + today);
		System.out.println("Start of week: " + startOfWeek);
		System.out.println("End of week: " + endOfWeek);

		double runDistance = 0;
		int runDuration = 0;
		int runCount = 0;

		double bikeDistance = 0;
		int bikeDuration = 0;
		int bikeCount = 0;

		double swimDistance = 0;
		int swimDuration = 0;
		int swimCount = 0;

		int strengthDuration = 0;
		int strengthCount = 0;

		for (Workout workout : workouts) {
			LocalDate workoutDate = LocalDate.parse(workout.getDate());

			if (!workoutDate.isBefore(startOfWeek) && !workoutDate.isAfter(endOfWeek)) {
				if (workout.getType().trim().equalsIgnoreCase("Run")) {
					runDistance += workout.getDistance();
					runDuration += workout.getDuration();
					runCount++;
				} else if (workout.getType().trim().equalsIgnoreCase("Swim")) {
					swimDistance += workout.getDistance();
					swimDuration += workout.getDuration();
					swimCount++;
				} else if (workout.getType().trim().equalsIgnoreCase("Bike")) {
					bikeDistance += workout.getDistance();
					bikeDuration += workout.getDuration();
					bikeCount++;
				} else if (workout.getType().trim().equalsIgnoreCase("Strength")) {
					strengthDuration += workout.getDuration();
					strengthCount++;
				}
			}
		}

		System.out.println("===== Overall Weekly Statistics =====");
		System.out.println("Total workouts: " + (runCount + bikeCount + swimCount + strengthCount));
		System.out.println("Total distance: " + (runDistance + bikeDistance + swimDistance + " miles"));
		System.out.println("Total duration: " + (runDuration + bikeDuration + swimDuration + strengthDuration + " minutes"));

		System.out.println();
		
		System.out.println("===== Running Statistics =====");
		System.out.println("Total runs: " + runCount);
		System.out.println("Total distance: " + runDistance + " miles");
		System.out.println("Total duration: " + runDuration + " minutes");
		
		System.out.println();
		
		System.out.println("===== Biking Statistics =====");
                System.out.println("Total rides: " + bikeCount);
                System.out.println("Total distance: " + bikeDistance + " miles");  
                System.out.println("Total duration: " + bikeDuration + " minutes");

		System.out.println();

		System.out.println("===== Swim Statistics =====");
                System.out.println("Total swims: " + swimCount);
                System.out.println("Total distance: " + swimDistance + " miles");  
                System.out.println("Total duration: " + swimDuration + " minutes");

		System.out.println();

		System.out.println("===== Strength Statistics =====");
                System.out.println("Total sessions: " + strengthCount);  
                System.out.println("Total duration: " + strengthDuration + " minutes");
	}
}
