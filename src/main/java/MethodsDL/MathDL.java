// PotatoCurry
// This file contains several useful methods I often use in my own programs.

package MethodsDL;

public class MathDL extends MethodsDL {

    //Areas
	public static double CircleArea(double radius) {
            double circleArea = Math.PI * (radius * radius);
            return circleArea;
    }

	public static double RectangleArea(double length, double width) {
	    double rectangleArea = length * width;
	    return rectangleArea;
	}

    //Volumes
        public static double ConeVolume(double radius, double height) {
	    double coneVolume = (1.0/3.0) * (Math.PI * (radius * radius)) * height;
	    return coneVolume;
	}

	public static double CylinderVolume(double radius, double height) {
	    double cylinderVolume = (Math.PI * (radius * radius)) * height;
	    return cylinderVolume;
	}

	public static double RectangularPrismVolume(double length, double width, double height) {
	    double prismVolume = length * width * height;
	    return prismVolume;
	}

	public static double SphereVolume(double radius) {
	    double SphereVolume  = (Math.PI * (radius * radius * radius)) * (4.0/3.0);
	    return SphereVolume;
	}

    //Other
	public static double PointDistance(double x1, double y1, double x2, double y2) {
	    double pointDistance = Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
	    return pointDistance;
	}

	public static double NumberAverage(int intCount, double[] numList) {
	    double numSum = 0;
	    for (int i = 0; i <= numList.length; i++) {
	    	numSum += numList[i];
	    }
	    double numAverage = numSum / intCount;
	    return numAverage;
	}

}
