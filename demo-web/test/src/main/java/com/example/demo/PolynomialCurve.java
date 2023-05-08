package com.example.demo;

import com.alibaba.fastjson.JSON;
import org.apache.commons.math3.fitting.PolynomialCurveFitter;
import org.apache.commons.math3.fitting.WeightedObservedPoints;

/**
 * @Author: Cirmons
 * @Date: 2022-04-11
 */
public class PolynomialCurve {


//    public static class Point{
//        public double x;
//        public double y;
//
//        public Point(double x, double y) {
//            this.x = x;
//            this.y = y;
//        }
//    }
    
    
    public WeightedObservedPoints getPoints() {
        
        double[] real = {1.85 / (660 - 57), 1.75 / (581 - 65), 1.75 / (559 - 73), 1.65 / (512 - 84), 1.75 / (427 - 23), 1.85 / (808 - 118), 1.65 / (782 - 206), 1.7 / (1057 - 388), 1.7 / (1080 - 441), 1.87 / (1021 - 183), 1.87 / (967 - 205), 1.87 / (1027 - 195), 1.7 / (1011 - 357)};
        double[] y = {(660 + 57) / 2.0, (581.0 + 65.0) / 2, (559.0 + 73.0) / 2, (512.0 + 84.0) / 2, (427.0 + 23.0) / 2, (808.0 + 118.0) / 2, (782.0 + 206.0) / 2, (1057.0 + 388.0) / 2, (1080.0 + 441.0) / 2, (1021.0 + 183.0) / 2, (967.0 + 205.0) / 2, (1027.0 + 195.0) / 2, (1011.0 + 357.0) / 2};

//
//        System.out.println(JSON.toJSONString(real));
//        System.out.println(JSON.toJSONString(y));
        
        int length = real.length;
        
        
        WeightedObservedPoints points = new WeightedObservedPoints();
        for (int i = 0; i < length; i++) {
            points.add( y[i],real[i]);
        }
        return points;
    }


//    public void curveFitter(WeightedObservedPoints points, int deg) {
//
//        //指定多项式阶数
//        PolynomialCurveFitter fitter = PolynomialCurveFitter.create(deg);
//
//        // 曲线拟合，结果保存于数组
//        double[] result = fitter.fit(points.toList());
//
//        for(int i = 0; i < result.length; i++) {
//            System.out.println(result[i]);
//        }
//
//
//    }
    
    
    public double polyfit1d(double x, double[] coefficient){
        if (coefficient == null) {
            return 0;
        }
        double sum = 0;
        for (int i = 0; i < coefficient.length; i++) {
            sum += Math.pow(x, i) * coefficient[i];
        }
        return sum;
    }
    
    public static void main(String[] args) {
        PolynomialCurve curve = new PolynomialCurve();
        WeightedObservedPoints points = curve.getPoints();
        
        PolynomialCurveFitter fitter = PolynomialCurveFitter.create(2);
        double[] result = fitter.fit(points.toList());
        //curve.curveFitter(points,2);
    
        System.out.println("[result]:"+JSON.toJSONString(result));
        
        double[] xs = new double[]{732d, 284d, 456d, 998d, 325d, 556d, 566d, 245d, 462d, 267d};
        double[] ys = new double[xs.length];
        for (int i = 0; i < xs.length; i++) {
            ys[i] = curve.polyfit1d(xs[i],result);
        }
    
        
    
        System.out.println("[xs]:"+JSON.toJSONString(xs));
        System.out.println("[ys]:"+JSON.toJSONString(ys));
        
        
        
    }
    
    
}
