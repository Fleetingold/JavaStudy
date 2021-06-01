package com.designpattern.prototype;

import java.util.Hashtable;

import com.designpattern.factory.Circle;
import com.designpattern.factory.Rectangle;
import com.designpattern.factory.Shape;
import com.designpattern.factory.Square;

public class ShapeCache {
	private static Hashtable<String, Shape> shapeMap = new Hashtable<String, Shape>();

	// ��ÿ����״���������ݿ��ѯ, ����������״
	// shapeMap.put(shapeKey, shape);
	// ����, ����Ҫ���������״
	public static void loadCache() {
		// TODO Auto-generated method stub
		Circle circle = new Circle();
		circle.setId("1");
		shapeMap.put(circle.getId(), circle);
		
		Square square = new Square();
		square.setId("2");
		shapeMap.put(square.getId(), square);
		
		Rectangle rectangle = new Rectangle();
		rectangle.setId("3");
		shapeMap.put(rectangle.getId(), rectangle);
	}

	public static Shape getShape(String shapeId) {
		// TODO Auto-generated method stub
		Shape cachedShape = shapeMap.get(shapeId);
		return (Shape) cachedShape.clone();
	}

}
