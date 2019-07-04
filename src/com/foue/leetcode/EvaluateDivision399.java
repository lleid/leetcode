package com.foue.leetcode;

import java.util.*;

public class EvaluateDivision399 {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Set<String>> map = getAllParamers(equations, values);
        double[] result = new double[queries.length];

        for (int i = 0; i < queries.length; i++) {
            result[i] = calResult(map, queries[i]);
        }
        return result;
    }

    public double calResult(Map<String, Set<String>> map, String[] param) {
        String key1 = param[0];
        String key2 = param[1];
        if (!map.containsKey(key1) || !map.containsKey(key2)) {
            return -1.0;
        }

        Set<String> set1 = map.get(key1);
        Set<String> set2 = map.get(key2);


        for (String str : set1) {
            if (str.indexOf(key2) != -1) {
                return calResult(str, key2);
            }
        }
        for (String str : set2) {
            if (str.indexOf(key1) != -1) {
                return calResult(key1, str);
            }
        }

        for (String str : set1) {
            String[] arr = str.split("\\*").length > 1 ? str.split("\\*") : str.split("\\/");
            for (String str1 : set2) {
                if (str1.indexOf(arr[0]) != -1) {
                    return calResult(str, str1);
                }
            }
        }

        return -1.0;
    }

    public double calResult(String str1, String str2) {
        List<String> fList = new ArrayList<>();
        List<String> mList = new ArrayList<>();

        if (str1.indexOf("/") != -1) {
            fList.add(str1.split("\\/")[0]);
            mList.add(str1.split("\\/")[1]);
        } else {
            fList.add(str1.split("\\/")[0]);
            if (str1.split("\\/").length > 1) {
                fList.add(str1.split("\\/")[1]);
            }
        }

        if (str2.indexOf("/") != -1) {
            fList.add(str2.split("\\/")[1]);
            mList.add(str2.split("\\/")[0]);
        } else {
            mList.add(str2.split("\\/")[0]);
            if (str2.split("\\/").length > 1) {
                mList.add(str2.split("\\/")[1]);
            }
        }

        Iterator<String> iterator = fList.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            if (mList.contains(next)) {
                iterator.remove();
                mList.remove(next);
            }
        }

        try {

            Double fDouble = 1.0;
            Double mDouble = 1.0;
            for (int i = 0; i < fList.size(); i++) {
                fDouble = fDouble * Double.parseDouble(fList.get(i));
            }
            for (int i = 0; i < mList.size(); i++) {
                mDouble = mDouble * Double.parseDouble(mList.get(i));
            }

            return fDouble / mDouble;
        } catch (Exception e) {
            return -1.0;
        }
    }

    public Map<String, Set<String>> getAllParamers(String[][] equations, double[] values) {
        Map<String, Set<String>> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] arr = equations[i];
            String key1 = arr[0];
            String key2 = arr[1];
            double value = values[i];

            if (map.containsKey(key1)) {
                map.get(key1).add(key2 + "*" + value);
            } else {
                map.put(key1, new HashSet<String>() {{
                    add(key2 + "*" + value);
                }});
            }
            if (map.containsKey(key2)) {
                map.get(key2).add(key1 + "/" + value);
            } else {
                map.put(key2, new HashSet<String>() {{
                    add(key1 + "/" + value);
                }});
            }
        }
        return map;
    }

    public static void main(String[] args) {
        EvaluateDivision399 ed = new EvaluateDivision399();
        String[][] earray = new String[][]{{
                "a", "b"
        }, {
                "b", "c"
        }};
        double[] varray = new double[]{
                2.0, 3.0
        };
        String[][] qarray = new String[][]{{
                "a", "c"
        }, {
                "b", "a"
        }, {
                "a", "e"
        }, {
                "a", "a"
        }, {
                "x", "x"
        }};
        double[] dou = ed.calcEquation(earray, varray, qarray);
        for (double d : dou) {
            System.out.println(d);
        }
    }
}
