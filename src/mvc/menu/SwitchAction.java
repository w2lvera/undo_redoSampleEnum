/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.menu;

import mvc.state.State;
import mvc.model.action.PaintAction;

/**
 *
 * @author Netbeans
 */
public class SwitchAction implements Command{
    PaintAction ab;
    State state;

    public SwitchAction(PaintAction ab, State state) {
        this.ab = ab;
        this.state = state;
    }

   
    @Override
    public void execute() {
        state.setAction(ab);
    }
    
}
