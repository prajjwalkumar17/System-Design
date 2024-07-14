package design_patterns;

/**
 * BuilderPattern
*/

class phone {
  public static void main(String[] args) {
    PhoneBuilder ph = new PhoneBuilder().setOs("android").setScreenSize(21).getPhone();
  }
}

class PhoneBuilder {
  public String Os;
  public int ScreenSize;
  public Float Camera;

  public PhoneBuilder() {
  }
  public PhoneBuilder setOs(String os) {
      Os = os;
      return this;
  }
  public PhoneBuilder setCamera(Float camera) {
      Camera = camera;
      return this;
  }
  public PhoneBuilder setScreenSize(int sc) {
      ScreenSize  = sc;
      return this;
  }
  public PhoneBuilder getPhone(){
    System.out.println("The phone is:\n" +Os +"\n"+ScreenSize+"\n"+Camera);
      return this;
  }
}
