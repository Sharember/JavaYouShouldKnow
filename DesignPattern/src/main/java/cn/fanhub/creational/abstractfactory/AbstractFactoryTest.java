package cn.fanhub.creational.abstractfactory;

import cn.fanhub.creational.abstractfactory.base.Circle;
import cn.fanhub.creational.abstractfactory.base.Color;
import cn.fanhub.creational.abstractfactory.base.Red;
import cn.fanhub.creational.abstractfactory.base.Shape;
import cn.fanhub.creational.abstractfactory.generics.ColorFactoryGenerics;
import cn.fanhub.creational.abstractfactory.generics.FactoryProducerGenerics;
import cn.fanhub.creational.abstractfactory.generics.ShapeFactoryGenerics;
import org.junit.Test;

public class AbstractFactoryTest {
    @Test
    public void testSimple() {
        Red red  = ((Red) ((ColorFactory) FactoryProducer.getFactory(ColorFactory.class)).getColor(Red.class));
        red.fill();

        Circle circle = ((Circle) ((ShapeFactory) FactoryProducer.getFactory(ShapeFactory.class)).getShape(Circle.class));

        circle.draw();

        /**
         * fill red
         * i am circle
         */
    }

    @Test
    public void testGenerics() {
        Color red = FactoryProducerGenerics.getFactory(ColorFactoryGenerics.class).getColor(Red.class);
        red.fill();

        Shape circle = FactoryProducerGenerics.getFactory(ShapeFactoryGenerics.class).getShape(Circle.class);
        circle.draw();
        /**
         *
         * fill red
         * i am circle
         */
    }
}