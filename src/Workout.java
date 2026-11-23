public class Workout {
	
	private String date;
	private String type;
	private double distance;
	private int duration;

	public Workout(String date, String type, double distance, int duration) {
		this.date = date;
		this.type = type;
		this.distance = distance;
		this.duration = duration;
	}

	public void displayWorkout() {
		System.out.println("Date: " + date);
		System.out.println("Type: " + type);
		System.out.println("Distance: " + distance + " miles");
		System.out.println("Duration: " + duration + " minutes");
	}
}
