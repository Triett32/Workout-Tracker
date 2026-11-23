import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class WorkoutStorage {

	public void saveWorkout(Workout w) {
		try (BufferedWriter br = new BufferedWriter(new FileWriter("workouts.csv", true))) {
			br.write(w.getDate() + "," + w.getType() + "," + w.getDistance() + "," + w.getDuration());
			br.newLine();
		} catch (IOException e) {
			System.out.println("Could not save workout");
		}	
	}
}
