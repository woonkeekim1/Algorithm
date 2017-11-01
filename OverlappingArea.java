public class OverlappingArea {
  public static void main(String[] args) {
    OverlappingArea area = new OverlappingArea();
    System.out.println(area.advertiseArea(
    700, 400, 1600, 1100, 0, 400, 1100, 900, 900, 0, 1800, 650
    ));
    System.out.println(area.advertiseArea(
    0, 0, 10, 10, 10, 10, 20, 20, 20, 20, 30, 30
    ));
  }

  //given 3 retangles, find area for first trectangle(x1, y1, x2, y2)
  // second and third area always overlap the first rectangle
  // input (x1, x1) -> bottom left of rectangle1
  //       (x2, y2) -> top right of rectangle1
  //       (x3, x3) -> bottom left of rectangle2
  //       (x4, y4) -> top right of rectangle2
  //       (x5, x5) -> bottom left of rectangle3
  //       (x6, y6) -> top right of rectangle3

  public int advertiseArea(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int x5, int y5, int x6, int y6) {
    int area = 0;
    //get area for ad A
    area = (x2 - x1) * (y2 - y1);

    //subtract duplicate area between ad A and ad B
    area -= getDupAreaBetweenTwoAds(x1, y1, x2, y2, x3, y3, x4, y4);
    //subtract duplicate area between ad A and ad C
    area -= getDupAreaBetweenTwoAds(x1, y1, x2, y2, x5, y5, x6, y6);

    //add all duplicate area among ad
    area += getDupAreaAmongAllAds(x1, y1, x2, y2, x3, y3, x4, y4, x5, y5, x6, y6);
    return area;
  }

  public int getDupAreaAmongAllAds(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4, int x5, int y5, int x6, int y6) {
    int minTopX = Math.min(x2, Math.min(x4, x6));
    int minTopY = Math.min(y2, Math.min(y4, y6));
    int maxBottomX = Math.max(x1, Math.max(x3, x5));
    int maxBottomY = Math.max(y1, Math.max(y3, y5));
    return Math.max(0, (minTopX - maxBottomX) * (minTopY - maxBottomY));
  }

  public int getDupAreaBetweenTwoAds(int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4) {
    int minTopX = Math.min(x2, x4);
    int minTopY = Math.min(y2, y4);
    int maxBottomX = Math.max(x1, x3);
    int maxBottomY = Math.max(y1, y3);
    return Math.max(0, (minTopX - maxBottomX) * (minTopY - maxBottomY));
  }
}
