package kz.ya.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

/**
 *
 * @author yerlana
 */
public class CodilityZalando {

    public static void main(String[] args) {
        int[] A = {-1, -3};
        System.out.println(getSmallestPositiveInt(A));

        Point2D[] B = new Point2D[5];
        Point2D point = new Point2D();
        point.x = -1;
        point.y = -2;
        B[0] = point;
        point = new Point2D();
        point.x = 1;
        point.y = 2;
        B[1] = point;
        point = new Point2D();
        point.x = 2;
        point.y = 4;
        B[2] = point;
        point = new Point2D();
        point.x = -3;
        point.y = 2;
        B[3] = point;
        point = new Point2D();
        point.x = 2;
        point.y = -2;
        B[4] = point;
        System.out.println(getMinRays(B));
    }

    public static int getSmallestPositiveInt(int[] A) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : A) {
            set.add(i);
        }
        int m = 1;
        for (int i = 0; i < set.size(); i++) {
            if (set.contains(m)) {
                m++;
            }
        }
        return m;
    }

    // HH:MM:SS
    public static String getEarliestValidTime(int A, int B, int C, int D, int E, int F) {
        TreeSet<Integer> set = new TreeSet<>();
        set.add(A);
        set.add(B);
        set.add(C);
        set.add(D);
        set.add(E);
        set.add(F);
        
        if (set.first() > 2) {
            return "NOT POSSIBLE";
        }
        if (set.size() == 1 && set.first() == 0) {
            return "00:00:00";
        }
        
        return "NOT POSSIBLE";
    }

    public static int getMinRays(Point2D[] A) {
        int counter = 0;

        ArrayList<Point2D> first = new ArrayList<>();
        ArrayList<Point2D> second = new ArrayList<>();
        ArrayList<Point2D> third = new ArrayList<>();
        ArrayList<Point2D> fourth = new ArrayList<>();

        for (Point2D point : A) {
            if (point.x > 0 && point.y > 0) {
                first.add(point);
            } else if (point.x < 0 && point.y > 0) {
                second.add(point);
            } else if (point.x < 0 && point.y < 0) {
                third.add(point);
            } else if (point.x > 0 && point.y < 0) {
                fourth.add(point);
            }
        }

        PointComparator pointComparator = new PointComparator();
        Point2D oldPoint;
        int epsilonX = 0;
        int epsilonY = 0;

        if (!first.isEmpty()) {
            Collections.sort(first, pointComparator);

            counter++;
            oldPoint = second.remove(0);
            epsilonX = oldPoint.x;
            epsilonY = oldPoint.y;

            for (Point2D point : first) {
                if (isInOneDirection(oldPoint.x, point.x, epsilonX) && isInOneDirection(oldPoint.y, point.y, epsilonY)) {
                    oldPoint = point;
                    epsilonX = oldPoint.x;
                    epsilonY = oldPoint.y;
                    continue;
                }
                counter++;
            }
        }

        if (!second.isEmpty()) {
            Collections.sort(second, pointComparator);

            counter++;
            oldPoint = second.remove(0);
            epsilonX = oldPoint.x;
            epsilonY = oldPoint.y;

            for (Point2D point : second) {
                if (isInOneDirection(oldPoint.x, point.x, epsilonX) && isInOneDirection(oldPoint.y, point.y, epsilonY)) {
                    oldPoint = point;
                    epsilonX = oldPoint.x;
                    epsilonY = oldPoint.y;
                    continue;
                }
                counter++;
            }
        }

        if (!third.isEmpty()) {
            Collections.sort(third, pointComparator);

            counter++;
            oldPoint = third.remove(0);
            epsilonX = oldPoint.x;
            epsilonY = oldPoint.y;

            for (Point2D point : third) {
                if (isInOneDirection(oldPoint.x, point.x, epsilonX) && isInOneDirection(oldPoint.y, point.y, epsilonY)) {
                    oldPoint = point;
                    epsilonX = oldPoint.x;
                    epsilonY = oldPoint.y;
                    continue;
                }
                counter++;
            }
        }

        if (!fourth.isEmpty()) {
            Collections.sort(fourth, pointComparator);
            
            counter++;
            oldPoint = fourth.remove(0);
            epsilonX = oldPoint.x;
            epsilonY = oldPoint.y;

            for (Point2D point : fourth) {
                if (isInOneDirection(oldPoint.x, point.x, epsilonX) && isInOneDirection(oldPoint.y, point.y, epsilonY)) {
                    oldPoint = point;
                    epsilonX = oldPoint.x;
                    epsilonY = oldPoint.y;
                    continue;
                }
                counter++;
            }
        }

        return counter;
    }

    private static boolean isInOneDirection(int old, int current, int epsilon) {
        return (current - old) >= epsilon;
    }

    static class PointComparator implements Comparator<Point2D> {

        @Override
        public int compare(Point2D o1, Point2D o2) {
            int result = Integer.compare(o1.x, o2.x);
            if (result == 0) {
                // both X are equal -> compare Y too
                result = Integer.compare(o1.y, o2.y);
            }
            return result;
        }
    }

    static class Point2D {

        public int x;
        public int y;
    }
}
