/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jones.general;

import jones.map.House;

/**
 *
 * @author dimid
 */
public class Player {
    
    private int _id;
    private String _name;
    private PlayerState _state;
    private PlayerGraphics _graphics;

    public Player (String name, PlayerGraphics graphics) {
    	 throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    boolean hasWon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setGoals(Goals goals) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }
    
    void startTurn() {
        _state.advanceWeeks();
        House home = _state.getHouse();
        _state.setPos(home.getPosition(), false);
    }

    public int getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public PlayerState getState() {
        return _state;
    }

    public PlayerGraphics getGraphics() {
        return _graphics;
    }
    
    public int clothesLevel () {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    void move(int x, int y) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    void move(Movement move) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    
    
            
}