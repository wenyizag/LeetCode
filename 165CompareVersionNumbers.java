    public int compareVersion(String version1, String version2) {
        //这个题还蛮多陷阱的，比如"."是特殊字符，需要用两分隔符把它分隔开。。
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        
        
        int vr1, vr2;
        for(int i = 0 ; i < v1.length || i < v2.length; i++){
            vr1 = 0; vr2 = 0;
            //其次是为什么选择parseInt而不选择s.equals()，因为可能有"01", "1"这样的test case，它们也是相等的；
            //还有"1.0"和"1",所以数组的长度也得按照长的那一个算
            if(i < v1.length) vr1 = Integer.parseInt(v1[i]);
            if(i < v2.length) vr2 = Integer.parseInt(v2[i]);
            if(vr1 != vr2){
                return vr1 > vr2 ? 1 : -1;
            }
        }
        return 0;
    }