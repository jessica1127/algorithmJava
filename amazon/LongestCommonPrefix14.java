public class LongestCommonPrefix14{
    public String longestCommonPrefix(String[] strs) {
         if (strs.length==0) return "";
        String prefix=strs[0];
        for(int i=1; i<strs.length; i++){
            System.out.println("000prefix= " + prefix + "; strs[i].indexOf== " + strs[i].indexOf(prefix) + "; ==" + strs[0].indexOf("flower"));

            while(strs[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length()-1);

                if(prefix.isEmpty()) return "";
            }
            
        }
        return prefix;
    }
    public static void main(String[] args){
        String[] input = {"flower","flow","flght"};
        LongestCommonPrefix14 longestCommonPrefix = new LongestCommonPrefix14();
        String res = longestCommonPrefix.longestCommonPrefix(input);
        System.out.println(res);
    }
}