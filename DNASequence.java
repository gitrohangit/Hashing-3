// Time Complexity : O(20*n), for finding substring, checking in hashmap
// Space Complexity :  O(2n)
// Did this code successfully run on Leetcode : yes
//approach : find all substrings and add them in hashset

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> allSubs = new HashSet<>();
        Set<String> result = new HashSet<>();
        int n = s.length();
        if(n < 10){
            return new ArrayList<>();
        }
        for(int i = 0 ; i <= n - 10; i++){
            String sub = s.substring(i, i+10);
            if(!allSubs.contains(sub)){
                allSubs.add(sub);
            }
            else{
                result.add(sub);
            }  
        }

        return new ArrayList<>(result);
    }
}

//Robin Carb rolling hash
// Time Complexity : O(n)

//approach: find hashes based on incoming and outgoing character

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('A', 1);map.put('C', 2);map.put('G', 3);map.put('T', 4);

        Set<Long> hashes = new HashSet<>();
        Set<String> result = new HashSet<>();
        int n = s.length();
        long hash = 0l;
        long kl = (long)Math.pow(4, 9); // value of out Character
        
        for(int i = 0; i < n; i++){
            //out character
            if(i >= 10){
                hash = hash - (map.get(s.charAt(i-10)) * kl);
            }
            //in character
            hash = (hash * 4) + map.get(s.charAt(i));

            if(hashes.contains(hash)){
                result.add(s.substring(i-9,i+1));
            }
            else{
                hashes.add(hash);
            }
            
        }

        return new ArrayList<>(result);
    }
}
