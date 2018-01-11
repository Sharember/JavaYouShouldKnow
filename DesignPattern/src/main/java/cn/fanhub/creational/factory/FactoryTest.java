package cn.fanhub.creational.factory;

import org.junit.Test;

/**
 * @author chengfan
 * @date 2018-1-11 23:43:22
 */
public class FactoryTest {

    @Test
    public void test() {
        Circle circle = (Circle) ShapeFactory.getShape(Circle.class);
        circle.draw();

        Square square = (Square) ShapeFactory.getShape(Square.class);
        square.draw();

        /**
         *
         * i am circle
         * i am square
         */
    }
}