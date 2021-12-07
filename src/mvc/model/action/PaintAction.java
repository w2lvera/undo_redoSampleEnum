/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.action;


import mvc.model.Model;
import mvc.model.shape.MyShape;
import java.awt.geom.Point2D;

/**
 *
 * @author Wera
 */
public interface PaintAction {
   MyShape actionPress(Point2D p1);
    void actionDrag(Point2D p1);
    void setModel(Model m);
    void execute();
    void unexecute();
    PaintAction clone();
}
