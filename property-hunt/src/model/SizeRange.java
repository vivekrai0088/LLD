package model;

public class SizeRange {
  private int sizeStart;
  private int sizeEnd;
  private SizeUnit sizeUnit;

  public SizeRange(int sizeStart, int sizeEnd) {
    this.sizeStart = sizeStart;
    this.sizeEnd = sizeEnd;
  }

  public int getSizeStart() {
    return this.sizeStart;
  }

  public int getSizeEnd() {
    return this.sizeEnd;
  }
}
