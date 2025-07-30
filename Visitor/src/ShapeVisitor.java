interface ShapeVisitor {
    void visit(Circle circle);
    void visit(Triangle triangle);
    void visit(Rectangle rectangle);
}