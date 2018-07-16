    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //双向BFS法：
        
        
        //我的妈呀，一遍遍测试终于从1124ms提升到打败99%了，这一步真的关键啊
        //一定要提前把wordList转换成Set数据结构，因为LinkedList的查找是O(n)，而Set的查找是O(1)啊
        Set<String> dic = new HashSet<String>(wordList);
        
        //为什么要提前排除呢，这一步也非常重要，不然就是WA，因为之后的代码没办法排除endword本身不在wordList的情况
        if(!dic.contains(endWord)) return 0;
        
        
        HashSet<String> begin = new HashSet<>();
        HashSet<String> end = new HashSet<>();
        begin.add(beginWord);
        end.add(endWord);
        int step = 0;
        
        HashSet<String> visited = new HashSet<>();
        while(!begin.isEmpty() && !end.isEmpty()) {
        		step++;
        		if(begin.size() > end.size()) {
        			HashSet<String> tmp = begin;
        			begin = end;
        			end = tmp;
        		}
        		//我终于知道为什么以 'a'-'z' 26个字母展开迭代
        		//比在直接在wordList里查找与beginWrod只差一个字母的快得多了
        		//因为wordList的测试长度非常非常长，一个个去查找是非常花时间的
        		//虽然linkedList.contains时间复杂度也是o(n)...
        		HashSet<String> cur = new HashSet<>();
        		//System.out.println(end);
        		for(String word : begin) {
        			char[] wordchar = word.toCharArray();
        			for(int i = 0; i < word.length(); i++) {
        				//是<=z哦，不是<
        				for(char j='a'; j <='z'; j++) {
        					char old = wordchar[i];
        					wordchar[i] = j;
        					//这里有个细节是String.valueOf(wordchar)，不能使wordchar.toString()...
        					//不然又把wordchar给变回string了
        					String wordString = String.valueOf(wordchar);
                            if(end.contains(wordString)) {
            					return step+1;
            				}
        					if(dic.contains(wordString) && !visited.contains(wordString)) {
        						cur.add(wordString);
            					visited.add(wordString);
        					}
        					wordchar[i] = old;
        				}
        			}
        		}
        		begin = cur;
        }
        
    		return 0;
    }

// ======================================================================

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    //这是单向的BFS法，有一个重要的点是已经visited过的点肯定不能重复访问，不然路径肯定是要变长的，所以直接从wordList里删除就好
    //我之前用wordList主要用到了get(index)函数，但是这个事件复杂度是O(n),所以还是像双向BFS一样换成了set，set的contains真的方便
    Set<String> dic = new HashSet<String>(wordList);
    if(!dic.contains(endWord)) return 0;
    
    Queue<String> q = new LinkedList<>();
    q.add(beginWord);
    int step = 0;
    while(!q.isEmpty() && dic.size() > 0) {
            step++;
            int size = q.size();
            while(size > 0) {
                String cur = q.poll();
                char[] curchar = cur.toCharArray();
                for(int i = 0; i < curchar.length; i++) {
                    for(char j='a'; j<='z'; j++) {
                        char old = curchar[i];
                        curchar[i] = j;
                        String curstring = String.valueOf(curchar);
                        //比较两个string的时候一定要用equals不能用==
                        if(curstring.equals(endWord)) {
                            return step+1;
                        }else if(dic.contains(curstring)) {
                            q.add(curstring);
                            dic.remove(curstring);
                        }
                        curchar[i] = old;
                    }
                }
                size--;
            }   
    }
    return 0;
}

