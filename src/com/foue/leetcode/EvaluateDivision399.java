package com.foue.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number).
 * Given some queries, return the answers. If the answer does not exist, return -1.0.
 * <p/>
 * Example:
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 */
public class EvaluateDivision399 {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, String> map = new HashMap<String, String>();
        Map<String, Integer> map2 = generateMap(equations);

        double[] _value = new double[queries.length];

        while (map.size() != map2.size()) {
            for (int i = 0; i < equations.length; i++) {
                String _var1 = equations[i][0];
                String _var2 = equations[i][1];
                double _var3 = values[i];

                if (map.size() == 0) {
                    map.put(_var1, _var1);
                }
                if (!map.containsKey(_var1) && !map.containsKey(_var2)) {
                    if (map2.get(_var1) == 1 && map2.get(_var2) == 1) {
                        map.put(_var1, _var1);
                    }
                }
                if (map.containsKey(_var1) && !map.containsKey(_var2)) {
                    map.put(_var2, generateString(map.get(_var1), "/", _var3));
                }
                if (!map.containsKey(_var1) && map.containsKey(_var2)) {
                    map.put(_var1, generateString(map.get(_var2), "*", _var3));
                }
            }
        }

        for (int i = 0; i < queries.length; i++) {
            String _var1 = queries[i][0];
            String _var2 = queries[i][1];

            if (map.containsKey(_var1) && map.containsKey(_var2)) {
                _value[i] = generateDouble(generateString(map.get(_var1), "/", map.get(_var2)));
            } else {
                _value[i] = -1.0;
            }
        }
        return _value;
    }

    public Map<String, Integer> generateMap(String[][] equations) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (int i = 0; i < equations.length; i++) {
            for (int j = 0; j < equations[i].length; j++) {
                String str = equations[i][j];
                if (!map.containsKey(str)) {
                    map.put(str, 1);
                } else {
                    map.put(str, map.get(str) + 1);
                }
            }
        }
        return map;
    }

    /**
     * 模拟乘除法
     *
     * @param str1
     * @param key
     * @param str2
     * @return
     */
    public String generateString(String str1, String key, Double str2) {
        String[] _str1Arr = str1.split("/");
        String str = "";
        if (key.equals("/")) {
            str += _str1Arr[0];
            str += "/";
            if (_str1Arr.length > 1) {
                str += _str1Arr[1] + "*";
            }
            str += str2;
        } else if (key.equals("*")) {
            str += _str1Arr[0];
            str += "*";
            str += str2;
            str += "/";
            if (_str1Arr.length > 1) {
                str += _str1Arr[1];
            }
        }
        return str;
    }

    /**
     * 模拟乘除法
     *
     * @param str1
     * @param key
     * @param str2
     * @return
     */
    public String generateString(String str1, String key, String str2) {
        String[] _str1Arr = str1.split("/");
        String[] _str2Arr = str2.split("/");
        String str = "";
        if (key.equals("/")) {
            str += _str1Arr[0];
            if (_str2Arr.length > 1) {
                str += "*";
                str += _str2Arr[1];
            }
            str += "/";
            if (_str1Arr.length > 1) {
                str += _str1Arr[1];
                str += "*";
            }
            str += _str2Arr[0];
        } else if (key.equals("*")) {
            str += _str1Arr[0];
            str += "*";
            str += _str2Arr[0];
            if (_str1Arr.length > 1 || _str2Arr.length > 1) {
                str += "/";
            }
            if (_str1Arr.length > 1) {
                str += _str1Arr[1];
                str += "*";
            }
            if (_str2Arr.length > 1) {
                str += _str2Arr[1];
            }
        }
        return str;
    }

    /**
     * 计算有乘除的string
     *
     * @param str
     * @return
     */
    public double generateDouble(String str) {
        final String[] _str = str.split("/");
        List<String> _str1 = new ArrayList<String>() {{
            for (String s : _str[0].split("\\*")) {
                add(s);
            }
        }};
        List<String> _str2 = new ArrayList<String>() {{
            for (String s : _str[1].split("\\*")) {
                add(s);
            }
        }};
        double _num1 = 1;
        double _num2 = 1;
        List<String> _remove = new ArrayList<String>();
        for (String s : _str2) {
            if (_str1.contains(s)) {
                _remove.add(s);
            }
        }
        _str1.removeAll(_remove);
        _str2.removeAll(_remove);

        for (String s : _str1) {
            if (s.matches("[a-zA-Z]+")) {
                return -1.0;
            }
            _num1 *= Double.parseDouble(s);
        }
        for (String s : _str2) {
            if (s.matches("[a-zA-Z]+")) {
                return -1.0;
            }
            _num2 *= Double.parseDouble(s);
        }

        return _num1 / _num2;
    }

    public static void main(String[] args) {
        EvaluateDivision399 ed = new EvaluateDivision399();
        String[][] earray = new String[][]{{
                "a", "b"
        }, {
                "e", "f"
        }, {
                "b", "e"
        }};
        double[] varray = new double[]{
                3.4, 1.4, 2.3
        };
        String[][] qarray = new String[][]{{
                "b", "a"
        }, {
                "a", "f"
        }, {
                "f", "f"
        }, {
                "e", "e"
        }, {
                "c", "c"
        }, {
                "a", "c"
        }, {
                "f", "e"
        }};
        double[] dou = ed.calcEquation(earray, varray, qarray);
        for (double d : dou) {
            System.out.println(d);
        }
    }
}
