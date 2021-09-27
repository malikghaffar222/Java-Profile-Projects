package task1;

public class Video {
	private int id;
	private String title;
	private int duration;
	private String category;

	public Video(int id, String title, int duration, String category) {
		this.id = id;
		this.title = title;
		this.duration = duration;
		this.category = category;
	}

	public int getDuration() {
		return duration;
	}

	public String getCategory() {
		return category;
	}

	@Override
	public boolean equals(Object obj) {

		return id == ((Video) obj).id;
	}

	@Override
	public String toString() {
		return "\nVideo ID: " + id + "\nTitle: " + title + "\nDuration: " + duration + " seconds\nCategory: " + category;
	}
}
