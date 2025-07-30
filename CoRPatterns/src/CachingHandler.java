import java.util.*;
class CachingHandler extends BaseHandler {
    private static List<String> cachedRequestIds = new ArrayList<>();
    private static List<String> cachedUserIds = new ArrayList<>();

    public void handle(Request request) {
        System.out.println("Executing: CachingHandler");

        switch (request.requestType.toLowerCase()) {
            case "addproduct":
                System.out.println("This handler doesn't handle addproduct requests.");
                break;

            case "getproducts":
                boolean isCached = false;

                for (String id : cachedRequestIds) {
                    if (id.equals(request.requestid)) {
                        isCached = true;
                        break;
                    }
                }

                if (!isCached) {
                    for (String uid : cachedUserIds) {
                        if (uid.equals(request.userid)) {
                            isCached = true;
                            break;
                        }
                    }
                }

                if (isCached) {
                    if (ProductStore.products.isEmpty()) {
                        System.out.println("No products available (cached).");
                    } else {
                        System.out.println("Available products (from cache):");
                        for (String p : ProductStore.products) {
                            System.out.println("- " + p);
                        }
                    }
                } else {
                    System.out.println("Request not cached. Skipping getproducts for requestid: " + request.requestid);
                }

                if (!cachedRequestIds.contains(request.requestid)) {
                    cachedRequestIds.add(request.requestid);
                    System.out.println("Caching requestid for the first time: " + request.requestid);
                }
                if (!cachedUserIds.contains(request.userid)) {
                    cachedUserIds.add(request.userid);
                    System.out.println("Caching userid for the first time: " + request.userid);
                }

                break;

            default:
                System.out.println("CachingHandler does not handle request type: " + request.requestType);
        }
    }
}