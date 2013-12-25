package orig2011.v7;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ReversiScoreView implements PropertyChangeListener {

	@Override
	public void propertyChange(PropertyChangeEvent ev) {
		if(ev.getSource().getClass() == ReversiModel.class){
			// TODO Get scores
		}
		
	}

}
