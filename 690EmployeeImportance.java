    //题目看上去比较吓人，其实比较简单，就是一个把原本的输入转化成图，用hashmap储存，然后再用dfs求解
    HashMap<Integer, Employee> map = new HashMap<>();
    int ans;
    public int getImportance(List<Employee> employees, int id) {
        for(Employee cur : employees){
            map.put(cur.id, cur);
        }
        dfs(id);
        return ans;
    }
    public void dfs(int id){
        ans += map.get(id).importance;
        for(Integer cur : map.get(id).subordinates){
            dfs(cur);
        }
        return;
    }