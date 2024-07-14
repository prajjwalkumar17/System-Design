package design_patterns;

/**
 * AdapterPattern
*/

class College {
  public static void main(String[] args) {
    // You got this from your friend
    PilotPen pp = new PilotPen();
    // You got a pen from the PilotPen which will help you to create your assignment
    Pen p = new PenAdapter(pp);
    Assignment a = new Assignment(p);
    a.write_assignment("Assignment for computer organization");
  }
}


// Required to write an assignment
interface Pen {
  public String write();
}

// You borrowed this from your friend as you/he didn't had pen
class PilotPen {
}

// Converts the PilotPen into the Pen required to write assignment
class PenAdapter implements Pen {
  PilotPen p;
  public PenAdapter(PilotPen p) {
    this.p = p;
  }
@Override
public String write() {
	return "writing";
}
}

// The work given by your college which requires a pen to be completed
class Assignment {
  Pen p;

  public Assignment(Pen p) {
    this.p = p;
  }

public void write_assignment(String assignment_content) {
    System.out.println("Assignment is being written from pen and the content is: "+assignment_content);
  }
}

