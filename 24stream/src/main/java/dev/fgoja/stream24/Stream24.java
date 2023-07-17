package dev.fgoja.stream24;

public class Stream24 {
    public String GetHTML(String brand,
                          String productId,
                          String retailerDomain,
                          String templateType){
        return GetHTML(brand, productId, retailerDomain, templateType, Stream24ResultType.html, Stream24ContentType.shopInShops);
    }
    public String GetHTML(String brand,
                          String productId,
                          String retailerDomain,
                          String templateType,
                          Stream24ResultType resultType){
        return GetHTML(brand, productId, retailerDomain, templateType, resultType, Stream24ContentType.shopInShops);
    }
    public String GetHTML(String brand,
                          String productId,
                          String retailerDomain,
                          String templateType,
                          Stream24ContentType contentType){
        return GetHTML(brand, productId, retailerDomain, templateType, Stream24ResultType.html, contentType);
    }
    public String GetHTML(  String brand,
                            String productId,
                            String retailerDomain,
                            String templateType,
                           Stream24ResultType resultType,
                           Stream24ContentType contentType){

        return String.format("  <!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "<meta charset=\"UTF-8\">" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1, maximum-scale=1\" />" +
                "<title>24 Stream</title>" +
                "</head>" +
                "<body>" +
                "<div class=\"wrapper\"></div>" +
                "<script>(function (w, d, s, o) { var f = d.getElementsByTagName(s)[0]; var j = d.createElement(s); w.TTLStreamReady = new Promise((resolve) => { j.async = true; j.src = 'https://content.24ttl.stream/widget.js'; f.parentNode.insertBefore(j, f); j.onload = function () { w.ttlStream = new TTLStream(o); resolve(w.ttlStream); }; }); })(window, document, 'script', {}); </script>" +
                "<script>" +
                "const parameters = { \"brand\": \"%s\", \"productId\": \"%s\", \"retailerDomain\": \"%s\", \"templateType\": \"%s\", \"resultType\": \"%s\", \"contentType\": \"%s\", \"el\": \".wrapper\", \"windowMode\": \"self\" }\n" +
                "TTLStreamReady.then(() => { ttlStream.findAndInsert(parameters); }); </script>" +
                "</body>" +
                "</html>", brand, productId, retailerDomain, templateType, _getContentType(contentType), _getResultType(resultType));
    }
    static String _getContentType(Stream24ContentType contentType) {
        switch (contentType) {
            case shopInShops:
                return "sis";
            default:
                return "minisite";
        }
    }

    static String _getResultType(Stream24ResultType resultType) {
        switch (resultType) {
            case json:
                return "json";
            case iframe:
                return "iframe";
            default:
                return "html";
        }
    }


    enum Stream24ContentType { shopInShops, minisite }

    enum Stream24ResultType { html, json, iframe }

}
