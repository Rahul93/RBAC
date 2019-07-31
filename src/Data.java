import java.util.*;

public class Data {

    static private Map<String, Object> data = new HashMap<>();

    public static boolean addUser(User user) {
        List<User> users = (List<User>) data.get("user");
        if(users == null) {
            users = new ArrayList<>();
            data.put("user",users);
        }
        users.add(user);

        Map<String, List<ActionType>> resources = user.getAllResources();
        Set<String> cache = (Set<String>) data.get("cache");
        if(cache == null) {
            cache = new HashSet<>();
            data.put("cache", cache);
        }
        for(Map.Entry<String, List<ActionType>> resource : resources.entrySet()) {
            List<ActionType> currentActionTypes = resource.getValue();
            String resourceName = resource.getKey();
            for(ActionType actionType : currentActionTypes) {
                cache.add(user.getId()+"_"+resourceName+"_"+actionType);
            }
        }
        return true;
    }


    public static boolean search(User user, String actionType, String name) {
        String key = user.getId()+"_"+name+"_"+actionType;
        Set<String> cache = (Set<String>) data.get("cache");
        return cache.contains(key);
    }
}