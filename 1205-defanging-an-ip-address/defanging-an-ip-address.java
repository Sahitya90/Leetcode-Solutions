class Solution {
    public String defangIPaddr(String address) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i<address.length(); i++){

            char characterAtCurrentIndex = address.charAt(i);
            if(characterAtCurrentIndex =='.'){
                sb.append("[.]");
            }else{
                sb.append(characterAtCurrentIndex);
            }
        }
        return sb.toString();
    }
}