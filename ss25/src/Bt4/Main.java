package Bt4;

public class Main {
    public static void main(String[] args) {
        MediaPlayer player = new Adapter();

        player.play("mp4", "movie.mp4");
        player.play("vlc", "song.vlc");
        player.play("avi", "video.avi");
    }
}