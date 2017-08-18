package tools;

import java.awt.Robot;
import java.awt.event.InputEvent;

import utility.dateTime.DateTime;

public class MouseClick {
	public static void main(String[] argv) throws Exception {
	    Robot robot = new Robot();
	    
	    for (int i=0; i < 200; i++){
	    robot.mousePress(InputEvent.BUTTON1_MASK);
	    robot.mouseRelease(InputEvent.BUTTON1_MASK);
	    System.out.println("Click" + i);
	    DateTime.sleep(300000);
	    }
	  }

}
