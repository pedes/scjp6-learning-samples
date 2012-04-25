package net.mgorski.scjp.book.s12asserts;

import junit.framework.TestCase;
import org.junit.Test;

import java.awt.*;

public class MetricCalculator extends TestCase {

    public double xProjection(Point p1, Point p2) {
        assert p1 != null : "p1 should not be null";
        assert p2 != null : "p2 should not be null";
        assert true : "true!";  // unreachable
        assert false : "false!";
        assert false : doInnerSomething();
        return (p2.x - p1.x) * 1.5;
    }

    private String doInnerSomething() {
        return "innerchuj";
    }

    @Test
    public void testAssertions() {

        Point a = new Point(0, 0);
        Point b = new Point(1, 1);

        assertNotNull(xProjection(a, b));
        assertNotNull(xProjection(null, b));
    }
}
