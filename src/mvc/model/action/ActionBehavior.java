/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mvc.model.action;

import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import mvc.model.Model;
import mvc.model.shape.MyShape;

/**
 *
 * @author Netbeans
 */
public enum ActionBehavior {
    Draw{
        

        @Override
        public MyShape actionPress(Model model, Point2D[] p) {
            return model.actionPressDraw(p);
        }

        @Override
        public MyShape actionDrag(Model model, Point2D[] p) {
            return model.acctionDragDraw(p);
        }

        @Override
        public MyShape execute(Model model,MyShape shape) {
            return model.executeDraw(shape);
        }

        @Override
        public MyShape unexecute(Model model,MyShape shape) {
            return model.unexecuteDraw();
        }
    },Move{
        

        @Override
        public MyShape actionPress(Model model, Point2D[] p) {
           return  model.acctionPressMove(p);
        }

        public MyShape actionDrag(Model model, Point2D[] p) {
            return model.acctionDragMove(p);
        }

        @Override
        public MyShape execute(Model model,MyShape shape) {
            model.reseverMove();
            return shape;
        }

        @Override
        public MyShape unexecute(Model model,MyShape shape) {
             model.reseverMove();
            return shape;
        }
    };
   
   
    public abstract MyShape actionPress(Model model,Point2D []p);
    public abstract MyShape actionDrag(Model model,Point2D []p);
    public abstract MyShape execute(Model model,MyShape shape);
    public abstract MyShape unexecute(Model model,MyShape shape);
    
}
