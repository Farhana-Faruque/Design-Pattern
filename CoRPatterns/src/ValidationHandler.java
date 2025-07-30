class ValidationHandler extends BaseHandler {
    public void handle(Request request) {
        System.out.println("Executing: ValidationHandler");

        if (request.requestType.equalsIgnoreCase("addproduct")) {
            if (request.body == null || !request.body.contains(",")) {
                System.out.println("Validation failed: Invalid body format. Use 'product,price'");
                return;
            }

            String[] parts = request.body.split(",");
            if (parts.length != 2) {
                System.out.println("Validation failed: Expected format 'product,price'");
                return;
            }

            try {
                String name = parts[0].trim();
                double price = Double.parseDouble(parts[1].trim());
                request.addProduct(name, price);
            } catch (NumberFormatException e) {
                System.out.println("Validation failed: Price must be a number.");
                return;
            }
        }

        super.handle(request);
    }
}