package com.factual.driver;

import java.util.HashMap;

import com.google.common.collect.Lists;

public class Rectangle extends Shape {
  private double topLeftLat;
  private double topLeftLon;
  private double bottomRightLat;
  private double bottomRightLon;
	

  /**
   * Constructs a Rectangle.
   * 
   * @param topLeftLat the latitude of the top left point
   * @param topLeftLon the longitude of the top left point
   * @param bottom the latitude of the bottom right point
   * @param right the longitude of the bottom right point
   */
  public Rectangle(double topLeftLat, double topLeftLon, 
                   double bottomRightLat, double bottomRightLon) {
	  this.topLeftLat = topLeftLat;
	  this.topLeftLon = topLeftLon;
	  this.bottomRightLat = bottomRightLat;
	  this.bottomRightLon = bottomRightLon;
	  
  }
	
  @SuppressWarnings({ "unchecked", "rawtypes", "serial" })
  @Override
  public Object toJsonObject() {
    return new HashMap() {
      {
        put(Constants.RECTANGLE,
        		Lists.newArrayList(
        				Lists.newArrayList(topLeftLat, topLeftLon),
        				Lists.newArrayList(bottomRightLat, bottomRightLon)));}};
  }

}