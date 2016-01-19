package baseline;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.interactions.Action;

public class MyCompositeAction implements Action {
	
	public MyCompositeAction()
    {
        actionsList = new ArrayList<Action>();
    }

    public void perform()
    {
        Action action;
        for(Iterator<Action> iterator = actionsList.iterator(); iterator.hasNext(); action.perform())
            action = (Action)iterator.next();

    }

    public MyCompositeAction addAction(Action action)
    {
        actionsList.add(action);
        return this;
    }

    public int getNumberOfActions()
    {
        return actionsList.size();
    }

    private List<Action> actionsList;

}
