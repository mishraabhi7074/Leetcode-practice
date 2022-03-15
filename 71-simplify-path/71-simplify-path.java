class Solution {
    public static String simplifyPath(String path) {

        Stack<String> stack = new Stack<>();
        
        for (String token : path.split("/")) {
            if (token.equals("..")) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else if (!token.equals("") && !token.equals(".")) {
                stack.push(token);
            }
        }

        String canonical = new String();

        for (String token : stack) {
            canonical += ("/" + token);
        }

        return canonical.equals("") ? "/" : canonical;
    }
}