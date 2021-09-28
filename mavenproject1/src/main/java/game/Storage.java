package game;


import java.io.FileNotFoundException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author p0074487
 */
public interface Storage {
    public void save (String name) throws FileNotFoundException;
    public void load(String name) throws FileNotFoundException;
    
}
