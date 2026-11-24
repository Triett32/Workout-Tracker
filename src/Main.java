import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Welcome to Workout Tracker!");

		WorkoutStorage ws = new WorkoutStorage();

		Scanner scanner = new Scanner(System.in);

		int choice;
		
		do {

			System.out.println("1. Log a workout");
			System.out.println("2. View all workouts");
			System.out.println("3. View weekly statistics");
			System.out.println("4. Exit");

			System.out.print("Enter your choice: ");
			choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
				case 1 -> {
					System.out.print("Date (####-##-##): ");
					String date = scanner.nextLine();

					System.out.print("Workout type: ");
					String type = scanner.nextLine();

					System.out.print("Distance (miles): ");
					double distance = scanner.nextDouble();

					System.out.print("Duration (minutes): ");
					int duration = scanner.nextInt();

					ws.saveWorkout(new Workout(date, type, distance, duration));
					System.out.println("Workout saved");
				}

				case 2 -> {
					ArrayList<Workout> workouts = ws.loadWorkouts();
					
					if (workouts.isEmpty()) {
						System.out.println("No workouts found");
					} else {
						for (Workout workout : workouts) {
							workout.displayWorkout();
							System.out.println();
						}
					}
				}

				case 3 -> System.out.println("Viewing weekly stats...");

				case 4 -> System.out.println("Exiting...");

				default -> System.out.println("Not a choice");
			}
		} while (choice != 4);

		scanner.close();
	}
}
