/*
Given an absolute file path (Unix-style), shorten it to the format /<dir1>/<dir2>/<dir3>/....

Here is some info on Unix file system paths:

/ is the root directory; the path should always start with it even if it isn't
there in the given path;
/ is also used as a directory separator; for example, /code/fights denotes a fights
subfolder in the code folder in the root directory;
this also means that // stands for "change the current directory to the current directory"
. is used to mark the current directory;
.. is used to mark the parent directory; if the current directory is root already, ..
 does nothing.
Example

For path = "/home/a/./x/../b//c/", the output should be
simplifyPath(path) = "/home/a/b/c".

Here is how this path was simplified:
* /./ means "move to the current directory" and can be replaced with a single /;
* /x/../ means "move into directory x and then return back to the parent directory",
so it can replaced with a single /;
* // means "move to the current directory" and can be replaced with a single /.

Input/Output

[time limit] 3000ms (java)

[input] string path

A line containing a path presented in Unix style format. All directories in the path
are guaranteed to consist only of English letters.

Guaranteed constraints:
1 ≤ path.length ≤ 5 · 104.

[output] string

The simplified path.
 */
package newprogram;

public class SimplifyPath {
    public static void main(String[] args) {

        SimplifyPath simplifyPath = new SimplifyPath();
//        System.out.println(simplifyPath.simplifyPath("/home/a/./x/../b//c/"));

//        /a/b/c/../..
//        String path = "/a/./b/../../c/";
        String path = "/home/a/./x/../b//c/";
        System.out.println(simplifyPath.simplifyPath(path));
//        System.out.println(path.indexOf("/./"));
//        System.out.println(path.substring(1));

    }

    String simplifyPath(String path) {

        path = "/" + path + "/";

        while (path.indexOf("//") != -1) {
            path = path.replaceAll("//", "/");
        }

        while (path.indexOf("/./") != -1) {
            int index = path.indexOf("/./");
            if (index == 0) {
                path = path.substring(index + 2);
            } else {
                path = path.substring(0, index) + path.substring(index + 2);
            }
        }


        while (path.indexOf("/../") != -1) {

            int index = path.indexOf("/../");

            if (index == 0) {
                path = path.substring(index + 3);
            } else {
                String tempString = path.substring(0, index);
                int lastIndex = tempString.lastIndexOf("/");
                path = path.substring(0, lastIndex) + path.substring(index + 3);
            }
        }

        if (path.length() > 1){
            return path.substring(0, path.length() - 1);
        }

        return path;

    }


}
