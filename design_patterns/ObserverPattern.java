package design_patterns;

/**
 * ObserverPattern
*/

import java.util.ArrayList;
import java.util.List;

class youtube {
  public static void main(String[] args) {
    Rejointech rejointech = new Rejointech();

    Pk pk = new Pk("Prajjwal");
    Pk harsh = new Pk("Harsh");
    Pk sumit = new Pk("Sumit");
    Pk honey = new Pk("Honey");

    rejointech.subscribe(pk);
    rejointech.subscribe(harsh);
    rejointech.subscribe(sumit);
    rejointech.subscribe(honey);

    pk.subscribeToChannel(rejointech);
    harsh.subscribeToChannel(rejointech);
    sumit.subscribeToChannel(rejointech);
    honey.subscribeToChannel(rejointech);

    rejointech.publish("How to learn programming");
  }

}
interface Publisher {
  // publish video
  public void publish(String title);

  // notify all the subscribers about the video being published
  public void notifySubscriber();

  // pull subscibers onboard
  public void subscribe(Pk s);

  // remove subscriber
  public void unsubscribe(Pk s);
}

interface Subscriber {
  // get updates about the published videos
  public void getUpdates();

  // subscribe to a channel
  public void subscribeToChannel(Rejointech c);
}

class Rejointech implements Publisher{
  String title;
  List<Pk> subs = new ArrayList<>();

  @Override
  public void publish(String title) {
    this.title = title;
    notifySubscriber();
  }

  @Override
  public void notifySubscriber() {
    for(Pk sub: subs) {
      sub.getUpdates();
    }
  }
   
  @Override
  public void subscribe(Pk s) {
    subs.add(s);
  }

  @Override
  public void unsubscribe(Pk s) {
    subs.remove(s);
  }
}
class Pk implements Subscriber{
  public String name;
  Rejointech c = new Rejointech();

  public Pk (String name) {
    this.name = name;
  }

  @Override
  public void getUpdates() {
    System.out.println("Video uploaded for: " +this.name+" with title "+c.title);
  }

  @Override
  public void subscribeToChannel(Rejointech c) {
    this.c = c;
  }

}

