package com.proko;

public class Edge {
    private int fromV;
    private int toV;
    private int distBetween;

    /**
     * Construct edges of the graph
     * @param fromV The vertex from which the edge of the graph
     * @param toV The vertex to which the edge of the graph
     * @param distBetween Distance between vertices
     */
    public Edge(int fromV, int toV, int distBetween) {
        this.fromV = fromV;
        this.toV = toV;
        this.distBetween = distBetween;
    }
    /**
     * @return The vertex from which the edge of the graph
     */
    public int getVerticeFrom() {
        return fromV;
    }
    /**
     * @return The vertex to which the edge of the graph
     */
    public int getVerticeTo() {
        return toV;
    }
    /**
     * @return Distance between two vertices
     */
    public int getDistance() {
        return distBetween;
    }
}
