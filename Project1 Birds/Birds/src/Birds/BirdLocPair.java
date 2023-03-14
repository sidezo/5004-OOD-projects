package Birds;

public class BirdLocPair {
    private Birds bird;
    private String location;

    public BirdLocPair(Birds bird, String location) {
      this.bird = bird;
      this.location = location;
    }
    public Birds getBird() {
      return bird;
    }
    public String getLocation() {
        return location;
 }
}