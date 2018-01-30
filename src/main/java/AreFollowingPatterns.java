/*
Given an array strings, determine whether it follows the sequence given in the patterns
array. In other words, there should be no i and j for which strings[i] = strings[j]
and patterns[i] ≠ patterns[j] or for which strings[i] ≠ strings[j] and patterns[i] = patterns[j].

Example

For strings = ["cat", "dog", "dog"] and patterns = ["a", "b", "b"], the output should be
areFollowingPatterns(strings, patterns) = true;
For strings = ["cat", "dog", "doggy"] and patterns = ["a", "b", "b"], the output should be
areFollowingPatterns(strings, patterns) = false.
Input/Output

[time limit] 3000ms (java)
[input] array.string strings

An array of strings, each containing only lowercase English letters.

Guaranteed constraints:
1 ≤ strings.length ≤ 105,
1 ≤ strings[i].length ≤ 10.

[input] array.string patterns

An array of pattern strings, each containing only lowercase English letters.

Guaranteed constraints:
patterns.length = strings.length,
1 ≤ patterns[i].length ≤ 10.

[output] boolean

Return true if strings follows patterns and false otherwise.

 */

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class AreFollowingPatterns {
    public static void main(String[] args) {

    }

    static boolean areFollowingPatterns(String[] strings, String[] patterns) {

        Map<String, String> map = new HashMap<String, String>();
        boolean match = true;

        for (int i = 0; i < patterns.length; i++) {

            if (map.containsKey(patterns[i])){
                if (!map.get(patterns[i]).equals(strings[i])){
                    match = false;
                }
            } else {
                Collection<String> v = map.values();
                if (v.contains(strings[i])){
                    match = false;
                }

                map.put(patterns[i], strings[i]);
            }

        }

        return match;

    }


}
