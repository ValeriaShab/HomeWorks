package com.shabatura.hw7;

public class Vector {
    private final double x;
    private final double y;
    private final double z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getLength() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public Vector getVectorProduct(Vector vector) {
        return new Vector((y * vector.z - z * vector.y), (x * vector.z - z * vector.x), (x * vector.y - y * vector.x));
    }

    public double getCos(Vector vector) {
        return (x * vector.x + y * vector.y + z * vector.z) / (getLength() * vector.getLength());
    }

    public Vector getSum(Vector vector) {
        return new Vector(x + vector.x, y + vector.y, z + vector.z);
    }

    public Vector getDif(Vector vector) {
        return new Vector(x - vector.x, y - vector.y, z - vector.z);
    }

    public static Vector[] generator(int N) {
        Vector[] vectors = new Vector[N];
        for (int i = 0; i < N; i++) {
            vectors[i] = new Vector(Math.random(), Math.random(), Math.random());
        }
        return vectors;
    }

    @Override
    public String toString() {
        return '{' + "x=" + x + ", y=" + y + ", z=" + z + '}';
    }
}
