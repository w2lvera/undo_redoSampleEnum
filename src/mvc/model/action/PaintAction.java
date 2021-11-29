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
public class PaintAction {

    Model model;
    Point2D[] p;
    Point2D[] pNew;
    Point2D[] pOld;
    MyShape shape;
    ActionBehavior ab;

    public PaintAction(ActionBehavior ab) {
        this.ab = ab;
        p = new Point2D[2];
        pNew = new Point2D[2];
        pOld = new Point2D[2];
        pOld[0] = new Point2D.Double();
        pOld[1] = new Point2D.Double();
        pNew[0] = new Point2D.Double();
        pNew[1] = new Point2D.Double();
    }

    public void setAb(ActionBehavior ab) {
        this.ab = ab;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public PaintAction() {
        p = new Point2D[2];
        pNew = new Point2D[2];
        pOld = new Point2D[2];
        pOld[0] = new Point2D.Double();
        pOld[1] = new Point2D.Double();
        pNew[0] = new Point2D.Double();
        pNew[1] = new Point2D.Double();

    }

    public MyShape getShape() {
        return shape;
    }

    public void actionPress(Point2D p) {
        this.p[0] = p;
        shape = ab.actionPress(model, this.p);
        pOld[0].setLocation(shape.getShape().getMinX(), shape.getShape().getMinY());
        pOld[1].setLocation(shape.getShape().getMaxX(), shape.getShape().getMaxY());

    }

    public void actionDrag(Point2D p1) {
        this.p[1] = p1;
        ab.actionDrag(model, this.p);
        

    }

    public void execute() {
       
        pNew[0].setLocation(shape.getShape().getMinX(), shape.getShape().getMinY());
        pNew[1].setLocation(shape.getShape().getMaxX(), shape.getShape().getMaxY());
        shape.getShape().setFrameFromDiagonal(pOld[0],pOld[1]);
        
        ab.execute(model, shape);
        
        pOld[0].setLocation(pNew[0]);
        pOld[1].setLocation(pNew[1]);

    }

    public void unexecute() {
        pNew[0].setLocation(shape.getShape().getMinX(), shape.getShape().getMinY());
        pNew[1].setLocation(shape.getShape().getMaxX(), shape.getShape().getMaxY());
        
        shape.getShape().setFrameFromDiagonal(pOld[0],pOld[1]);
                
        ab.unexecute(model, shape);
        pOld[0].setLocation(pNew[0]);
        pOld[1].setLocation(pNew[1]);

    }

    @Override
    public PaintAction clone() {
        PaintAction help = new PaintAction(this.ab);
        help.pOld[0] = (Point2D)pOld[0].clone();
        help.pOld[1] = (Point2D)pOld[1].clone();
        help.pNew[0] = (Point2D)pNew[0].clone();
        help.pNew[1] = (Point2D)pNew[1].clone();
        help.shape = shape;
        help.setModel(model);
        return help;
    }
}
