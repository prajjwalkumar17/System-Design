package design_patterns;

/**
 * FactoryPattern
 */

class MobileStore{
  public static void main(String[] args) {
    Factory phone_factory = new Factory();
    OperatingSystem os = phone_factory.getOpratingSystem("flexible");
    os.spec();
  }
}

interface OperatingSystem {
  public void spec();
}

class Android implements OperatingSystem {
  @Override
  public void spec() {
      System.out.println("Most flexible OS");
  }
}

class Ios implements OperatingSystem {
  @Override
  public void spec() {
      System.out.println("Most secure OS");
  }
}

class Windows implements OperatingSystem {
  @Override
  public void spec() {
      System.out.println("Not widely used OS");
  }
}

class Factory {
  public OperatingSystem getOpratingSystem(String s) {
    switch (s) {
      case "secure": return new Ios();
      case "flexible": return new Android();
      case "windows": return new Windows();
      default: return new Android();
    }
  }
}
