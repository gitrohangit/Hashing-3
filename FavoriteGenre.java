// Time Complexity : O(s),  s= for adding all songs, 2g : for counting the fav genre of each user and u for traversing over users
// Space Complexity :  O(s + g)  , g will small
// Did this code successfully run on Leetcode : yes
//Approach : Find Genre of each songs, then find fav genre of each user.

// "static void main" must be defined in a public class.
public class Main {
    public static Map<String, List<String>> favoritegenre(Map<String, List<String>> userMap, Map<String, List<String>> genreMap) {
        Map<String,String> songGenre = new HashMap<>();
        for(Map.Entry<String, List<String>> entry : genreMap.entrySet()){
            String genre = entry.getKey();
            for(String song : entry.getValue()){
                songGenre.put(song,genre);
            }
        }
        
        Map<String, Integer> countMap;
        Map<String, List<String>> res = new HashMap<>();
        
        for(Map.Entry<String, List<String>> entry : userMap.entrySet()){
            countMap = new HashMap<>();
            int max = 0;
            String user = entry.getKey();
            for(String song : entry.getValue()){
                String genre = songGenre.get(song);
                countMap.put(genre, countMap.getOrDefault(genre,0)+1);
                max = Math.max(max, countMap.get(genre));
            }
            
            for(Map.Entry<String, Integer> element : countMap.entrySet()){
                String genre = element.getKey();
                if(element.getValue() == max){
                    res.put(user, res.getOrDefault(user,new ArrayList<String>()));
                    res.get(user).add(genre);
                }
            }
        }
        // userMap.forEach((user,songs) -> {
        //     for(String song : songs){
        //         String genre = songGenre.get(song);
        //         countMap.put(genre, countMap.getOrDefault(genre,0)+1);
        //         max = Math.max(max, countMap.get(genre));
        //     }
        //     // String user = key;
        //     countMap.forEach((genre,count) -> {
        //         if(count == max){
        //             res.put(user, res.getOrDefault(user,new ArrayList<String>()));
        //             res.get(user).add(genre);
        //         }
        //     });
        // });
        
        
        return res;
}

public static void main(String[] args) {
        HashMap<String, List<String>> userSongs = new HashMap<>();

        userSongs.put("David", Arrays.asList(new String[]{"song1", "song2", "song3", "song4", "song8"}));

        userSongs.put("Emma", Arrays.asList(new String[]{"song5", "song6", "song7"}));

        HashMap<String, List<String>> genreSong = new HashMap<>();

        genreSong.put("Rock", Arrays.asList(new String[]{"song1", "song3"}));

        genreSong.put("Dubstep", Arrays.asList(new String[]{"song7"}));

        genreSong.put("Techno", Arrays.asList(new String[]{"song2", "song4"}));

        genreSong.put("Pop", Arrays.asList(new String[]{"song5", "song6"}));

        genreSong.put("Jazz", Arrays.asList(new String[]{"song8", "song9"}));

        Map<String, List<String>> res = favoritegenre(userSongs, genreSong);

        System.out.println(res);
    }
}