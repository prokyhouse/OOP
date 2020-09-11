package com.proko;

import org.junit.Assert;
import org.junit.Test;
public class GraphTests {
    @Test
    public void test1() {
        Graph graph = null;
        Distance distance = new Distance(0, graph);
        int dist = distance.getDist(1);
        Assert.assertEquals(-1, dist);
    }

    @Test
    public void test2() {
        Edge[] arr  = new Edge[14];
        arr[0] = new Edge(0,1, 1);
        arr[1] = new Edge(1,2, 1);
        arr[2] = new Edge(2,9, 1);
        arr[3] = new Edge(2,7, 1);
        arr[4] = new Edge(0,10, 1);
        arr[5] = new Edge(10,3, 1);
        arr[6] = new Edge(1,8, 1);
        arr[7] = new Edge(9,7, 1);
        arr[8] = new Edge(8,3, 1);
        arr[9] = new Edge(4,3, 1);
        arr[10] = new Edge(4,6, 1);
        arr[11] = new Edge(7,5, 1);
        arr[12] = new Edge(8,6, 1);
        arr[13] = new Edge(3,6, 1);
        Graph graph = new Graph(11, arr);
        Distance distance = new Distance(0, graph);
        int dist = distance.getDist(3);
        Assert.assertEquals(2, dist);
    }

    @Test
    public void test3() {
    Edge[] arr  = new Edge[6];
    arr[0] = new Edge(0,1, 10);
    arr[1] = new Edge(1,2, 50);
    arr[2] = new Edge(0,4, 100);
    arr[3] = new Edge(2,4, 10);
    arr[4] = new Edge(3,2, 20);
    arr[5] = new Edge(0,3, 30);

    Graph graph = new Graph(6, arr);
    Distance distance = new Distance(0, graph);
    int dist = distance.getDist(4);
        Assert.assertEquals(60, dist);
}

    @Test
    public void test4() {
        Edge[] arr = new Edge[6];
        arr[0] = new Edge(0, 1, 2);
        arr[1] = new Edge(1, 2, 3);
        arr[2] = new Edge(2, 3, 4);
        arr[3] = new Edge(3, 1, 6);
        arr[4] = new Edge(0, 3, 1);
        arr[4] = new Edge(0, 2, 5);
        Graph graph = new Graph(4,arr);
        Distance d = new Distance(1, graph);
        int dist = d.getDist(0);
        Assert.assertEquals(-1, dist);
    }

    @Test
    public void test5() {
        Edge[] arr = new Edge[6];
        arr[0] = new Edge(0, 1, 2);
        arr[1] = new Edge(1, 2, 3);
        arr[2] = new Edge(2, 3, 4);
        arr[3] = new Edge(3, 1, 6);
        arr[4] = new Edge(0, 3, 1);
        arr[4] = new Edge(0, 2, 5);
        Graph graph = new Graph(4,arr);
        Distance d = new Distance(1, graph);
        int dist = d.getDist(3);
        Assert.assertEquals(7, dist);
    }

}
