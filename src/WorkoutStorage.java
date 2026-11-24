import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class WorkoutStorage {

	public void saveWorkout(Workout w) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("workouts.csv", true))) {
			bw.write(w.getDate() + "," + w.getType() + "," + w.getDistance() + "," + w.getDuration());
			bw.newLine();
		} catch (IOException e) {
			System.out.println("Could not save workout");
		}	
	}

	public ArrayList<Workout> loadWorkouts() {
		ArrayList<Workout> workouts = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader("workouts.csv"))) {
			String s;
			while ((s = br.readLine()) != null) {
				String[] str = s.split(",");
				workouts.add(new Workout(str[0], str[1], Double.parseDouble(str[2]), Integer.parseInt(str[3])));
			}
		} catch (IOException e) {
			System.out.println("Could not load workouts");
		}
		return workouts;
	}	
}
