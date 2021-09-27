package task1;

public class Channel {
	private String name;
	private int nbPlaylists;
	private Playlist[] playlists;

	public Channel(String name, int size) {
		this.name = name;
		playlists = new Playlist[size];
	}

	public boolean addPlaylist(Playlist p) {
		if (nbPlaylists >= playlists.length || this.toString().contains(p.toString()))
			return false;
		playlists[nbPlaylists++] = p;
		return true;
	}

	public boolean deletePlaylist(Playlist p) {
		if (nbPlaylists == 0)
			return false;
		for (int i = 0; i < nbPlaylists; i++) {
			if (playlists[i].equals(p)) {
				playlists[i] = playlists[--nbPlaylists];
				playlists[--nbPlaylists] = null;
				return true;
			}
		}
		return false;
	}

	public boolean flipSharedStatusOf(Playlist p) {
		if (p.isShared())
			p.setShared(false);
		else
			p.setShared(true);
		return p.isShared();
	}

	public Playlist getPlaylist(String category) {
		if (nbPlaylists == 0)
			return null;
		Playlist maxPlaylist = playlists[0];
		for (int i = 1; i < nbPlaylists; i++) {
			if (playlists[i].countVideosOf(category) > maxPlaylist.countVideosOf(category))
				maxPlaylist = playlists[i];
		}
		return maxPlaylist;
	}

	public void sortPlaylists() {
		if (nbPlaylists == 0)
			return;
		for (int i = 0; i < nbPlaylists; i++) {
			playlists[i].sortOnDuration();
		}
	}

	@Override
	public boolean equals(Object obj) {
		return name.equals(((Channel) obj).name);
	}

	@Override
	public String toString() {
		if (nbPlaylists == 0)
			return "\n***Channel Name: " + name + "***\n--------------------------------------------------";
		String buf = "\n***Channel Name: " + name + "***\n--------------------------------------------------";
		for (int i = 0; i < nbPlaylists; i++) {
			buf += playlists[i].toString();
		}
		return buf + "\n";
	}
}
