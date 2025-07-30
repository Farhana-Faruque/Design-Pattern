class VolumeCalculatorVisitor implements ShapeVisitor {
    private double result;
    private double height;

    public VolumeCalculatorVisitor(double height) {
        this.height = height;
    }

    public double getResult() {
        return result;
    }

    @Override
    public void visit(Circle circle) {
        result = Math.PI * circle.getRadius() * circle.getRadius() * height;
    }

    @Override
    public void visit(Triangle triangle) {
        result = 0.5 * triangle.getBase() * triangle.getHeight() * height;
    }

    @Override
    public void visit(Rectangle rectangle) {
        result = rectangle.getLength() * rectangle.getWidth() * height;
    }
}
