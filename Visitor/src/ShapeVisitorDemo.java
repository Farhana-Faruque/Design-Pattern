public class ShapeVisitorDemo {
    public static void main(String[] args) {
        Shape[] shapes = {
                new Circle(5.0),
                new Triangle(4.0, 3.0),
                new Rectangle(6.0, 2.0)
        };

        AreaCalculatorVisitor areaVisitor = new AreaCalculatorVisitor();
        VolumeCalculatorVisitor volumeVisitor = new VolumeCalculatorVisitor(10.0);

        System.out.println("Calculating Areas:");
        for (Shape shape : shapes) {
            shape.accept(areaVisitor);
            System.out.printf("%s area: %.2f\n",
                    shape.getClass().getSimpleName(),
                    areaVisitor.getResult());
        }

        System.out.println("\nCalculating Volumes:");
        for (Shape shape : shapes) {
            shape.accept(volumeVisitor);
            System.out.printf("%s volume: %.2f\n",
                    shape.getClass().getSimpleName(),
                    volumeVisitor.getResult());
        }
    }
}