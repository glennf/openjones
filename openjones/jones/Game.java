/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jones;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author dimid
 */
public class Game {
    
    public final int MAX_PLAYERS = 4;
    public final int WEEK_LIMIT = 600;

    private ArrayList <Player> _players;
    private ArrayList <Building> _buildings;
    private EventGenerator _eventGen;
    
    private int _curPlayerIndex;
    private Player _curPlayer;
    //private boolean [] _hasWon; //true if player met his goals
    private ArrayList <Player> _victors; // = new ArrayList<>;
    private Grid<Location> _grid;
    private EconomyModel _economy; //holds a list of stocks and updates them
    
    /**
     * Initializes the game. Adds Default buildings
     */
     
    public Game (Grid<Location> grid, ArrayList <Building> buildings) {
        if (null == grid) {
            _buildings = new ArrayList<>();
            addDefaultBuildings();
            _grid = getDefaultGrid(_buildings);
        }
        
        _players = new ArrayList<>();
         _victors = new ArrayList<>();
        
        _eventGen = new EventGenerator();
        
        _economy = new ConstantEconomyModel();
        addDefaultStocks();
        
        _curPlayerIndex = -1;
        _curPlayer = null;
        
    }
    
    private void addDefaultStocks() {
		// TODO Auto-generated method stub
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

	}

	/**
     * Adds a player to the game
     * @param p player
     * @return True iff added successfully
     */
    public boolean addPlayer (Player p) {
        if (_players.size() >= MAX_PLAYERS) {
            return false;
        }
        _players.add(p);
        return true;
    }
    
    /**
     * Move player to a different position.
     * If there's not enough time, end turn.
     * 
     * @param pos new position
     */
    public void movePlayer (PlayerPosition pos) {
        Action event = _eventGen.getRandomRoadEvent(_curPlayer);
        performAction(event, _curPlayer);
        
        Route route = Route.findRoute (_curPlayer.getState().getPos(), pos, _grid);
        ArrayList<Movement> path = route.getMovementSequence();
        Iterator<Movement> iter = path.iterator();
        while (hasTime() && iter.hasNext()) {
           Movement move =  iter.next();
           //updates clock
           _curPlayer.move(move);
        }
        if (!hasTime()) {
            endTurn();
        }
    }
    
    public void enterBuilding() {
        PlayerPosition pos = _curPlayer.getState().getPos();
        pos.enterBuilding();
        movePlayer(pos);
    }
 
    public void leaveBuilding() {
        PlayerPosition pos = _curPlayer.getState().getPos();
        pos.leaveBuilding();
        movePlayer(pos);
    }

    
    /**
     * Advances game to the next player`s turn.
     * @return True iff any player has won
     */
    
    public boolean endTurn() {
        
        // we check all players, even players who haven't this turn,
        // since they may win due to an economy change
        // (e.g. stocks rising, losing a job)
        for (Player p: _players) {
            if (p.hasWon()) {
                _victors.add(p);
            }
        }
        
        if (!_victors.isEmpty()) {
            return true;
        }
        
        _curPlayer = getNextPlayer();
        _curPlayer.startTurn(); //eat food, rent etc
        Action event = _eventGen.getRandomWeekendEvent(_curPlayer);
        performAction(event, _curPlayer);
        
        changeEconomy();
        return false;                
    }

    private Player getNextPlayer() {
        if (_players.isEmpty())
			return null;
		if (_players.size() - 1 >  _curPlayerIndex) {
			++_curPlayerIndex;
			return _players.get(_curPlayerIndex);
		}
		else {
			_curPlayerIndex = 0;
			return _players.get(_curPlayerIndex);
		}
						       
    }

    private void changeEconomy() {
        _economy.changeStocks();
        _economy.changeBuildings(_buildings); //prices + salaries 
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void addDefaultBuildings() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void performAction(Action event, Player _curPlayer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean hasTime() {
		return _curPlayer.getState().getHour() < WEEK_LIMIT;
    }

    private Grid<Location> getDefaultGrid(ArrayList<Building> _buildings) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
        
    
}