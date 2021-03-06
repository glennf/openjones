/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jones.map;

import java.util.ArrayList;
import java.util.HashMap;
import jones.actions.Action;
import jones.general.Player;
import jones.general.PlayerState;
import jones.general.Position;
import jones.possessions.Possession;
import net.vivin.GenericTree;

/**
 * Allows the user to pawn items for quick cash.
 * In the first two weeks, the player may redeem them, and after that all players may buy them
 * @author dimid
 */
class PawnShop extends Building {

    /*
     *  Note: If multiplayer games are played simultaneously
     *  (each player doesn't wait for the others to finish their turn, and has his own week count),
     *  the pawnshop must synchronyzed (e/g/ protected by a lock) to prevent race conditions
     */
    
    private HashMap<Player, ArrayList<Possession>> _redeemables;
    private ArrayList<Possession> _buyables;
    
    public PawnShop(Position pos, String name) {
        super(pos,name);
        _redeemables = new HashMap<>();
        _buyables = new ArrayList<>();
       // _actions.add(new PawnAction);
        //TODO
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
