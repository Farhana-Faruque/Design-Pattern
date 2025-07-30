class AreaCalculatorVisitor implements ShapeVisitor {
    private double result;

    public double getResult() {
        return result;
    }

    @Override
    public void visit(Circle circle) {
        result = Math.PI * circle.getRadius() * circle.getRadius();
    }

    @Override
    public void visit(Triangle triangle) {
        result = 0.5 * triangle.getBase() * triangle.getHeight();
    }

    @Override
    public void visit(Rectangle rectangle) {
        result = rectangle.getLength() * rectangle.getWidth();
    }
}