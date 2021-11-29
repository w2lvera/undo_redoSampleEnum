/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.action;

import java.awt.geom.Point2D;
import mvc.model.Model;
import mvc.model.shape.MyShape;

/**
 *
 * @author Netbeans
 */
public class Draw implements PaintAction{
    Model model;
    Point2D[] p;
    MyShape myShape;
    
    public Draw(Model model) {
        this.model = model;
        p = new Point2D[2];
    }

    public Draw() {
       p = new Point2D[2]; 
    }
    @Override
    public void actionPress(Point2D p1) {
        p[0] = p1;
        myShape = model.actionPressDraw(p);
    }

    @Override
    public void actionDrag(Point2D p1) {
        p[1] = p1;
        myShape = model.acctionDragDraw(p);
    }

    @Override
    public void setModel(Model m) {
        model = m;
    }

    @Override
    public void execute() {
        myShape = model.executeDraw(myShape);
    }

    @Override
    public void unexecute() {
        myShape = model.unexecuteDraw();
    }

    @Override
    public PaintAction clone() {
        Draw d = new Draw(model);
        d.myShape = myShape;
        d.p = p;
        return d;
    }
    
}
