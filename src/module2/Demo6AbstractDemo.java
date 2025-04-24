package module2;

/**
 * 抽象类
 */
public class Demo6AbstractDemo {
    public static void main(String[] args) {
//        Shape shape = new Shape();
        Circle circle = new Circle(5);
        System.out.println("circle.calculateArea() = " + circle.calculateArea());
        System.out.println("circle.calculatePerimeter() = " + circle.calculatePerimeter());
        circle.display();

        Rectangle rectangle = new Rectangle(5, 6);
        System.out.println("rectangle.calculateArea() = " + rectangle.calculateArea());
        System.out.println("rectangle.calculatePerimeter() = " + rectangle.calculatePerimeter());
        rectangle.display();
    }
}


/**
 * 矩形
 */
class Rectangle extends Shape{

    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return 0;
    }

    @Override
    public double calculatePerimeter() {
        return 0;
    }
}

/**
 * 圆形
 */
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void display() {
        System.out.println("这个是一个半径为" + radius + "的圆");
    }
}


// 定义一个抽象类，叫做形状
abstract class Shape {
    // 定义抽象方法，但凡是个形状，就应该能够计算面积。
    // 但是，形状没有确定之前，面积的计算方式无法确定，所以这只能是个抽象方法。
    public abstract double calculateArea();

    // 计算周长
    public abstract double calculatePerimeter();

    public void display() {
        System.out.println("这是一个抽象的形状");
    }

}

