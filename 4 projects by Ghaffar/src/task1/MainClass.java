package task1;

public class MainClass {

	public static void main(String[] args) {
		Playlist playlist = new Playlist("X", true, 5);
		playlist.addVideo(new Video(23, "A", 40, "Sad Song"));
		playlist.addVideo(new Video(89, "C", 120, "Comedy"));
		playlist.addVideo(new Video(12, "D", 150, "Comedy"));
		playlist.addVideo(new Video(3, "B", 20, "Meme"));

		Playlist playlist2 = new Playlist("Y", true, 5);
		playlist2.addVideo(new Video(23, "K", 55, "Folk Song"));
		playlist2.addVideo(new Video(89, "J", 50, "Meme"));

		Channel channel = new Channel("ATV", 5);
		channel.addPlaylist(playlist);
		channel.addPlaylist(playlist2);
		
		System.out.println(channel);

	}

}
