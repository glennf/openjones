/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jones.map;

import jones.actions.Action;
import jones.general.Player;
import jones.general.PlayerState;
import jones.general.Position;
import net.vivin.GenericTree;

/**
 *
 * @author dimid
 */
class DepartmentStore extends Building {

    public DepartmentStore(Position pos, String name) {
        super(pos,name);
    }

	@Override
	protected void buildActionsTree(PlayerState player, GenericTree<Action> actionsTree) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void addJobs() {
		// TODO Auto-generated method stub
		
	}
    
}
