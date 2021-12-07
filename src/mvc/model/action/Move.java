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
public class Move implements PaintAction{
    Model model;
    Point2D[] p;
    MyShape shapeNew;
    MyShape shapeOld;
    
   public Move(Model model) {
        this.model = model;
        p = new Point2D[2];
    }

    public Move() {
        p = new Point2D[2];
    }

    @Override
    public MyShape actionPress(Point2D p1) {
       p[0]=p1;
       shapeNew =  model.acctionPressMove(p);
       if(shapeNew!=null)shapeOld = shapeNew.clone();
       return shapeNew;
    }

    @Override
    public void actionDrag(Point2D p1) {
        p[1] = p1;
        model.acctionDragMove(p);
    }

    @Override
    public void setModel(Model m) {
        model = m;
    }

    @Override
    public void execute() {
        Point2D oldP[] = new Point2D[2];
        oldP[0] = new Point2D.Double(shapeOld.getShape().getMinX(), shapeOld.getShape().getMinY());
        oldP[1] = new Point2D.Double(shapeOld.getShape().getMaxX(), shapeOld.getShape().getMaxY());
        shapeOld = shapeNew.clone();
        shapeNew.getShape().setFrameFromDiagonal(oldP[0],oldP[1]);
        model.reseverMove();
    }

    @Override
    public void unexecute() {
        Point2D oldP[] = new Point2D[2];
        oldP[0] = new Point2D.Double(shapeOld.getShape().getMinX(), shapeOld.getShape().getMinY());
        oldP[1] = new Point2D.Double(shapeOld.getShape().getMaxX(), shapeOld.getShape().getMaxY());
        shapeOld = shapeNew.clone();
        shapeNew.getShape().setFrameFromDiagonal(oldP[0],oldP[1]);
        model.reseverMove();
    }

    @Override
    public PaintAction clone() {
        Move d = new Move(model);
        d.shapeNew = shapeNew;
        d.shapeOld = shapeOld;
        d.p = p;
        return d;
    }
    
}
