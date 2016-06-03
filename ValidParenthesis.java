public class ValidParenthesis {
    public boolean isValid(String s) {
        HashMap<Character,Character> alphabet = new HashMap<>();
        alphabet.put('(',')');
        alphabet.put('{','}');
        alphabet.put('[',']');
        Stack<Character> stack = new Stack<>();
        char[]  st = s.toCharArray();
        for(int i =0; i< st.length;i++){
            if(alphabet.containsKey(st[i])){
                stack.push(st[i]);
            }
            else{
                if(!stack.empty()){
                     Character c = stack.pop();
                     if(alphabet.get(c.charValue()) != st[i]) return false;
                }
                else{
                    return false;
                }

            }
        }
        return stack.empty();

    }
}
