/*
 * Created by Dawid Liszka
 */
import static java.lang.Math.*;
class Triangle implements Comparable<Triangle>
{
	private Point a;
	private Point b;
	private Point c;
	private double area;
	private double height;
	private double perimeter;

	/*
		 Default constructor Triangle():
		 Pytagoras triangle |A| = 3, |B| = 4, |C| = 5
	*/
	public Triangle()
	{
		this.a = new Point(0,0);
		this.b = new Point(3,0);
		this.c = new Point(0,4);
		this.checkIfValid();
	}

	public Triangle(Point a, Point b, Point c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
		this.checkIfValid();
	}

	Triangle(Triangle triangle)
	{
		this.a = new Point(triangle.a);
		this.b = new Point(triangle.b);
		this.c = new Point(triangle.c);
		this.checkIfValid();
	}

	public boolean checkIfValid() throws RuntimeException
	{
		double _a = this.a.getLength(this.b);
		double _b = this.b.getLength(this.c);
		double _c = this.c.getLength(this.a);
		double max = Math.max(_a, Math.max(_b, _c));
		if(2*max < _a+_b+_c)
			return true;
		throw new RuntimeException("Triangle is not valid");
	}

	public void setPointA(Point a)
	{
		this.a = a;
		this.checkIfValid();
	}

	public void setPointB(Point b)
	{
		this.b = b;
		this.checkIfValid();
	}

	public void setPointC(Point c)
	{
		this.c = c;
		this.checkIfValid();
	}

	public Point getPointA()
	{
		return this.a;
	}

	public Point getPointB()
	{
		return this.b;
	}

	public Point getPointC()
	{
		return this.c;
	}

	public double getPenimeter()
	{
		return Point.NORMA(this.a, this.b) + Point.NORMA(this.b, this.c) + Point.NORMA(this.c, this.a);
	}

	public double getArea()
	{
		double p = (0.5)*this.getPenimeter(); 	// half of penimeter
		double a = this.a.getLength(this.b);
		double b = this.b.getLength(this.c);
		double c = this.c.getLength(this.a);
		return Math.sqrt(p*(p-a)*(p-b)*(p-c));
	}

	public double getHeight(int whichVertic) throws RuntimeException
	{
		/*
			 whichVertic :=1 - BC
			 whichVertic :=2 - AC
			 whichVertic :=3 - AB
			 Perfect for enumerable type :)
		*/
		double floor = 0;
		double area = this.getArea();
		boolean status = true;
		switch(whichVertic) {
			case 1 :
				floor = this.b.getLength(this.c);
				break;
			case 2 : 
				floor = this.a.getLength(this.c);
				break;
			case 3 : 
				floor = this.a.getLength(this.b);
				break;
			default: 
				// error? WRONG PARAM
				status = false;
				break;
		}
		if(status == false)
			throw new RuntimeException("Param is not valid");
		return Math.abs( (2*area)/floor );
	}

	@Override
	public String toString()
	{
		String str = "";
		str += "Triangle : "+this.a+", "+this.b+", "+this.c;
		return str;
	}

	@Override
	public int compareTo(Triangle triangle)
	{

		double comparedTriangleArea = triangle.getArea();
		double thisArea = this.getArea();

		if(comparedTriangleArea > thisArea)
			return -1;
		else if(comparedTriangleArea < thisArea)
			return 1;
		else return 0;
	}
	
}
