import java.util.Random;

class RandomizedSet {

    HashMap<Integer, Integer> map;
    ArrayList<Integer> array;
    Random rand;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
        array = new ArrayList<>();
        rand = new Random();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)) return false;
        array.add(val);
        map.put(val, array.size()-1);
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int index = map.get(val);

        //swap the target with the last element
        if(index < array.size()-1){
            int e = array.get(array.size()-1);
            array.set(index, e);
            map.put(e, index);
        }
        array.remove(array.size()-1);
        map.remove(val);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        //注意这个rand.nextInt返回的是0 ~ size()-1, array.size()是maximum，到不了
        return array.get(rand.nextInt(array.size()));  
    }
}