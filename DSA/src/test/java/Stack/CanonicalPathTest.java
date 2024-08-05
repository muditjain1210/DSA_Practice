package Stack;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CanonicalPathTest {

    @Test
    void simplifyPath() {
        CanonicalPath canonicalPath = new CanonicalPath();
//        canonicalPath.simplifyPath("//home/./mjain/hello/../");
//        canonicalPath.simplifyPath("//home/./mjain//hello/../vaibs/../");
//        canonicalPath.simplifyPath("/home/");
//        canonicalPath.simplifyPath("/../");
//        canonicalPath.simplifyPath("/home//foo/.../");
        //     canonicalPath.simplifyPath("/a//b////c/d//././/..");
        canonicalPath.simplifyPath("/hello../world");
    }
}