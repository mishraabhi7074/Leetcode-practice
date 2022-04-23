public class Codec {
    Map<String, String> map = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String key = ""+map.size();
        // created a key to encode the url
        /* we can also use the below line to gererate the key, the only difference is the key generation
        String key = ""+longUrl.hashCode();
        in the above line, we are using the hash of the url as the key */
        map.put(key, longUrl);
        // dumping the key into the map
        return key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.get(shortUrl);
        // we check the original url in the map
    }
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));