package task1;

public class Playlist {
	private String name;
	private boolean shared;
	private Video[] videos;
	private int nbVideos;

	public Playlist() {
	}

	public Playlist(String name, boolean shared, int size) {
		this.name = name;
		this.shared = shared;
		videos = new Video[size];
	}

	public boolean addVideo(Video v) {
		if (nbVideos >= videos.length || this.toString().contains(v.toString()))
			return false;
		videos[nbVideos++] = v;
		return true;
	}

	public boolean removeVideo(Video v) {
		if (nbVideos == 0)
			return false;
		for (int i = 0; i < nbVideos; i++) {
			if (videos[i].equals(v)) {
				for (int j = i; j < nbVideos - 1; j++) {
					videos[j] = videos[j + 1];
				}
				videos[--nbVideos] = null;
				return true;
			}
		}
		return false;
	}

	public int countVideosOf(String category) {
		if (nbVideos == 0)
			return 0;
		int count = 0;
		for (int i = 0; i < nbVideos; i++) {
			if (videos[i].getCategory().equals(category))
				count++;
		}
		return count;
	}

	public void sortOnDuration() {
		if (nbVideos == 0)
			return;
		for (int i = 0; i < nbVideos; i++) {
			for (int j = 0; j < nbVideos - i - 1; j++) {
				if (videos[j].getDuration() > videos[j + 1].getDuration()) {
					Video temp = videos[j];
					videos[j] = videos[j + 1];
					videos[j + 1] = temp;
				}
			}
		}
	}

	public String getName() {
		return name;
	}

	public boolean isShared() {
		return shared;
	}

	public void setShared(boolean shared) {
		this.shared = shared;
	}

	@Override
	public boolean equals(Object obj) {
		return name.equals(((Playlist) obj).getName());
	}

	@Override
	public String toString() {
		if (nbVideos == 0)
			return "\n*Playlist Name: " + name + "*\n-----------------------------";
		String buf = "\n*Playlist Name: " + name + "*\n-----------------------------";
		for (int i = 0; i < nbVideos; i++) {
			buf += videos[i].toString();
		}
		return buf + "\n";
	}

}
